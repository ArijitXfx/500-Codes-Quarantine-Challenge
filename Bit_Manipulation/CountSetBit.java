import java.util.Scanner;

public class CountSetBit{
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int test = sc.nextInt();
	    while(test-->0){
	        //code here
	        int N = sc.nextInt();
	        int count = 0;
	        while(N>0){
	            count += 1 & N;
	            N>>=1;
	        }
	        System.out.println(count);
	    }
	 }
}
