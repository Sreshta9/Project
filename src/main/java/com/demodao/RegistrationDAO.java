package com.demodao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demobeans.Registration;
import com.probeans.Demojdbc;

public class RegistrationDAO {
public boolean insert(Registration reg) {
	String sql="insert into registration values(?,?,?)";
	try {
		PreparedStatement st=Demojdbc.getconnect().prepareStatement(sql);
		st.setInt(1,reg.getEmpId());
		st.setString(2,reg.getEmpName());
		st.setString(3,reg.getEmpmail());
		return st.executeUpdate()>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

private String getDate() {
	String query = "select curdate()";
	PreparedStatement statement;
	String date = null;
	try {
		statement = Demojdbc.getconnect().prepareStatement(query);
		ResultSet res = statement.executeQuery();
		while(res.next()) { date = res.getString(1); }
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return date;
	
}

private String getTime() {
	String query = "select curtime()";
	PreparedStatement statement;
	String time = null;
	try {
		statement = Demojdbc.getconnect().prepareStatement(query);
		ResultSet res = statement.executeQuery();
		while(res.next()) { time = res.getString(1); }
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return time;
	
}

public int userLogin(Registration employee) {
	String query = "insert into userdata(empId, empName, date, login) values(?, ?, ?, ?)";
	String uidQuery = "select uid from userdata where login = ? ";
	
	int uid = 0;

	try {
		
		String date = getDate();
		String loginTime = getTime();
		
		PreparedStatement statement = Demojdbc.getconnect().prepareStatement(query);
		statement.setInt(1, employee.getEmpId());
		statement.setString(2, employee.getEmpName());
		statement.setString(3, date);
		statement.setString(4, loginTime);
		statement.executeUpdate();
		
		PreparedStatement statement1 = Demojdbc.getconnect().prepareStatement(uidQuery);
		statement1.setString(1, loginTime); ;
		ResultSet res3 = statement1.executeQuery();
		while(res3.next()) { uid = res3.getInt(1); }

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return uid;
}

public List<Registration> viewUsers() {
	List<Registration> list = new ArrayList<>();
	Registration user = null;
	String query = "select * from registration";

	try {
		PreparedStatement statement = Demojdbc.getconnect().prepareStatement(query);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			user = new Registration();
			user.setEmpId(res.getInt(1));
			user.setEmpName(res.getString(2));
			user.setEmpmail(res.getString(3));

			list.add(user);
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return list;
}

public boolean userLogout(int uid) {
	String query = "update userdata set logout = ? where uid = ?";

	try {
		
		PreparedStatement statement = Demojdbc.getconnect().prepareStatement(query);
		statement.setString(1, getTime());
		statement.setInt(2, uid);
		
		return statement.executeUpdate() > 0;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
}
