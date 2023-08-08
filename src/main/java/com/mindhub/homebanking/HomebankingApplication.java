package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository){
		return (args) -> {
			Client client = new Client("12345674","Lean","Lescano","lean@mail.com");
			Client client1 = new Client("789541","Melba","Morel","melba@mindhub.com");
			//Account Account= new Account("VIN000", LocalDate.now(),5000.0);
			//Account Account1= new Account("VIN001",LocalDate.now(),7500.0);

			clientRepository.save(client);
			clientRepository.save(client1);

			Account account1 = new Account("VIN001",LocalDate.now(),7500.0);
			client.addAccount(account1);
			accountRepository.save(account1);

		};
	}

}
