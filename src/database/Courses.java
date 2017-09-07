package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Courses {
	private Connection conn;
	private  String name;
	public Courses(Connection conn)throws SQLException
	{
		this.name=name;
		this.conn=conn;
		PreparedStatement prepareStatement ;
		try {
			//conn.prepareStatement("CREATE TABLE COURSES (ID INTEGER PRIMARY KEY, NAME VARCHAR(20),DESCRIPTION VARCHAR(20), CREDITS INTEGER)").executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			conn.close();
		}
	}
	
	public void addRow(String ID, String NAME, String DESCRIPTION, String CREDITS)throws SQLException
	{
		try {
			conn.prepareStatement("INSERT INTO COURSES (ID, NAME, DESCRIPTION, CREDITS) VALUES ("+ID+", '"+NAME+"', '"+DESCRIPTION+"', "+ CREDITS+")").executeUpdate();
			
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			conn.close();
		}
	}
	
	public int returnID(String n)throws SQLException
	{
		try {
			conn.prepareStatement("SELECT FROM COURSES WHERE NAME='"+n+"'").executeUpdate();
			ResultSet executeQuery=conn.prepareStatement("SELECT FROM COURSES WHERE NAME='"+n+"'").executeQuery();
			while(executeQuery.next())
			{
				return executeQuery.getInt(1);
				
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			conn.close();
		}
		return -1;
	}
	public void show() throws SQLException
	{
		try {
			
			ResultSet executeQuery=conn.prepareStatement("SELECT * FROM Courses").executeQuery();
			while(executeQuery.next())
			{
				System.out.println(executeQuery.getInt(1)+" | " + executeQuery.getString(2)+" | " + executeQuery.getString(3)+" | " + executeQuery.getInt(4));
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			conn.close();
		}
	}
	public void removeRow(String name)throws SQLException
	{
			try {
				conn.prepareStatement("DELETE FROM COURSES\r\n" + "WHERE NAME="+name+")").executeUpdate();
				}
			catch (Exception e)
			{
				System.out.println(e);
			}
			finally {
				conn.close();
			}
	}

}
