/**
 * 
 */
package com.colinsOrg.chatClient;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author cfletch
 *
 */
public class SimpleChatClientA {
	
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	private final static String ADDRESS = "127.0.0.1";
	private final static int PORT = 4242;
	
	public void go() {
		JFrame frame = new JFrame("Super simple ChatboxClient");
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		setUpNetworking();
		frame.setSize(400, 500);
		frame.setVisible(true);
	} //end go
	
	public void setUpNetworking() {
		try {
			sock = new Socket(ADDRESS, PORT);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("We are live! Network running on: " + PORT);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	} // end setUpNetworking
	
	public class SendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			try {
				writer.println(outgoing.getText());
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	} // end SendButtonListener inner
	
	public static void main(String[] args) {
		new SimpleChatClientA().go();
	}
}// end outer class
