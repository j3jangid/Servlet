package com.groot;

public class Student {
	private static Student s=new Student();
	private Student() {
		
	}
	public static Student getStudent() {
		return s;
	}
}
