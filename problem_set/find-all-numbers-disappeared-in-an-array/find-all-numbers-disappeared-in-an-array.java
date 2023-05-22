
```
// @Title: 找到所有数组中消失的数字 (Find All Numbers Disappeared in an Array)
// @Author: robert.sunq
// @Date: 2021-06-21 22:35:47
// @Runtime: 7 ms
// @Memory: 47.4 MB

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i =0;
        while(i<nums.length){
            // 如果位置下标与数字对应 或者 位置该下标对应的数字不存在跳过
            if(nums[i] == i+1 || nums[i] == -1) {
                i++;
                continue;
            }
            // 即当前元素与其对应下标位置的元素重复，将当前位置赋值为 -1，表示暂时该下标对应的数字缺失;
            if(nums[i] == nums[nums[i] - 1]){
                nums[i] = -1;
                i++;
            }else{
                // 否则，交换位置 ， 使得目标位置的下标与数字相同
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        for(i = 0;i<nums.length;i++){
            if(nums[i] == -1) res.add(i+1);
        }
        return res;
    }
}
