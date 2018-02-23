package com.entrance;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

import com.entrance.listener.Listener;

public class Load {
	
	public JPanel centerPanel, southPanel, northPanel,
	westPanel, midwestPanel, mideastPanel, midcenterPanel,westnorthPanel, weatsouthPanet, eastPanel; 
	public java.lang.String acount="123456" , key="123456"; 

	/**
	 * @param args
	 */
	public void login()  {
		centerPanel = new JPanel();
		southPanel = new JPanel();
		northPanel = new JPanel();
		westPanel = new JPanel();
		eastPanel = new JPanel();
		midwestPanel = new JPanel();
		mideastPanel = new JPanel();
		midcenterPanel = new JPanel();
		westnorthPanel = new JPanel();
		weatsouthPanet = new JPanel();
		JPanel cwn = new JPanel();
		JPanel cws = new JPanel();
		JPanel wwn = new JPanel();
		JPanel wws = new JPanel();
		
		// TODO Auto-generated method stub
		javax.swing.JFrame jf = new javax.swing.JFrame();
		jf.setSize(445,374);
		jf.setTitle("Loading");
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		java.awt.BorderLayout bdyt = new java.awt.BorderLayout();

		jf.setLayout(bdyt);
		jf.add(northPanel,BorderLayout.NORTH);
		jf.add(westPanel,BorderLayout.WEST);
		jf.add(eastPanel,BorderLayout.EAST);
		
		eastPanel.setPreferredSize(new Dimension(130,0));
		westPanel.setPreferredSize(new Dimension(130,0));
		
		midwestPanel.setPreferredSize(new Dimension(10, 0));
//		centerPanel.add(midwestPanel,BorderLayout.WEST);
		
		mideastPanel.setPreferredSize(new Dimension(20, 0));
//		centerPanel.add(mideastPanel,BorderLayout.EAST);
		
		midcenterPanel.setPreferredSize(new Dimension(170, 100));
		centerPanel.add(midcenterPanel,BorderLayout.CENTER);
		
		southPanel.setPreferredSize(new Dimension(500, 48));
		
		jf.add(centerPanel,BorderLayout.CENTER);
		jf.add(southPanel,BorderLayout.SOUTH);
		
		com.game.frame.GameFrame interfacial = new com.game.frame.GameFrame();
		
		javax.swing.ImageIcon img = interfacial.getimg();
		javax.swing.JLabel lb = new javax.swing.JLabel(img);
		java.awt.Dimension d = new java.awt.Dimension(500,181);
		lb.setPreferredSize(d);
		northPanel.add(lb);
		
		final javax.swing.JTextField name = new javax.swing.JTextField();
		java.awt.Dimension d1 = new java.awt.Dimension(150,28);
		name.setPreferredSize(d1);
		midcenterPanel.add(name);
		
		eastPanel.add(cws,BorderLayout.SOUTH);
		cws.setPreferredSize(new Dimension(100,20));
		eastPanel.add(cwn,BorderLayout.NORTH);
		cwn.setPreferredSize(new Dimension(100,20));
		westPanel.add(wws,BorderLayout.SOUTH);
		cws.setPreferredSize(new Dimension(100,20));
		westPanel.add(wwn,BorderLayout.NORTH);
		cwn.setPreferredSize(new Dimension(100,20));
		
		javax.swing.JLabel zc = new javax.swing.JLabel("◊¢≤·’À∫≈ ");
		zc.setForeground(java.awt.Color.blue);
		cwn.add(zc);
		
		javax.swing.JLabel dl = new javax.swing.JLabel("«Î ‰»Î√‹¬Î ");
		dl.setForeground(java.awt.Color.black);
		wwn.add(dl);
		
		javax.swing.JTextField keyfield = new javax.swing.JTextField();
		keyfield.setPreferredSize(d1);
		midcenterPanel.add(keyfield);
		
		javax.swing.JLabel zh = new javax.swing.JLabel("’“ªÿ√‹¬Î ");
		zh.setForeground(java.awt.Color.blue);
		cws.add(zh);
		
		javax.swing.JLabel k = new javax.swing.JLabel("«Î ‰»Î’À∫≈");
		k.setForeground(java.awt.Color.black);
		wws.add(k);
		
		javax.swing.JCheckBox j1 = new javax.swing.JCheckBox("º«◊°√‹¬Î");
		midcenterPanel.add(j1);
		
		javax.swing.JCheckBox z1 = new javax.swing.JCheckBox("◊‘∂Øµ«¬º");
		midcenterPanel.add(z1);
		
		javax.swing.JButton bt = new javax.swing.JButton("µ«¬º");
		java.awt.Dimension d2 = new java.awt.Dimension(150,30);
		bt.setPreferredSize(d2);
		southPanel.add(bt);
		Listener lis = new Listener(acount,key,name,keyfield,jf);
		bt.addActionListener(lis);
		
		jf.setVisible(true);
	}
}
