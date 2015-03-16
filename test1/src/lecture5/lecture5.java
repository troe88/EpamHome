package lecture5;

public class lecture5 {
	public static int a = 9;

	{
		a = 20;
		System.out.println("a = " + this.a);
	}
	
	public lecture5() {
		// TODO Auto-generated constructor stub
	}
	
	public lecture5(int a) {
		this.a = a;
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		Integer a = 21;
		a.toBinaryString(a);
		System.out.println(a);
	}
}
