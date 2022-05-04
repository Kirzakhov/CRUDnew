package com.vivek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudOps {
	Connection con = Connectivity.getConnection();
	PreparedStatement pst = null;
	ResultSet rs = null;
	public int insert(int roll, String name, int age, String add) throws SQLException {
		String q = "insert into student values(?,?,?,?)";
		pst = con.prepareStatement(q);
		pst.setInt(1, roll);
		pst.setString(2, name);
		pst.setInt(3, age);
		pst.setString(4, add);
		int i = pst.executeUpdate();
		return i;
	}

	public int update(int roll, String name, int age, String add) throws SQLException {
		
		String s = "select * from student where rollno=?";
		pst = con.prepareStatement(s);
		pst.setInt(1, roll);
		rs = pst.executeQuery();
		int i = 0;
		if(rs.next()) {
			String q = "insert into student values(?,?,?,?)";
			pst = con.prepareStatement(q);
			pst.setInt(1, roll);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.setString(4, add);
			i = pst.executeUpdate();
		}
		return i;
	}

	public int delete(int roll) throws SQLException {
		String s = "select * from student where rollno=?";
		pst = con.prepareStatement(s);
		pst.setInt(1, roll);
		rs = pst.executeQuery();
		int i = 0;
		if(rs.next()) {
			String q = "delete from student where rollno=?";
			pst = con.prepareStatement(q);
			pst.setInt(1, roll);
			i = pst.executeUpdate();
		}
		return i;
	}

	public ResultSet display(int roll) throws SQLException {
		String s = "select * from student where rollno=?";
		pst = con.prepareStatement(s);
		pst.setInt(1, roll);
		rs = pst.executeQuery();
		return rs;
		
	}

	public ResultSet displayAll() throws SQLException {
		String s = "select * from student";
		pst = con.prepareStatement(s);
		rs = pst.executeQuery();
		return rs;
		
	}

}
