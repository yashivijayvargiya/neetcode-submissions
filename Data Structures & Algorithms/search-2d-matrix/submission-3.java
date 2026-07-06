class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int lessthantarget= -1;
        for(int i= 0 ; i<row;i++){
            int currentElement = matrix[i][0];
            if(currentElement<=target){
                lessthantarget= i;
            }
            else{
                break;
            }
        }
        if(lessthantarget==-1){
            return false;
        }
        int left = 0;
        int right =col -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int midEle = matrix[lessthantarget][mid];
            if(midEle==target){
                return true;
            }
            else if(midEle>target){
                right = mid-1;
            }
            else{
                left= mid+1;
            }
        }
        return false;
    }
}
