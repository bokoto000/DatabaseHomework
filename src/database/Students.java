package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Students {
	private Connection conn;
	private  String name;
	public Students(Connection conn)throws SQLException
	{
		this.name=name;
		this.conn=conn;
		PreparedStatement prepareStatement ;
		try {
			conn.prepareStatement("CREATE TABLE STUDENTS (ID INTEGER PRIMARY KEY, FIRST_NAME VARCHAR(20),LAST_NAME VARCHAR(20),FACULTY VARCHAR(20))").executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void addRow(String ID, String first_name, String last_name, String Faculty)throws SQLException
	{
		try {
			conn.prepareStatement("INSERT INTO STUDENTS (ID, FIRST_NAME, LAST_NAME) VALUES ("+ID+", '"+
			first_name+"', '"+last_name+"','"+Faculty+"')").executeUpdate();
			
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void removeRow(String ID)throws SQLException
	{
		try {
			conn.prepareStatement("DELETE FROM Students\r\n" + "WHERE ID="+ID+")").executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void removeRows(String s)throws SQLException
	{
		try {
			ResultSet executeQuery=conn.prepareStatement("SELECT FROM Students WHERE FACULTY='"+s+"')").executeQuery();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void show() throws SQLException
	{
		try {
			
			ResultSet executeQuery=conn.prepareStatement("SELECT * FROM STUDENTS").executeQuery();
			while(executeQuery.next())
			{
				System.out.println(executeQuery.getInt(1)+" | " + executeQuery.getString(2)+" | " + executeQuery.getString(3)+" | " + executeQuery.getString(4));
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
