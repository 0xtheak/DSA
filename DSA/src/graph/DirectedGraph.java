package graph;

import java.util.*;

public class DirectedGraph {
	
	public static void dfsHelper(int[][] adj, int currentVertex, boolean[] visited) {
		if(currentVertex>adj.length) {
			return;
		}
		System.out.print(currentVertex + " ");
		visited[currentVertex] = true;
		for(int i=0; i<adj.length; i++) {
			if(adj[currentVertex][i] == 1 && !visited[i]) {
				dfsHelper(adj, i, visited);
			}
		}
	}
	
	public static void dfs(int[][] adj) {
		boolean[] visited = new boolean[adj.length];
		for(int i= 0; i<adj.length; i++) {
			if(!visited[i]) {
				dfsHelper(adj, i, visited);
			}
		}
		
	}
	
	public static void bfs(int[][] adj) {
		boolean[] visited = new boolean[adj.length];
		Queue<Integer> pendingVertex = new LinkedList<>();
		pendingVertex.add(0);
		
		while(!pendingVertex.isEmpty()) {
			int currentVertex = pendingVertex.poll();
			if(!visited[currentVertex]) {
				System.out.print(currentVertex + " ");
			}
			visited[currentVertex]=true;
			for(int i=0; i<adj[currentVertex].length; i++) {
				if(adj[currentVertex][i]==1 && !visited[i]) {
					pendingVertex.add(i);
					 
				}
			}
		}
	}
	
	public static boolean isCycleDirected(int[][] adj, int currentVertex, boolean[] visited, boolean[] rec) {
		visited[currentVertex] = true;
		rec[currentVertex] = true;
		for(int i=0; i<adj.length; i++) {
			int edge = adj[currentVertex][i];
			if(edge==1) {
				if(rec[edge]) {
					return true;
				}else if(!visited[edge] && isCycleDirected(adj, edge, visited, rec)) {
					return true;
				}
			}
		}
		rec[currentVertex] = false;
		return false;
	}
	
	public static void topSort(int[][] adj, int currentVertex, boolean[] visited, Stack<Integer> stack) {
		visited[currentVertex] = true; 
		for(int i=0; i<adj.length; i++) {
			int edge = adj[currentVertex][i];
			if(edge==1) {
				if(!visited[edge]) {
					topSort(adj, edge, visited, stack);
				}
			}
		}
		stack.push(currentVertex);
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
		}
		
		dfs(adj);
		System.out.println();
//		bfs(adj);
//		System.out.println(isCycleDirected(adj, 0, new boolean[adj.length], new boolean[adj.length]));
		
		boolean[] visited = new boolean[n];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				topSort(adj, i, visited, stack);
			}
			
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

}
}
