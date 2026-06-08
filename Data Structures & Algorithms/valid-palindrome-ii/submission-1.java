public class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r){
           if(s.charAt(l)!=s.charAt(r)){
                return isPalindrom(s.substring(0, l) + s.substring(l + 1)) ||
                       isPalindrom(s.substring(0, r) + s.substring(r + 1));           }
            l++;
            r--;
        }
        return true;
        
    }

    private boolean isPalindrom(String s){
        int l = 0; int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!= s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}