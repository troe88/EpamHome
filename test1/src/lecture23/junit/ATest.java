package lecture23.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ATest {

	A a;

	@Before
	public void setup() {
		a = new A();
		System.out.println("qwe");
	}

	@Test
	public void createObject() {
		assertEquals(0, a.state);
	}

	@Test
	public void changeState() {
		a.change();
		assertEquals(1, a.state);
	}

	@Test
	public void changeCycling() throws Exception {
		a.change();
		a.change();
		a.change();
		assertEquals(0, a.state);
	}

	@Test
	public void decrease() throws Exception {
		a.dec();
		assertEquals(-1, a.state);
	}

}
