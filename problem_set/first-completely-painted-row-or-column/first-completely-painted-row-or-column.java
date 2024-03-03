
```
// @Title: 找出叠涂元素 (First Completely Painted Row or Column)
// @Author: robert.sunq
// @Date: 2023-12-01 22:13:48
// @Runtime: 24 ms
// @Memory: 61 MB

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }

        // 统计染色的点，所在的 行 和 列 的个数
        int[] rowCount = new int[n];
        int[] colCount = new int[m];

        for (int i = 0; i < arr.length; i++) {
            int[] v = map.get(arr[i]);
            rowCount[v[0]] = rowCount[v[0]] + 1;

            // 第一个满足就返回，此时就是下标最小的，因为从 0 开始遍历的
            // 个数与列相等，则表示这样一行已经满了。
            if (rowCount[v[0]] == m) {
                return i;
            }
            // 个数与行相等，则表示这样一列已经满了。
            colCount[v[1]] = colCount[v[1]] + 1;
            if (colCount[v[1]] == n) {
                return i;
            }
        }

        return -1;
    }
}
