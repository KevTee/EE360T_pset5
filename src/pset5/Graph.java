package pset5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Graph {
	
	private int numNodes; // number of nodes in the graph
	private boolean[][] edges;
	private ArrayList<Integer> visited;

	// edges[i][j] is true if and only if there is an edge from node i to node j
	// class invariant: fields "edges" is non-null;
	// "edges" is a square matrix;
	// numNodes is number of rows in "edges"

	public Graph(int size) {
		edges = new boolean[size][size];
		visited = new ArrayList<Integer>();
		numNodes = size;
	}
	
	public String toString() {
		return "numNodes: " + numNodes + "\n" + "edges: " + Arrays.deepToString(edges);
	}
	
	public boolean equals(Object o) {
		if (o.getClass() != Graph.class) return false;
		return toString().equals(o.toString());
	}
	
	public void addEdge(int from, int to) {
		// postcondition: adds a directed edge "from" -> "to" to this graph
		// your code goes here
		//...
		if(from < 0 || from >= numNodes) return;
		if(to < 0 || to >= numNodes) return;
		edges[from][to] = true;
	}
	
	public boolean reachable(Set<Integer> sources, Set<Integer> targets) {
		if (sources == null || targets == null) throw new IllegalArgumentException();
		
		boolean found = false;
		for(Integer target : targets) {
			for(Integer source : sources) {
				// postcondition: returns true if (1) "sources" does not contain an illegal node,
				if(source < 0 || source >= numNodes) return false;
				//(2) "targets" does not contain an illegal node, and
				if(target < 0 || target >= numNodes) return false;
				//(3) for each node "m" in set "targets", there is some
				//node "n" in set "sources" such that there is a directed
				//path that starts at "n" and ends at "m" in "this"; and
				//false otherwise
				if(searchPath(source, target)) found = true;
			}
			if(!found) return false;
			found = false;
		}
		return true;
	}
	
	public boolean searchPath(Integer from, Integer to) {
		if(from.equals(to)) return true;
		if(edges[from][to]) return true;
		
		for(int i = 0; i < numNodes; i++) {
			if(edges[from][i] && !from.equals(i) && !visited.contains(i)) {
				visited.add(from);
				if(searchPath(i, to)) {
					visited.clear();
					return true;
				}
			}
		}
		visited.clear();
		return false;
	}
}