package com.game.frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.game.imageManagement.Images;

public class ResetButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1134234191453130392L;

	public ResetButton() {
		init();
	}

	private void init() {
		ImageIcon rst = Images.getImageIcon("reset.jpg", this);
		setIcon(rst);
	}
}
