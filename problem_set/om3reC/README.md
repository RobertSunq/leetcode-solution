
| [English](README_EN.md) | 简体中文 |

# [LCR 108. 单词接龙](https://leetcode.cn//problems/om3reC/)

## 题目描述

<p>在字典（单词列表）&nbsp;<code>wordList</code> 中，从单词 <code>beginWord</code><em>&nbsp;</em>和 <code>endWord</code> 的 <strong>转换序列 </strong>是一个按下述规格形成的序列：</p>

<ul>
	<li>序列中第一个单词是 <code>beginWord</code> 。</li>
	<li>序列中最后一个单词是 <code>endWord</code> 。</li>
	<li>每次转换只能改变一个字母。</li>
	<li>转换过程中的中间单词必须是字典&nbsp;<code>wordList</code> 中的单词。</li>
</ul>

<p>给定两个长度相同但内容不同的单词<em> </em><code>beginWord</code><em>&nbsp;</em>和 <code>endWord</code> 和一个字典 <code>wordList</code> ，找到从&nbsp;<code>beginWord</code> 到&nbsp;<code>endWord</code> 的 <strong>最短转换序列</strong> 中的 <strong>单词数目</strong> 。如果不存在这样的转换序列，返回 0。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>beginWord = &quot;hit&quot;, endWord = &quot;cog&quot;, wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]
<strong>输出：</strong>5
<strong>解释：</strong>一个最短转换序列是 &quot;hit&quot; -&gt; &quot;hot&quot; -&gt; &quot;dot&quot; -&gt; &quot;dog&quot; -&gt; &quot;cog&quot;, 返回它的长度 5。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>beginWord = &quot;hit&quot;, endWord = &quot;cog&quot;, wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;]
<strong>输出：</strong>0
<strong>解释：</strong>endWord &quot;cog&quot; 不在字典中，所以无法进行转换。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= beginWord.length &lt;= 10</code></li>
	<li><code>endWord.length == beginWord.length</code></li>
	<li><code>1 &lt;= wordList.length &lt;= 5000</code></li>
	<li><code>wordList[i].length == beginWord.length</code></li>
	<li><code>beginWord</code>、<code>endWord</code> 和 <code>wordList[i]</code> 由小写英文字母组成</li>
	<li><code>beginWord != endWord</code></li>
	<li><code>wordList</code> 中的所有字符串 <strong>互不相同</strong></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 127&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/word-ladder/">https://leetcode-cn.com/problems/word-ladder/</a></p>


## 题解


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



## 相关话题

- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



