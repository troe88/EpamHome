package lesson18.patterns.command;

import java.util.Arrays;
import java.util.List;

import lesson18.patterns.command.Calculator.Command;

public class UseCalc {
	public static void main(final String[] args) {
		System.out.println("start");
		Calculator calculator = new Calculator();
		final List<Calculator.Command> list = Arrays.asList(
				calculator.new Plus(10),
				calculator.new Minus(20),
				calculator.new Get(),
				calculator.new Clear(),
				calculator.new Get());

//		Collections.reverse(list);

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (Command command : list) {
					try {
						command.exec();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		System.out.println("finish");
	}
}
