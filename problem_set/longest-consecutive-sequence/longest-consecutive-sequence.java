
```
// @Title: 最长连续序列 (Longest Consecutive Sequence)
// @Author: robert.sunq
// @Date: 2021-08-03 00:12:53
// @Runtime: 15 ms
// @Memory: 53.6 MB

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i= 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int res = 0;
        for(int i : set){
            // 找到每组序列开始的最小元素，及前一位不在set中
            if(!set.contains(i-1)){
                int curNum = i;
                int curLen = 1;
                // 开始从这个最小的开始往后找其最长序列长度
                while(set.contains(curNum+1)){
                    curNum++;
                    curLen++;
                }
                res = Math.max(res,curLen);
            }
        }
        return res;
    }
}
