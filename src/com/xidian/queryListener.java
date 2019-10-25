package com.xidian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

public class queryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//得到要查询的号码
		String inputPhonenum2 = login.inputPhonenum2.getText();
		
		Pattern pattern = Pattern.compile("[0-9]*");
		if( !pattern.matcher(inputPhonenum2).matches()) {
			login.queryNotification.setText(" 输入的字符非法!");
			return;
		}
		
		if(inputPhonenum2.length()==11) {
			//数据库查询
			Connection c = null;
	        Statement stmt = null;
	        try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//加载数据库
		        c.setAutoCommit(false);
		        stmt = c.createStatement();
		        String sql ="select * from VIPMember where phonenum = '"+inputPhonenum2+"';";
		        ResultSet rs = stmt.executeQuery(sql);
		        int rowCount = 0;   
	            while(rs.next()) {   
	              rowCount++;   
	            }
	            if(rowCount==0) {
	            	stmt.close();
	                c.commit();
	                c.close();
	                login.showScore.setText("");
            		login.showCreated_time.setText("");
            		login.showModified_time.setText("");
	            	login.queryNotification.setText("该会员账号未注册!");
	            }else {
	            	rs = stmt.executeQuery(sql);
	            	while(rs.next()) {
	            		int score = rs.getInt("score");
	            		String created_time = rs.getString("created_time").replaceAll("_", " ");
	            		String modified_time = rs.getString("modified_time").replaceAll("_", " ");
	            		login.showScore.setText(String.valueOf(score));
	            		login.showCreated_time.setText(created_time);
	            		login.showModified_time.setText(modified_time);
	            		stmt.close();
	                    c.commit();
	                    c.close();
	                    login.queryNotification.setText(" 查询成功!");
	            	}
	            }
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			login.showScore.setText("");
    		login.showCreated_time.setText("");
    		login.showModified_time.setText("");
			login.queryNotification.setText("手机号位数不对!");
		}
		
		
		
	}

}
