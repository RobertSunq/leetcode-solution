
| English | [简体中文](README.md) |

# [剑指 Offer II 073. 狒狒吃香蕉](https://leetcode.cn//problems/nZZqjQ/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 狒狒吃香蕉 (狒狒吃香蕉)
// @Author: robert.sunq
// @Date: 2023-07-17 23:28:13
// @Runtime: 6 ms
// @Memory: 43 MB

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int mid = 0;
        int res = max;
        // 注意 速度的上下限， 不能相等，否则会无限循环。 因为 max = mid
        while (min < max) {
            mid = (min + max) /2;
            // 因为是找到最小的速度， 所以 消耗时间等于预计的时候还要继续遍历，为了找到 消耗时间是h时候的最小值。
            if (getTime(piles, mid) <= h) {
                res = mid;
                // 注意这里
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions


