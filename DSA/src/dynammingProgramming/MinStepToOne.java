package dynammingProgramming;

public class MinStepToOne {
	
	public static int minStepToOne(int n, int[] dp) {
		if(n==1 || n==0) {
			return 0;
		}
		int a = Integer.MAX_VALUE, b=Integer.MAX_VALUE, c=Integer.MAX_VALUE;
		if(dp[n-1]==-1) {
			a = minStepToOne(n-1, dp)+1;
			dp[n-1] = a;
		}else {
			a = dp[n-1];
		}
		
		if(n%2==0 && dp[n/2]==-1) {
			b = minStepToOne(n/2, dp)+1;
			dp[n/2] = b;
		}else {
			if(n%2==0) {
				b = dp[n/2];
			}
		}
		
		if(n%3==0 && dp[n/3]==-1) {
			c = minStepToOne(n/3, dp)+1;
			dp[n/3] = c;
		}else {
			if(n%3==0) {
				c = dp[n/3];
			}
		}
		return Math.min(a, Math.min(b, c));
	}
	
	public static int minStepToOneI(int n) {
		if(n<=1) {
			return 0;
		}
		if(n==2 || n==3) {
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=0;
		dp[2]=1;
		dp[3]=1;
		for(int i=4; i<dp.length; i++) {
			int ans1 = dp[i-1]+1;
			int ans2 = Integer.MAX_VALUE;
			int ans3 = Integer.MAX_VALUE;
			if(i%2==0) {
				ans2 = dp[i/2]+1;
			}
			if(i%3==0) {
				ans3 = dp[i/3]+1;
			}
			dp[i] = Math.min(ans1, Math.min(ans2, ans3));
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int[] dp = new int[8];
		for(int i=0; i<dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(minStepToOneI(3));

	}

}
