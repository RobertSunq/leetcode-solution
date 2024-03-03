
```
// @Title: 爱吃香蕉的珂珂 (Koko Eating Bananas)
// @Author: robert.sunq
// @Date: 2023-09-18 22:09:45
// @Runtime: 7 ms
// @Memory: 42.8 MB

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0, min = 1;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int ans = max;
        // max 就是最快速度，即 每次吃最大堆的
        while (min < max) { // 注意不能相等， 否则可能会两者相等而进入死循环
            int mid = min + (max - min) / 2;
            if (getTime(piles, mid) <= h) {
                ans = mid;
                // 注意这里, 可以吃完的时候，将最大速度降低到当前的中值
                max = mid;
            } else {
                // 最小速度一步步提升，避免遗漏
                min = mid + 1;
            }
        }

        return ans;
    }

    private int getTime(int[] piles, int speed) {
        int ans = 0;
        for (int pile : piles) {
            ans = ans + (pile + speed - 1) / speed; // 注意这里如何做除法向上取整的
        }
        return ans;
    }
}
