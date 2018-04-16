package pset5;

import static org.junit.Assert.*;
import java.util.TreeSet;
import java.util.Set;
import org.junit.Test;

public class GraphTester {
	
	// tests for method "addEdge" in class "Graph"
	@Test public void tae0() {
		Graph g = new Graph(2);
		g.addEdge(0, 1);
		//System.out.println(g);
		assertEquals(g.toString(), "numNodes: 2\nedges: [[false, true], [false, false]]");
	}
	@Test public void tae1() {
		Graph g = new Graph(1);
		g.addEdge(0, 0);
		//System.out.println(g);
		assertEquals(g.toString(), "numNodes: 1\nedges: [[true]]");
	}
	@Test public void tae2() {
		Graph g = new Graph(3);
		g.addEdge(0, 3);
		//System.out.println(g);
		assertEquals(g.toString(), "numNodes: 3\nedges: [[false, false, false], [false, false, false], [false, false, false]]");
	}
	@Test public void tae3() {
		Graph g = new Graph(3);
		g.addEdge(-1, 1);
		//System.out.println(g);
		assertEquals(g.toString(), "numNodes: 3\nedges: [[false, false, false], [false, false, false], [false, false, false]]");
	}
	@Test public void tae4() {
		Graph g = new Graph(3);
		g.addEdge(2, 2);
		//System.out.println(g);
		assertEquals(g.toString(), "numNodes: 3\nedges: [[false, false, false], [false, false, false], [false, false, true]]");
	}
	// your tests for method "addEdge" in class "Graph" go here
	// you must provide at least 4 test methods;
	// each test method has at least 1 invocation of addEdge;
	// each test method creates exactly 1 graph
	// each test method creates a unique graph w.r.t. "equals" method
	// each test method has at least 1 test assertion;
	// your test methods provide full statement coverage of your
	// implementation of addEdge and any helper methods
	// no test method directly invokes any method that is not
	// declared in the Graph class as given in this homework
	//...
	//tests for method "reachable" in class "Graph"
	@Test public void tr0() {	//Can reach itself
		Graph g = new Graph(1);
		Set<Integer> nodes = new TreeSet<Integer>();
		nodes.add(0);
		assertTrue(g.reachable(nodes, nodes));
	}
	@Test public void tr1() {	//no source goes to target node[1] --> returns false
		Graph g = new Graph(3);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		Set<Integer> nodes = new TreeSet<Integer>();
		nodes.add(0);
		nodes.add(2);
		Set<Integer> nodes2 = new TreeSet<Integer>();
		nodes2.add(0);
		nodes2.add(1);	//HERE
		assertFalse(g.reachable(nodes, nodes2));
	}
	@Test public void tr2() {	//source node out of bounds
		Graph g = new Graph(3);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		Set<Integer> nodes = new TreeSet<Integer>();
		nodes.add(-1);	//HERE
		nodes.add(2);
		Set<Integer> nodes2 = new TreeSet<Integer>();
		nodes2.add(0);
		nodes2.add(1);
		assertFalse(g.reachable(nodes, nodes2));
	}
	@Test public void tr3() {	//target node out of bounds
		Graph g = new Graph(3);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		Set<Integer> nodes = new TreeSet<Integer>();
		nodes.add(0);
		nodes.add(2);
		Set<Integer> nodes2 = new TreeSet<Integer>();
		nodes2.add(0);
		nodes2.add(4); 	//HERE
		assertFalse(g.reachable(nodes, nodes2));
	}
	@Test public void tr4() {	//target node is 0-3 edges away
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		Set<Integer> nodes = new TreeSet<Integer>();
		nodes.add(0);
		Set<Integer> nodes2 = new TreeSet<Integer>();
		nodes2.add(0);
		nodes2.add(1);
		nodes2.add(2);
		nodes2.add(3);
		assertTrue(g.reachable(nodes, nodes2));
	}
	//your tests for method "reachable" in class "Graph" go here
	//you must provide at least 6 test methods;
	//each test method must have at least 1 invocation of reachable;
	//each test method must have at least 1 test assertion;
	//at least 2 test methods must have at least 1 invocation of addEdge;
	//your test methods must provide full statement coverage of your
	//implementation of reachable and any helper methods
	//no test method directly invokes any method that is not
	//declared in the Graph class as given in this homework
	//...
}