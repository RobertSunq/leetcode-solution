
```
// @Title: H 指数 II (H-Index II)
// @Author: robert.sunq
// @Date: 2023-10-30 23:08:54
// @Runtime: 0 ms
// @Memory: 49.8 MB

class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) /2;

            int h = citations.length - mid;
            // 符合 h 的要求， 但是此时 h 不是最大的，时比较小的，所以缩小上线(缩小 mid )，找更大的h， 因为 h = n - mid
            if (citations[mid] >= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return citations.length - left;
    }

}
