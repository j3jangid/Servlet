package com.groot.respo;

import java.sql.ResultSet;
import java.util.List;

import com.groot.entity.Student;

public interface StudentDB {
		public int add(Student st);
		public int update(Student st);
		public int delete(Student st);
		public int deleteById(int  id);
		public int deleteById(Student  id);
		public ResultSet getStudents();
		public Student getStudent();
		public List<Student> getStudentList();
}
