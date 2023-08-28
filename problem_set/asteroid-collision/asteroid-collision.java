
```
// @Title: 行星碰撞 (Asteroid Collision)
// @Author: robert.sunq
// @Date: 2023-08-26 22:01:39
// @Runtime: 1 ms
// @Memory: 43.1 MB

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        // 表示保留下来的行星的坐标 + 1；
        int left = 1;
        int right = 1;
        int n = asteroids.length;
        while (right < n) {
            // 发生相撞
            if (left > 0 && (asteroids[left - 1] > 0 && asteroids[right] < 0)) {
                int le = Math.abs(asteroids[left - 1]);
                int ri = Math.abs(asteroids[right]);
                if (le == ri) {
                    left--;
                    right++;
                } else if (le > ri) {
                    right++;
                } else {
                    left--;
                }
            } else {
                asteroids[left++] = asteroids[right++];
            }
        }

        int[] ans = new int[left];
        for (int i = 0; i < left; i++) {
            ans[i] = asteroids[i];
        }

        return ans;
    }
}
