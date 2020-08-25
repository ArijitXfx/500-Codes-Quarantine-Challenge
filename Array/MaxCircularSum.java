public class MaxCircularSum{
	
	public static int kadane(int[] arr){
		int maxSoFar = Integer.MIN_VALUE;
		int currMax = 0;
		
		for(int i:arr){
			currMax += i;
			if(maxSoFar<currMax) maxSoFar = currMax;
			if(currMax<0) currMax = 0;
		}
		return maxSoFar;
	}
	
	public static int solver(int[] arr){
		int maxKadane = kadane(arr);
		int total = 0;
		for(int i=0;i<arr.length;i++){
			total += arr[i];
			arr[i] = -arr[i];
		}
		total+=kadane(arr);
		return Math.max(maxKadane,total);
	}
	
	public static void main(String[] args){
		int[] arr = {11, 10, -20, 5, -3, -5, 8, -13, 10};
		System.out.println(solver(arr));
	}
}