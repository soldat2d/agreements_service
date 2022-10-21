package net.da.net.agreements_service;

import net.da.net.agreements_service.entity.Agreement;
import net.da.net.agreements_service.service.AgreementService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class AgreementsServiceApplication implements CommandLineRunner {

	final AgreementService agreementService;

	public AgreementsServiceApplication(AgreementService agreementService) {this.agreementService = agreementService;}

	public static void main(String[] args) {
		SpringApplication.run(AgreementsServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		agreementService.save(new Agreement(3231, 1242, "4525.12", new Date(105, 11, 29)));
		agreementService.save(new Agreement(1563, 2534, "1525.55", new Date(111, 6, 13)));
		agreementService.save(new Agreement(1114, 4566, "525.19", new Date(119, 3, 1)));
		agreementService.save(new Agreement(1563, 1242, "9575.73", new Date(120, 5, 22)));
		agreementService.save(new Agreement(1563, 2534, "1925.23", new Date(121, 9, 6)));
	}
}
