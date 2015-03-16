package lecture3;

public class Arrays2 {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		int b[] = new int[3];
		
		System.out.println(java.util.Arrays.toString(a));
		System.out.println(java.util.Arrays.toString(b));
		
		System.arraycopy(a, 0, b, 0, a.length);

		System.out.println(java.util.Arrays.toString(b));
		
	}

}
