import java.util.*;

public class SubArrayWithSum{
	
	public static void solver(int[] arr, int N, int sum, StringBuffer out){
		int currSum = arr[0];
		int start = 0;
		for(int i=1;i<=N;){
			//System.out.println(currSum+" "+sum);
			if(currSum==sum) {
				out.append(start+1);
				out.append(" ");
				out.append(i);
				return;
			}else if(currSum>sum){
				currSum-=arr[start++];
			}else{
			    if(i==N) break;
				currSum += arr[i++];
			}
		}
		out.append("-1");
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuffer out = new StringBuffer();
		int test = sc.nextInt();
		while(test-->0){
			int N = sc.nextInt();
			int sum = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			solver(arr,N,sum,out);
			out.append("\n");
		}
		sc.close();
		System.out.println(out.toString());
	}
}