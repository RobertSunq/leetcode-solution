
```
// @Title: 三数之和 (3Sum)
// @Author: robert.sunq
// @Date: 2021-06-02 21:33:00
// @Runtime: 23 ms
// @Memory: 42.5 MB

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        while(i < nums.length){
            if(nums[i] > 0) break;
            int j = i+1,t = nums.length-1;
            while(j < t){
                if(nums[j]+ nums[t] == -nums[i]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[t]);
                    res.add(temp);
                    while(j < nums.length && nums[j] == temp.get(1)) j++;
                }else if(nums[j] + nums[t] > -nums[i]){
                    t--;
                }else{
                    j++;
                }
            }
            i++;
            while(i < nums.length && nums[i] == nums[i-1])i++;
        }
        return res;
    }
}
