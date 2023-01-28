package com.bitlabs.dao;

import java.util.List;


import com.bitlabs.SpringOrm.Student;

public interface StudentDaoInterface {

	 public int saveStudent(Student st);
	 public Student getStudent(int id);
	 public List<Student> getAllStudents();
	 public void UpdateStudent(Student st);
	 public void deleteStudent(int id);
	 
}
