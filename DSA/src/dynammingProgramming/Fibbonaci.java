package dynammingProgramming;

public class Fibbonaci {
	
	public static int fibI(int n) {
		int dp[] = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	public static int fib(int n) {
		if(n==1 || n==0) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static int dynamicFib(int n, int[] ans) {
		if(n==1 || n==0) {
			return n;
		}
		int a;
		if(ans[n-1]==-1) {
			a = dynamicFib(n-1, ans);
			ans[n-1] = a;
		}else {
			a = ans[n-1];
		}
		
		int b;
		if(ans[n-2]==-1) {
			b = dynamicFib(n-2, ans);
			ans[n-2]=b;
		}else {
			b = ans[n-2];
		}
		ans[n] = a+b;
		return a + b;
	}

	public static void main(String[] args) {
		int[] ans = new int[11];
		for(int i=0; i<ans.length; i++) {
			ans[i] = -1;
		}
		System.out.println(fibI(6));
//		for(int i: ans ) {
//			System.out.print(i + " ");
//		}
		

	}

}
