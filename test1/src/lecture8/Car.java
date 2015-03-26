package lecture8;

import java.util.Random;

public abstract class Car extends Vehicle {

	Random random = new Random();
	
	protected void shutDown() {
		System.out.println("Выключили");
	}

	protected void drive() {
		System.out.println("Едем");
	}

	protected void turnOn() {
		System.out.println("Завели");
	}

	protected void repare() {
		System.out.println("Починили");
	}

	protected boolean notBroken() {
		return random.nextBoolean();
	}

}
