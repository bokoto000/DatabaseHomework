package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Faculty {
	private Connection conn;
	private  String name;
	public Faculty(Connection conn)throws SQLException
	{
		this.name=name;
		this.conn=conn;
		PreparedStatement prepareStatement ;
		try {
			conn.prepareStatement("CREATE TABLE FACULTY (ID INTEGER PRIMARY KEY, NAME VARCHAR(20))").executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void addRow(String ID, String NAME)throws SQLException
	{
		try {
			conn.prepareStatement("INSERT INTO FACULTY (ID, NAME) VALUES ("+ID+", '"+NAME+"')").executeUpdate();
			
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void removeRow(String NAME)throws SQLException
	{
		try {
			conn.prepareStatement("DELETE FROM FACULTY\r\n" + "WHERE ID="+NAME+")").executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void getID(String NAME)throws SQLException
	{
		try {
			conn.prepareStatement("SELECT ID FROM FACULTY\r\n" + "WHERE NAME="+NAME).executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void show() throws SQLException
	{
		try {
			
			ResultSet executeQuery=conn.prepareStatement("SELECT * FROM Faculty").executeQuery();
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

}
