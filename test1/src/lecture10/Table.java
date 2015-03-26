package lecture10;

public abstract class Table extends Furniture {
	@Override
	public void move() {
		System.out.println("Moving table");
	}

	@Override
	public void clean() {
		System.out.println("clean table");
	}
}
