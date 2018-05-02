package edu.yccc.cis174.wlago.portraitgallery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;

/*
 * Interactive Fiction game that features several "sub-games" that must be completed to advance the story.
 * -Use of inheritance and interface for managing each subgame
 * -Windowbuilder GUI
 * -User input parsing and validation
 * -Save/load system
 * -Persistent gamestate elements across subgames
 */

public class GameWindow {

	private JFrame frame;
	private JTextField inputField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if (GameState.initialized == false)
		{
			GameState.initialized = true;
			GameState.gh = new GameHub();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameRules gr = new GameRules();
				gr.save();
			}
		});
		btnSaveGame.setBounds(0, 322, 124, 23);
		frame.getContentPane().add(btnSaveGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameRules gr = new GameRules();
				gr.load();
			}
		});
		btnLoadGame.setBounds(124, 322, 124, 23);
		frame.getContentPane().add(btnLoadGame);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(0, 302, 496, 20);
		
		JButton btnQuitGame = new JButton("Clear Log");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("");
			}
		});
		btnQuitGame.setBounds(372, 322, 124, 23);
		frame.getContentPane().add(btnQuitGame);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bodyPanel.setBounds(0, 0, 496, 301);
		bodyPanel.setBackground(textPane.getBackground());
		frame.getContentPane().add(bodyPanel);
		bodyPanel.setLayout(new BorderLayout(0, 0));

		bodyPanel.add(textPane, BorderLayout.SOUTH);
		
		inputField = new JTextField();
		inputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (inputField.getText().length() > 0)
				{
					textPane.setText(textPane.getText() + ">" + inputField.getText());
					if (GameState.subGame == 0)
					{
						textPane.setText(textPane.getText() + "\n" + GameState.gh.parse(inputField.getText()));
					}
					else if (GameState.subGame == 1)
					{
						textPane.setText(textPane.getText() + "\n" + GameState.gp.parse(inputField.getText()));
					}
					else if (GameState.subGame == 3)
					{
						textPane.setText(textPane.getText() + "\n" + GameState.gc.parse(inputField.getText()));
					} 
					inputField.setText("");
					inputField.grabFocus();
				}
			}
		});
		inputField.setBounds(0, 302, 496, 20);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		inputField.grabFocus();
		textPane.setText(GameState.gh.start() + GameState.gh.getRoomDesc());
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText(textPane.getText() + GameState.gh.help());
			}
		});
		btnHelp.setBounds(248, 322, 124, 23);
		frame.getContentPane().add(btnHelp);
	}
}
