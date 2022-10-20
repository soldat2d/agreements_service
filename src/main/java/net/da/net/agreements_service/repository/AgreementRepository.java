package net.da.net.agreements_service.repository;

import net.da.net.agreements_service.entity.Agreement;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AgreementRepository {

    private AtomicInteger id;
    private ConcurrentHashMap<Integer, Agreement> agreementRepository;

    public AgreementRepository() {
        this.id.set(0);
        agreementRepository = new ConcurrentHashMap<>();
    }

    public Agreement getById (Integer id) {
        return agreementRepository.get(id);
    }

    public List<Agreement> getAll () {
//        return agreementRepository.entrySet();
    }

    public Agreement save (Agreement agreement) {
       return null;
    }

    public Boolean delete (Integer Id) {
        return null;
    }
}
