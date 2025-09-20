package com.bsm.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bsm.aopdemo.dao.AccountDAO;
import com.bsm.aopdemo.dao.MembershipDAO;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration.class
})

public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cli(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return (runner) -> {
			demoTheBeforeAdvice(theMembershipDAO, theAccountDAO);
		};
	}

	private void demoTheBeforeAdvice(MembershipDAO theMembershipDAO, AccountDAO theAccountDAO) {

		// call the business method
		theMembershipDAO.addSillyMember();

		theAccountDAO.addAccount(new Account("Madhu", "Platinum"), true);


		System.out.println("Finished");
	}

}
