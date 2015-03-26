package lecture8;

public class Audi extends Car {
	{
		speed = 12;
	}

	@Override
	public void moveTo(final int x, final int y) {
		turnOn();
		while (_dist <= x) {
			_dist += speed;
			drive();
		}
		shutDown();
		System.out.println("Ауди приехала!!!");
	}
}
