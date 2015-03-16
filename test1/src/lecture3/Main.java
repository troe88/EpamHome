package lecture3;

public class Main {

	public static void main(String[] args) {
		int[][] a = { { 1, 0, 3 }, { 4, 0, 6 }, { 7, 0, 9 }, { 0, 0, 0 } };

		int x = indexOfSum(a, 10);
		System.out.println(x);
		int xx = zeroCount(a);
		System.out.println(xx);
		// printMatrix(a);

	}

	private static int zeroCount(int[][] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 0) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	private static int indexOfSum(int[][] a, int max) {
		int sum = 0;
		int n = -1;
		top: for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				sum += a[i][j];
				n++;
				if (sum > max)
					break top;
			}
		}

		return n;
	}

	private static void printMatrix(int[][] mart) {
		for (int i = 0; i < mart.length; i++) {
			for (int j = 0; j < mart[i].length; j++) {
				System.out.print(mart[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
