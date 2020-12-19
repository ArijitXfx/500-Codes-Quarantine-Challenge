import java.util.*;

public class RodCutting{
	private static HashMap<String,Integer> cache;
	
	public static int solver(int W, int[] cuts, int N){
		if(W==0 || N==0) return 0;
		else if(cache.containsKey(W+" "+N)) return cache.get(W+" "+N);
		else if(W>=N)
			cache.put(W+" "+N, Math.max(cuts[N-1]+solver(W-N,cuts,N),
			solver(W,cuts,N-1)));
		else cache.put(W+" "+N, solver(W,cuts,N-1));
		return cache.get(W+" "+N);
	}
	
	public static void main(String[] args){
		int[] cuts = {1,5,8,9,10,17,17,20};
		int N = 8;
		cache = new HashMap<String, Integer>();
		System.out.println(solver(N, cuts, N));
	}
}