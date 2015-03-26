package lecture8;

public class TransportCompany {
	public static void main(final String[] args) {

		Vehicle[] vehicles = { new Lada(), new Audi(), new Horse() };

		for (final Vehicle vehicle : vehicles) {
			// vehicle.moveTo(100, 100);
			// System.out.println();

			Thread myThready = new Thread(new Runnable() {
				@Override
				public void run() 
				{
					vehicle.moveTo(10, 10);
				}
			});
			myThready.start();

		}

	}
}
