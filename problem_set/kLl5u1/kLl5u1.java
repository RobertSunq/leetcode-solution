
```
// @Title: 排序数组中两个数字之和 (排序数组中两个数字之和)
// @Author: robert.sunq
// @Date: 2023-05-29 22:10:21
// @Runtime: 1 ms
// @Memory: 43.5 MB

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {0, numbers.length - 1};

        while (ans[0] < ans[1]) {
            int tmp = numbers[ans[0]] + numbers[ans[1]];
            if (tmp == target) {
                break;
            } else if (tmp < target) {
                ans[0] = ans[0] + 1;
            } else {
                ans[1] = ans[1] - 1;
            }
        }

        return ans;

    }
}
