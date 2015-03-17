package lecture6;

public class UseD {
	public static void main(final String[] args) {
		System.out.println("start");
		D d = D.create(50, 50);
		System.out.println(d.getX() + "  " + d.getY());

		D d2 = D.create(30, 40);
		System.out.println(d2);

		// D d = new D(100, 200);
	}
}
