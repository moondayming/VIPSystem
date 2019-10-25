package com.xidian;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class lb4MouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		login.lb1.setBackground(null);
		login.lb2.setBackground(null);
		login.lb3.setBackground(null);
		login.lb4.setBackground(Color.BLUE);
		login.lb5.setBackground(null);
		login.lb6.setBackground(null);
		login.mainpanel.setVisible(false);
		login.mainpanel2.setVisible(false);
		login.mainpanel3.setVisible(false);
		login.mainpanel4.setVisible(true);
		login.mainpanel5.setVisible(false);
		login.mainpanel6.setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		login.lb1.setBackground(null);
		login.lb2.setBackground(null);
		login.lb3.setBackground(null);
		login.lb4.setBackground(Color.BLUE);
		login.lb5.setBackground(null);
		login.lb6.setBackground(null);
		login.mainpanel.setVisible(false);
		login.mainpanel2.setVisible(false);
		login.mainpanel3.setVisible(false);
		login.mainpanel4.setVisible(true);
		login.mainpanel5.setVisible(false);
		login.mainpanel6.setVisible(false);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		login.lb1.setBackground(null);
		login.lb2.setBackground(null);
		login.lb3.setBackground(null);
		login.lb4.setBackground(Color.BLUE);
		login.lb5.setBackground(null);
		login.lb6.setBackground(null);
		login.mainpanel.setVisible(false);
		login.mainpanel2.setVisible(false);
		login.mainpanel3.setVisible(false);
		login.mainpanel4.setVisible(true);
		login.mainpanel5.setVisible(false);
		login.mainpanel6.setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
