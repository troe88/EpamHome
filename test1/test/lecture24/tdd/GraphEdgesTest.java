package lecture24.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GraphEdgesTest {

	private Graph g;

	@Before
	public void setup() {
		g = new Graph(4);
	}

	@Test
	public void addEdgeCorrectVertices() {
		try {
			g.addEdge(4, 5);
			fail("frong parameters");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void edgeCount() throws Exception {
		g.addEdge(0, 1);
		assertEquals(1, g.getEdges());
		g.addEdge(1, 3);
		assertEquals(2, g.getEdges());
	}

	@Test
	public void addEdge() throws Exception {
		assertFalse(g.connected(0, 1));
		assertFalse(g.connected(1, 0));
		g.addEdge(0, 1);
		assertTrue(g.connected(0, 1));
		assertTrue(g.connected(1, 0));
		g.addEdge(0, 2);
		assertTrue(g.connected(0, 2));
		assertTrue(g.connected(2, 0));
	}

	@Test
	public void adjacent() throws Exception {
		g.addEdge(0, 1);
		g.addEdge(2, 0);
		g.addEdge(0, 3);
		assertEquals(g.adjacent(0).toString(), Arrays.asList(1, 2, 3).toString());
	}

}
