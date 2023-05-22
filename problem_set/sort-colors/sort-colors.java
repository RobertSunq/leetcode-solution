
```
// @Title: 颜色分类 (Sort Colors)
// @Author: robert.sunq
// @Date: 2021-06-05 22:20:06
// @Runtime: 0 ms
// @Memory: 36.6 MB

class Solution {
    public void sortColors(int[] nums) {
        int i = 0 , j = nums.length - 1;
        int index = 0;
        while(i <= j && index <= j){
            if(nums[index] == 0){
                nums[index] = nums[i];
                nums[i] = 0;
                i++;
            }else if(nums[index] == 2){
                nums[index] = nums[j];
                nums[j] = 2;
                j--;
            } else {
                index++;
            }
            if(index < i){
                index = i;
            }
        }
        return;
    }
}
