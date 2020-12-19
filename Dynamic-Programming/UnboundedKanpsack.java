public class UnboundedKanpsack{
	private static HashMap<String, Integer> cache;
    
    static int knapSack(int N, int W, int val[], int wt[])
    {
        cache = new HashMap<String, Integer>();
        return knapSackUtil(N,W,val,wt);
    }
    
    static int knapSackUtil(int N, int W, int val[], int wt[]){
        if(N==0 || W==0) 
            return 0;
        if(cache.containsKey(N+" "+W))
            return cache.get(N+" "+W);
        if(W-wt[N-1]>=0){
            cache.put(N+" "+W,Math.max(val[N-1]+knapSackUtil(N,W-wt[N-1],val,wt),
            knapSackUtil(N-1,W,val,wt)));
        }else{
            cache.put(N+" "+W,knapSackUtil(N-1,W,val,wt));
        }
        return cache.get(N+" "+W);
    }
}