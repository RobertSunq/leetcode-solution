
| English | [简体中文](README.md) |

# [LCR 116. 省份数量](https://leetcode.cn//problems/bLyHh0/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 省份数量 (省份数量)
// @Author: robert.sunq
// @Date: 2023-08-06 18:45:35
// @Runtime: 5 ms
// @Memory: 42.8 MB

class Solution {

    // bfs
    public int findCircleNum(int[][] isConnected) {
        // if (isConnected != null) {
        //     return findCircleNumDFS(isConnected);
        // }

        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            if (!visit[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visit[j] = true;
                    for (int k =0; k < n ; k++) {
                        if (isConnected[j][k] == 1 && !visit[k]) {
                            queue.offer(k);
                        }
                    }
                }
                ans++;
            }
        }

        return ans;
    }


    // dfs 
    private int findCircleNumDFS(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(isConnected, visit, n, i);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int[][] isConnected, boolean[] visit, int n, int i) {
        for (int j = 0; j<n; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                visit[j] = true;
                dfs(isConnected, visit, n , j);
            }
        }
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Graph](https://leetcode.cn//tag/graph)

## Similar Questions


