package dynammingProgramming;

public class MinNoSqs {
	
	public static int minNoSq(int n, int[] dp) {
		if( n==0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for(int i=1; (i*i)<=n; i++) {
			int currAns;
			if(dp[n-(i*i)]==-1) {
				currAns = minNoSq(n-(i*i), dp) ;
				dp[n-(i*i)] = currAns;
			}else {
				currAns = dp[n-i*i];
			}
			if(ans>currAns) {
				ans = currAns;
			}
		}
		
		return ans+1;
	}

	public static void main(String[] args) {
		int[] dp = new int[11];
		for(int i=0; i<dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(minNoSq(10, dp));
		for(int i: dp) {
			System.out.print(i + " ");
		}

	}

}
