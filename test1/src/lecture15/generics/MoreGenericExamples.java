package lecture15.generics;

import lecture10.Cat;
import lecture10.Cleanable;

public class MoreGenericExamples {
	
	static class CleaningBag<T extends Cleanable>{
		
		T box;
		
		public void store(final T t) {
			box = t;
			t.clean();
		}
		
		public T get() {
			return box;
		}
	}
	
	public static void main(final String[] args) {
		CleaningBag<Cat> catTrap = new CleaningBag<>();
		catTrap.store(new Cat());
//		bag.store(123);
		
		System.out.println(catTrap.get());
	}


}
