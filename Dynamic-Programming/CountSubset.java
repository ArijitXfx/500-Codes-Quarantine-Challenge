import java.util.*;

public class CountSubset{
	
	static int[][] dp;
	
	public static int solver(int[] arr, int N, int sum){
		if(sum==0) return 1;
		if(N==0) return 0;
		if(dp[N][sum]!=-1) return dp[N][sum];
		dp[N][sum] = 0;
		if(arr[N-1]<=sum){
			dp[N][sum]+= solver(arr,N-1,sum-arr[N-1])+solver(arr,N-1,sum);
		}else{
			dp[N][sum]+= solver(arr, N-1, sum);
		}
		return dp[N][sum];
	}
	
	public static void main(String[] args){
		int[] arr = {1, 1, 1, 1};
		int sum = 2;
		dp = new int[arr.length+1][sum+1];
		for(int[] row:dp) Arrays.fill(row,-1);
		System.out.println(solver(arr,arr.length,sum));
	}
}