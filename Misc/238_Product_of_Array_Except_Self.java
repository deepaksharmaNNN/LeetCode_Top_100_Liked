class Solution {//TC -> O(N) SC -> O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            if(i == 0) res[i] = 1;
            else res[i] = nums[i - 1] * res[i - 1];
        }
        int product = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] = res[i] * product;
            product *= nums[i];
        }
        return res;
    }
}
/** Using Extra Space TC -> O(N + N + N) SC -> O(N + N)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre  = new int[n];
        int[] post = new int[n];

        for(int i = 0; i < n; i++){
            if(i == 0) pre[i] = 1;
            else pre[i] = nums[i - 1] * pre[i - 1];
        }
        for(int i = n - 1; i >= 0; i--){
            if(i == n - 1) post[i] = 1;
            else post[i] = nums[i + 1] * post[i + 1];
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}
 */
/** Using division (Restricted Method) O(N) TC -> 0(1) SC
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int productXZ = 1;
        int zeros = 0;
        int[] res = new int[nums.length];
        for(int ele : nums){
            product *= ele;
            if(ele == 0) zeros++;
            if(ele != 0) productXZ *= ele;
        }
        if(zeros > 1) productXZ = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0) res[i] = product / nums[i];
            else res[i] = productXZ;
        }
        return res;
    }
}
 */