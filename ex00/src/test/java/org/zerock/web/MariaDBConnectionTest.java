package org.zerock.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MariaDBConnectionTest {

	public static final String DRIVER ="org.mariadb.jdbc.Driver";
	public static final String URL ="jdbc:mariadb://localhost:3306/root";
	public static final String USER ="root";
	public static final String PW ="dhfpswl7";
	
	@Test  
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try {
			Connection con = DriverManager.getConnection(URL,USER,PW);
			System.out.println(con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
