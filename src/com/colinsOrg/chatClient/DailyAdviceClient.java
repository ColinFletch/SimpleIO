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
public class DailyAdviceClient {
	
	public void go() {
		try {
		Socket s = new Socket("127.0.0.1", 4242);
		
		InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
		BufferedReader reader = new BufferedReader(streamReader);
		
		String advice = reader.readLine();
		System.out.println("Words for Today \n" + advice);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}
	
}
