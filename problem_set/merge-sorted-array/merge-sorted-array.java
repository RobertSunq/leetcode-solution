
```
// @Title: 合并两个有序数组 (Merge Sorted Array)
// @Author: robert.sunq
// @Date: 2023-10-01 22:37:04
// @Runtime: 0 ms
// @Memory: 40 MB

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsTmp = new int[m];


        for(int i = 0; i < m; i++) {
            numsTmp[i] = nums1[i];
        }


        int p1 = 0, p2 = 0;
        int i = 0;
        while(p1 < m && p2 < n) {
            if (numsTmp[p1] <= nums2[p2]) {
                nums1[i] = numsTmp[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }
            i++;
        }

        while (p1 <m) {
            nums1[i] = numsTmp[p1];
            p1++;
            i++;
        }
        while (p2 <n) {
            nums1[i] = nums2[p2];
            p2++;
            i++;
        }

    }
}
