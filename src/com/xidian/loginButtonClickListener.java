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
		//读取输入的账号和密码
		String count = login.inputCount.getText();
		String password = new String(login.inputPassword.getPassword());
		String sqlitePassword=null;

		//读取数据库里保存的账号和密码
		Connection c = null;
        Statement stmt = null;
        
        try {
			Class.forName("org.sqlite.JDBC");//jdbc驱动
			c = DriverManager.getConnection("jdbc:sqlite:D:/UserTable.db");//加载数据库
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
            	login.notification.setText(" 账号不存在!");
            }else {
            	rs = stmt.executeQuery(sql);
            	while(rs.next()) {
            		sqlitePassword=rs.getString("password");
            		if(sqlitePassword!=null) {
            			if(!sqlitePassword.equals(password)) {
            				stmt.close();
                            c.commit();
                            c.close();
            				login.notification.setText(" 密码错误!");
            			}else {
            				stmt.close();
                            c.commit();
                            c.close();
            				login.notification.setText(" 登陆成功!");
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
