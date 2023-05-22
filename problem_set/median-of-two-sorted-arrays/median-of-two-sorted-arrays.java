
```
// @Title: 寻找两个正序数组的中位数 (Median of Two Sorted Arrays)
// @Author: robert.sunq
// @Date: 2021-06-01 22:09:19
// @Runtime: 3 ms
// @Memory: 39.6 MB

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n= nums2.length;
        int index1 = (m+n-1)/2;
        int index2 = (m+n-1)/2 + (m+n-1)% 2;
        int i = 0,j=0,t=0;
        int[] res = new int[n+m];
        while(i < m && j <n){
            if(nums1[i]<=nums2[j]) {
                res[t] = nums1[i];
                i++;
            }else{
                res[t] = nums2[j];
                j++;
            }
            t++;
        }
        while(i<m){
            res[t++] = nums1[i++];
        }
        while(j<n){
            res[t++] = nums2[j++];
        }
        return (res[index1] + res[index2]) / 2.0;
    }
}
