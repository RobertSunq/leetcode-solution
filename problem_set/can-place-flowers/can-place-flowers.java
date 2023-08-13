
```
// @Title: 种花问题 (Can Place Flowers)
// @Author: robert.sunq
// @Date: 2023-08-09 22:43:29
// @Runtime: 1 ms
// @Memory: 42.6 MB

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                // 从右侧空位开始， 可用种植的数量为 空位 / 2
                if (prev < 0) {
                    count = count + (i / 2);
                } else {
                    // 非边界， 种植数量为 (空位置 - 1) / 2, 因为最左，最有都无法种植
                    // 空位 (j - i - 1) 
                    count = count + (i - prev - 2) / 2;
                }
                prev = i;
            } 
        }

        // 都是空的
        if (prev < 0) {
            count = count + (m + 1) / 2;
        } else {
            count = count + (m - prev - 1) / 2;
        }

        return count >= n;
    }
}
