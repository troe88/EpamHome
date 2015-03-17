package lecture6;

public class B {

	
	public static void main(String[] args) {
		int x = 20;
		something(x);
		System.out.println(x);
	}

	private static void something(int x) {
		x = 30;
		System.out.println(x);
	}
}