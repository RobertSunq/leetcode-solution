
```
// @Title: 两数之和 (Two Sum)
// @Author: robert.sunq
// @Date: 2021-06-01 00:19:00
// @Runtime: 2 ms
// @Memory: 38.5 MB

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0 ;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    void quickSort(int[] nums , int start,int end){
        if(start >= end) return;
        // 哨兵
        int i = start,j=end;
        int temp = nums[i];
        while(i < j){
            while(j>i && nums[j]>=temp) j--;
            if(j>i) nums[i] = nums[j];
            while(i<j && nums[i] <= temp) i++;
            if(i < j) nums[j] = nums[i];
        }

    }
}
