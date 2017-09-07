package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Students {
	public String url="jdbc:postgresql://localhost/GeekyCamp";
	public Properties props=new Properties();
	private Connection conn=DriverManager.getConnection(url,props);
	private  String name;
	public Students()throws SQLException
	{
		this.name=name;
		props.setProperty("user", "postgres");
		props.setProperty("password", "123456ok");
		conn=DriverManager.getConnection(url,props);
		PreparedStatement prepareStatement ;
		try {
			//conn.prepareStatement("CREATE TABLE STUDENTS (ID INTEGER PRIMARY KEY, FIRST_NAME VARCHAR(20),LAST_NAME VARCHAR(20))").executeUpdate();
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			conn.close();
		}
	}
	
	public void addRow(String ID, String first_name, String last_name)throws SQLException
	{
		try {
			conn.prepareStatement("INSERT INTO STUDENTS (ID, FIRST_NAME, LAST_NAME) VALUES ("+ID+", '"+first_name+"', '"+last_name+")").executeUpdate();
			
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			conn.close();
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
		finally {
			conn.close();
		}
	}
	

}
