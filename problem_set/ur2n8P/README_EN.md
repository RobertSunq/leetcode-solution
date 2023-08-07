
| English | [简体中文](README.md) |

# [LCR 115. 序列重建](https://leetcode.cn//problems/ur2n8P/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 序列重建 (序列重建)
// @Author: robert.sunq
// @Date: 2023-08-06 18:26:38
// @Runtime: 50 ms
// @Memory: 52.8 MB

class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Map<Integer, Integer> indexCount = new HashMap<>();

        for (int[] seq : sequences) {
            for (int i = 1; i < seq.length; i++) {
                if (!edges.containsKey(seq[i - 1])) {
                    edges.put(seq[i - 1], new ArrayList<>());
                }
                edges.get(seq[i - 1]).add(seq[i]);
                indexCount.put(seq[i], indexCount.getOrDefault(seq[i], 0) + 1);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!indexCount.containsKey(i)) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty() || queue.size() > 1 || nums.length != indexCount.size() + 1) {
            return false;
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int i = queue.poll();
            ans.add(i);
            for (int j : edges.getOrDefault(i, new ArrayList<>())) {
                indexCount.put(j , indexCount.get(j) - 1);
                if (indexCount.get(j) == 0) {
                    queue.offer(j);
                }
            }
            if (queue.size() > 1) {
                return false;
            }
        }

        if (ans.size() != nums.length) {
            return false;
        }

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            if (ans.get(i) != nums[i]) {
                return false;
            }
        }

        return true;
    }
}
```



## Related Topics

- [Graph](https://leetcode.cn//tag/graph)
- [Topological Sort](https://leetcode.cn//tag/topological-sort)
- [Array](https://leetcode.cn//tag/array)

## Similar Questions


