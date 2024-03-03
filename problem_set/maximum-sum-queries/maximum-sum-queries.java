
```
// @Title: 最大和查询 (Maximum Sum Queries)
// @Author: robert.sunq
// @Date: 2023-11-17 23:38:17
// @Runtime: 60 ms
// @Memory: 89.5 MB

class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[][] sortedNums = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortedNums[i][0] = nums1[i];
            sortedNums[i][1] = nums2[i];
        }

        Arrays.sort(sortedNums, (a, b) -> b[0] - a[0]);
        int q = queries.length;
        int[][] sortedQueries = new int[q][3];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = i;
            sortedQueries[i][1] = queries[i][0];
            sortedQueries[i][2] = queries[i][1];
        }

        Arrays.sort(sortedQueries, (a, b) -> b[1] - a[1]);
        List<int[]> stack = new ArrayList<>();
        int[] ans = new int[q];

        Arrays.fill(ans, -1);

        int j = 0;
        for (int[] query : sortedQueries) {
            int i = query[0], x = query[1], y = query[2];
            // 因为 sortedNums 是根据 x1 降序的， sortedQueries 也是 x 降序的
            // 所以可以保留 j 的索引，来找到 比 x 大的 x1, 然后再找y
            while (j < n && sortedNums[j][0] >= x) {
                int[] pair = sortedNums[j];
                int num1 = pair[0], num2 = pair[1];
                // 移除 已经访问过的 x2 + y2 <= 当前 x1 + y1 的值，因为这些都不满足最大的条件。
                while (!stack.isEmpty() && stack.get(stack.size() - 1)[1] <= num1 + num2) {
                    stack.remove(stack.size() - 1);
                }
                
                //保存符合题意的结果
                if(stack.isEmpty() || stack.get(stack.size() - 1)[0] < num2) {
                    stack.add(new int[]{num2, num1 + num2});
                }
                j++;
            }
            // 二分法查找结果的索引
            int k = binarySearch(stack, y);
            if (k < stack.size()) {
                ans[i] = stack.get(k)[1];
            }
        }
        return ans;

    }

    private int binarySearch(List<int[]> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 注意 y1 是递增的
            if (list.get(mid)[0] >= target) {
                high = mid;
            } else {
                // x1 + y1 是递减的
                low = mid + 1;
            }
        }

        return low;
    }


}
