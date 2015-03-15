package LSDSort;

import java.util.Arrays;

import javax.swing.SortingFocusTraversalPolicy;

public class Main {

	public static void main(String[] args) {

		System.out.println(Integer.class);
		
		 int[] array = new int[LSDSort.MAX];
		
		 LSDSort.genRandArray(array, false);
		
		 //System.out.println(Arrays.toString(array));
		 long start = System.currentTimeMillis();
		 //Arrays.sort(array);
		 LSDSort.sort(array);
		 long end = System.currentTimeMillis();
		 //System.out.println(Arrays.toString(array));
		 System.out.println("Arrays.sort(array): " + (end - start));
		
		 LSDSort.genRandArray(array, false);
		
		 //System.out.println(Arrays.toString(array));
		 long start1 = System.currentTimeMillis();
		 LSDSort.sort_(array);
		 long end1 = System.currentTimeMillis();
		// System.out.println(Arrays.toString(array));
		 System.out.println("LSDSort.sort(array): " + (end1 - start1));

		//sortInt();

	}
}
