
```
// @Title: 矩阵中最大的矩形 (矩阵中最大的矩形)
// @Author: robert.sunq
// @Date: 2023-07-03 23:30:56
// @Runtime: 52 ms
// @Memory: 41.9 MB

class Solution {
    public int maximalRectangle(String[] matrix) {
        int n = matrix.length;
        if (n < 1) {
            return 0;
        }
        int m = matrix[0].length();

        int[] heights = new int[m];

        int ans = 0;
        // 类似于题 https://leetcode.cn/problems/0ynMMM/description/， 将每一行作为低，抽象为一个柱状图
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                if (matrix[i].charAt(j) == '1') {
                    heights[j] = heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
            }
            // 计算每一行的最大面积， 柱状图中的最大面积
            ans = Math.max(ans, largestRectangleArea(heights));
        }

        return ans;
    }


    /**
     *
     */
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        // 记录 左侧第一个小于当前 heights[i] 的索引 - 1
        int[] leftMinIndex = new int[n];
        // 记录 右侧第一个大于当前 heights[i] 的索引 + 1
        int[] rightMinIndex = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 单调栈的形式，找到左侧第一个小于当前元素的索引
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            leftMinIndex[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();


        for (int i = n - 1; i >= 0; i--) {
            // 单调栈的形式，找到右侧第一个小于当前元素的索引
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            rightMinIndex[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (rightMinIndex[i] - leftMinIndex[i] - 1) * heights[i]);
        }
        return ans;
    }


    
}
