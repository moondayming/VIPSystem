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

public class subButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//获取要增加的手机号和积分数
		String inputPhonenum4 = login.inputPhonenum4.getText();
		String inputScore4 = login.inputScore4.getText();
		
		Pattern pattern = Pattern.compile("[0-9]*");
		if( !pattern.matcher(inputPhonenum4).matches() || !pattern.matcher(inputScore4).matches()) {
			login.showRemainScore4.setText(" 输入的字符非法!");
			return;
		}
		
		//查询数据库
		if(inputPhonenum4.length()==11) {
			if(inputScore4.equals("")) {
				login.showRemainScore4.setText("消费的积分不能为空!");
			}else if(Integer.valueOf(inputScore4)<=0){
				login.showRemainScore4.setText("消费的积分要大于等于1!");
			}
			else {
				Connection c = null;
		        Statement stmt = null;
		        try {
					Class.forName("org.sqlite.JDBC");
					c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//加载数据库
			        c.setAutoCommit(false);
			        stmt = c.createStatement();
			        String sql ="select * from VIPMember where phonenum = '"+inputPhonenum4+"';";
			        ResultSet rs = stmt.executeQuery(sql);
			        int rowCount = 0;   
		            while(rs.next()) {   
		              rowCount++;   
		            }
		            if(rowCount==0) {
		            	stmt.close();
		                c.commit();
		                c.close();
		                login.showRemainScore4.setText("该手机号未注册!");
		            }else {
		            	Date d = new Date();
		            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		            	sql ="update VIPMember set score=score-"+inputScore4+",modified_time = '"+sdf.format(d)+"' where phonenum='"+inputPhonenum4+"';";
		            	stmt.executeUpdate(sql);
		            	sql="select * from VIPMember where phonenum = '"+inputPhonenum4+"';";
		            	rs = stmt.executeQuery(sql);
		            	while(rs.next()) {
		            		int score = rs.getInt("score");
		            		if(score<0) {
		            			login.showRemainScore4.setText("积分余额不足");
		            			sql ="update VIPMember set score=score+"+inputScore4+" where phonenum='"+inputPhonenum4+"';";
				            	stmt.executeUpdate(sql);
		            		}else {
		            			login.showRemainScore4.setText("积分余额："+score);
		            		}
		            		
		            		
		            		
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
			login.showRemainScore4.setText("手机号位数不对!");
		}
	}

}
