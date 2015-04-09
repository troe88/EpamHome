package lecture14.exception_finaly;

public class FinalyExamples2 {
	public static void main(final String[] args) {
		System.out.println("start");
		try {
			a();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finaly");
		}
		System.out.println("finish");
	}

	private static void a() {
		throw new RuntimeException("qwe");
	}
}
