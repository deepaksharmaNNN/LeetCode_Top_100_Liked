class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		//As soon as they meet, move both
		//pointer at same speed until they meet again
		slow = 0;
		while(slow != fast){
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
    }
}