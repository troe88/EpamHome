package lecture10;

public class Service {
	public static void main(final String[] args) {
		Furniture[] things = { new Chair(), new SurgeryTable(),
				new KitchenTable() };

		serve(things);
		clean(new Cleanable[] { new Cat(), new Chair(), new KitchenTable() });
	}

	private static void clean(final Cleanable[] things) {
		for (Cleanable something : things)
			something.clean();
	}

	private static void serve(final Furniture[] things) {
		for (Furniture furniture : things) {
			furniture.move();
			furniture.clean();
			furniture.move();
		}
	}
}
