package com.groot;

public class Test {
	public static void main(String[] args) {
//		Student s1=Student.getStudent();
//		Student s2=Student.getStudent();
//		System.out.println(s1==s2);
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s1.equals(s2));
//		Student s3=new Student();
//		System.out.println(s1.toString()==s3.toString());
		String str="dfdf";//new String("dfdf");
		String str2=str;
		String str3="dfdf";
		String str5= new String("dfdf");
		System.out.println(str==str5);
		String str4=str.concat("dff");
		System.out.println(str);
//		System.out.println(str==str2);
		System.out.println(str==str3);
		System.out.println(str.equals(str2));
		System.out.println(str.equals(str3));
		System.out.println();
	}
}
