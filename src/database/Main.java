package database;
import database.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws SQLException 
	{
		
		Students studentTable=new Students();
		Courses coursesTable=new Courses();
		Faculty facultyTable=new Faculty();
		StudentToCourses studentCourses=new StudentToCourses();
		for(;;)
		{
			Scanner scan=new Scanner(System.in);
			String n=scan.nextLine();
			String[] props=n.split(" ");
			if(props[0]=="add"&&props[1]=="student")studentTable.addRow(props[2], props[3], props[4]);
			if(props[0]=="add"&&props[1]=="faculty")facultyTable.addRow(props[2], props[3]);
			if(props[0]=="add"&&props[1]=="coursesTable")coursesTable.addRow(props[2], props[3],props[4], props[5]);
			if(props[0]=="delete"&&props[1]=="student")studentTable.removeRow(props[2]);
			if(props[0]=="delete"&&props[1]=="faculty") {
				facultyTable.removeRow(props[2]);
			    
			}
		}
		
	}