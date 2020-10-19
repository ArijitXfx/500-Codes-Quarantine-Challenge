import java.util.*;

public class EquilibriumPoint{

	public static int solver(int[] arr, int N){
		long sum = 0;
		for(int i:arr) sum+=i;
		long left = 0;
		long right = sum-arr[0];
		if(left==right) return 1;
		for(int i=1;i<N;i++){
			left+=arr[i-1];
			right-=arr[i];
			if(left==right) return i+1;
		}
		return -1;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0){
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++) arr[i] = sc.nextInt();
			System.out.println(solver(arr,N));
		}
	}
}