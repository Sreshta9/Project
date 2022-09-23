package com.probeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demojdbc {
public static Connection connect;
public static Connection getconnect() throws SQLException
{
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/soprasteria","root","Sreshta@9801");
return connect;
}
catch(ClassNotFoundException e)
{
	e.printStackTrace();
}
return null;
}
}
