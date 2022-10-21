package net.da.net.agreements_service.controller;

import net.da.net.agreements_service.entity.Agreement;
import net.da.net.agreements_service.service.AgreementService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AgreementController {

    private final AgreementService agreementService;

    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @PostMapping("/agreements")
    public ResponseEntity<?> saveAgreement(@Validated @RequestBody Agreement agreement) {
        return agreementService.save(agreement);
    }

    @GetMapping("/agreements/{id}")
    public ResponseEntity<?> getAgreement(@PathVariable Integer id) {
        return agreementService.getById(id);
    }

    @GetMapping("/agreements")
    public ResponseEntity<?> getAgreements(@RequestParam(required = false) Integer clientId, @RequestParam(required = false) Integer productId) {
        return agreementService.getAll(clientId, productId);
    }

    @DeleteMapping("/agreements/{id}")
    public ResponseEntity<?> deleteAgreement(@PathVariable Integer id) {
        return agreementService.delete(id);
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> getStatistics(@RequestParam(required = false) Integer clientId, @RequestParam(required = false) Integer productId) {
        return agreementService.getStatistics(clientId, productId);
    }
}
