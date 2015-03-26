package lecture10;

public class Cat implements Cleanable{

	@Override
	public void clean() {
		System.out.println("Wearing gloves");
		System.out.println("Washing cat");
	}

}
