package serverData;

import java.util.concurrent.Callable;

public class PrintMessageJob implements Callable<String> {

	@Override
	public String call() {

		System.out.println("This is task 1");
		return "randomString";
	}
}
