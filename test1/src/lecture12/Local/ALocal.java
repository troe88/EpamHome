package lecture12.Local;

import lecture10.Cleanable;

public class ALocal {
	public Cleanable[] getHeros() {

		class PetHero implements Cleanable {

			private String name;

			public PetHero(final String name) {
				this.name = name;
			}

			@Override
			public void clean() {
				System.out.println("Cleaning" + name);
			}

		}
		return new Cleanable[] { new PetHero("alien"), new PetHero("preadtor"),
				new PetHero("terminator") };
	}

	public static void main(final String[] args) {
		ALocal a = new ALocal();
		for (Cleanable c : a.getHeros()) {
			c.clean();
		}
	}
}
