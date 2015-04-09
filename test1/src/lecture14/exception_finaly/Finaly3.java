package lecture14.exception_finaly;

public class Finaly3 {
	public static void main(final String[] args) {
		try {
			a();
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().getMessage();
		}
	}

	private static void a() throws Exception {
		try {
			b();
			System.out.println("after b");
		} catch (Exception e) {
			System.out.println("catch exception" + e.getStackTrace()[1].getMethodName());
			throw new Exception(e);
		} finally {
			System.out.println("close resource");
		}
	}

	private static void b() {
		throw new RuntimeException("error b()");
	}
}
