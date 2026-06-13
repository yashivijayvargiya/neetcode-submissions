class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        boolean isClosetsOnRight = true;
        int nearestElementIndex = arr.length-1;
        int smallestDiffTillNow = Integer.MAX_VALUE;
        // this loop is used to determine what's my
        // nearest element
        for (int i= arr.length - 1; i>=0; i--) {
            int currentDiff;
            if (arr[i] >= x) {
                    currentDiff = arr[i] - x;
                    if (currentDiff <= smallestDiffTillNow) {
                        smallestDiffTillNow = currentDiff;
                        isClosetsOnRight = true;
                        nearestElementIndex = i;
                }
            } else {
                    currentDiff = x - arr[i];
                    if (currentDiff <= smallestDiffTillNow) {
                        smallestDiffTillNow = currentDiff;
                        isClosetsOnRight = false;
                        nearestElementIndex = i;
                }
            }
        }
        int left, right;
        if (isClosetsOnRight) {
        right = nearestElementIndex;
        left = nearestElementIndex-1;
        } else {
        left = nearestElementIndex;
        right = nearestElementIndex+1;
        }

        // till now we are able to divide the array into two pa
        // two parts left and right around the x

        // what we need to return? K elements neares
        // to x

        int[] tempAnsArr = new int[arr.length];
        // int[] ans = new int[k];
        List<Integer> ans = new ArrayList<>();
        // tempAnsArr = [0, 0, 0, 1, 0, 0];
        while (left>=0 && right < arr.length && k>0) {
            if (x - arr[left] <= arr[right] - x) {
            tempAnsArr[left] = 1;
            left--;
            } else {
            tempAnsArr[right] = 1;
            right++;
            }
            k--;
        }
        while(left>=0 && k>0){
            tempAnsArr[left] = 1;
            left--;
            k--;
        }
        while(right<arr.length && k>0){
            tempAnsArr[right] = 1;
            right++;
            k--;
        }
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tempAnsArr[i] == 1) {
                ans.add(arr[i]);
                j++;
            }
        }
        return ans;
    }
}