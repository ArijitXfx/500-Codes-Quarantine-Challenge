class MissRepeat {
    int[] findTwoElement(int arr[], int n) {
        int[] res = {-1,-1};
        for(int i=0;i<n;i++){
            while(i!=arr[i]-1 && arr[i]!=arr[arr[i]-1]){
                swap(arr,i,arr[i]-1);
            }
        }
        
        for(int i=0;i<n;i++){
            if(arr[i]-1!=i){
                res[0] = arr[i];
                res[1] = i+1;
            }
        }
        return res;
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}