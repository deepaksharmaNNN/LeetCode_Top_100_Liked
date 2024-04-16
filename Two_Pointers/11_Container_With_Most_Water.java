class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = -1;
        while(left < right){
            int max = (Math.min(height[left], height[right]) * (right - left));
            maxArea = Math.max(maxArea, max);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}