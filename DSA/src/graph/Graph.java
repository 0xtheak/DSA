package graph;

import java.util.*;

public class Graph {
	
	public static void dfsHelper(int[][] adj, int currentVertex, boolean[] visited) {
		if(currentVertex>adj.length) {
			return; 
		}
		System.out.print(currentVertex + " ");
		visited[currentVertex] = true;
		for(int i=0; i<adj[currentVertex].length; i++) {
			if(adj[currentVertex][i]==1 && !visited[i]) {
				dfsHelper(adj, i, visited);
			}
		}
	}
	
	public static void dfs(int[][] adj) {
		boolean[] visited = new boolean[adj.length];
		dfsHelper(adj, 0, visited);
	}
	
	public static void bfs(int[][] adj) {
		boolean[] visited = new boolean[adj.length];
		Queue<Integer> pendingVertex = new LinkedList<>();
		pendingVertex.add(0);
		visited[0] = true;
		while(!pendingVertex.isEmpty()) {
			int currentVertex = pendingVertex.poll();
			System.out.print(currentVertex + " ");
			for(int i=0; i<adj[currentVertex].length; i++) {
				if(adj[currentVertex][i]==1 && !visited[i]) {
					pendingVertex.add(i);
					visited[currentVertex]=true; 
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		int[][] adj = new int[n][n];
		for(int i=0; i<e; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
		
//		dfs(adj);
		bfs(adj);

	}

}
