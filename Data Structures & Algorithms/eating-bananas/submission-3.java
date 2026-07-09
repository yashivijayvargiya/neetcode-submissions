class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile: piles){
           max = Math.max(max,pile);
        }
        int left = 1;
        int right = max;
        int ans = max;
      
        while(left<=right){
            int mid = left + (right-left)/2;
            long hours = 0;
            for(int pile: piles){
                hours += (pile+mid-1)/mid;
            }
            if(hours<=h){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}
