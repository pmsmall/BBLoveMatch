package com.game.imageManagement;

import javax.swing.ImageIcon;

public class Images {
	public static ImageIcon[] getImageIcons(String[] dir, Object instance) {
		ImageIcon[] icons = new ImageIcon[dir.length];
		for (int i = 0; i < icons.length; i++)
			icons[i] = new ImageIcon(instance.getClass().getResource(dir[i]));
		return icons;
	}

	public static ImageIcon getImageIcon(String dir, Object instance) {
		return new ImageIcon(instance.getClass().getResource(dir));
	}

}
