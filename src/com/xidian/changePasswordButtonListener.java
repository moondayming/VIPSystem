package com.xidian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;

public class changePasswordButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//得到原密码和新密码
		String oldPassword = new String(login.inputOldPassword5.getPassword());
		String newPassword = new String(login.inputNewPassword5.getPassword());
		
		//查询原密码
		Connection c = null;
        Statement stmt = null;
        try {
        	Class.forName("org.sqlite.JDBC");//jdbc驱动
			c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//加载数据库
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql ="select * from user;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	String password = rs.getString("password");
            	if(password.equals(oldPassword)) {
            		//更新密码
            		if(!newPassword.equals("")) {
            			sql ="update user set password = '"+newPassword+"';";
                        stmt.executeUpdate(sql);
                        login.changePasswordNotification.setText("修改密码成功，新密码为:"+newPassword+",请牢记!");
                        stmt.close();
                        c.commit();
                        c.close();
            		}else {
            			stmt.close();
                        c.commit();
                        c.close();
                        login.changePasswordNotification.setText("         新密码为空,请重试!");
            		}
            		
            	}else {
            		stmt.close();
                    c.commit();
                    c.close();
                    login.changePasswordNotification.setText("         原密码错误,请重试!");
            	}
            }
        }catch(Exception e1) {
        	e1.printStackTrace();
        }

	}

}
