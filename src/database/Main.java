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
		
		String url="jdbc:postgresql://localhost/GeekyCamp";
		Properties propsi=new Properties();
		propsi.setProperty("user", "postgres");
		propsi.setProperty("password", "123456ok");
		Connection conn=DriverManager.getConnection(url,propsi);
		
		try{
		Students studentTable=new Students(conn);
		Courses coursesTable=new Courses(conn);
		Faculty facultyTable=new Faculty(conn);
		StudentToCourses studentCourses=new StudentToCourses(conn);
		for(;;)
		{
			Scanner scan=new Scanner(System.in);
			String n=scan.nextLine();
			String[] props=n.split(" ");
			if(props[0].equals("add")&&props[1].equals("student"))studentTable.addRow(props[2], props[3], props[4],props[5]);//id name second name faculty
			if(props[0].equals("add")&&props[1].equals("faculty"))facultyTable.addRow(props[2], props[3]);//id name
			if(props[0].equals("add")&&props[1].equals("courses"))coursesTable.addRow(props[2], props[3],props[4], props[5]);//id name desc credits
			if(props[0].equals("add")&&props[1].equals("courseToStudent"))
			{
				studentCourses.addRow(props[2], props[3]);//student id + course iD
			}
			if(props[0].equals("delete")&&props[1].equals("student"))
				{
				studentTable.removeRow(props[2]);//needs ID
				studentCourses.removeRow(props[2]);//needs ID
				}
			if(props[0].equals("delete")&&props[1].equals("faculty")) {
				studentTable.removeRows(props[2]);
				facultyTable.removeRow(props[2]);
			}
			if(props[0].equals("delete")&&props[1].equals("course"))
			{
				studentCourses.removeRows(coursesTable.returnID(props[2]));
				coursesTable.removeRow(props[2]);
			}
			if(props[0].equals("show")&&props[1].equals("students"))
			{
				studentTable.show();
			}
			if(props[0].equals("show")&&props[1].equals("faculties"))
			{
				facultyTable.show();
			}
			if(props[0].equals("show")&&props[1].equals("courses"))
			{
				coursesTable.show();
			}
			
		}}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{conn.close();}
		
	}
}