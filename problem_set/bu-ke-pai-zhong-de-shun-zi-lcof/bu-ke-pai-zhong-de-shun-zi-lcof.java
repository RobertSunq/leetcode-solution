
```
// @Title: 扑克牌中的顺子 (扑克牌中的顺子  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 22:51:27
// @Runtime: 1 ms
// @Memory: 35.8 MB

class Solution {
    public boolean isStraight(int[] nums) {
        // recur(nums,0,nums.length-1);
        int max = 0, min = 14;
        Set<Integer> temp = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(nums[i] == 0) continue;
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
            if(temp.contains(nums[i])) return false;
            temp.add(nums[i]);
        }
        return  max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子;
    }

    void recur(int[] nums,int start,int end){
        if(start >= end) return;
        int temp = nums[start];
        int i = start,j = end;
        while(i < j){
            while(i < j && nums[j] >= temp ) j--;
            if(i < j){
                nums[i] = nums[j];
                i++;
            }
            while(i < j && nums[i] <= temp ) i++;
            if(i < j){
                nums[j] = nums[i];
                j--;
            }
            nums[i] = temp;
            
        }
        recur(nums,start,i-1);
        recur(nums,i+1,end);
    }
}
