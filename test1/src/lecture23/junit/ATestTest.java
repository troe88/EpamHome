package lecture23.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ATestTest {
	
	static {
		System.out.println("static init");
	}
	
	{
		System.out.println("init");
	}
	
	public ATestTest() {
		System.out.println("constr");
	}
	
	@BeforeClass
	public static void setupClass(){
		System.out.println("beforeClass");
	}
	
	@Before
	public void setup(){
		System.out.println("setup");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}

	@After
	public void teardown() {
		System.out.println("teardown");
	}

	@AfterClass
	public static void teardownClass(){
		System.out.println("teardownClass");
	}
	

}
