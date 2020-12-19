import java.util.*;

public class CoinChange{
	private static HashMap<String,Integer> cache;
	
	public static int solver(int W, int[] cuts, int N){
		if(W==0 || N==0) return 0;
		else if(cache.containsKey(W+" "+cuts[N-1])) return cache.get(W+" "+cuts[N-1]);
		else if(W>=cuts[N-1])
			cache.put(W+" "+cuts[N-1], Math.max(1+solver(W-cuts[N-1],cuts,N),
			solver(W,cuts,N-1)));
		else cache.put(W+" "+cuts[N-1], solver(W,cuts,N-1));
		return cache.get(W+" "+cuts[N-1]);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int W = 7;
		int[] cuts = {1,2,3,4,7,8,9,11};
		int N = 8;
		cache = new HashMap<String, Integer>();
		System.out.println(solver(W, cuts, N));
	}
}