package lecture11_nestedClasses;
import lecture11_nestedClasses.B.C;

public class Use {
	public static void main(final String[] args) {
		B b = new B();
		C c = new C();
		
		
		D d = new D();
		d.s.print();
		
		E e = new E();
		e.i.print();
		
		E.I i = e.new I();
		
	}
}
