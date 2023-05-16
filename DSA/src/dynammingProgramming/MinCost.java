package dynammingProgramming;

public class MinCost {
	
	public static int minCost(int[][] cost, int i, int j) {
		if(i== cost.length-1 && j== cost.length-1) {
			return cost[i][j];
		}
		
//		base case
		if(i>=cost.length || j>=cost[0].length) {
			return Integer.MAX_VALUE;
		}
		
		return Math.min(minCost(cost, i+1, j), Math.min(minCost(cost, i, j+1), minCost(cost, i+1, j+1))) + cost[i][j];
		
	}
	
	public static int minCostDR(int[][] cost, int[][] dp, int i, int j) {
		if(i>= cost.length || j>= cost[0].length) {
			return Integer.MAX_VALUE;
		}
		int ans1, ans2, ans3;
		if(dp[i+1][j]==Integer.MIN_VALUE) {
			ans1 = minCost(cost, i+1, j);
			dp[i+1][j] = ans1;
		}else {
			ans1 = dp[i+1][j];
		}
		
		if(dp[i][j+1]==Integer.MIN_VALUE) {
			ans2 = minCost(cost, i, j+1);
			dp[i][j+1] = ans2;
		}else {
			ans2 = dp[i][j+1];
		}
		
		if(dp[i+1][j+1]==Integer.MIN_VALUE) {
			ans3 = minCost(cost, i+1, j+1);
			dp[i+1][j+1] = ans3;
		}else {
			ans3 = dp[i+1][j+1];
		}
		dp[i][j] = Math.min(ans1, Math.min(ans2, ans3)) + cost[i][j];
		
		return dp[i][j];
	}
	
	public static int minCostDI(int[][] cost) {
		int m = cost.length;
		int n = cost[0].length;
		int[][] dp = new int[m + 1][n+1];
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if(i==m-1 && j==n-1) {
					dp[i][j] = cost[i][j];
					continue;
				}
				int ans1 = dp[i][j+1];
				int ans2 = dp[i+1][j];
				int ans3 = dp[i+1][j+1];
				dp[i][j] = Math.min(Math.min(ans1, ans2), ans3) + cost[i][j];
			}
		}
		return dp[0][0];
		
	}
	
	public static void main(String[] args) {
		int[][] cost = {{1,2,3},{4,5,6},{7,8,9} };
		int[][] dp = new int[cost.length + 1][cost[0].length + 1];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		System.out.println(minCostDI(cost));
//		for(int i=0; i<dp.length; i++) {
//			for(int j=0; j<dp[0].length; j++) {
//				 System.out.print(dp[i][j] +" ");
//			}
//			System.out.println();
//		}
		
	}

}
