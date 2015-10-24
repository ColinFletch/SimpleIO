/**
 * 
 */
package com.colinsOrg.chatClient;

import java.io.*;
import java.net.*;
/**
 * @author cfletch
 *
 */
public class DailyAdviceServer {

	String lt = "When you are content to be simply yourself and don't compare or compete, everyone will respect you. \n Lao Tzu, Tao Te Ching";
	String ga = "Take a look, it's in a book - Reading Rainbow";
	String rwe = "It is easy in the world to live after the world's opinion; it is easy in solitude to live after our own; \n but the great man is he who in the midst of the crowd keeps with perfect sweetness the independence of solitude. \n - Ralph Waldo Emerson";
	String as = "We will gradually become indifferent to what goes on in the minds of other people \n when we acquire a knowledge of the superficial nature of their thoughts, the narrowness of their views and of the number of their errors. \nWhoever attaches a lot of value to the opinions of others pays them too much honor. \n - Arthuer Schopenhauer, The Philosophy of Schopenhauer";
	String[] adviceList = {lt, rwe, ga, as};
	
	public void go() {
		try {
			ServerSocket serverSock = new ServerSocket(4242);
			
			while (true) {
				
				Socket sock = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
			
		} catch(IOException ex) {
			ex.printStackTrace();
			
		}
	} //close go
	
	private String getAdvice() {
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
		
	}

}
