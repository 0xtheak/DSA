package dynammingProgramming;

public class KnapSack {
	
	public static int knapSack(int[] val, int[] wt, int w, int i) {
		if(i==val.length) {
			return 0;
		}
		int ans;
//		include
		if(wt[i]<=w) {
			int ans1 = val[i] + knapSack(val, wt, w-wt[i], i+1);
			int ans2 = knapSack(val, wt, w, i+1);
			ans = Math.max(ans1, ans2);
		}else {
			ans = knapSack(val, wt, w, i+1);
		}
		return ans;
	}
	
	public static int knapSackDI(int W, int[] val, int[] wt) {
		int n = val.length;
		int[][] dp = new int[n+1][W+1];
		
		for(int i=n-1; i>=0; i--) {
			for(int w=0; w<=W; w++) {
				int ans;
				if(wt[i]<=w) {
					int ans1 = val[i] + dp[i+1][w-wt[i]];
					int ans2 = dp[i+1][w];
					ans = Math.max(ans1, ans2);
				}else {
					ans = dp[i+1][w];
				}
				dp[i][w] = ans;
			}
		}
		return dp[0][W];
	}

	public static void main(String[] args) {
		int val[] = {200, 300, 100};
		int wt[] = {20, 25, 30};
		int w = 50;
		int ans = knapSackDI(w, val, wt);
		System.out.println(ans);
		

	}

}
