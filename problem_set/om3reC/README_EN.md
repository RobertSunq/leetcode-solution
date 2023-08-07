
| English | [简体中文](README.md) |

# [LCR 108. 单词接龙](https://leetcode.cn//problems/om3reC/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 单词接龙 (单词接龙)
// @Author: robert.sunq
// @Date: 2023-08-06 02:51:41
// @Runtime: 1749 ms
// @Memory: 44 MB

class Solution {

    // https://leetcode.cn/problems/zlDJc7/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        System.out.println(1);

        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> wordSet = new HashSet<>();
        // Set<String> seen = new HashSet<>();
        for (String str : wordList) {
            wordSet.add(str);
        }
        wordSet.remove(beginWord);

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);

        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String nextStatus : bfs(status, wordSet)) {
                    if (nextStatus.equals(endWord)) {
                        return step + 1;
                    }
                    queue.offer(nextStatus);
                    wordSet.remove(nextStatus);
                }
            }
        }

        return 0;
    }

    private List<String> bfs(String status, Set<String> wordSet) {
        List<String> ans = new ArrayList<>();
        List<Set<Character>> words = new ArrayList();
        int n = status.length();
        for (int i = 0; i<n;i++) {
            words.add(new HashSet<>());
        }

        for (String str : wordSet) {
            for (int i = 0 ; i < n; i++) {
                words.get(i).add(str.charAt(i));
            }
        }

        char[] array = status.toCharArray();
        for (int i = 0; i<n; i++) {
            char c = array[i];
            Set<Character> word = words.get(i);
            for (char w : word) {
                array[i] = w;
                String nextStatus = new String(array);
                if (!nextStatus.equals(status) && wordSet.contains(nextStatus)) {
                    ans.add(nextStatus);
                }
            }
            // 恢复现场
            array[i] = c;
        }

        return ans;
    }
}
```



## Related Topics

- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [String](https://leetcode.cn//tag/string)

## Similar Questions


