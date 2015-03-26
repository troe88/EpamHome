package lecture8;

public abstract class Vehicle {
	
	int speed = 0;
	protected int _dist;
	
	protected Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void moveTo(final int x, final int y);
	
//	public void moveTo(final int x, final int y) {
//		System.out.println("Moved 2: [" + x + " : " + y + " ]");
//	}
//	
	
}
