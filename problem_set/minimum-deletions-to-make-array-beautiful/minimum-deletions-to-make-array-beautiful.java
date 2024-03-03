
```
// @Title: 美化数组的最少删除数 (Minimum Deletions to Make Array Beautiful)
// @Author: robert.sunq
// @Date: 2023-11-21 22:17:34
// @Runtime: 2 ms
// @Memory: 55.7 MB

class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int right = 1;
        int left = 0 ;
        while (right < n) {
            // 初始时，left % 2 == 0， right = left + 1; 所以可以直接判断，是否满足需求
            // 在满足需求时，left = right + 1, 即来到了奇数位的下一位，则还是偶数位置，同理，right = right + 2， 也就是下一个要对比的偶数维
            if (nums[left] != nums[right]) {
                left = right + 1;
                right = left + 1;
            } else {
                // 相等，则删除下一位， right往后走，视作在移动整个右侧。
                right = right + 1;
                ans += 1;
            }
        }

        // 删除相关元素后，剩余的长度是奇数，则代表最后一位也要删除
        if ((n - ans) % 2 == 1) {
            ans += 1;
        }

        return ans;
    }
}
