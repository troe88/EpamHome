package lecture24.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
	List<Integer>[] _edges;
	int _edgesCount;

	public Graph(final int vertices) {
		if (vertices <= 0)
			throw new IllegalArgumentException("cant be zero");
		_edges = new List[vertices];
		for (int i = 0; i < _edges.length; i++) {
			_edges[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(final int from, final int to) {
		if (from >= size() || to >= size()) {
			throw new IllegalArgumentException();
		}
		_edges[from].add(to);
		_edges[to].add(from);
		_edgesCount++;
	}

	public int size() {
		return _edges.length;
	}

	public int getEdges() {
		return _edgesCount;
	}

	public boolean connected(final int from, final int to) {
		return _edges[from].contains(to);
	}

	public final Iterable<Integer> adjacent(final int from) {
		return Collections.unmodifiableList(_edges[from]);
	}

}
