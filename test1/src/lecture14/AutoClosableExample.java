package lecture14;


public class AutoClosableExample {

	static class Res implements AutoCloseable {
		{
			System.out.println("create");
		}
		
		public void proc() {
			System.out.println("processing");
		}
		
		@Override
		public void close() {
			System.out.println("close");
		}
	};

	public static void main(final String[] args) {

		try(Res res = new Res()){
			res.proc();
		} 
		
//		try (Scanner in = new Scanner(System.in);
//				Scanner in2 = new Scanner(System.in)) {
//			String line = in.nextLine();
//			System.out.println(line);
//		}
	}
}
