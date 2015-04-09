package lecture14;

public class MultiExeptions {
	public static void main(final String[] args) {
		System.out.println("start");
		try {
			a();
		} catch (Exception1 | Exception2 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finish");
	}

	public static class Exception1 extends Exception {

	}

	public static class Exception2 extends Exception {

	}

	private static void a() throws Exception1, Exception2 {
		b();
		throw new Exception1();
	}

	private static void b() throws Exception2 {
		throw new Exception2();
	}
}
