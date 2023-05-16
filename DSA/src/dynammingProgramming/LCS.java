package dynammingProgramming;

public class LCS {
	
	public static int lcs(String s1, String s2, int i, int j) {
		if(i>=s1.length() || j>=s2.length() ) {
			return 0;
		}
		int ans;
		if(s1.charAt(i)==s2.charAt(j)) {
			ans = lcs(s1, s2, i+1, j+1)+1;
		}else {
			ans = Math.max(lcs(s1, s2, i, j+1), lcs(s1, s2, i+1, j));
		}
		return ans;
	}
	
	public static int lcsDR(String s1, String s2, int[][] dp, int i, int j) {
		if(i==s1.length() || j==s2.length()) {
			return 0;
		}
		int ans;
		if(s1.charAt(i)== s2.charAt(j)) {
			if(dp[i+1][j+1]==-1) {
			ans = lcsDR(s1, s2, dp, i+1, j+1) ;	
			dp[i+1][j+1] = ans;
			ans++;
			}else {
				ans = dp[i+1][j+1];
			}
		}else {
			int ans1, ans2;
			if(dp[i+1][j]==-1) {
				ans1 = lcsDR(s1, s2, dp, i+1, j);
				dp[i+1][j] = ans1;
			}else {
				ans1 = dp[i+1][j];
			}
			
			if(dp[i][j+1]==-1) {
				ans2 = lcsDR(s1, s2, dp, i, j+1);
				dp[i][j+1] = ans2;
			}else {
				ans2 = dp[i][j+1];
			}
			ans = Math.max(ans1, ans2);
		}
		dp[i][j] = ans;
		return ans;
	}
	
	public static int lcsDI(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m+1][n+1];
		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				int ans;
				if(s1.charAt(i)==s2.charAt(j)) {
					ans = 1+ dp[i+1][j+1];
				}else {
					int ans1 = dp[i][j+1];
					int ans2 = dp[i+1][j];
					ans = Math.max(ans1, ans2);
				}
				dp[i][j] = ans;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		int[][] dp = new int[s1.length() +1][s2.length() +1];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(lcs(s1, s2, 0, 0));

	}

}
