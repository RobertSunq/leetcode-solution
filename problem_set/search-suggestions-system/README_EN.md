
| English | [简体中文](README.md) |

# [1268. Search Suggestions System](https://leetcode.cn//problems/search-suggestions-system/)

## Description

<p>You are given an array of strings <code>products</code> and a string <code>searchWord</code>.</p>

<p>Design a system that suggests at most three product names from <code>products</code> after each character of <code>searchWord</code> is typed. Suggested products should have common prefix with <code>searchWord</code>. If there are more than three products with a common prefix return the three lexicographically minimums products.</p>

<p>Return <em>a list of lists of the suggested products after each character of </em><code>searchWord</code><em> is typed</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> products = [&quot;mobile&quot;,&quot;mouse&quot;,&quot;moneypot&quot;,&quot;monitor&quot;,&quot;mousepad&quot;], searchWord = &quot;mouse&quot;
<strong>Output:</strong> [[&quot;mobile&quot;,&quot;moneypot&quot;,&quot;monitor&quot;],[&quot;mobile&quot;,&quot;moneypot&quot;,&quot;monitor&quot;],[&quot;mouse&quot;,&quot;mousepad&quot;],[&quot;mouse&quot;,&quot;mousepad&quot;],[&quot;mouse&quot;,&quot;mousepad&quot;]]
<strong>Explanation:</strong> products sorted lexicographically = [&quot;mobile&quot;,&quot;moneypot&quot;,&quot;monitor&quot;,&quot;mouse&quot;,&quot;mousepad&quot;].
After typing m and mo all products match and we show user [&quot;mobile&quot;,&quot;moneypot&quot;,&quot;monitor&quot;].
After typing mou, mous and mouse the system suggests [&quot;mouse&quot;,&quot;mousepad&quot;].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> products = [&quot;havana&quot;], searchWord = &quot;havana&quot;
<strong>Output:</strong> [[&quot;havana&quot;],[&quot;havana&quot;],[&quot;havana&quot;],[&quot;havana&quot;],[&quot;havana&quot;],[&quot;havana&quot;]]
<strong>Explanation:</strong> The only word &quot;havana&quot; will be always suggested while typing the search word.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= products.length &lt;= 1000</code></li>
	<li><code>1 &lt;= products[i].length &lt;= 3000</code></li>
	<li><code>1 &lt;= sum(products[i].length) &lt;= 2 * 10<sup>4</sup></code></li>
	<li>All the strings of <code>products</code> are <strong>unique</strong>.</li>
	<li><code>products[i]</code> consists of lowercase English letters.</li>
	<li><code>1 &lt;= searchWord.length &lt;= 1000</code></li>
	<li><code>searchWord</code> consists of lowercase English letters.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 搜索推荐系统 (Search Suggestions System)
// @Author: robert.sunq
// @Date: 2023-09-27 23:02:14
// @Runtime: 72 ms
// @Memory: 46.2 MB

class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node head = new Node();

        for (String s : products) {
            insert(head, s);
        }
        List<List<String>> ans = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String sub = searchWord.substring(0, i);
            Node p = startsWith(head, sub);
            if (p != null) {
                List<String> tmp = new ArrayList<>();
                search(p, tmp, new StringBuilder());
                List<String> result = new ArrayList<>();
                if (tmp.size() == 0) {
                    result.add(sub);
                } else {
                    for (String s : tmp) {
                        result.add(sub + s);
                    }
                }
                ans.add(result);
            } else {
                ans.add(new ArrayList<>());
            }
        }
        return ans;
    }


    public void search(Node p, List<String> result, StringBuilder str) {
        if (result.size() == 3 || p == null) {
            return;
        }
        if (p.end) {
            result.add(str.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (p.child[i] != null) {
                str.append((char) (i + 'a'));
                search(p.child[i], result, str);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }


    class Node {
        public Node[] child;
        public boolean end;

        public Node () {
            this.child = new Node[26];
            this.end = false;
        }
    }

    public void insert(Node head, String word) {

        Node p = head;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.child[index] == null) {
                p.child[index] = new Node();
            }
            p = p.child[index];
        }
        p.end = true;
    }

    public Node startsWith(Node head, String prefix) {
        Node p = head;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.child[index] == null) {
                return null;
            }
            p = p.child[index];
        }
        return p;
    }
}
```



## Related Topics

- [Trie](https://leetcode.cn//tag/trie)
- [Array](https://leetcode.cn//tag/array)
- [String](https://leetcode.cn//tag/string)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions


