import java.util.*;

public class Knapsack{

	public static void solver(int[] wt, int[] val, int W, int N){
		if(W==0 || N==0) return 0;
		if(wt[n-1]>W){
			return solver(wt,val,W-wt[n-1],N-1);
		}else{
			return Math.max(val[N-1]+solver(wt,val,W-wt[n-1],N-1),
			solver(wt,val,W-wt[n-1],N-1));
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
			for(int i=0;i<N;i++) wt[i] = sc.nextInt();
			for(int i=0;i<N;i++) val[i] = sc.nextInt();
			
			System.out.println(solver(wt,val,W,N));
		}
	}
}