class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int currentSum = target - nums[i];
            if(map.containsKey(currentSum)){
                res[0] = map.get(currentSum);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}