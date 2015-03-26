package lecture7;

public class UseSingleton {
	public static void main(final String[] args) {
		System.out.println("start");
		Singleton singleton;
		singleton = Singleton.get();
		
		System.out.println(Singleton.get());
		
		System.out.println("finish");
	}
}
