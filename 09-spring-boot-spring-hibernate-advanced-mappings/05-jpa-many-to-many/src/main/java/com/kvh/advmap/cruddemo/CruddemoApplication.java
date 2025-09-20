package com.kvh.advmap.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kvh.advmap.cruddemo.dao.AppDAO;
import com.kvh.advmap.cruddemo.entity.Course;
import com.kvh.advmap.cruddemo.entity.Instructor;
import com.kvh.advmap.cruddemo.entity.InstructorDetail;
import com.kvh.advmap.cruddemo.entity.Review;
import com.kvh.advmap.cruddemo.entity.Student;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(AppDAO appDAO){
		return runner ->{
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourses(appDAO);
			//addCoursesForStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}
	

	

	private void deleteStudent(AppDAO appDAO) {
		
		int theId = 1;
		System.out.println("Deleting the student with id: "+theId);
		appDAO.deleteStudentById(theId);
		System.out.println("Deleted the student with id: "+theId);
	}

	private void addCoursesForStudent(AppDAO appDAO) {
		int theId = 1;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Loaded Student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());

		Course tempCourse1 = new Course("React Advanced.");
		Course tempCourse2 = new Course("Java For Complete Placement Guide.");
		
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Saving the courses....");
		System.out.println("Courses: "+tempStudent.getCourses());
		appDAO.update(tempStudent);
		System.out.println("Done saving the courses....");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 1;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsById(theId);
		System.out.println("Course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		System.out.println("Creating a course and students....");
		// create a course
		// create the students
		// add students to the course
		// save the course and students
		Course tempCourse = new Course("Spring Boot - Part 1");
		Student tempStudent1 = new Student("Bunny", "H", "bunny@starverse.com");
		Student tempStudent2 = new Student("Sam", "Mary", "sam_mary@starverse.com");
		Student tempStudent3 = new Student("Roshan", "Oak", "roshanok@starverse.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);
		System.out.println("Saving the course: "+tempCourse);
		System.out.println("The students: "+tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("Done saving the course and students....");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		System.out.println("Deleting the course and reviews....");
		int theId = 10;
		appDAO.deleteCourseById(theId);
		System.out.println("Deleted the course and reviews....");
	}

	private void retreiveCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsById(theId);
		System.out.println("Course: "+tempCourse);
		System.out.println("Reviews: "+tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		//Create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		//add some reviews
		Review tempReview1 = new Review("Great course... loved it!");
		Review tempReview2 = new Review("Cool course, job well done");
		Review tempReview3 = new Review("What a dumb course, you are an idiot!");

		tempCourse.setReviews(java.util.Arrays.asList(tempReview1, tempReview2, tempReview3));

		//save the course ... and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());		
		appDAO.save(tempCourse);
		System.out.println("Done saving the course and reviews");	
		

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

	// create an instructor and courses
	public void createInstructorWithCourses(AppDAO appDAO){
		// create the instructor
		Instructor tempInstructor=new Instructor("Bros", "Code","bcode@gmail.com");
		// create the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com/bcode","Cricket,VolleyBall,Tennis");
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		// create some courses
		Course tempCourse1=new Course("React Adv");
		Course tempCourse2=new Course("Python for Beginners");
		Course tempCourse3=new Course("Web Development from Scratch");
		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);
		// save the instructor
		// this will also save the courses
		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done saving instructor: "+tempInstructor);
	}
	// find the instructor and courses
	public void findInstructorWithCourses(AppDAO appDAO){
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("Found instructor: "+tempInstructor);
		System.out.println("Courses: "+tempInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		Instructor tempInstructor = appDAO.findInstructorById(1);
		System.out.println("tempInstructor"+ tempInstructor);
		System.out.println("Finding the courses associated with Instructor......");
		System.out.println(appDAO.findCoursesByInstructorId(1));
	}
	
	private void findCoursesForInstructorJoinFetch(AppDAO appDAO) {
		int theId = 1;

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Finding the Instructor with Id: 1,............");
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Courses Asscoiated: " + tempInstructor.getCourses());
		System.out.println("Query Excueted Successfully...!!!");
	}
	//update Instructor
	public void updateInstructor(AppDAO appDAO){
		Instructor theInstructor = appDAO.findInstructorById(1);
		theInstructor.setEmail("kvhme@starverse.com");
		theInstructor.setFirstName("Cheekati");
		System.out.println("Updating the existing entity,........");
		appDAO.update(theInstructor);
		System.out.println(theInstructor);
		System.out.println("Process executed(0)");
		
	}
	//update Courses
	public void updateCourse(AppDAO appDAO){
		int id = 10;
		Course tempCourse = appDAO.findCourseById(id);
		tempCourse.setTitle("Spring Boot Tutorial, Part - 1");
		System.out.println("Updating the existing Course entity,........");
		appDAO.updateCourse(tempCourse);
		System.out.println(tempCourse);

		tempCourse = appDAO.findCourseById(11);
		tempCourse.setTitle("Spring Boot Tutorial, Part - 2");
		System.out.println("Updating the existing Course entity,........");
		appDAO.updateCourse(tempCourse);
		System.out.println(tempCourse);
		System.out.println("Process executed(0)");
		
	}

	public void deleteCourse(AppDAO appDAO) {
		int id = 11;
		System.out.println("Deleting the course,....."+id);
		appDAO.deleteCourseById(id);
		System.out.println("Exceuted Done (0)");
	}
}

