package com.xidian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class registerListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// 读取注册信息
		String phonenum = login.inputPhonenum.getText();
		String score = login.inputScore.getText();
		
		Pattern pattern = Pattern.compile("[0-9]*");
		if( !pattern.matcher(phonenum).matches() || !pattern.matcher(score).matches()) {
			login.registerLabel.setText(" 输入的字符非法!");
			return;
		}
		
		if(phonenum.length()==11) {
			if(score.equals("")) {
				score = "0";
			}
			Connection c = null;
	        Statement stmt = null;
			try {
				Class.forName("org.sqlite.JDBC");//jdbc驱动
				c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//加载数据库
		        c.setAutoCommit(false);
		        stmt = c.createStatement();
		        String sql ="select * from VIPMember where phonenum = '"+phonenum+"';";
		        ResultSet rs = stmt.executeQuery(sql);
		      //判断当前账号是否被注册
		        int rowCount = 0;   
	            while(rs.next()) {   
	              rowCount++;   
	            }
	            if(rowCount!=0) {
	            	stmt.close();
	                c.commit();
	                c.close();
	            	login.registerLabel.setText(" 该手机号已被注册!");
	            }else {
	            	//如果没被注册则保持数据库
	            	Date d = new Date();
	            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	            	sql ="insert into VIPMember values('"+phonenum+"','"+score+"','"+sdf.format(d)+"','"+sdf.format(d)+"');";
	            	stmt.executeUpdate(sql);
	            	stmt.close();
	                c.commit();
	                c.close();
	            	login.registerLabel.setText("     注册成功!");
	            }
		        
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			login.registerLabel.setText(" 手机号位数不对!");
		}
		
	}

}
