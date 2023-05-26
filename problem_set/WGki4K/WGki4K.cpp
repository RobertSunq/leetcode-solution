
```
// @Title: 只出现一次的数字  (只出现一次的数字 )
// @Author: robert.sunq
// @Date: 2023-05-25 23:50:15
// @Runtime: 8 ms
// @Memory: 9.3 MB

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        // DFS 参考 官方答案解析 https://leetcode.cn/problems/WGki4K/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-0vrt/
        // 数字电路设计, 不过我已经忘完了。
        int a = 0, b = 0;
        for (int num: nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
            // 未简化之前或者，tie(a, b) = pair{(~a & b & num) | (a & ~b & ~num), ~a & (b ^ num)};
        }
        return b;
    }
};
