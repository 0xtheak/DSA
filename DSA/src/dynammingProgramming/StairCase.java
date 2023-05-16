package dynammingProgramming;

public class StairCase {
	
	public static int stairCaseI(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] =1;
		dp[2]=2;
		for(int i=3; i<dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		return dp[n];
	}

	public static int stairCase(int n, int[] dp) {
		if(n==1 || n==2 || n==0) {
			return 1;
		}
		int a, b, c;
		if(dp[n-1]==-1) {
			a = stairCase(n-1, dp);
			dp[n-1] = a;
		}else {
			a = dp[n-1];
		}
		if(dp[n-2]==-1) {
			b = stairCase(n-2, dp);
			dp[n-2] = b;
		}else {
			b = dp[n-2];
		}
		
		if(dp[n-3]==-1) {
			c = stairCase(n-3, dp);
			dp[n-3] = c;
		}else {
			c = dp[n-3];
		}
		dp[n] = a+b+c;
		return dp[n];
	}
	
	public static void main(String[] args) {
		int[] dp = new int[20];
		for(int i=0; i<dp.length; i++) {
			dp[i] = -1;
		}
		
		System.out.println(stairCaseI(4));
	}

}
