class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minWindow = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sum >= target) {
                minWindow = Math.min(minWindow, right - left);
                sum -= nums[left];
                left++;
            } else {
                sum += nums[right];
                right++;
            }
        }

        // drain remaining window after right hits nums.length
        while (sum >= target) {
            minWindow = Math.min(minWindow, right - left);
            sum -= nums[left];
            left++;
        }

        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
            }
}