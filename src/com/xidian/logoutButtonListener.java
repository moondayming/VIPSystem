package com.xidian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

public class logoutButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputPhonenum6 = login.inputPhonenum6.getText();
		
		Pattern pattern = Pattern.compile("[0-9]*");
		if( !pattern.matcher(inputPhonenum6).matches()) {
			login.logoutNotification.setText("        ������ַ��Ƿ�!");
			return;
		}
		
		if(inputPhonenum6.length()==11) {
			Connection c = null;
	        Statement stmt = null;
	        try {
	        	Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//�������ݿ�
		        c.setAutoCommit(false);
		        stmt = c.createStatement();
		        String sql ="select * from VIPMember where phonenum = '"+inputPhonenum6+"';";
		        ResultSet rs = stmt.executeQuery(sql);
		        int rowCount = 0;   
	            while(rs.next()) {   
	              rowCount++;   
	            }
	            if(rowCount==0) {
	            	login.logoutNotification.setText("        ���ֻ���δע��!");
	            	stmt.close();
	                c.commit();
	                c.close();
	            }else {
	            	sql = "delete from VIPMember where phonenum = '"+inputPhonenum6+"';";
	            	stmt.executeUpdate(sql);
	            	stmt.close();
	                c.commit();
	                c.close();
	                login.logoutNotification.setText("        ���ֻ�����ע���ɹ�!");
	            }
		        
	        }catch(Exception e1) {
	        	e1.printStackTrace();
	        }
	        
		}else {
			login.logoutNotification.setText("        �ֻ���λ������!");
		}

	}

}
