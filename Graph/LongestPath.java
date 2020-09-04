public class LongestPath{
	
	
	public static int LongestPathDFS(int[][] graph, int N){
		boolean[] vis = new boolean[N];
		int[] dp = new int[N];
		for(int i=0;i<N;i++){
			if(!vis[i]){
				util(i, graph, N, dp, vis);
			}
		}
		int max = 0;
		for(int i:dp)
			max = max<i?i:max;
		return max;
	}

	public static void util(int v, int[][] graph, int N, int[] dp, boolean[] vis){
		vis[v] = true;
		for(int i:graph[v]){
			if(!vis[i]){
				util(i,graph,N,dp,vis);
			}
			dp[v] = Math.max(dp[v], 1+dp[i]);
		}
	}

	public static void main(String[] args){
		int[][] graph = {
			{},
			{},
			{3},
			{1},
			{0,1},
			{0,2}
		};
		System.out.println(LongestPathDFS(graph, 6));

	}

}
