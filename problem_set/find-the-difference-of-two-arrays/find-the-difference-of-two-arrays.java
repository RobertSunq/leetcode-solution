
```
// @Title: 找出两数组的不同 (Find the Difference of Two Arrays)
// @Author: robert.sunq
// @Date: 2023-08-22 21:52:23
// @Runtime: 11 ms
// @Memory: 43.1 MB

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();
        for (int n : nums1) {
            numSet1.add(n);
        }

        for (int n : nums2) {
            numSet2.add(n);
        }

        for (int n : nums1) {
            numSet2.remove(n);
        }

        for (int n : nums2) {
            numSet1.remove(n);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int n : numSet1) {
            tmp.add(n);
        }
        ans.add(tmp);

        tmp = new ArrayList<>();
        for (int n : numSet2) {
            tmp.add(n);
        }
        ans.add(tmp);

        return ans;
    }
}
