package test1;

public class SumElem {
	public static void main(String[] args) {

		System.out.println(sum(new int[] { 1, 2, 3 }));

		System.out.println(sum(new int[] { 1, 5, 7, 9, 3 }));

		System.out.println(sum(new int[] { 1 }));

		System.out.println(sum(new int[] {}));

	}

	private static int sum(int[] a) {
		int length = a.length;
		if (length == 0) {
			return 0;
		} else if (length == 1) {
			return a[0];
		}

		int result = 0;
		for (int i : a)
			result += i;
		return result;
	}
}
