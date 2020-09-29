public class SearchDifferK{

    public static int solver(int[] arr, int k, int x){
        int i = 0;
        while(i<arr.length){
            if(arr[i] == x) return i+1;
            i+=(x-arr[i])/k==0?1:(x-arr[i])/k;
        }
		return -1;
    }
    
    public static void main(String[] args){
        int[] arr = {4, 5, 6, 7, 6};
        int k = 1;
        int x = 6;
        System.out.println(solver(arr,k,x));
    }
}