package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Courses {
	public String url="jdbc:postgresql://localhost/GeekyCamp";
	public Properties props=new Properties();
	private Connection conn=DriverManager.getConnection(url,props);
	private  String name;
	public Courses()throws SQLException
	{
		this.name=name;
		props.setProperty("user", "postgres");
		props.setProperty("password", "123456ok");
		conn=DriverManager.getConnection(url,props);
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
			conn.prepareStatement("INSERT INTO COURSES (ID, FIRST_NAME, LAST_NAME) VALUES ("+ID+", '"+NAME+"', '"+DESCRIPTION+"', "+ CREDITS+")").executeUpdate();
			
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			conn.close();
		}
	}
	
	
	public void removeRow()
	{
		
	}

}
