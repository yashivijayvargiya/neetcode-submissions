class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String newTemp = new String(temp);
            if(!map.containsKey(newTemp)){
                map.put(newTemp, new ArrayList<>());
            }
            map.get(newTemp).add(strs[i]);
        }

return new ArrayList<>(map.values());

}
}