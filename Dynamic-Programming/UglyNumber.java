import java.util.*;

public class UglyNumber{

	public static long[] init(){
		int N = 10000;
		long[] dt = new long[N];
		dt[0] = 1;
		int two = 0, three = 0, five = 0;

		for(int i=1;i<N;i++){
			dt[i] = Math.min(2*dt[two],Math.min(3*dt[three],5*dt[five]));
			if(dt[i]==2*dt[two]) two++;
			if(dt[i]==3*dt[three]) three++;
			if(dt[i]==5*dt[five]) five++;
		}
		return dt;
	}

	public static void main(String[] args){
		long[] dt = init();
		//System.out.println(Arrays.toString(dt));

		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0){
			System.out.println(dt[sc.nextInt()-1]);
		}
	}
}
