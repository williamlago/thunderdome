package edu.yccc.cis174.wlago.slackclient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

/* Maven: A build management tool that allows Java developers to view the
 * build structure of a given application and easily identify its dependencies. 
 * 
 * JAR: Short for Java Archive, JAR files are used to package Java classes
 * together with resources and metadata they require to run.
 */

public class ClientWindow implements MessengerInterface {

	private JFrame frame;
	JTextField textField;
	JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindow window = new ClientWindow();
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
	public ClientWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
				
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 11, 414, 258);
		
		JPanel box = new JPanel( new BorderLayout() );
		box.setBorder(new LineBorder(new Color(0, 0, 0)));
		box.setBounds(10, 11, 414, 258);
        box.setBackground(textPane.getBackground() );
		frame.getContentPane().add(box);
        box.add(textPane, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().length() > 0)
				{
					textPane.setText(textPane.getText() + "\n" + textField.getText());
					send();
				}
			}
		});
		textField.setBounds(10, 280, 340, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().length() > 0)
				{
					textPane.setText(textPane.getText() + "\n" + textField.getText());
					send();
				}
			}
		});
		btnNewButton.setBounds(360, 279, 64, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void send()
	{
		SlackService slackService = new SlackService();
		slackService.sendMessage("#steamed-hams", "Seymour", textField.getText());
		textField.setText("");
		textField.requestFocusInWindow();
	}
}
