package net.da.net.agreements_service.service;

import net.da.net.agreements_service.entity.Agreement;
import net.da.net.agreements_service.repository.AgreementRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgreementService {

    private final AgreementRepository agreementRepository;

    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    public ResponseEntity<Agreement> save(Agreement agreement) {
        return null;
    }

    public ResponseEntity<Agreement> getById(Integer id) {
        return null;
    }

    public ResponseEntity<List<Agreement>> getAll(Integer clientId, Integer productId) {
        return null;
    }

    public ResponseEntity delete(Integer id) {
        return null;
    }

    public ResponseEntity<List<Agreement>> getStatistics(Integer clientId, Integer productId) {
        return null;
    }
}
