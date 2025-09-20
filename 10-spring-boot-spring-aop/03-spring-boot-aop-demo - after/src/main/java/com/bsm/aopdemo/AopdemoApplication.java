package com.bsm.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bsm.aopdemo.dao.AccountDAO;
import com.bsm.aopdemo.dao.MembershipDAO;
import com.bsm.aopdemo.service.TrafficFortuneService;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration.class
})

public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cli(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theFortuneService) {
		return (runner) -> {
			//demoTheBeforeAdvice(theMembershipDAO, theAccountDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(theFortuneService);
			demoTheAroundHandleException(theFortuneService);
		};
	}

	private void demoTheAroundHandleException(TrafficFortuneService theFortuneService) {
		System.out.println("\n\nMain Program: AroundDemoApp");
		System.out.println("----");
		boolean tripWire = true;
		System.out.println("Calling getFortune()");
		String data = theFortuneService.getFortune(tripWire);
		System.out.println("\nMy fortune is: " + data);
	}

	private void demoTheAroundAdvice(TrafficFortuneService theFortuneService) {
		System.out.println("\n\nMain Program: AroundDemoApp");
		System.out.println("----");

		System.out.println("Calling getFortune()");
		String data = theFortuneService.getFortune();
		System.out.println("\nMy fortune is: " + data);
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulate exception
			boolean tripWire = false;
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception e) {
			System.out.println("\n\nMain Program: .... caught exception: " + e);
			
		}
		
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");

		System.out.println(theAccounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulate exception
			boolean tripWire = true;
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception e) {
			System.out.println("\n\nMain Program: .... caught exception: " + e);
			
		}
		
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");

		System.out.println(theAccounts);
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");

		System.out.println(theAccounts);
		
		System.out.println("Finished");
	}

	private void demoTheBeforeAdvice(MembershipDAO theMembershipDAO, AccountDAO theAccountDAO) {

		// call the business method
		theAccountDAO.addAccount(new Account("Madhu", "Platinum"), true);
		theAccountDAO.doWork();

		// call getters & setters
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		// membership methods
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

		
	}

}
