
```
// @Title: 移动机器人 (Movement of Robots)
// @Author: robert.sunq
// @Date: 2023-10-10 22:19:58
// @Runtime: 13 ms
// @Memory: 53.2 MB

class Solution {
    // 当两个机器人相撞时，它们会沿着原本相反的方向移动。
    // 由于机器人之间并灭有任何区别，相撞可以看作是穿透，
    // 原本左边的机器人相撞后交换为右边的机器人，原本右边的机器人相撞后交换为左边的机器人
    // 如此，可以无视相撞，独立计算每个机器人d秒后所在的位置即可

    private static final int MOD = 1000000007;
    public int sumDistance(int[] nums, String s, int d) {

        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = (long) nums[i] - d;
            } else {
                pos[i] = (long) nums[i] + d;
            }
        }

        Arrays.sort(pos);
        long ans = 0;
        for (int i = 1; i < n; i++) {
            // 注意这里计算的是排序后的两个相近节点之间的距离
            // 在计算两两节点之间的具体时， 这个相邻的节点会被重复计算多次， 次数就是左侧的节点数 * 右侧（包含本身）
            ans = (ans + (pos[i] - pos[i - 1]) * i % MOD * (n - i) % MOD) % MOD;
        }

        return (int) ans;
    }
}
