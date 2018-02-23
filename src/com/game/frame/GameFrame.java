package com.game.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.imageManagement.Images;
import com.game.listener.Listener;
import com.game.stringManagement.Strings;

public class GameFrame {
	public static int total_cols = 5;
	public static int total_rows = 6;
	int total_img = 5;

	JPanel centerPanel, southPanel, northPanel, westSouthPanel, eastSouthPanel, cardPanel1, cardPanel2;
	JButton diamondsButton[][];
	JLabel gradeLable = new JLabel("0"), footLable = new JLabel("0");
	JButton Button1, Button2;

	int x1 = -2, y1 = -2, x2 = -2, y2 = -2, firstMsg = 0, secondMsg = 0, thirdMsg;
	int grid[][];
	public static final int buttonWidth = 80;
	public static final int buttonHeight = 80;

	static boolean pressInformation = false;

	ImageIcon[] buttomImage;

	ImageIcon imgNorth = Images.getImageIcon("shell.jpg", this);
	ImageIcon imgSouth = Images.getImageIcon("flower.jpg", this);

	Listener listener;

	public ImageIcon getimg() {
		return imgSouth;
	}

	JFrame mainFrame;

	public GameFrame() {
		init();
	}

	public GameFrame(int cols, int rows) {
		init(cols, rows);
	}

	private void init(int cols, int rows) {
		this.total_cols = cols;
		this.total_rows = rows;
		init();
	}

	private void init() {
		grid = new int[total_rows + 2][total_cols + 2];
		diamondsButton = new JButton[total_rows][total_cols];

		buttomImage = Images.getImageIcons(Strings.buttom_image, this);
		random();

		mainFrame = new JFrame();
		listener = new Listener(this);

		String n = "宝宝爱消除";
		mainFrame.setTitle(n);
		ImageIcon img = new ImageIcon(this.getClass().getResource("logo.gif"));
		mainFrame.setIconImage(img.getImage());

		centerPanel = new JPanel();
		southPanel = new JPanel();
		northPanel = new JPanel();
		westSouthPanel = new JPanel();
		eastSouthPanel = new JPanel();

		mainFrame.add(northPanel, BorderLayout.NORTH);

		JLabel label1 = new JLabel(imgNorth);
		label1.setPreferredSize(new Dimension(500, 120));
		northPanel.add(label1);
		northPanel.setPreferredSize(new Dimension(0, 120));

		mainFrame.add(southPanel, BorderLayout.SOUTH);

		southPanel.add(westSouthPanel, BorderLayout.WEST);
		southPanel.add(eastSouthPanel, BorderLayout.EAST);

		southPanel.setBackground(new Color(150, 100, 145));

		westSouthPanel.setBackground(null);
		eastSouthPanel.setBackground(null);

		southPanel.setPreferredSize(new Dimension(0, 50));

		initCenterPanel(mainFrame);

		JButton exit = new ExitButton();
		exit.setPreferredSize(new Dimension(80, 30));
		eastSouthPanel.add(exit);

		JButton reset = new ResetButton();
		reset.setPreferredSize(new Dimension(30, 30));
		eastSouthPanel.add(reset);
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reset(centerPanel, mainFrame);
			}
		});

		JLabel labelScore = new JLabel("现在的分数是：");
		labelScore.setForeground(Color.yellow);
		gradeLable.setText(String.valueOf(Integer.parseInt(gradeLable.getText())));
		gradeLable.setForeground(Color.yellow);
		westSouthPanel.add(labelScore);
		westSouthPanel.add(gradeLable);

		mainFrame.setSize(total_cols * buttonWidth + 15, total_rows * buttonHeight + 12 * 3
				+ northPanel.getPreferredSize().height + southPanel.getPreferredSize().height);
		mainFrame.setDefaultCloseOperation(3);
		mainFrame.setLocationRelativeTo(null);
	}

	public void setVisible(boolean v) {
		mainFrame.setVisible(v);
		new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				centerPanel.repaint();
			};
		}.start();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public void random() {
		int random = 0, rows, cols;
		int vertmp[][] = new int[total_rows + 1][total_cols + 1];
		int hortmp[][] = new int[total_rows + 1][total_cols + 1];
		for (rows = 1; rows <= total_rows; rows++) {
			for (cols = 1; cols <= total_cols; cols++) {
				int tmp1 = total_img + 1, tmp2 = total_img + 1;
				if (hortmp[rows - 1][cols] >= 1)
					tmp1 = tmp2 = this.grid[rows - 1][cols];
				if (vertmp[rows][cols - 1] >= 1) {
					int tmp = this.grid[rows][cols - 1];
					if (tmp1 > tmp)
						tmp1 = tmp;
					else
						tmp2 = tmp;
				}
				int sub_num = 0;
				if (tmp1 != 6) {
					sub_num++;
					if (tmp1 != tmp2)
						sub_num++;
				}
				random = (int) (Math.random() * (total_img - sub_num) + 1);
				if (random >= tmp1)
					random++;
				if (random >= tmp2 && tmp1 != tmp2)
					random++;
				this.grid[rows][cols] = random;
				if (random == this.grid[rows - 1][cols])
					hortmp[rows][cols] = hortmp[rows - 1][cols] + 1;
				if (random == this.grid[rows][cols - 1])
					vertmp[rows][cols] = vertmp[rows][cols - 1] + 1;
			}
		}
	}

	public void reset(JPanel centerPanel, JFrame frame) {
		int grid[][] = new int[total_rows + 2][total_cols + 2];
		this.grid = grid;
		random();
		centerPanel.setVisible(false);
		centerPanel.removeAll();
		gradeLable.setText(String.valueOf(0));
		pressInformation = false;
		initCenterPanel(frame);
	}

	private void grade(int n) {
		gradeLable.setText(String.valueOf(Integer.parseInt(gradeLable.getText()) + 10 * n));
	}

	public void change(int x, int y, JButton button) {
		x1 = x2;
		y1 = y2;
		firstMsg = secondMsg;
		Button1 = Button2;
		x2 = x;
		y2 = y;
		Button2 = button;
		secondMsg = grid[y2 + 1][x2 + 1];
		pressInformation = false;
		if (((x1 - x2 == 1 || x2 - x1 == 1) && y1 == y2) || ((y1 - y2 == 1 || y2 - y1 == 1) && x1 == x2)) {
			grid[y2 + 1][x2 + 1] = firstMsg;
			grid[y1 + 1][x1 + 1] = secondMsg;
			figure(y1, x1, y1, x1);
			figure(y2, x2, y2, x2);
			x1 = x2 = y1 = y2 = -2;
		}
	}

	public void exchange(int x1, int y1, int x2, int y2) {
		int tmp = grid[y2 + 1][x2 + 1];
		grid[y2 + 1][x2 + 1] = grid[y1 + 1][x1 + 1];
		grid[y1 + 1][x1 + 1] = tmp;
		figure(y1, x1, y1, x1);
		figure(y2, x2, y2, x2);
	}

	private void initCenterPanel(JFrame frame) {
		frame.add(centerPanel, BorderLayout.CENTER);

		centerPanel.setVisible(true);
		centerPanel.setLayout(null);
		centerPanel.addMouseListener(listener);
		centerPanel.addMouseMotionListener(listener);

		for (int rows = 0; rows < total_rows; rows++) {
			for (int cols = 0; cols < total_cols; cols++) {
				diamondsButton[rows][cols] = new JButton();
				JButton button = diamondsButton[rows][cols];
				figure(rows, cols, rows, cols);
				button.addActionListener(listener);
				button.addMouseListener(listener);
				button.addMouseMotionListener(listener);
				centerPanel.add(button);
				button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
				button.setSize(buttonWidth, buttonHeight);
				button.setLocation(cols * buttonWidth, rows * buttonHeight);
			}
		}
	}

	private void figure(int rows, int cols, int x, int y) {
		diamondsButton[x][y].setIcon(buttomImage[grid[rows + 1][cols + 1] - 1]);
	}

	private void recompose() {
		int rows = 1;
		boolean needContinue = false;
		do {
			needContinue = false;
			for (rows = 2; rows <= total_rows; rows++) {
				for (int cols = 1; cols <= total_cols; cols++) {
					if (diamondsButton[rows - 1][cols - 1].isVisible() == false) {
						needContinue = true;
						if (diamondsButton[rows - 2][cols - 1].isVisible() == true) {
							grid[rows][cols] = grid[rows - 1][cols];
							figure(rows - 1, cols - 1, rows - 1, cols - 1);
							diamondsButton[rows - 1][cols - 1].setVisible(true);
							diamondsButton[rows - 2][cols - 1].setVisible(false);
						}
					}
				}
			}
			rows = 1;
			for (int cols = 1; cols <= total_cols; cols++) {
				if (diamondsButton[rows - 1][cols - 1].isVisible() == false) {
					needContinue = true;
					grid[rows][cols] = (int) (Math.random() * total_img + 1);
					figure(rows - 1, cols - 1, rows - 1, cols - 1);
					diamondsButton[rows - 1][cols - 1].setVisible(true);
				}
			}
		} while (needContinue);
		exam();
	}

	public void exam() {
		int vertmp[][] = new int[total_rows + 2][total_cols + 2];
		int hortmp[][] = new int[total_rows + 2][total_cols + 2];
		boolean needRecompose = false;
		for (int rows = 1; rows <= total_rows + 1; rows++) {
			for (int cols = 1; cols <= total_cols + 1; cols++) {
				int count = 0;
				if (this.grid[rows][cols] == this.grid[rows - 1][cols])
					vertmp[rows][cols] = vertmp[rows - 1][cols] + 1;
				else if (vertmp[rows - 1][cols] > 1) {
					needRecompose = true;
					for (int i = 0; i <= vertmp[rows - 1][cols]; i++) {
						if (diamondsButton[rows - 1 - i - 1][cols - 1].isVisible()) {
							diamondsButton[rows - 1 - i - 1][cols - 1].setVisible(false);
							count++;
						}
					}

				}
				if (this.grid[rows][cols] == this.grid[rows][cols - 1])
					hortmp[rows][cols] = hortmp[rows][cols - 1] + 1;
				else if (hortmp[rows][cols - 1] > 1) {
					needRecompose = true;
					for (int i = 0; i <= hortmp[rows][cols - 1]; i++) {
						if (diamondsButton[rows - 1][cols - 1 - i - 1].isVisible()) {
							diamondsButton[rows - 1][cols - 1 - i - 1].setVisible(false);
							count++;
						}
					}
				}
				grade(count);
			}
		}
		if (needRecompose)
			recompose();
	}

	public void flash() {
		centerPanel.repaint();
	}
}
