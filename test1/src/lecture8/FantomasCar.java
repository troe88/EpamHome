package lecture8;

public class FantomasCar extends Car{

	@Override
	public void moveTo(final int x, final int y) {
		System.out.println("moving quick");
	}

	public void flyTo(final int x, final int y) {
		System.out.println("flying");
	}
	
}
