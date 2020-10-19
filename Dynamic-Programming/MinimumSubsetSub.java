class MinimumSubsetSub{
    private int min;
    private HashMap<String, Integer> cache;
    public int util(int[] arr, int n, int sum, int curr){
        if(n==0) 
			return min;
		
        if(cache.containsKey(sum+" "+n)) 
			return cache.get(sum+" "+n);
		
        if(curr+arr[n-1]<=sum-arr[n-1]){
            min = Math.min(min,sum-curr-2*arr[n-1]);
            cache.put(sum+" "+n, Math.min(util(arr,n-1,sum-arr[n-1],curr+arr[n-1]),
            util(arr,n-1,sum,curr)));
        }else{
            cache.put(sum+" "+n,util(arr,n-1,sum,curr));
        }
        return cache.get(sum+" "+n);
    }

	public int minDiffernce(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int i:arr) sum += i;
	    min = sum;
	    cache = new HashMap<String, Integer>();
	    return util(arr,n,sum,0);
	} 
}