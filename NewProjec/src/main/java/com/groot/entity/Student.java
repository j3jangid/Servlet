package com.groot.entity;

public class Student {
		int id;
		String name;
		float fee;
		public Student() {
			
		}
		public Student(int id, String name, float fee) {
			super();
			this.id = id;
			this.name = name;
			this.fee = fee;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getFee() {
			return fee;
		}
		public void setFee(float fee) {
			this.fee = fee;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", fee=" + fee + "]";
		}
		
}
