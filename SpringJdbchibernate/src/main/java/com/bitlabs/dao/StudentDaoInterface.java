package com.bitlabs.dao;

import java.util.List;





public interface StudentDaoInterface {

	 public int saveStudent(Student st);
	 public Student getStudent(int id);
	 public List<Student> getAllStudents();
	 public void UpdateStudent(Student st);
	 public void deleteStudent(int id);
	 
}
