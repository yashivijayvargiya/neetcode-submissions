class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len1= s1.length();
        int len2= s2.length();
        if (len1 > len2) return false; // edge case

        // build frequency map for s1
        for (int i = 0; i < len1; i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // take first window from s2
        for (int i = 0; i < len1 && i < len2; i++) {
            char ch = s2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        if (allZero(map)) return true;
        for(int i = len1;i<len2;i++){
            char newChar = s2.charAt(i);
            map.put(newChar, map.getOrDefault(newChar, 0) - 1);
            char oldChar = s2.charAt(i-len1);
            map.put(oldChar, map.get(oldChar) + 1);
            if (allZero(map)) return true;
            
        }

        return false;
    }

    private boolean allZero(HashMap<Character, Integer> map) {
        for (int value : map.values()) {
            if (value != 0) return false;
        }
        return true;
    }
}
