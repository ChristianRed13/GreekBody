package serverData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutomaticReminder {

	ScheduledExecutorService ex;

	public AutomaticReminder() {

		// Create executor with schedule to run task every 30 seconds
		ex = Executors.newScheduledThreadPool(10);
		ex.scheduleAtFixedRate(() -> {
			try {
				initialize();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 0, 30, TimeUnit.SECONDS);

	}

	// Method that will be created as Runnable and will run every 30 seconds
	// in a separate thread
	private void initialize() throws InterruptedException {

		// we can have multiple jobs scheduled like this one
		PrintMessageJob job = new PrintMessageJob();
		Future<String> result = ex.submit(job);
		try {
			if (result.get().equals("Hatz")) {
				System.out.println("Execuring task ");
			}
		} catch (ExecutionException e) {

			e.printStackTrace();
		}

		// Creates a new specific date based on a new time
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date reminderDate = Calendar.getInstance().getTime();

		// Print the new formatted date
		System.out.println("Data: " + dateFormat.format(reminderDate));
		System.out.println("Gods have limited time, do your tasks faster!");
	}
}

