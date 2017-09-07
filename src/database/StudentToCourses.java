package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class StudentToCourses {
	private Connection conn;
	private  String name;
	public StudentToCourses(Connection conn)throws SQLException
	{
		this.name=name;
		this.conn=conn;
		PreparedStatement prepareStatement ;
		try {
			conn.prepareStatement("CREATE TABLE StudentToCourses (ID INTEGER PRIMARY KEY, COURSEID INTEGER)").executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void showStudents(String ID)
	{
		try {                                                                                     
            
			ResultSet executeQuery=conn.prepareStatement("SELECT * FROM StudentToCourses WHERE ID=ID").executeQuery(); 
			while(executeQuery.next())                                                            
			{                                                                                     
				System.out.println(executeQuery.getInt(1)+" | " + executeQuery.getString(2));     
			}                                                                                     
		}                                                                                         
		catch (Exception e)                                                                       
		{                                                                                         
			System.out.println(e);                                                                
		}                                                                                         
	}
	public void addRow(String ID, String NAME)throws SQLException
	{
		try {
			conn.prepareStatement("INSERT INTO SudentToCourses (ID, COURSEID) VALUES ("+ID+", '"+NAME+"')").executeUpdate();
			
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void removeRow(String ID)throws SQLException
	{
		try {
			conn.prepareStatement("DELETE  FROM FACULTY\r\n" + "WHERE ID="+ID).executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void removeRows(int id)throws SQLException
	{
		try {
			conn.prepareStatement("DELETE  FROM FACULTY\r\n" + "WHERE COURSEID="+id).executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
}
