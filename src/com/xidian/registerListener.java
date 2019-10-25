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
		// ��ȡע����Ϣ
		String phonenum = login.inputPhonenum.getText();
		String score = login.inputScore.getText();
		
		Pattern pattern = Pattern.compile("[0-9]*");
		if( !pattern.matcher(phonenum).matches() || !pattern.matcher(score).matches()) {
			login.registerLabel.setText(" ������ַ��Ƿ�!");
			return;
		}
		
		if(phonenum.length()==11) {
			if(score.equals("")) {
				score = "0";
			}
			Connection c = null;
	        Statement stmt = null;
			try {
				Class.forName("org.sqlite.JDBC");//jdbc����
				c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//�������ݿ�
		        c.setAutoCommit(false);
		        stmt = c.createStatement();
		        String sql ="select * from VIPMember where phonenum = '"+phonenum+"';";
		        ResultSet rs = stmt.executeQuery(sql);
		      //�жϵ�ǰ�˺��Ƿ�ע��
		        int rowCount = 0;   
	            while(rs.next()) {   
	              rowCount++;   
	            }
	            if(rowCount!=0) {
	            	stmt.close();
	                c.commit();
	                c.close();
	            	login.registerLabel.setText(" ���ֻ����ѱ�ע��!");
	            }else {
	            	//���û��ע���򱣳����ݿ�
	            	Date d = new Date();
	            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	            	sql ="insert into VIPMember values('"+phonenum+"','"+score+"','"+sdf.format(d)+"','"+sdf.format(d)+"');";
	            	stmt.executeUpdate(sql);
	            	stmt.close();
	                c.commit();
	                c.close();
	            	login.registerLabel.setText("     ע��ɹ�!");
	            }
		        
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			login.registerLabel.setText(" �ֻ���λ������!");
		}
		
	}

}
