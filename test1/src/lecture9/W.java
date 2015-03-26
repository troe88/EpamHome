package lecture9;

public class W extends Q{
	public static void name() {
		System.out.println("W");
	}
	
	public static void main(final String[] args) {
		Q q = new Q();
		Q q1 = new W();
		
		((W)q1).name();		
	}
}
