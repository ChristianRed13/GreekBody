package client_test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.gson.Gson;

import socket.SocketClientCallable;
import userData.GreekUser;

public class ClientTest {
	

	public static void main(String[] args) throws IOException {
		GreekUser user = new GreekUser("CHRBOSS","Hatz1313");
		String payload = new Gson().toJson(user);
		
		String serverResponse = "";
		ExecutorService es = Executors.newCachedThreadPool();

		System.out.println("Sending command to server with data: " + payload);
		SocketClientCallable commandWithSocket = new SocketClientCallable("localhost", 3800, "find snack", payload);
		
		
		Future<String> response = es.submit(commandWithSocket);
		try {
			// Blocking this thread until the server responds
			serverResponse = response.get();
			
			System.out.println("Response from server is "+ serverResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Connection to server terminated");
	    System.out.println("Server response is:\n" + serverResponse);
			
		
	}

}
