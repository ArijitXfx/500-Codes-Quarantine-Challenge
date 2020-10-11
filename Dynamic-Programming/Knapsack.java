import java.util.*;

public class Knapsack{

	private static HashMap<String, Integer> cache;
	
	public static int solver(int[] wt, int[] val, int W, int N){
		if(W==0 || N==0) return 0;
		if(cache.containsKey(W+" "+N)) {
			return cache.get(W+" "+N);
		}
		if(wt[N-1]>W){
			int profit = solver(wt,val,W,N-1);
			cache.put(W+" "+N,profit);
			return profit;
		}else{
			int profit = Math.max(val[N-1]+solver(wt,val,W-wt[N-1],N-1),
			solver(wt,val,W,N-1));
			cache.put(W+" "+N,profit);
			return profit;
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0){
			int N = sc.nextInt();
			int W = sc.nextInt();
			int[] wt = new int[N];
			int[] val = new int[N];
			for(int i=0;i<N;i++) val[i] = sc.nextInt();
			for(int i=0;i<N;i++) wt[i] = sc.nextInt();
			cache = new HashMap<String, Integer>();
			System.out.println(solver(wt,val,W,N));
		}
	}
}