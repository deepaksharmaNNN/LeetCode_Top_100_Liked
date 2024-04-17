class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(hash[ch] != -1){
                left = Math.max(left, hash[ch] + 1);
            }
            maxLength = Math.max(right - left + 1, maxLength);
            hash[ch] = right;
            right++;
        }
        return maxLength;
    }
}