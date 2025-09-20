package com.kvh.advmap.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kvh.advmap.cruddemo.dao.AppDAO;
import com.kvh.advmap.cruddemo.entity.Instructor;
import com.kvh.advmap.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(AppDAO appDAO){
		return runner ->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
			
		};
	}
	// create the instructor and the instructor detail objects
	public void createInstructor(AppDAO appDAO){
		// create the instructor
		Instructor tempInstructor=new Instructor("Balasubramani","H","bala@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com/bala","Guitar,Cricket,Carrom,FreeFire");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		// save the instructor
		// Note: this will also save the details object
		// because of CascadeType.ALL
		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done saving instructor: "+tempInstructor);
	}
	// find the instructor by id
	public void findInstructor(AppDAO appDAO){
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("Found instructor: "+tempInstructor);
		System.out.println("The associated instructor detail: "+tempInstructor.getInstructorDetail());
	}	
	//delete the instructor by id
	public void deleteInstructor(AppDAO appDAO){
		int theId=1;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted instructor id: "+theId);
	}

	//find the instructor detail by id
	public void findInstructorDetail(AppDAO appDAO){
		int theId=2;
		System.out.println("Finding instructor detail id: "+theId);
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);
		System.out.println("Found instructor detail: "+tempInstructorDetail);
		System.out.println("The associated instructor: "+tempInstructorDetail.getInstructor());
	}
	//delete the instructor detail by id
	public void deleteInstructorDetail(AppDAO appDAO){
		int theId=2;
		System.out.println("Deleting instructor detail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Deleted instructor detail id: "+theId);
	}
}
