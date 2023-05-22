
```
// @Title: 滑动窗口最大值 (Sliding Window Maximum)
// @Author: robert.sunq
// @Date: 2021-06-18 00:42:09
// @Runtime: 33 ms
// @Memory: 52.7 MB

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length<2) return nums;
        // 双向队列保存降序数值的坐标  当前窗口的最大值数组位置
        LinkedList<Integer> queue = new LinkedList<>();
        int i =0;
        int[] res = new int[nums.length-k+1];
        while(i<nums.length){
            // 队列不为空，将队列中小于当前元素的坐标全部弹出，因为当前窗口内的最小值可以为当前值
            while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]){
                queue.removeLast();
            }
            // 当前位置的元素即为队列中的最小值，将当前元素放到队列末尾
            queue.addLast(i);
            // 当前队列头部的元素 不在窗口内 放出
            if(queue.getFirst() <= i-k){
                queue.removeFirst();
            }
            // 当窗口长度已经到带 K是 保存当前最大值
            if(i >= k -1){
                res[i-k + 1] = nums[queue.getFirst()];
            }
            i++;
        }
        return res;
    }
}
