package com.bitlabs.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.bitlabs.SpringOrm.Student;

public class StudentDaoImpl implements StudentDaoInterface{

	private HibernateTemplate hibernatetemplate;
	
	
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

	@Transactional
	public int saveStudent(Student st) {
		
		int i= (Integer)hibernatetemplate.save(st);
		return i;
	}

	public Student getStudent(int id) {
		Student st=hibernatetemplate.get(Student.class,id);
		
		return st;
	}

	public List<Student> getAllStudents() {
		List<Student> list= hibernatetemplate.loadAll(Student.class);
		return list;
	}

	@Transactional
	public void UpdateStudent(Student st) {
		hibernatetemplate.update(st);
	}

	
	@Transactional
	public void deleteStudent(int id) {
		Student stm=hibernatetemplate.get(Student.class,id);
		hibernatetemplate.delete(stm);
		
	}
	
	
	
	

}
