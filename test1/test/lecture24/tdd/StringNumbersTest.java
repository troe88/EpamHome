package lecture24.tdd;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringNumbersTest {

	private int _input;
	private String _output;


	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{1, "один"},
				{2, "два"},
				{3, "три"},
				{21, "двадцать один"}
				});
	}

	public StringNumbersTest(final int input, final String output) {
		_input = input;
		_output = output;
		
	}
	
	
	@Test
	public void test() {
		assertEquals(_output, StringNumbers.toString(_input));
	}

}

