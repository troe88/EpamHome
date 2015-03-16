package lecture3;

import javax.rmi.CORBA.Util;

public class DeepCopy {
	public static void main(String[] args) {

		int a[][] = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int b[][] = new int[a.length][];
		deepArrayCopy(a, b);
		
		a[0][0]=9;
		
		System.out.println(java.util.Arrays.deepToString(a));
		System.out.println(java.util.Arrays.deepToString(b));

	}

	public static void deepArrayCopy(final int[][] src, int target[][]) {
		if (src.length != target.length)
			target = new int[src.length][];

		for (int i = 0; i < src.length; i++) {
			target[i] = new int[src[i].length];
			System.arraycopy(src[i], 0, target[i], 0, src[i].length);
		}
	}

}
