package com.xidian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginButtonClickListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//��ȡ������˺ź�����
		String count = login.inputCount.getText();
		String password = new String(login.inputPassword.getPassword());
		String sqlitePassword=null;

		//��ȡ���ݿ��ﱣ����˺ź�����
		Connection c = null;
        Statement stmt = null;
        
        try {
			Class.forName("org.sqlite.JDBC");//jdbc����
			c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//�������ݿ�
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql ="select password from user where count ='"+count+"';";
            ResultSet rs = stmt.executeQuery(sql);
            int rowCount = 0;   
            while(rs.next()) {   
              rowCount++;   
            }
            if(rowCount==0) {
            	stmt.close();
                c.commit();
                c.close();
            	login.notification.setText(" �˺Ų�����!");
            }else {
            	rs = stmt.executeQuery(sql);
            	while(rs.next()) {
            		sqlitePassword=rs.getString("password");
            		if(sqlitePassword!=null) {
            			if(!sqlitePassword.equals(password)) {
            				stmt.close();
                            c.commit();
                            c.close();
            				login.notification.setText(" �������!");
            			}else {
            				stmt.close();
                            c.commit();
                            c.close();
            				login.notification.setText(" ��½�ɹ�!");
            				login.loginframe.setVisible(false);
            				login.barpanel.setVisible(true);
            				login.menupanel.setVisible(true);
            				
            				login.mainpanel.setVisible(true);
            				login.mainpanel2.setVisible(false);
            				login.mainpanel3.setVisible(false);
            				login.mainpanel4.setVisible(false);
            				login.mainpanel5.setVisible(false);
            				
            				login.workframe.setVisible(true);
            				login.loginframe.setVisible(false);
            			}
            		}
            	}
            }
            
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        
		
	}

}
