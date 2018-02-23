package com.game.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import com.game.frame.GameFrame;

public class Listener implements MouseMotionListener, ActionListener, MouseListener {

	GameFrame myGame;
	int x;
	int y;
	int mouse_x, mouse_x1;
	int mouse_y, mouse_y1;
	int xOrignIndex, yOrignIndex;

	public Listener(GameFrame myGame) {
		this.myGame = myGame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton clickButton = (JButton) (e.getSource());
			clickButton.getParent().setComponentZOrder(clickButton, 0);
			mouse_x = mouse_x1 = e.getXOnScreen();
			x = clickButton.getLocation().x;
			mouse_y = mouse_y1 = e.getYOnScreen();
			y = clickButton.getLocation().y;
			xOrignIndex = x / GameFrame.buttonWidth + (x % GameFrame.buttonWidth == 0 ? 0 : 1);
			yOrignIndex = y / GameFrame.buttonHeight + (y % GameFrame.buttonHeight == 0 ? 0 : 1);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() instanceof JButton) {

			JButton clickButton = (JButton) (e.getSource());
			int xIndex = clickButton.getLocation().x / GameFrame.buttonWidth
					+ (clickButton.getLocation().x % GameFrame.buttonWidth == 0 ? 0 : 1);
			int yIndex = clickButton.getLocation().y / GameFrame.buttonHeight
					+ (clickButton.getLocation().y % GameFrame.buttonHeight == 0 ? 0 : 1);

			clickButton.setLocation(x, y);
			System.out.println(xIndex + ";" + yIndex);
			if (xIndex < 0 || xIndex >= GameFrame.total_cols || yIndex < 0 || yIndex >= GameFrame.total_rows)
				return;
			if (xIndex == xOrignIndex && yIndex == yOrignIndex)
				return;
			myGame.exchange(xIndex, yIndex, xOrignIndex, yOrignIndex);
			myGame.flash();
			System.out.println("123");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton clickButton = (JButton) (e.getSource());
			myGame.change(clickButton.getLocation().x / GameFrame.buttonWidth,
					clickButton.getLocation().y / GameFrame.buttonHeight, clickButton);
			myGame.exam();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (Math.abs(e.getXOnScreen() - mouse_x1) > 1 && Math.abs(e.getYOnScreen() - mouse_y1) > 1) {
			mouse_x = mouse_x1;
			mouse_y = mouse_y1;
			mouse_x1 = e.getXOnScreen();
			mouse_y1 = e.getYOnScreen();
			if (e.getSource() instanceof JButton) {
				JButton clickButton = (JButton) (e.getSource());
				int tmpx = clickButton.getLocation().x + mouse_x1 - mouse_x;
				int tmpy = clickButton.getLocation().y + mouse_y1 - mouse_y;
				clickButton.setLocation(tmpx, tmpy);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		/*
		 * mouse_x = mouse_x1; mouse_y = mouse_y1; mouse_x1 = e.getX(); mouse_y1
		 * = e.getY();
		 */
	}

}
