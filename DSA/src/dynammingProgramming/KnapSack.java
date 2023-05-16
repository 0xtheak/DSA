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

	public static void main(String[] args) {
		int val[] = {200, 300, 100};
		int wt[] = {20, 25, 30};
		int w = 50;
		int ans = knapSack(val, wt, w, 0);
		System.out.println(ans);
		

	}

}
