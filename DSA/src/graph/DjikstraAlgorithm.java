package graph;

import java.util.*;


public class DjikstraAlgorithm {
	
	public static class Pair implements Comparable<Pair> {
		int node;
		int dist;
		
		public Pair(int n, int d) {
			this.node = n;
			this.dist = d;
		}
		
		@Override
		public int compareTo(Pair p2) {
			return this.dist - p2.dist; // ascending order sorting
		}
	}
	
	public static class Edge {
		int src;
		int dst;
		int weight;
		public Edge(int s, int d, int weight) {
			this.src = s;
			this.dst = d;
			this.weight = weight;
		}
	}
	
	public static void DjisktraAlgo(ArrayList<ArrayList<Edge>> graph, int src, int V) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V];
		int dist[] = new int[V];
		for(int i=0; i<V; i++) {
			if(i!=src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		pq.add(new Pair(0, 0));
		dist[src]=0;
		
		while(!pq.isEmpty()) {
			Pair curr = pq.remove();
			if(!visited[curr.node]) {
				visited[curr.node] = true;
				for(int i=0; i<graph.get(curr.node).size(); i++) {
					Edge e = graph.get(curr.node).get(i);
					int u = e.src;
					int v = e.dst;
					if(dist[u] + e.weight < dist[v]) { //relaxation
						dist[v] = dist[u] + e.weight;
						pq.add(new Pair(v, dist[v]));
						
					}
				}
			}
			
		}
		for(int i=0; i<V; i++ ) {
			System.out.print(dist[i] + " ");
		}
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>(n);
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		for(int i=0; i<e; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			int wt = s.nextInt();
			graph.get(x).add(new Edge(x, y, wt));
		}
		DjisktraAlgo(graph, 0, e);
//		System.out.println(graph);
		
//		for(int i=0; i<graph.size(); i++) {
//			for(int j=0; j<graph.get(i).size(); j++) {
//				Edge edge = graph.get(i).get(j);
//				System.out.println();
//				System.out.print(edge.src + " " + edge.dst + " " + edge.weight );
//			}
//		}

	}

}
