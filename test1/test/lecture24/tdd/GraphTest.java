package lecture24.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class GraphTest {

	@Test
	public void vertStoredInConstructor() {
		Graph g = new Graph(4);
		assertEquals(4, g._edges.length);
		Graph g1 = new Graph(10);
		assertEquals(10, g1._edges.length);
	}

	@Test
	public void edgesCreateInConstuctor() throws Exception {
		Graph g = new Graph(4);
		assertNotNull(g._edges);
	}

	@Test
	public void negativeConstructorParametrs() throws Exception {
		try {
			new Graph(-1);
			fail("graph vertices must be grater than zero, should throw exeption");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void zeroConstructorParametrs() throws Exception {
		try {
			new Graph(0);
			fail("graph vertices must be grater than zero, should throw exeption");
		} catch (IllegalArgumentException iae) {
		}
	}
}
