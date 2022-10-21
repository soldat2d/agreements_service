package net.da.net.agreements_service.repository;

import net.da.net.agreements_service.entity.Agreement;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class AgreementRepository {

	private final AtomicInteger keyId;
	private final ConcurrentHashMap<Integer, Agreement> agreementRepository;

	public AgreementRepository() {
		keyId = new AtomicInteger(0);
		agreementRepository = new ConcurrentHashMap<>();
	}

	public Agreement getById(Integer id) {
		return agreementRepository.get(id);
	}

	public List<Agreement> getAll(Integer clientId, Integer productId) {
//		как именно должен работать фильтр в задании не указано,
//		если судить из примера в задании то ищет по clientId плюс по productId, так и сделано тут и ниже в getStatistics
		return agreementRepository.values().parallelStream()
				.filter(v -> Objects.equals(clientId, v.getClientId()) ||
						Objects.equals(productId, v.getProductId()) ||
						(clientId == null && productId == null))
				.collect(Collectors.toList());
	}

	public Agreement save(Agreement agreement) {
		agreement.setAgreementId(keyId.incrementAndGet());
		agreementRepository.put(agreement.getAgreementId(), agreement);
		return agreement;
	}

	public Boolean delete(Integer Id) {
		return agreementRepository.remove(Id) != null;
	}

	public Statistics getStatistics(Integer clientId, Integer productId) {
		List<Agreement> agreementList = agreementRepository.values().parallelStream()
				.filter(v -> Objects.equals(clientId, v.getClientId()) ||
						Objects.equals(productId, v.getProductId()) ||
						(clientId == null && productId == null)).toList();
		if (agreementList.isEmpty()) {
			return null;
		}
		Comparator<Agreement> comparator = Comparator.comparing(Agreement::getAmount);
		Statistics stat = new Statistics();
		stat.setCount(agreementList.size());
		stat.setMinAmount(agreementList.stream().min(comparator).get().getAmount().toString());
		stat.setMaxAmount(agreementList.stream().max(comparator).get().getAmount().toString());
		stat.setSum(agreementList.stream().map(Agreement::getAmount).reduce(BigDecimal.valueOf(0), BigDecimal::add).toString());
		return stat;
	}
}
