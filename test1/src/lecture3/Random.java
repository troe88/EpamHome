package lecture3;

public class Random {
	public static void main(String[] args) {
		int [] a = new int[1000];
		fillRandom(a);
		java.util.Arrays.sort(a);
		System.out.println(java.util.Arrays.toString(a));
		
		int r = 0;
		r=java.util.Arrays.binarySearch(a, 10);
		System.out.println(r);
	}
	
	private static void fillRandom(int a[]){
		java.util.Random r = new java.util.Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(30);
		}
	}
}
