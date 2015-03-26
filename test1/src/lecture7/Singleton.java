package lecture7;

public class Singleton {

	private static final Singleton instance = new Singleton();
//	public static final Singleton instance = new Singleton();

	private Singleton() {
		System.out.println("Created new instance");
	}

	public static Singleton get() {
		return instance;
	}

//	public static Singleton instance() {
//		return instance;
//	}
//	
//	public static Singleton singleton(){
//		return instance;
//	}
}
