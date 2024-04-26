class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstElement(nums, target);
        int last = lastElement(nums, target);
        return new int[]{first, last};
    }
    private int firstElement(int[] nums, int target){
        int index = -1, low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                index = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return index;
    }
    private int lastElement(int[] nums, int target){
        int index = -1, low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                index = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return index;
    }
}