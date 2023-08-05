
| English | [简体中文](README.md) |

# [LCR 105. 岛屿的最大面积](https://leetcode.cn//problems/ZL6zAn/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 岛屿的最大面积 (岛屿的最大面积)
// @Author: robert.sunq
// @Date: 2023-08-03 00:58:36
// @Runtime: 5 ms
// @Memory: 42.6 MB

class Solution {


    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    visited[i][j] = true;
                    continue;
                }
                int tmp = 0;
                st.add(new int[]{i,j});
                visited[i][j] = true;
                while (!st.isEmpty()) {
                    int[] index = st.pop();
                    tmp++;
                    // 上
                    if(index[0] > 0 && grid[index[0]-1][index[1]] == 1 && !visited[index[0]-1][index[1]]) {
                        st.add(new int[]{index[0]-1, index[1]});
                        // 注意这里需要提前标记下，避免重复计算
                        visited[index[0] - 1][index[1]] = true;
                    }
                    // 左
                    if (index[1] > 0 && grid[index[0]][index[1] - 1] == 1 && !visited[index[0]][index[1] - 1]) {
                        st.add(new int[]{index[0], index[1] - 1});
                        // 注意这里需要提前标记下，避免重复计算
                        visited[index[0]][index[1] - 1] = true;
                    }
                    // 下
                    if(index[0] < n-1 && grid[index[0]+1][index[1]] == 1 && !visited[index[0]+1][index[1]]) {
                        st.add(new int[]{index[0]+1, index[1]});
                        // 注意这里需要提前标记下，避免重复计算
                        visited[index[0] + 1][index[1]] = true;
                    }
                    // 右
                    if (index[1] < m - 1 && grid[index[0]][index[1] + 1] == 1 && !visited[index[0]][index[1] + 1]) {
                        st.add(new int[]{index[0], index[1]+1});
                        // 注意这里需要提前标记下，避免重复计算
                        visited[index[0]][index[1] + 1] = true;
                    }
                }

                ans = Math.max(ans, tmp);
            }
        }

        return ans;
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Array](https://leetcode.cn//tag/array)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


