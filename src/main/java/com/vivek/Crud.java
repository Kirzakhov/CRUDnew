package com.vivek;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Crud")
public class Crud extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String btn = request.getParameter("btn");
		CrudOps co = new CrudOps();
		if(btn.equals("Insert")) {
			int roll = Integer.parseInt(request.getParameter("roll"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String add = request.getParameter("address");
			try {
				int i = co.insert(roll, name, age, add);
				if(i>0) {
					out.println("Record Inserted");
				}
				else {
					out.println("Not Inserted");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		else if(btn.equals("Update")) {
			int roll = Integer.parseInt(request.getParameter("roll"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String add = request.getParameter("address");
			try {
				int i = co.update(roll, name, age, add);
				if(i>0) {
					out.println("Record Updated");
				}
				else {
					out.println("Not Updated");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		else if(btn.equals("Delete")) {
			int roll = Integer.parseInt(request.getParameter("roll"));
			try {
				int i = co.delete(roll);
				if(i>0) {
					out.println("Record Deleted");
				}
				else {
					out.println("Not Deleted");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		else if(btn.equals("Display")) {
			int roll = Integer.parseInt(request.getParameter("roll"));
			try {
				ResultSet rs = co.display(roll);
				int r = rs.getInt(1);
				String n = rs.getString(2);
				int a = rs.getInt(3);
				String add = rs.getString(4);
				out.println("Roll  Name  Age  Address");
				out.println(r+"/t"+n+"/t"+a+"/t"+add);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(btn.equals("DisplayAll")) {
			try {
				ResultSet rs = co.displayAll();
				out.println("Roll  Name  Age  Address");
				while(rs.next()) {
					int r = rs.getInt("roll");
					String n = rs.getString("name");
					int a = rs.getInt("age");
					String add = rs.getString("address");
					out.println(r+"/t"+n+"/t"+a+"/t"+add);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
