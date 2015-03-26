package lecture7;

public class LazySingleton {
	private static LazySingleton instance;
	
	private LazySingleton(){
	}
	
	// Ленивая инициализация плохой стиль
	public LazySingleton  get() {
		if(instance == null)
			instance = new LazySingleton();
		return instance;
	}
}
