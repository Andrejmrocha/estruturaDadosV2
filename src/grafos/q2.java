package grafos;

import java.util.List;

public class q2 {
	public static void main(String[] args) {
		EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(5);

		digraph.addEdge(0,1,-2);
		digraph.addEdge(0,2,1);
		digraph.addEdge(0,4,1);
		
		
		digraph.addEdge(1,3,6);
		
		digraph.addEdge(2,1,4);
		
		digraph.addEdge(3,2,3);
		digraph.addEdge(3,0,1);
		digraph.addEdge(3,4,8);
		
		digraph.addEdge(4,2,5);
		


		int source = 3;
		ShortestPath sp = new BellmanFord(digraph, 3);
		showDistances(digraph, source, sp);
		
		System.out.println();
		
		
	}

	private static void showDistances(EdgeWeightedDigraph digraph, int source, ShortestPath sp) {
		List<Integer> vertices = digraph.getVertices();
		for (Integer vertex : vertices) {
			System.out.println("A distancia de " + source + " para " + vertex + " é:" + sp.distTo(vertex) + " com path:"
					+ sp.pathTo(vertex));
		}
	}
}
