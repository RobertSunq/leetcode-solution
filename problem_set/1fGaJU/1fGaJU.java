
```
// @Title: 数组中和为 0 的三个数 (数组中和为 0 的三个数)
// @Author: robert.sunq
// @Date: 2023-05-29 22:43:21
// @Runtime: 22 ms
// @Memory: 46.4 MB

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序，固定一个位置，然后转为找两个数的和等于第一个
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int targetIndex = 0;
        int startIndex = 1;
        int endIndex = nums.length - 1;
        while (targetIndex < nums.length - 1) {
            // 当 target 发生变化时， 将起始和终止恢复位置
            startIndex = targetIndex + 1;
            endIndex = nums.length - 1;
            while(startIndex < endIndex) {
                // 注意 负数
                if ( 0 - nums[targetIndex] == nums[startIndex] + nums[endIndex]) {
                    List<Integer> tmpAns = new ArrayList<>();
                    tmpAns.add(nums[targetIndex]);
                    tmpAns.add(nums[startIndex]);
                    tmpAns.add(nums[endIndex]);

                    ans.add(tmpAns);

                    // 注意 跳过相等的数字，避免出现重复结果
                    // 当然不论是从开头还是结果进行跳过，结果都一样，因为和固定情况下，只要一个数发生改变，另一个也变化
                    while (startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]) {
                        startIndex++;
                    }
                    startIndex++;
                } else if (0 - nums[targetIndex] > nums[startIndex] + nums[endIndex]) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
            // 同样需要跳过固定值的相同属性
            while (targetIndex < nums.length - 1 && nums[targetIndex] == nums[targetIndex+1]) {
                targetIndex++;
            }
            targetIndex++;
        }

        return ans;
    }
}
