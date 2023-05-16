package backtracking;

public class RatInAMaze {
	
	public static boolean wayFinder(int[][] maze, int[][] path, int i, int j) {
		int n = maze.length;
		if(i<0 || j>= n || i>=n || j< 0 || path[i][j]==1 || maze[i][j]==0 ) {
			
			return false;
		}
		path[i][j]=1;
		if(i==n-1 && j==n-1) {
			for(int k=0; k<path.length; k++) {
				for(int l=0; l<path[0].length; l++) {
					System.out.print(path[k][l] + " ");
				}
				
			}
			System.out.println();
			
			path[i][j]=0;
			return true;
		}
		
		boolean left  = wayFinder(maze, path, i, j-1);
		boolean right = wayFinder(maze, path, i, j+1);
		boolean top = wayFinder(maze, path, i-1, j);
		boolean down = wayFinder(maze, path, i+1, j);
		path[i][j]=0;
		return left || right || top || down;
	}
	
	public static boolean ratInMaze(int maze[][]) {
		int[][] isPath = new int[maze.length][maze[0].length];
		return wayFinder(maze, isPath, 0, 0);
		
		
		
	}

	public static void main(String[] args) {
		int maze[][] = {{1,1,1},{1,1,1},{1,1,1}};
		boolean pathPossible = ratInMaze(maze);
		System.out.println(pathPossible);

	}

}
