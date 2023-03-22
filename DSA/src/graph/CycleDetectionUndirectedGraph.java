package graph;

import java.util.Scanner;
import java.util.*;

public class CycleDetectionUndirectedGraph {
	
	public static boolean cycleDetectdfs(int[][] adj, int currentVertex, int parent, boolean[] visited) {
		visited[currentVertex] = true;
		
		for(int i=0; i<adj[currentVertex].length; i++) {
			int edge = adj[currentVertex][i];
			if(edge==1) {
				
				if(visited[i] && i!=parent) {
					return true;
				}else if(!visited[i]) {
					if(cycleDetectdfs(adj, i, currentVertex, visited)) {
						return true;
					}
			}
			}
		}
		return false;
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
		
		boolean[] visited = new boolean[n];
		System.out.println(cycleDetectdfs(adj, 0, -1, visited));
	}

}
