package lecture2;
import java.util.Scanner;


public class Main {


	final static long MAX = 0xffffffffl;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		long[] mass = new long[count];
		for(int i = 0; i < count; i++){
			mass[i] = in.nextLong();
		}
		
		for(long i : mass){
			i = i ^ MAX	;
			System.out.println( i );
		}

	}
}
