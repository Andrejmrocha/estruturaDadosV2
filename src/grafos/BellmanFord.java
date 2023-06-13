package grafos;


public class BellmanFord extends ShortestPath{
	public BellmanFord(EdgeWeightedDigraph graph, int source) {
		super(graph, source);
	}

	@Override
	protected void execute() {
		for (int i = 0; i < distTo.length; i++) {
			if (i != source) {
				if (graph.containsEdge(source, i)) {
					distTo[i] = graph.getWeight(source, i);
					edgeTo[i] = graph.getEdge(source, i);
				} else {
					distTo[i] = EdgeWeightedDigraph.INFINITY;		
				}
			}
		}
		
		for (int k = 0; k < graph.getNumberOfVertices(); k++) {
			boolean changed = false;
			
			for (int j = 0; j < graph.getNumberOfVertices(); j++) {
				if (j == source) {
					continue;
				}

				
				
				Iterable<DirectedEdge> pred = graph.predecessors(j);
				for (DirectedEdge edge : pred) {
					if (distTo[edge.from()] + edge.weight() < distTo[j]) {
						distTo[j] = distTo[edge.from()] + edge.weight();
						edgeTo[j] = edge;
						
						changed = true;
					}
				}
				
				System.out.print("dist To: ");
				System.out.println(distToString());
				
				System.out.print("edge To: ");
				System.out.println(edgeToString());
				
			}
			
			
			if (!changed) {
				System.out.println("Bye com i: "+ k);
				break;
			}
		}
		
	}
}
