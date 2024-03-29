
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 066. 单词之和](https://leetcode.cn//problems/z1R5dt/)

## 题目描述

<p>实现一个 <code>MapSum</code> 类，支持两个方法，<code>insert</code>&nbsp;和&nbsp;<code>sum</code>：</p>

<ul>
	<li><code>MapSum()</code> 初始化 <code>MapSum</code> 对象</li>
	<li><code>void insert(String key, int val)</code> 插入 <code>key-val</code> 键值对，字符串表示键 <code>key</code> ，整数表示值 <code>val</code> 。如果键 <code>key</code> 已经存在，那么原来的键值对将被替代成新的键值对。</li>
	<li><code>int sum(string prefix)</code> 返回所有以该前缀 <code>prefix</code> 开头的键 <code>key</code> 的值的总和。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
inputs = [&quot;MapSum&quot;, &quot;insert&quot;, &quot;sum&quot;, &quot;insert&quot;, &quot;sum&quot;]
inputs = [[], [&quot;apple&quot;, 3], [&quot;ap&quot;], [&quot;app&quot;, 2], [&quot;ap&quot;]]
<strong>输出：</strong>
[null, null, 3, null, 5]

<strong>解释：</strong>
MapSum mapSum = new MapSum();
mapSum.insert(&quot;apple&quot;, 3);  
mapSum.sum(&quot;ap&quot;);           // return 3 (<u>ap</u>ple = 3)
mapSum.insert(&quot;app&quot;, 2);    
mapSum.sum(&quot;ap&quot;);           // return 5 (<u>ap</u>ple + <u>ap</u>p = 3 + 2 = 5)
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= key.length, prefix.length &lt;= 50</code></li>
	<li><code>key</code> 和 <code>prefix</code> 仅由小写英文字母组成</li>
	<li><code>1 &lt;= val &lt;= 1000</code></li>
	<li>最多调用 <code>50</code> 次 <code>insert</code> 和 <code>sum</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 677&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/map-sum-pairs/">https://leetcode-cn.com/problems/map-sum-pairs/</a></p>


## 题解


### Java

```Java
// @Title: 单词之和 (单词之和)
// @Author: robert.sunq
// @Date: 2023-07-14 22:52:18
// @Runtime: 11 ms
// @Memory: 40.3 MB

class MapSum {

    TreeNode head;
    /** Initialize your data structure here. */
    public MapSum() {
        head = new TreeNode();
    }
    
    public void insert(String key, int val) {
        head.insert(key, val);
    }
    
    public int sum(String prefix) {
        TreeNode p = head.startsWith(prefix);
        if (p == null) {
            return 0;
        }
        int ans = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(p);
        while (!st.isEmpty()) {
            p = st.pop();
            for (int i = 0; i < 26; i++) {
                if (p.next[i] != null) {
                    st.push(p.next[i]);
                }
            }
            if (p.isEnd) {
                ans+=p.val;
            }
        }

        return ans;
    }

    class TreeNode {
        public TreeNode[] next;
        public boolean isEnd;
        public int val;

        public TreeNode() {
            next = new TreeNode[26];
            isEnd = false;
            val = 0;
        }

        public void insert(String key, int val) {
            TreeNode root = this;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (root.next[index] == null) {
                    root.next[index] = new TreeNode();
                }
                root = root.next[index];
            }

            root.isEnd = true;
            root.val = val;
        }

        public TreeNode startsWith(String prefix) {
            TreeNode root = this;
            int i = 0;
            int n = prefix.length();
            while (root != null && i < n) {
                int index = prefix.charAt(i) - 'a';
                if (root.next[index] == null) {
                    return null;
                }
                i++;
                root = root.next[index];
            }
            return root;
        }

    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
```



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [字典树](https://leetcode.cn//tag/trie)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [字符串](https://leetcode.cn//tag/string)

## 相似题目



