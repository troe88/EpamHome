package lecture12.Local;

import lecture10.Cleanable;

public class A {
	public Cleanable[] doThomething() {
		return new Cleanable[] { new Cleanable() {
			@Override
			public void clean() {
				System.out.println("Cleaning Alien");
			}
		}, new Cleanable() {

			@Override
			public void clean() {
				System.out.println("Cleaning Predator");

			}
		}, new Cleanable() {

			@Override
			public void clean() {
				System.out.println("Cleaning terminator");
			}
		} };
	}
}
