class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int start = 0;
        int end = 0;
        while(end < k){
            //add every eth person
            while(dq.size() > 0 && nums[dq.getLast()] < nums[end]) dq.removeLast();
            dq.addLast(end);
            end++;
        }
        list.add(nums[dq.getFirst()]);

        //apply sliding window for rest
        while(end < nums.length){
            //add the eth person
            while(dq.size() > 0 && nums[dq.getLast()] < nums[end]) dq.removeLast();
            dq.addLast(end); 
            //remove first if out of index
            while(dq.getFirst() <= start) dq.removeFirst();
            //find ans
            list.add(nums[dq.getFirst()]);
            //expand
            start++;
            end++;
        }
        int[] ans = new int[list.size()];
        for(int i = 0;i< ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}