package serverData;

import java.io.BufferedReader;
import userData.GreekUser;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import com.google.gson.Gson;

import service.*;
import userData.*;
import foodData.*;
@FunctionalInterface
interface InputDataHandlerInterface<T> {

	// abstract method
	String executeTask(T inputData);
	
}

public class CommandService implements Runnable {
	private final ServerSocket serverSocket;
	// store one lambda for each command
	private static final HashMap<String, InputDataHandlerInterface<String>> map = new HashMap<String, InputDataHandlerInterface<String>>() {

		private static final long serialVersionUID = 1L;

		{
			put("find user", (user) -> {
 
				UserService us = new UserService();	
				GreekUser userInput = new Gson().fromJson(user, GreekUser.class);
				System.out.print(userInput.toString());
				GreekUser gu = new GreekUser();
				String finalMessage = "";
					try {
						gu = us.findUserWithNamePassword(userInput.getUsername(), userInput.getPassword());	
						System.out.print(gu.toString());
						finalMessage = new Gson().toJson(gu);
						return finalMessage;
					} catch (Exception e) {
						System.out.println("Server user not found sending message to customer");
					}

				return finalMessage;
			
			});
			put("create user", (user) -> {
				
				GreekUser userInput = new Gson().fromJson(user, GreekUser.class);
				GreekUser finalUser = new GreekUser();
				UserService us = new UserService();

				CalculatorCalorii calculator = new CalculatorCalorii();
				calculator.setActivity(userInput.getActivity());
				calculator.setAge(userInput.getAge());
				calculator.setHeight(userInput.getHeight());
				calculator.setGender(userInput.getGender().toString());
				calculator.setWeight(userInput.getWeight());
				calculator.setGoals(userInput.getGoals());
				System.out.println(calculator.toString());	
				
				
				FoodService fs = new FoodService();
				UserFoodService ufs = new UserFoodService();
				try {
					finalUser = us.findUserWithNamePassword(userInput.getUsername(), userInput.getPassword());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ufs.addUserFood(new UserFood(fs.findFoodCaloriesCategory(calculator.getBreakfastCalories(),CategoryFood.BREAKFAST), finalUser));
					ufs.addUserFood(new UserFood(fs.findFoodCaloriesCategory(calculator.getLunchCalories(), CategoryFood.LUNCH), finalUser));					
					ufs.addUserFood(new UserFood(fs.findFoodCaloriesCategory(calculator.getDinnerCalories(), CategoryFood.DINNER), finalUser));
					ufs.addUserFood(new UserFood(fs.findFoodCaloriesCategory(calculator.getSnackCalories(), CategoryFood.SNACK), finalUser));
				} catch (Exception e) {				
					e.printStackTrace();
				}
				if(calculator.calculateCalories() == 0)
					return "calculator error";
				
				return "user created!";
			});
			
			put("breakfast", (beakfastCalories) -> {				
				FoodService fs = new FoodService();
				int calories = Integer.parseInt(beakfastCalories);
				System.out.print(calories);	
				String response = "";
				
					try {
						response = fs.findFoodCaloriesCategory(calories,CategoryFood.BREAKFAST).toString();	
						System.out.println(response);
					} catch (Exception e) {
					
						e.printStackTrace();
					}
					System.out.println(response);

				return response;
			});
			put("lunch", (lunchCalories) -> {
				FoodService fs = new FoodService();
				int calories = Integer.parseInt(lunchCalories);
				System.out.print(calories);	
				String response = "";
				
					try {
						response = fs.findFoodCaloriesCategory(calories,CategoryFood.LUNCH).toString();	
						System.out.println(response);
					} catch (Exception e) {
					
						e.printStackTrace();
					}
				System.out.println(response);

				return response;
			});
			put("dinner", (dinnerCalories) -> {
				FoodService fs = new FoodService();
				int calories = Integer.parseInt(dinnerCalories);
				System.out.print(calories);	
				String response = "";
				
					try {
						response = fs.findFoodCaloriesCategory(calories,CategoryFood.DINNER).toString();
						System.out.println(response);
					} catch (Exception e) {
					
						e.printStackTrace();
					}
				

				return response;
			});
			put("snack", (snackCalories) -> {
				FoodService fs = new FoodService();
				int calories = Integer.parseInt(snackCalories);
				System.out.print(calories);	
				String response = "";
				
					try {
						response = fs.findFoodCaloriesCategory(calories,CategoryFood.SNACK).toString();
						System.out.println(response);
					} catch (Exception e) {
					
						e.printStackTrace();
					}
				

				return response;
			});
			
			
			put("workout", (user) -> {
				UserService us = new UserService();	
				UserWorkoutService ufs = new UserWorkoutService();
				GreekUser userInput = new Gson().fromJson(user, GreekUser.class);
				System.out.print(userInput.toString());
				GreekUser finalUser = new GreekUser();
				String response = "";
				
					try {
						finalUser= us.findUserWithNamePassword(userInput.getUsername(), userInput.getPassword());
						response = ufs.findWorkoutWithUserID(finalUser.getIdUser());
					} catch (Exception e) {
					
						e.printStackTrace();
					}
				

				return response;
			});
			put("find breakfast", (user) -> {		
				GreekUser userInput = new Gson().fromJson(user, GreekUser.class);
				UserFoodService ufs = new UserFoodService();
				UserService us = new UserService();
				
				String response = "";
				
					try {
						response = ufs.findFoodBreakfastByUserId(us.findUserWithNamePassword(userInput.getUsername(),userInput.getPassword()).getIdUser());
						System.out.println(response);
					} catch (Exception e) {
						
					return "Not existing breakfast with this user ID";				
					}
					System.out.println(response);

				return response;
			});
			put("find lunch", (user) -> {		
				GreekUser userInput = new Gson().fromJson(user, GreekUser.class);
				UserFoodService ufs = new UserFoodService();
				UserService us = new UserService();
				
				String response = "";
				
					try {
						response = ufs.findFoodLunchByUserId(us.findUserWithNamePassword(userInput.getUsername(),userInput.getPassword()).getIdUser());
						System.out.println(response);
					} catch (Exception e) {
						
					return "Not existing lunch with this user ID";				
					}
					System.out.println(response);

				return response;
			});
			put("find dinner", (user) -> {		
				GreekUser userInput = new Gson().fromJson(user, GreekUser.class);
				UserFoodService ufs = new UserFoodService();
				UserService us = new UserService();
				
				String response = "";
				
					try {
						response = ufs.findFoodDinnerByUserId(us.findUserWithNamePassword(userInput.getUsername(),userInput.getPassword()).getIdUser());
						System.out.println(response);
					} catch (Exception e) {
						
					return "Not existing dinner with this user ID";				
					}
					System.out.println(response);

				return response;
			});
			put("find snack", (user) -> {		
				GreekUser userInput = new Gson().fromJson(user, GreekUser.class);
				UserFoodService ufs = new UserFoodService();
				UserService us = new UserService();
				
				String response = "";
				
					try {
						response = ufs.findFoodSnackByUserId(us.findUserWithNamePassword(userInput.getUsername(),userInput.getPassword()).getIdUser());
						System.out.println(response);
					} catch (Exception e) {
						
					return "Not existing snack with this user ID";				
					}
					System.out.println(response);

				return response;
			});
		}
	};

	public CommandService(int port) throws IOException {
		// Create server socket and set the timeout for serverSocket.accept method
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(250);
	}

	@Override
	public void run() {
		try {
			accept();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void accept() throws IOException {
		System.out.println("Accepting connections on port " + serverSocket.getLocalPort());

		// Loop until the thread is interrupted
		while (!Thread.interrupted()) {
			// Use a try-with resources to instantiate the client socket and
			// buffers for reading and writing messages from and to the client
			try (Socket socket = serverSocket.accept();

					BufferedWriter bufferedOutputWriter = new BufferedWriter(
							new OutputStreamWriter(socket.getOutputStream()));
					BufferedReader bufferedInputReader = new BufferedReader(
							new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));) {

				System.out.println("Connection accepted");

				// Read the command and data from the client
				String receivedCommand = bufferedInputReader.readLine();
				String receivedData = bufferedInputReader.readLine();
				
				System.out.println(map.toString());

				System.out.println("Command received:  " + receivedCommand);
				System.out.println("Data received:  " + receivedData);

				String result = map.get(receivedCommand).executeTask(receivedData);

				if (result.isEmpty()) {
					System.out.println(result);
				} else {
					System.out.println("Unexpected command");
				}
				outputToClient(bufferedOutputWriter, result, true);

			} catch (SocketTimeoutException ste) {
				// timeout every .25 seconds to see if interrupted
			}
		}

		System.out.println("server connection end");
	}

	// Helper methods to send data to client
	private void outputToClient(BufferedWriter bufferedOutputWriter, String message, boolean withNewLine)
			throws IOException {

		bufferedOutputWriter.write(message);

		if (withNewLine) {
			bufferedOutputWriter.newLine();
		}

		bufferedOutputWriter.flush();
	}
}

