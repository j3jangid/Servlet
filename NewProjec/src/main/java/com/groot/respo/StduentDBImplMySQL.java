package com.groot.respo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.groot.entity.Student;

public class StduentDBImplMySQL implements StudentDB{
	Connection conn=GetConnectiopn.getConnection();
	@Override
	public int add(Student st) {
		PreparedStatement ps=null;
		int i=0;
		// TODO Auto-generated method stub
		try {
			ps=conn.prepareStatement("insert into student (name,fee) values(?,?)");
			ps.setString(1, st.getName());
			ps.setFloat(2, st.getFee());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int update(Student st) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Student st) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Student id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return null;
	}

}