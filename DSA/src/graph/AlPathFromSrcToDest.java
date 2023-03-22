package graph;

import java.util.Scanner;

public class AlPathFromSrcToDest {
	
	public static void dfsPathHelper(int[][] adj, int crn, int dest, String path, boolean[] visited) {
		if( crn==dest) {
			path += crn;
			System.out.println(path);
			return;
		}
		path += crn;
		for(int i=0; i<adj[crn].length; i++) {
			if(adj[crn][i]==1 && !visited[i]) {
				visited[crn] = true;
				dfsPathHelper(adj, i, dest, path, visited);
				visited[crn] = false;
				
			}
		}
	}
	
	public static void dfsPath(int[][] adj, int src, int dest) {
		boolean visited[] = new boolean[adj.length];
		 dfsPathHelper(adj, src, dest, "", visited);

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
		
		int src = s.nextInt();
		int dest = s.nextInt();
		dfsPath(adj, src, dest);

	}

}
