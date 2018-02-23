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
			JOptionPane.showMessageDialog(null, "����������벻�ԣ�����������");
		else if (!getname.equals(acount) && getkey.equals(key))
			JOptionPane.showMessageDialog(null, "��������˺Ų��ԣ�����������");
		else
			JOptionPane.showMessageDialog(null, "��������˺ź����붼���ԣ�����������");
	}
}
