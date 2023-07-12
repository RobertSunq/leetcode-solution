
```
// @Title: 和最小的 k 个数对 (和最小的 k 个数对)
// @Author: robert.sunq
// @Date: 2023-07-12 23:16:12
// @Runtime: 108 ms
// @Memory: 43.5 MB

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> q = new PriorityQueue<>(k + 1, (a , b) -> b[0] + b[1] - a[0] - a[1]);
        int[] tmp;
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                tmp = new int[]{n1, n2};
                q.offer(tmp);

                if (q.size() > k) {
                    q.poll();
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l;
        for (int[] n : q) {
            l = new ArrayList<>();
            l.add(n[0]);
            l.add(n[1]);
            result.add(l);
        }
        return result;
    }
}
