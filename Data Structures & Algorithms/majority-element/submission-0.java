class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int x: nums){
            int count = freq.getOrDefault(x, 0)+1;
            freq.put(x,count);
             if(count>n/2){
            return x;
        }
        }
       
        return -1;
    }
}