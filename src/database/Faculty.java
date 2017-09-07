package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Faculty {
	public String url="jdbc:postgresql://localhost/GeekyCamp";
	public Properties props=new Properties();
	private Connection conn=DriverManager.getConnection(url,props);
	private  String name;
	public Faculty()throws SQLException
	{
		this.name=name;
		props.setProperty("user", "postgres");
		props.setProperty("password", "123456ok");
		conn=DriverManager.getConnection(url,props);
		PreparedStatement prepareStatement ;
		try {
			//conn.prepareStatement("CREATE TABLE FACULTY (ID INTEGER PRIMARY KEY, NAME VARCHAR(20))").executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			conn.close();
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
		finally {
			conn.close();
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
		finally {
			conn.close();
		}
	}
	
	public void getID(String NAME)throws SQLException
	{
		try {
			conn.prepareStatement("SELECT ID FROM FACULTY\r\n" + "WHERE NAME="+NAME+")").executeUpdate();
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
