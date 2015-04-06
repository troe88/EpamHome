package lecture12.LocalVar;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LocalVarExample {
	public static void main( final String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter you name:");
		final String name = scanner.nextLine();
		
		greed(name);

	}

	public static void greed(final String name) {
		ScheduledExecutorService service = Executors
				.newSingleThreadScheduledExecutor();

		service.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("hello, " + name);
			}
		}, 1, TimeUnit.SECONDS);
	}
}
