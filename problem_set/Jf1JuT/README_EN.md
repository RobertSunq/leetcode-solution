
| English | [简体中文](README.md) |

# [LCR 114. 火星词典](https://leetcode.cn//problems/Jf1JuT/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 火星词典 (火星词典)
// @Author: robert.sunq
// @Date: 2023-08-06 17:34:29
// @Runtime: 3 ms
// @Memory: 39.5 MB

class Solution {

    // 记录 c, 之后的所有字符
    Map<Character, List<Character>> edges = new HashMap<>();
    // c 的入度
    Map<Character, Integer> indegrees = new HashMap<>();

    boolean valid = true;
    public String alienOrder(String[] words) {
        int n = words.length;
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                edges.putIfAbsent(c, new ArrayList<Character>());
            }
        }

        for (int i = 1; i < n; i++) {
            addEdge(words[i - 1], words[i]);
        }

        if(!valid) {
            return "";
        }
        Queue<Character> queue = new ArrayDeque<>();
        Set<Character> letterSet = edges.keySet();
        for (char u: letterSet) {
            // 入度为0的
            if (!indegrees.containsKey(u)) {
                queue.offer(u);
            }
        }

        StringBuffer ans = new StringBuffer();
        while (!queue.isEmpty()) {
            char u = queue.poll();
            ans.append(u);
            List<Character> ad = edges.get(u);
            for (char v : ad) {
                indegrees.put(v, indegrees.get(v) - 1);
                if (indegrees.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }

        return ans.length() == edges.size() ? ans.toString() : "";
    }

    private void addEdge(String before, String after) {
        int n1 = before.length();
        int n2 = after.length();
        int n = Math.min(n1, n2);
        int index = 0;
        while (index < n) {
            char c1 = before.charAt(index);
            char c2 = after.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                indegrees.put(c2, indegrees.getOrDefault(c2, 0) + 1);
                break;
            }
            index++;
        }
        // 所有字符都相等，但是前一个字符串长，则符合字典序
        if (index == n && n1 > n2) {
            valid = false;
        }
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Graph](https://leetcode.cn//tag/graph)
- [Topological Sort](https://leetcode.cn//tag/topological-sort)
- [Array](https://leetcode.cn//tag/array)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


