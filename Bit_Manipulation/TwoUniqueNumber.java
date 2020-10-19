class TwoUniqueNumber
{
    public int[] singleNumber(int[] nums)
    {
        int xor = 0;
        for(int i:nums) xor^=i;
        int musk = xor & (-xor);
        int[] res = new int[2];
        for(int i:nums){
            if((i & musk)!=0) res[0]^=i;
            else res[1]^=i;
        }
        Arrays.sort(res);
        return res;
    }
}