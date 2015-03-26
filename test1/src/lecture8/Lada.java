package lecture8;

public final class Lada extends Car{

	{
		speed = 10;
	}
	
	@Override
	public void moveTo(final int x, final int y) {
		turnOn();
		_dist = 0;
		while(notBroken() && _dist <= x){
			_dist += speed;
			drive();
			repare();
		}
		shutDown();
		System.out.println("Лада приехала!!!");
	}

}
