
```
// @Title: 山峰数组的顶部 (山峰数组的顶部)
// @Author: robert.sunq
// @Date: 2023-07-16 22:19:36
// @Runtime: 0 ms
// @Memory: 42 MB

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int mid = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] < arr[mid - 1]) {
                // 注意，这里时到中间点，这样保证 left 和 right 都不是峰。 否则会造成峰再边缘的情况
                right = mid;
            } else {
                if (arr[mid] > arr[mid + 1]) {
                    break;
                } else {
                    left = mid;
                }
            }
        }
        return mid;
    }
}
