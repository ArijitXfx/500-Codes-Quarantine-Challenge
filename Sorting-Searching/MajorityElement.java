class MajorityElement {
    public int majorityElement(int[] nums) {
		if(nums.length==0) return -1;
        int elem = nums[0];
		int freq = 1;
		
		for(int i=1;i<nums.length;i++){
			if(nums[i]==elem){
				freq++;
			}else{
				freq--;
			}
			
			if(freq==0) {
				elem = nums[i];
				freq = 1;
			}
		}
		
		freq = 0;
		for(int i:nums){
			if(elem==i) freq++;
		}
		if(freq>=nums.length/2) return elem;
		return -1;
    }
	
	public static void main(String[] args){
		int[] arr = {2,2,1,1,1,2,1,1};
		MajorityElement obj = new MajorityElement();
		System.out.println(obj.majorityElement(arr));
	}
}