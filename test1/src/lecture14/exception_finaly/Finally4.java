package lecture14.exception_finaly;

public class Finally4 {
	public static void main(final String[] args) {

		System.out.println(calc());

	}

	private static int calc() {

		try {
			return 2;
		} finally {
			return 1;
		}
	}
}
