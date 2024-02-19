package com.gamze.cruddemo;

import com.gamze.cruddemo.dao.StudentDAO;
import com.gamze.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);


	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students..");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve studen based on the id:primary key
		int studentId=3;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to Scooby
		System.out.println("updating student.." );
		myStudent.setFirstName("Scooby");

		//update the Student
		studentDAO.update(myStudent);

		//display the updated Student
		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents= studentDAO.findByLastName("Sakallı");
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findAll();
		//display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new students object...");
		Student tempStudent=new Student("Daffy", "Duck","daffy@outlook.com");

		//save the student
		studentDAO.save(tempStudent);

		//display id of the saved student

		int theId=tempStudent.getId();
		System.out.println("Saved the student. Generated id: "+theId);

		//retrieve the student based on the id: primary key
		Student myStudent=studentDAO.findById(theId);
		//display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 students object...");
		Student tempStudent1=new Student("John", "Doe","john@outlook.com");
		Student tempStudent2=new Student("Carla", "Public","carla@outlook.com");
		Student tempStudent3=new Student("Mary", "Applebum","mary@outlook.com");
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("Gamze", "Sakallı","gamzesakalli@outlook.com");
		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());

	}

}
