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
		//�õ�ԭ�����������
		String oldPassword = new String(login.inputOldPassword5.getPassword());
		String newPassword = new String(login.inputNewPassword5.getPassword());
		
		//��ѯԭ����
		Connection c = null;
        Statement stmt = null;
        try {
        	Class.forName("org.sqlite.JDBC");//jdbc����
			c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//�������ݿ�
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql ="select * from user;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	String password = rs.getString("password");
            	if(password.equals(oldPassword)) {
            		//��������
            		if(!newPassword.equals("")) {
            			sql ="update user set password = '"+newPassword+"';";
                        stmt.executeUpdate(sql);
                        login.changePasswordNotification.setText("�޸�����ɹ���������Ϊ:"+newPassword+",���μ�!");
                        stmt.close();
                        c.commit();
                        c.close();
            		}else {
            			stmt.close();
                        c.commit();
                        c.close();
                        login.changePasswordNotification.setText("         ������Ϊ��,������!");
            		}
            		
            	}else {
            		stmt.close();
                    c.commit();
                    c.close();
                    login.changePasswordNotification.setText("         ԭ�������,������!");
            	}
            }
        }catch(Exception e1) {
        	e1.printStackTrace();
        }

	}

}
