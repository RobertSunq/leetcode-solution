
```
// @Title: 前 K 个高频元素 (Top K Frequent Elements)
// @Author: robert.sunq
// @Date: 2021-06-20 01:23:52
// @Runtime: 14 ms
// @Memory: 41 MB

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        // 计算每个数值出现的个数
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        // 将数量保存到数组第一个，下标表示元素
        int[][] dp = new int[mp.keySet().size()][2];
        int i =0;
        for(Integer key:mp.keySet()){
            dp[i][0] = mp.get(key);
            dp[i][1] = key;
            i++;
        }
        // 采用快排方式，按照数组第一位进行排序
        recur(dp,0,dp.length-1);
        int[] res = new int[k];
        i = 0;
        // 获取前k个
        while(i<k){
            res[i] = dp[i][1];
            i++;
        }
        return res;
        
    }

    void recur(int[][]  dp , int start,int end){
        if(start >= end) return;
        int[] temp = new int[]{dp[start][0],dp[start][1]};
        int i = start;
        int j = end;
        while(i<j){
            while(i<j && dp[j][0] <= temp[0]) j--;
            if(i<j){
                dp[i][0] = dp[j][0];
                dp[i][1] = dp[j][1];
                i++;
            }
            while(i<j && dp[i][0] >= temp[0]) i++;
            if(i<j){
                dp[j][0] = dp[i][0];
                dp[j][1] = dp[i][1];
                j--;
            }
        }
        dp[i][0]=temp[0];
        dp[i][1]=temp[1];
        recur(dp,start,i-1);
        recur(dp,i+1,end);

    }
}
