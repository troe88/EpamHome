package Lecture13.Exseption;

public class DivisioinByZero {

	public static void main(final String[] args) {
		int result;
		try {
			result = div(100, 0);
		} catch (DividerIsZero e) {
			result = 0;
			e.printStackTrace();
		}
		System.out.println(result);
	}

	private static int div(final int i, final int j) throws DividerIsZero {
		
		if(j == 0){
			throw new DividerIsZero();
		}
		
		return i / j;
	}
}
