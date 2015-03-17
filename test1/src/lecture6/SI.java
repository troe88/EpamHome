package lecture6;

public class SI {
	public SI() {
		// TODO Auto-generated constructor stub
	}
	static int x;
	
	static 
	{	
		x = (int) 10.0f;
		System.out.println("static init: " + x);
	}
	
	static void test(){
		System.out.println("test");
	}
}
