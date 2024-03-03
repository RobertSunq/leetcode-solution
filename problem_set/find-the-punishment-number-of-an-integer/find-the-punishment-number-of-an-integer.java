
```
// @Title: 求一个整数的惩罚数 (Find the Punishment Number of an Integer)
// @Author: robert.sunq
// @Date: 2023-10-25 23:11:30
// @Runtime: 22 ms
// @Memory: 41.5 MB

class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i * i);

            if (dfs(s, 0, 0, i)) {
                ans = ans + (i * i);
            }
        }

        return ans;
    }

    public boolean dfs(String s, int pos, int tot, int target) {
        if (pos == s.length()) {
            return tot == target;
        }

        int sum = 0;
        for (int i = pos; i < s.length(); i++) {
            sum = sum * 10 + s.charAt(i) - '0';

            if (sum + tot > target) {
                break;
            }

            if (dfs(s, i + 1, sum + tot, target)) {
                return true;
            }
        }

        return false;
    }
}
