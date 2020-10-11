import java.util.*;

public class NextGreater{
	
	public static long[] solver(long[] arr, int N){
		Stack<Long> stack = new Stack<Long>();
		StringBuffer sb = new StringBuffer();
		long[] result = new long[N];
		for(int i=N-1;i>=0;i--){
			while(!stack.isEmpty() && stack.peek()<arr[i]){
				stack.pop();
			}
			result[i] = stack.isEmpty()?-1:stack.peek();
			stack.add(arr[i]);
		}
		return result;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		while(test-->0){
			int N = sc.nextInt();
			long[] arr = new long[N];
			for(int i=0;i<N;i++) arr[i] = sc.nextLong();
			long[] result = solver(arr,N);
			for(long i:result) {
				sb.append(i);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}