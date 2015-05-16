package lecture24.tdd;

public class StringNumbers {
	public static String toString(final int number){
		switch (number) {
		case 1:
			return "один";
		case 2:
			return "два";
		default:
			return null;
		}
	}
}
