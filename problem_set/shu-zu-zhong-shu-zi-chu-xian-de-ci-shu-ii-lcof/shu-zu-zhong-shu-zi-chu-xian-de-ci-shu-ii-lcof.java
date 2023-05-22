
```
// @Title: 数组中数字出现的次数 II (数组中数字出现的次数 II LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 18:44:02
// @Runtime: 19 ms
// @Memory: 39.6 MB

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Boolean> mp = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i]) ^ mp.get(nums[i]));
            }else{
                mp.put(nums[i],true);
            }
        }
        for(int i=0;i<nums.length;i++ ){
            if(mp.get(nums[i])) return nums[i];
        }
        return -1;
    }
}
