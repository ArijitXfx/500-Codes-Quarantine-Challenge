import java.util.*;

public class Sort012{

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void solver(int[] arr, int N){
		int lo = 0, hi = N-1;
		for(int i=0;i<=hi;){
			if(arr[i]==0){
				swap(arr,i,lo);
				i++;
				lo++;
			}else if(arr[i]==2){
				swap(arr,i,hi);
				hi--;
			}else{
				i++;
			}
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuffer res = new StringBuffer();
		while(test-->0){
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			solver(arr,N);
			for(int i:arr){
				res.append(i);
				res.append(" ");
			}
			res.append("\n");
		}
		System.out.println(res.toString());
	}
}