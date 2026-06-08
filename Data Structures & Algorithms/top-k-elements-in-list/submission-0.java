class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] count = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            int val = map.get(nums[i]);
            val++;

            map.put(nums[i], val);
        }
      
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // 3) Collect top k keys
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = entries.get(i).getKey();
        }
        return res;
    }


    
}