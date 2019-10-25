package com.xidian;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class login {
	public static JFrame loginframe;
	public static JPanel loginpanel;
	public static double width;
	public static double height;
	public static JTextField inputCount;
	public static JPasswordField inputPassword;
	public static JLabel notification;
	public static JFrame workframe;
	public static JPanel barpanel;
	public static JPanel menupanel;
	public static JPanel mainpanel;
	public static JLabel lb1;
	public static JLabel lb2;
	public static JLabel lb3;
	public static JLabel lb4;
	public static JLabel lb5;
	public static JLabel lb6;
	public static JTextField inputPhonenum;
	public static JTextField inputScore;
	public static JLabel registerLabel;
	public static JPanel mainpanel2;
	public static JTextField inputPhonenum2;
	public static JLabel showScore;
	public static JLabel showCreated_time;
	public static JLabel showModified_time;
	public static JLabel queryNotification;
	public static JPanel mainpanel3;
	public static JTextField inputPhonenum3;
	public static JTextField inputScore3;
	public static JLabel showRemainScore;
	public static JPanel mainpanel4;
	public static JTextField inputPhonenum4;
	public static JTextField inputScore4;
	public static JLabel showRemainScore4;
	public static JPanel mainpanel5;
	public static JPasswordField inputOldPassword5;
	public static JPasswordField inputNewPassword5;
	public static JLabel changePasswordNotification;
	public static JPanel mainpanel6;
	public static JTextField inputPhonenum6;
	public static JLabel logoutNotification;
	
	public static void main(String[] args) {
		width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		//登陆界面frame
		loginframe = new JFrame("系统登陆");
		loginframe.setSize((int)width, (int)height);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.setResizable(false);
		
		//登陆界面panel
		loginpanel = new JPanel();
		loginpanel.setBounds(0, 0, (int)width, (int)height);
		loginpanel.setBackground(new Color(197,228,251));
		loginframe.add(loginpanel);
		addLoginpanelComponent(loginpanel);
		loginframe.setVisible(true);
		
		//操作界面frame
		workframe = new JFrame("超市会员管理系统");
		workframe.setSize((int)width, (int)height);
		workframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		workframe.setResizable(false);
		workframe.setLayout(null);
		
		//操作界面panel
		//bar
		barpanel = new JPanel();
		barpanel.setBounds(0, 0, (int)width, (int)(height*0.2));
		barpanel.setBackground(new Color(197,228,251));
		workframe.add(barpanel);
		addBarpanelComponent(barpanel);
		barpanel.setVisible(false);
		
		//menu
		menupanel = new JPanel();
		menupanel.setBounds(0, (int)(height*0.2), (int)(width*0.2), (int)(height*0.8));
		menupanel.setBackground(Color.WHITE);
		menupanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		workframe.add(menupanel);
		addMenupanelComponent(menupanel);
		menupanel.setVisible(false);
		
		//main---6种
		mainpanel = new JPanel();
		mainpanel.setBounds((int)(width*0.2), (int)(height*0.2), (int)(width*0.8), (int)(height*0.8));
		mainpanel.setBackground(Color.WHITE);
		mainpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		workframe.add(mainpanel);
		addMainpanelComponent(mainpanel);
		mainpanel.setVisible(false);
		
		mainpanel2 = new JPanel();
		mainpanel2.setBounds((int)(width*0.2), (int)(height*0.2), (int)(width*0.8), (int)(height*0.8));
		mainpanel2.setBackground(Color.WHITE);
		mainpanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		workframe.add(mainpanel2);
		addMainpanel2Component(mainpanel2);
		mainpanel2.setVisible(false);
		
		mainpanel3 = new JPanel();
		mainpanel3.setBounds((int)(width*0.2), (int)(height*0.2), (int)(width*0.8), (int)(height*0.8));
		mainpanel3.setBackground(Color.WHITE);
		mainpanel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		workframe.add(mainpanel3);
		addMainpanel3Component(mainpanel3);
		mainpanel3.setVisible(false);
		
		mainpanel4 = new JPanel();
		mainpanel4.setBounds((int)(width*0.2), (int)(height*0.2), (int)(width*0.8), (int)(height*0.8));
		mainpanel4.setBackground(Color.WHITE);
		mainpanel4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		workframe.add(mainpanel4);
		addMainpanel4Component(mainpanel4);
		mainpanel4.setVisible(false);
		
		mainpanel5 = new JPanel();
		mainpanel5.setBounds((int)(width*0.2), (int)(height*0.2), (int)(width*0.8), (int)(height*0.8));
		mainpanel5.setBackground(Color.WHITE);
		mainpanel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		workframe.add(mainpanel5);
		addMainpanel5Component(mainpanel5);
		mainpanel5.setVisible(false);
		
		mainpanel6 = new JPanel();
		mainpanel6.setBounds((int)(width*0.2), (int)(height*0.2), (int)(width*0.8), (int)(height*0.8));
		mainpanel6.setBackground(Color.WHITE);
		mainpanel6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		workframe.add(mainpanel6);
		addMainpanel6Component(mainpanel6);
		mainpanel6.setVisible(false);
		
		workframe.setVisible(false);
		loginframe.setVisible(true);
	}

	private static void addMainpanel6Component(JPanel mainpanel6) {
		mainpanel6.setLayout(null);
		JLabel phonenum = new JLabel("手机号");
		phonenum.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		phonenum.setBounds((int)(width*0.2), (int)(height*0.2),(int)(width*0.1), (int)(height*0.06));
		mainpanel6.add(phonenum);
		
		inputPhonenum6 = new JTextField(11);
		inputPhonenum6.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		inputPhonenum6.setBounds((int)(width*0.35), (int)(height*0.2), (int)(width*0.18), (int)(height*0.06));
		inputPhonenum6.enableInputMethods(false);
		mainpanel6.add(inputPhonenum6);
		
		JButton logoutButton = new JButton("注销");
		logoutButton.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		logoutButton.setBounds((int)(width*0.3), (int)(height*0.3), (int)(width*0.1), (int)(height*0.06));
		logoutButton.setFocusPainted(false);
		logoutButton.addActionListener(new logoutButtonListener());
		mainpanel6.add(logoutButton);
		
		logoutNotification = new JLabel();
		logoutNotification.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		logoutNotification.setBounds((int)(width*0.15), (int)(height*0.45),(int)(width*0.6), (int)(height*0.15));
		mainpanel6.add(logoutNotification);
	}

	private static void addMainpanel5Component(JPanel mainpanel5) {
		mainpanel5.setLayout(null);
		JLabel phonenum = new JLabel("管理员账号");
		phonenum.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		phonenum.setBounds((int)(width*0.2), (int)(height*0.1),(int)(width*0.15), (int)(height*0.06));
		mainpanel5.add(phonenum);
		
		JLabel count = new JLabel("admin");
		count.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		count.setBounds((int)(width*0.35), (int)(height*0.1), (int)(width*0.15), (int)(height*0.06));
		count.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainpanel5.add(count);
		
		JLabel oldpassword = new JLabel("原密码");
		oldpassword.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		oldpassword.setBounds((int)(width*0.24), (int)(height*0.2),(int)(width*0.15), (int)(height*0.06));
		mainpanel5.add(oldpassword);
		
		inputOldPassword5 = new JPasswordField();
		inputOldPassword5.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		inputOldPassword5.setBounds((int)(width*0.35), (int)(height*0.2), (int)(width*0.15), (int)(height*0.06));
		inputOldPassword5.enableInputMethods(false);
		mainpanel5.add(inputOldPassword5);
		
		JLabel newpassword = new JLabel("新密码");
		newpassword.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		newpassword.setBounds((int)(width*0.24), (int)(height*0.3),(int)(width*0.15), (int)(height*0.06));
		mainpanel5.add(newpassword);
		
		inputNewPassword5 = new JPasswordField();
		inputNewPassword5.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		inputNewPassword5.setBounds((int)(width*0.35), (int)(height*0.3), (int)(width*0.15), (int)(height*0.06));
		inputNewPassword5.enableInputMethods(false);
		mainpanel5.add(inputNewPassword5);
		
		JButton changePasswordButton = new JButton("确定");
		changePasswordButton.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		changePasswordButton.setBounds((int)(width*0.3), (int)(height*0.4), (int)(width*0.1), (int)(height*0.06));
		changePasswordButton.setFocusPainted(false);
		changePasswordButton.addActionListener(new changePasswordButtonListener());
		mainpanel5.add(changePasswordButton);
		
		changePasswordNotification = new JLabel();
		changePasswordNotification.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		changePasswordNotification.setBounds((int)(width*0.15), (int)(height*0.53),(int)(width*0.6), (int)(height*0.15));
		mainpanel5.add(changePasswordNotification);
	}

	private static void addMainpanel4Component(JPanel mainpanel4) {
		mainpanel4.setLayout(null);
		JLabel phonenum = new JLabel("手机号");
		phonenum.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		phonenum.setBounds((int)(width*0.2), (int)(height*0.1),(int)(width*0.1), (int)(height*0.06));
		mainpanel4.add(phonenum);
		
		inputPhonenum4 = new JTextField(11);
		inputPhonenum4.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		inputPhonenum4.setBounds((int)(width*0.35), (int)(height*0.1), (int)(width*0.18), (int)(height*0.06));
		inputPhonenum4.enableInputMethods(false);
		mainpanel4.add(inputPhonenum4);
		
		JLabel score = new JLabel("消费积分");
		score.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		score.setBounds((int)(width*0.18), (int)(height*0.25),(int)(width*0.2), (int)(height*0.06));
		mainpanel4.add(score);
		
		inputScore4 = new JTextField(20);
		inputScore4.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		inputScore4.setBounds((int)(width*0.35), (int)(height*0.25), (int)(width*0.18), (int)(height*0.06));
		inputScore4.enableInputMethods(false);
		mainpanel4.add(inputScore4);
		
		JButton subButton = new JButton("确认");
		subButton.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		subButton.setBounds((int)(width*0.3), (int)(height*0.4), (int)(width*0.1), (int)(height*0.06));
		subButton.setFocusPainted(false);
		subButton.addActionListener(new subButtonListener());
		mainpanel4.add(subButton);
		
		showRemainScore4 = new JLabel();
		showRemainScore4.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.037)));
		showRemainScore4.setBounds((int)(width*0.28), (int)(height*0.55),(int)(width*0.3), (int)(height*0.06));
		mainpanel4.add(showRemainScore4);
	}

	private static void addMainpanel3Component(JPanel mainpanel3) {
		mainpanel3.setLayout(null);
		JLabel phonenum = new JLabel("手机号");
		phonenum.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		phonenum.setBounds((int)(width*0.2), (int)(height*0.1),(int)(width*0.1), (int)(height*0.06));
		mainpanel3.add(phonenum);
		
		inputPhonenum3 = new JTextField(11);
		inputPhonenum3.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		inputPhonenum3.setBounds((int)(width*0.35), (int)(height*0.1), (int)(width*0.18), (int)(height*0.06));
		inputPhonenum3.enableInputMethods(false);
		mainpanel3.add(inputPhonenum3);
		
		JLabel score = new JLabel("增加积分");
		score.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		score.setBounds((int)(width*0.18), (int)(height*0.25),(int)(width*0.2), (int)(height*0.06));
		mainpanel3.add(score);
		
		inputScore3 = new JTextField(20);
		inputScore3.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		inputScore3.setBounds((int)(width*0.35), (int)(height*0.25), (int)(width*0.18), (int)(height*0.06));
		inputScore3.enableInputMethods(false);
		mainpanel3.add(inputScore3);
		
		JButton addButton = new JButton("确认");
		addButton.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		addButton.setBounds((int)(width*0.3), (int)(height*0.4), (int)(width*0.1), (int)(height*0.06));
		addButton.setFocusPainted(false);
		addButton.addActionListener(new addButtonListener());
		mainpanel3.add(addButton);
		
		showRemainScore = new JLabel();
		showRemainScore.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.037)));
		showRemainScore.setBounds((int)(width*0.28), (int)(height*0.55),(int)(width*0.3), (int)(height*0.06));
		mainpanel3.add(showRemainScore);
		
		
	}

	private static void addMainpanel2Component(JPanel mainpanel2) {
		mainpanel2.setLayout(null);
		
		JLabel phonenum = new JLabel("手机号");
		phonenum.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		phonenum.setBounds((int)(width*0.15), (int)(height*0.1),(int)(width*0.1), (int)(height*0.06));
		mainpanel2.add(phonenum);
		
		inputPhonenum2 = new JTextField(11);
		inputPhonenum2.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.035)));
		inputPhonenum2.setBounds((int)(width*0.25), (int)(height*0.1), (int)(width*0.2), (int)(height*0.06));
		inputPhonenum2.enableInputMethods(false);
		mainpanel2.add(inputPhonenum2);
		
		JButton register = new JButton("查询");
		register.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		register.setBounds((int)(width*0.5), (int)(height*0.1), (int)(width*0.1), (int)(height*0.06));
		register.setFocusPainted(false);
		register.addActionListener(new queryListener());
		mainpanel2.add(register);
		
		JLabel score = new JLabel("会员积分");
		score.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		score.setBounds((int)(width*0.13), (int)(height*0.2),(int)(width*0.15), (int)(height*0.06));
		mainpanel2.add(score);
		
		showScore = new JLabel();
		showScore.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.035)));
		showScore.setBounds((int)(width*0.25), (int)(height*0.2),(int)(width*0.2), (int)(height*0.06));
		showScore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainpanel2.add(showScore);
		
		JLabel created_time = new JLabel("注册时间");
		created_time.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		created_time.setBounds((int)(width*0.13), (int)(height*0.3),(int)(width*0.15), (int)(height*0.06));
		mainpanel2.add(created_time);
		
		showCreated_time = new JLabel();
		showCreated_time.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.035)));
		showCreated_time.setBounds((int)(width*0.25), (int)(height*0.3),(int)(width*0.2), (int)(height*0.06));
		showCreated_time.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainpanel2.add(showCreated_time);
		
		JLabel modified_time = new JLabel("修改时间");
		modified_time.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		modified_time.setBounds((int)(width*0.13), (int)(height*0.4),(int)(width*0.15), (int)(height*0.06));
		mainpanel2.add(modified_time);
		
		showModified_time = new JLabel();
		showModified_time.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.035)));
		showModified_time.setBounds((int)(width*0.25), (int)(height*0.4),(int)(width*0.2), (int)(height*0.06));
		showModified_time.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainpanel2.add(showModified_time);
		
		queryNotification = new JLabel();
		queryNotification.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		queryNotification.setBounds((int)(width*0.23), (int)(height*0.5),(int)(width*0.25), (int)(height*0.1));
		mainpanel2.add(queryNotification);
	}

	private static void addMainpanelComponent(JPanel mainpanel) {
		mainpanel.setLayout(null);
		JLabel phonenum = new JLabel("手机号");
		phonenum.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		phonenum.setBounds((int)(width*0.2), (int)(height*0.1),(int)(width*0.1), (int)(height*0.06));
		mainpanel.add(phonenum);
		
		inputPhonenum = new JTextField(11);
		inputPhonenum.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		inputPhonenum.setBounds((int)(width*0.35), (int)(height*0.1), (int)(width*0.18), (int)(height*0.06));
		inputPhonenum.enableInputMethods(false);
		mainpanel.add(inputPhonenum);
		
		JLabel score = new JLabel("会员积分");
		score.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		score.setBounds((int)(width*0.18), (int)(height*0.3),(int)(width*0.2), (int)(height*0.06));
		mainpanel.add(score);
		
		inputScore = new JTextField(20);
		inputScore.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		inputScore.setBounds((int)(width*0.35), (int)(height*0.3), (int)(width*0.18), (int)(height*0.06));
		inputScore.enableInputMethods(false);
		mainpanel.add(inputScore);
		
		JButton register = new JButton("注册");
		register.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		register.setBounds((int)(width*0.28), (int)(height*0.45), (int)(width*0.1), (int)(height*0.06));
		register.setFocusPainted(false);
		register.addActionListener(new registerListener());
		mainpanel.add(register);
		
		registerLabel = new JLabel();
		registerLabel.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.037)));
		registerLabel.setBounds((int)(width*0.26), (int)(height*0.6),(int)(width*0.2), (int)(height*0.06));
		mainpanel.add(registerLabel);
	}

	private static void addMenupanelComponent(JPanel menupanel) {
		menupanel.setLayout(null);
		lb1 = new JLabel("   注册会员");
		lb1.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		lb1.setBounds(0, 0, (int)(width*0.2), (int)(height*0.13));
		lb1.setBorder(BorderFactory.createEtchedBorder());
		lb1.addMouseListener(new lb1MouseListener());
		menupanel.add(lb1);
		
		lb2 = new JLabel("   查询会员");
		lb2.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		lb2.setBounds(0, (int)(height*0.13), (int)(width*0.2), (int)(height*0.13));
		lb2.setBorder(BorderFactory.createEtchedBorder());
		lb2.addMouseListener(new lb2MouseListener());
		menupanel.add(lb2);
		
		lb3 = new JLabel("   增加积分");
		lb3.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		lb3.setBounds(0, (int)(height*0.13*2), (int)(width*0.2), (int)(height*0.13));
		lb3.setBorder(BorderFactory.createEtchedBorder());
		lb3.addMouseListener(new lb3MouseListener());
		menupanel.add(lb3);
		
		lb4 = new JLabel("   消费积分");
		lb4.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		lb4.setBounds(0, (int)(height*0.13*3), (int)(width*0.2), (int)(height*0.13));
		lb4.setBorder(BorderFactory.createEtchedBorder());
		lb4.addMouseListener(new lb4MouseListener());
		menupanel.add(lb4);
		
		lb5 = new JLabel("   修改密码");
		lb5.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		lb5.setBounds(0, (int)(height*0.13*4), (int)(width*0.2), (int)(height*0.13));
		lb5.setBorder(BorderFactory.createEtchedBorder());
		lb5.addMouseListener(new lb5MouseListener());
		menupanel.add(lb5);
		
		lb6 = new JLabel("   注销会员");
		lb6.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.05)));
		lb6.setBounds(0, (int)(height*0.13*5), (int)(width*0.2), (int)(height*0.11));
		lb6.setBorder(BorderFactory.createEtchedBorder());
		lb6.addMouseListener(new lb6MouseListener());
		menupanel.add(lb6);
		
	}

	private static void addBarpanelComponent(JPanel barpanel) {
		barpanel.setLayout(null);
		JLabel title = new JLabel("  超市会员管理系统");
		title.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.06)));
		title.setBounds((int)(width*0.35), (int)(height*0.02), (int)(width*0.6), (int)(height*0.15));
		barpanel.add(title);
	}

	private static void addLoginpanelComponent(JPanel loginpanel) {
		loginpanel.setLayout(null);
		
		JLabel title = new JLabel(" 超市会员管理系统");
		title.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.06)));
		title.setBounds((int)(width*0.35), (int)(height*0.1), (int)(width*0.3), (int)(height*0.1));
		loginpanel.add(title);
		
		JLabel count = new JLabel("账号");
		count.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		count.setBounds((int)(width*0.35), (int)(height*0.3),(int)(width*0.18), (int)(height*0.06));
		loginpanel.add(count);
		
		JLabel psw = new JLabel("密码");
		psw.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		psw.setBounds((int)(width*0.35), (int)(height*0.5),(int)(width*0.18), (int)(height*0.06));
		loginpanel.add(psw);
		
		inputCount = new JTextField(20);
		inputCount.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		inputCount.setBounds((int)(width*0.45), (int)(height*0.3), (int)(width*0.18), (int)(height*0.06));
		inputCount.enableInputMethods(false);
		loginpanel.add(inputCount);
		
		inputPassword = new JPasswordField(20);
		inputPassword.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		inputPassword.setBounds((int)(width*0.45), (int)(height*0.5), (int)(width*0.18), (int)(height*0.06));
		inputPassword.enableInputMethods(false);
		loginpanel.add(inputPassword);
		
		JButton loginButton = new JButton("登陆");
		loginButton.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.03)));
		loginButton.setBounds((int)(width*0.45), (int)(height*0.65), (int)(width*0.1), (int)(height*0.04));
		loginButton.setFocusPainted(false);
		loginButton.addActionListener(new loginButtonClickListener());
		loginpanel.add(loginButton);
		
		notification = new JLabel();
		notification.setFont(new Font("宋体", Font.PLAIN, (int)(height*0.04)));
		notification.setBounds((int)(width*0.43), (int)(height*0.75), (int)(width*0.2), (int)(height*0.06));
		//notification.setBorder(BorderFactory.createLineBorder(Color.red));
		loginpanel.add(notification);
		
	}

	

}
