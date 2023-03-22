package graph;

import java.util.*;

public class BellManFordAlgorithm {
	
	public static class Edge {
		int src;
		int dst;
		int wt;
		public Edge(int s, int d, int w) {
			this.src = s;
			this.dst = d;
			this.wt = w;
		}
	}
	
	public static void bellManFord(ArrayList<ArrayList<Edge>> graph, int src, int V) {
		int dist[] =  new int[V];
		for(int i=0; i<V; i++) {
			if(i!=src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		for(int k=0; k<V-1; k++) {
			for(int j=0; j<V; j++) {
				for(int i=0; i< graph.get(j).size(); i++ ) {
					Edge e  = graph.get(j).get(i);
					int u = e.src;
					int v = e.dst;
					if(dist[u]!=Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
						dist[v] = dist[u] + e.wt;
					}
				}
			}
		}
		for(int i = 0; i<V; i++) {
			System.out.print(dist[i] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>(V);
		for(int i=0; i<V; i++) {
			graph.add(new ArrayList<Edge>());
		}
		for(int i=0; i<E; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			int wt = s.nextInt();
			graph.get(x).add(new Edge(x, y, wt));
		}
		bellManFord(graph, 0, V);

	}

}
