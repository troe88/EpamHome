package lecture14;

public class LogWithStackTrace {
	
	public static void log(final String msg){
		Exception e = new Exception();
		int l = e.getStackTrace()[1].getLineNumber(); 
		System.out.println(msg + " : " + e.getStackTrace()[1].getMethodName() + " (" + l + ")");
		
	}
	
	public static void main(final String[] args) {
		log("msg 1");
		a();
		b();
	}

	private static void b() {
		log("error here");
	}

	private static void a() {
		log("error there");
	}
}
