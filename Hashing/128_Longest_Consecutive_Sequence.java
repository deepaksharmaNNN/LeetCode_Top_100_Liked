class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num,Boolean.FALSE);
        }
        for(int num : nums){
            int count = 1;
            int nextNum = num + 1;
            while(map.containsKey(nextNum) && map.get(nextNum) == false){
                count++;
                map.put(nextNum, Boolean.TRUE);
                nextNum++;
            }
            int prevNum = num - 1;
            while(map.containsKey(prevNum) && map.get(prevNum) == false){
                count++;
                map.put(prevNum, Boolean.TRUE);
                prevNum--;
            }
            longest = Math.max(count, longest);
        }
        return longest;
    }
}