package grafos;

import java.util.List;


public class q1 {
	public static void main(String[] args) {
		EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(6);

		digraph.addEdge(0,1,3);
		digraph.addEdge(0,3,4);
		digraph.addEdge(0,5,10);
		digraph.addEdge(0,2,8);
		
		digraph.addEdge(1,3,6);
		digraph.addEdge(1,0,3);
		
		digraph.addEdge(2,4,7);
		digraph.addEdge(2,0,8);
		
		digraph.addEdge(3,4,1);
		digraph.addEdge(3,1,6);
		digraph.addEdge(3,0,4);
		digraph.addEdge(3,5,3);
		
		digraph.addEdge(4,2,7);
		digraph.addEdge(4,3,1);
		digraph.addEdge(4,5,1);
		
		digraph.addEdge(5,3,3);
		digraph.addEdge(5,0,10);
		digraph.addEdge(5,4,1);


		int source = 0;
		ShortestPath sp = new Dijkstra(digraph, 0);
		showDistances(digraph, source, sp);
		
		System.out.println();
		
		source = 4;
		sp = new Dijkstra(digraph, 4);
		showDistances(digraph, source, sp);
		
	}

	private static void showDistances(EdgeWeightedDigraph digraph, int source, ShortestPath sp) {
		List<Integer> vertices = digraph.getVertices();
		for (Integer vertex : vertices) {
			System.out.println("A distancia de " + source + " para " + vertex + " é:" + sp.distTo(vertex) + " com path:"
					+ sp.pathTo(vertex));
		}
	}
}
