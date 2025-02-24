package br.com.parc3ria.verify;

import br.com.parc3ria.verify.principal.AppConfig;
import br.com.parc3ria.verify.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VerifyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VerifyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AppConfig appConfig = new AppConfig();
		Principal principal = new Principal(appConfig);
		principal.showMenu();
	}
}
