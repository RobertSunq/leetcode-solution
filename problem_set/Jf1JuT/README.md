
| [English](README_EN.md) | 简体中文 |

# [LCR 114. 火星词典](https://leetcode.cn//problems/Jf1JuT/)

## 题目描述

<p>现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。</p>

<p>给定一个字符串列表 <code>words</code> ，作为这门语言的词典，<code>words</code> 中的字符串已经 <strong>按这门新语言的字母顺序进行了排序</strong> 。</p>

<p>请你根据该词典还原出此语言中已知的字母顺序，并 <strong>按字母递增顺序</strong> 排列。若不存在合法字母顺序，返回 <code>&quot;&quot;</code> 。若存在多种可能的合法字母顺序，返回其中 <strong>任意一种</strong> 顺序即可。</p>

<p>字符串 <code>s</code> <strong>字典顺序小于</strong> 字符串 <code>t</code> 有两种情况：</p>

<ul>
	<li>在第一个不同字母处，如果 <code>s</code> 中的字母在这门外星语言的字母顺序中位于 <code>t</code> 中字母之前，那么&nbsp;<code>s</code> 的字典顺序小于 <code>t</code> 。</li>
	<li>如果前面 <code>min(s.length, t.length)</code> 字母都相同，那么 <code>s.length &lt; t.length</code> 时，<code>s</code> 的字典顺序也小于 <code>t</code> 。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>words = [&quot;wrt&quot;,&quot;wrf&quot;,&quot;er&quot;,&quot;ett&quot;,&quot;rftt&quot;]
<strong>输出：</strong>&quot;wertf&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>words = [&quot;z&quot;,&quot;x&quot;]
<strong>输出：</strong>&quot;zx&quot;
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>words = [&quot;z&quot;,&quot;x&quot;,&quot;z&quot;]
<strong>输出：</strong>&quot;&quot;
<strong>解释：</strong>不存在合法字母顺序，因此返回 <code>&quot;&quot; 。</code>
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
	<li><code>words[i]</code> 仅由小写英文字母组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 269&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/alien-dictionary/">https://leetcode-cn.com/problems/alien-dictionary/</a></p>


## 题解


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



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [图](https://leetcode.cn//tag/graph)
- [拓扑排序](https://leetcode.cn//tag/topological-sort)
- [数组](https://leetcode.cn//tag/array)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



