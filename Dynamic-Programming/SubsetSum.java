import java.io.*;
import java.util.*;

class SubsetSum{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static Boolean[][] dp;
    
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i:arr) sum+=i;
        dp = new Boolean[N+1][sum+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j] = null;
            }
        }
        return equalPartitionUtil(arr,N,sum)?1:0;
    }
    
	static boolean equalPartitionUtil(int[] arr, int N,int sum){
		if(sum%2==1) return false;
		sum/=2;
		dp = new Boolean[N+1][sum+1];
		for(int i=0;i<=sum;i++) dp[0][i] = false;
		for(int i=1;i<=N;i++) dp[i][0] = true;
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=sum;j++){
				if(j>=arr[i-1])
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		/*
		for(int i=0;i<=N;i++){
			for(int j=0;j<=sum;j++){
				System.out.print(dp[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		*/		
		return dp[N][sum];
	}
	
    static boolean equalPartitionUtil(int[] arr, int N,int sum, int curr){
        
        if(N==0) return false;
        if(sum==curr) return true;
        if(dp[N][sum]!=null) {
            System.out.println("Cache HIT");
            return dp[N][sum];
        }
        else if(sum>curr) {
           dp[N][sum] = equalPartitionUtil(arr,N-1,sum-arr[N-1],curr+arr[N-1]) || equalPartitionUtil(arr,N-1,sum,curr);
           return dp[N][sum];
        } else{
           dp[N][sum] = equalPartitionUtil(arr,N-1,sum,curr);
           return dp[N][sum];
        } 
    }
}