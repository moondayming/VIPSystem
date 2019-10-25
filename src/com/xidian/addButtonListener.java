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

public class addButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//获取要增加的手机号和积分数
		String inputPhonenum3 = login.inputPhonenum3.getText();
		String inputScore3 = login.inputScore3.getText();
		
		Pattern pattern = Pattern.compile("[0-9]*");
		if( !pattern.matcher(inputPhonenum3).matches() || !pattern.matcher(inputScore3).matches()) {
			login.showRemainScore.setText(" 输入的字符非法!");
			return;
		}
		
		//查询数据库
		if(inputPhonenum3.length()==11) {
			if(inputScore3.equals("")) {
				login.showRemainScore.setText("增加的积分不能为空!");
			}else if(Integer.valueOf(inputScore3)<=0){
				login.showRemainScore.setText("增加的积分要大于等于1!");
			}
			else {
				Connection c = null;
		        Statement stmt = null;
		        try {
					Class.forName("org.sqlite.JDBC");
					c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//加载数据库
			        c.setAutoCommit(false);
			        stmt = c.createStatement();
			        String sql ="select * from VIPMember where phonenum = '"+inputPhonenum3+"';";
			        ResultSet rs = stmt.executeQuery(sql);
			        int rowCount = 0;   
		            while(rs.next()) {   
		              rowCount++;   
		            }
		            if(rowCount==0) {
		            	stmt.close();
		                c.commit();
		                c.close();
		                login.showRemainScore.setText("该手机号未注册!");
		            }else {
		            	Date d = new Date();
		            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		            	sql ="update VIPMember set score=score+"+inputScore3+",modified_time = '"+sdf.format(d)+"' where phonenum='"+inputPhonenum3+"';";
		            	stmt.executeUpdate(sql);
		            	sql="select * from VIPMember where phonenum = '"+inputPhonenum3+"';";
		            	rs = stmt.executeQuery(sql);
		            	while(rs.next()) {
		            		int score = rs.getInt("score");
		            		login.showRemainScore.setText("积分余额："+score);
		            	}
		            	stmt.close();
		                c.commit();
		                c.close();
		            }
		            
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			
		}else {
			login.showRemainScore.setText("手机号位数不对!");
		}
	}

}
