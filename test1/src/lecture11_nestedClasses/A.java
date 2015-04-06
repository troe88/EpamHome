package lecture11_nestedClasses;

public class A {
	
	
	static class S{ // static
		
	}
	
	class i {  // inner
		
	}
	
	public void method() {
		class L{ // local
			
		}
	}
	
	public void method2() {
		
		Runnable task = new Runnable() { // anonimus
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
	}
	
	public static void main(final String[] args) {

	}
}
