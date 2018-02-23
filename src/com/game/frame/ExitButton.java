package com.game.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.game.imageManagement.Images;

public class ExitButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6625793917247252779L;

	public ExitButton() {
		init();
	}

	private void init() {
		ImageIcon ext = Images.getImageIcon("exit.jpg", this);
		setIcon(ext);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

}
