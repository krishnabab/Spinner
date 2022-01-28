package com.krish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RannumberSpinner implements ActionListener {
	JFrame jframe = new JFrame("Choose Player");
	JLabel winnerLabel = new JLabel();
	JButton button=new JButton("                                       Spin to choose player                                   ");
	JTextField textField = new JTextField(10);
	public RannumberSpinner() {
		prepareGUI();
	}

	private void prepareGUI() {
		Container container = jframe.getContentPane();
		JLabel noOfPlayersLabel = new JLabel("Enter the number of players:");
		noOfPlayersLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		container.add(noOfPlayersLabel);

		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(textField);
		container.setLayout(new FlowLayout());
		JLabel label = new JLabel();
		container.add(label);
		label.setForeground(Color.red);
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = textField.getText();
				int l = value.length();
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'|| ke.getKeyChar() == '\b') {
					textField.setEditable(true);
					label.setText("");
				} else {
					textField.setEditable(true);
					label.setText("* Enter only numeric digits(0-9)");
				}
			}
		});
		container.add(textField);
		button.setName("clkButtton");
		button.setBounds(130,200,100,40);
		button.addActionListener(this);
		container.add(button);
		container.add(winnerLabel);
		jframe.setSize(400, 350);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] argv) throws Exception {
		RannumberSpinner spinner = new RannumberSpinner();
	}

	@Override public void actionPerformed(ActionEvent actionEvent) {
		winnerLabel.setForeground(Color.red);
		winnerLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		int max = Integer.valueOf(textField.getText());
		String text = "Player picked: " +(int) ((Math.random() * (max - 1)) + 1);
		winnerLabel.setText(text);
		winnerLabel.setVisible(true);
	}
}