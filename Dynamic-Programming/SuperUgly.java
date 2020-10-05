import java.util.*;

public class SuperUgly{
	
	public static int solver(int[] primes, int N){
		int[] superUgly = new int[N];	
		int[] indicis = new int[primes.length];
		superUgly[0] = 1;
		for(int i=1;i<N;i++){
			int min = Integer.MAX_VALUE;
			for(int j=0;j<primes.length;j++){
				min = Math.min(min,primes[j]*superUgly[indicis[j]]);
			}
			
			for(int j=0;j<primes.length;j++){
				if(min == primes[j]*superUgly[indicis[j]]){
					indicis[j]++;
				}
			}
			superUgly[i] = min;
		}
		return superUgly[N-1];
	}
	
	public static void main(String[] args){
		int[] primes = {2,5};
		int N = 5;
		System.out.println(solver(primes,N));
		
		primes = new int[]{2, 3, 5};
		N = 50;
		System.out.println(solver(primes,N));
		
		primes = new int[]{3, 5, 7, 11, 13};
		N = 9;
		System.out.println(solver(primes,N));
	}
}