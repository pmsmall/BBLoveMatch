package com.entrance.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.game.frame.GameFrame;

public class Listener implements ActionListener {
	public String acount, key, getname, getkey;
	JTextField name = new JTextField();
	JTextField keyfield = new JTextField();
	JFrame jf = new JFrame();

	public Listener(String acount, String key, JTextField name, JTextField keyfield, JFrame jf) {
		this.acount = acount;
		this.key = key;
		this.name = name;
		this.keyfield = keyfield;
		this.jf = jf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		getname = name.getText();
		getkey = keyfield.getText();
		if (getname.equals(acount) && getkey.equals(key)) {
			jf.setVisible(false);
			GameFrame it = new GameFrame();
			it.setVisible(true);
		} else if (getname.equals(acount) && !getkey.equals(key))
			JOptionPane.showMessageDialog(null, "您输入的密码不对，请重新输入");
		else if (!getname.equals(acount) && getkey.equals(key))
			JOptionPane.showMessageDialog(null, "您输入的账号不对，请重新输入");
		else
			JOptionPane.showMessageDialog(null, "您输入的账号和密码都不对，请重新输入");
	}
}
