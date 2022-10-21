package net.da.net.agreements_service.service;

import net.da.net.agreements_service.entity.Agreement;
import net.da.net.agreements_service.repository.AgreementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AgreementService {

	private final AgreementRepository agreementRepository;

	public AgreementService(AgreementRepository agreementRepository) {
		this.agreementRepository = agreementRepository;
	}

	public ResponseEntity<?> save(Agreement agreement) {
		agreement.setTimestamp(new Date());
		return new ResponseEntity<>(agreementRepository.save(agreement), HttpStatus.CREATED);
	}

	public ResponseEntity<?> getById(Integer id) {
		Agreement agreement = agreementRepository.getById(id);
		if (agreement != null) {
			return new ResponseEntity<>(agreement, HttpStatus.OK);
		}
		return new ResponseEntity<>("договор не найден", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getAll(Integer clientId, Integer productId) {
		return new ResponseEntity<>(agreementRepository.getAll(clientId, productId), HttpStatus.OK);
	}

	public ResponseEntity<?> delete(Integer id) {
		if (agreementRepository.delete(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>("договор не найден", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getStatistics(Integer clientId, Integer productId) {

		return new ResponseEntity<>(agreementRepository.getStatistics(clientId, productId), HttpStatus.OK);
	}
}
