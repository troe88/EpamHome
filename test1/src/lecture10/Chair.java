package lecture10;

public class Chair extends Furniture {
	@Override
	public void move() {
		System.out.println("Moving Chair");
	}

	@Override
	public void clean() {
		System.out.println("clean Chair");
	}
	
	@Override
	public void repair() {
		System.out.println("Repairing Chair");
	}

	@Override
	public void paint() {
		System.out.println("Paintint Chair");
	}

}
