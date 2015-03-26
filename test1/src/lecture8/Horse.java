package lecture8;

public class Horse extends Vehicle {

	{
		speed = 2;
	}
	
	@Override
	public void moveTo(final int x, final int y) {
		System.out.println("Сели и ...");
		while (_dist <= x){
			_dist += speed;
			System.out.println("тыгыдым-тыгыдым");
		}
		System.out.println("Лошадь на месте!");
	}

}
