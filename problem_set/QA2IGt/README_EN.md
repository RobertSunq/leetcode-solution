
| English | [简体中文](README.md) |

# [LCR 113. 课程表 II](https://leetcode.cn//problems/QA2IGt/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 课程表 II (课程表 II)
// @Author: robert.sunq
// @Date: 2023-08-06 16:40:31
// @Runtime: 56 ms
// @Memory: 43.9 MB

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        int[] ans = new int[numCourses];
        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                ans[i] = i;
            }
            return ans;
        }

        // 保存， 学习 i 时候，需要学习的其他课程， 当其入度为0时，就可以学习了
        Set<Integer>[] dp = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dp[i] = new HashSet<>();
        }

        for (int[] pre : prerequisites) {
            dp[pre[0]].add(pre[1]);
        }

        int index = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (dp[i].isEmpty()) {
                queue.offer(i);
                dp[i] = null;
            }
        }

        while (!queue.isEmpty()) {
            // 学习这门科
            int num = queue.poll();
            ans[index++] = num;
            for (int i = 0; i < numCourses; i++) {
                if (dp[i] != null) {
                    if (dp[i].contains(num)) {
                        dp[i].remove(num);
                        if (dp[i].isEmpty()) {
                            queue.offer(i);
                            dp[i] = null;
                        }
                    }
                }
            }
        }

        return index == numCourses? ans : new int[0];
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Graph](https://leetcode.cn//tag/graph)
- [Topological Sort](https://leetcode.cn//tag/topological-sort)

## Similar Questions


