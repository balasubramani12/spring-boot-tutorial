package com.kvh.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.kvh.cruddemo.dao.StudentDAO;
import com.kvh.cruddemo.entity.Student;
import java.util.List;

import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Opted for clearing all students ...");
		int in = studentDAO.deleteAll();
		System.out.println("Cleared all "+in+" students ...");

	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Processing Your Delete Query ...");
		int id = 2;
		studentDAO.delete(id);
		System.out.println("Deletion Done ...");
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Retreiving Student ...");
		Student theStudent = studentDAO.findById(1);
		System.out.println("Updating the Student Name ...");
		theStudent.setLastName("Bhai");
		studentDAO.update(theStudent);
		System.out.println("Displaying updated data ...");
		System.out.println(studentDAO.findById(1));

	}

	private void queryByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Kumar");

		for(Student s: students){
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for(Student s: students){
			System.out.println("Student"+s.getId()+":\n\t"+"Name: "+s.getFirstName()+" "+s.getLastName()+"\n\tEmail: "+s.getEmail());
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating Student ...");
		Student tempStudent = new Student("Pawan", "Kumar", "pawan@kvh.com");
		//save the student
		System.out.println("Saving the Student ...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Generating...\nStudent Id of new Student: "+tempStudent.getId());
		//retreive student based in the pk
		Student found = studentDAO.findById(tempStudent.getId());
		System.out.println("Displaying Student Data ...");
		// display
		System.out.println("Student Name: "+found.getFirstName()+" "+found.getLastName()+"\nEmail: "+ found.getEmail());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating more students object ...");
		Student tempStudent1 = new Student("Mary", "John", "mary@kvh.com");
		Student tempStudent2 = new Student("Modi", "Ji", "modi@kvh.com");
		Student tempStudent3 = new Student("Mohan", "Lal", "lalji@kvh.com");
		
		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);		
		studentDAO.save(tempStudent3);

		// display id of the saved student
		System.out.println("Saved student1. Generate id: "+ tempStudent1.getId());
		System.out.println("Saved student2. Generate id: "+ tempStudent2.getId());
		System.out.println("Saved student3. Generate id: "+ tempStudent3.getId());
	}

	public void createStudent(StudentDAO studentDAO){
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@kvh.com");
		
		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generate id: "+ tempStudent.getId());
	}

}

