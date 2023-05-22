
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 38. 字符串的排列](https://leetcode.cn//problems/zi-fu-chuan-de-pai-lie-lcof/)

## 题目描述

<p>输入一个字符串，打印出该字符串中字符的所有排列。</p>

<p>&nbsp;</p>

<p>你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入：</strong>s = &quot;abc&quot;
<strong>输出：[</strong>&quot;abc&quot;,&quot;acb&quot;,&quot;bac&quot;,&quot;bca&quot;,&quot;cab&quot;,&quot;cba&quot;<strong>]</strong>
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>1 &lt;= s 的长度 &lt;= 8</code></p>


## 题解


### Java

```Java
// @Title: 字符串的排列 (字符串的排列  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 00:58:49
// @Runtime: 9 ms
// @Memory: 42.6 MB

class Solution {
    char[] dict;
    // StringBuilder res = new StringBuilder();
    ArrayList<String> res = new ArrayList();
    int len ;
    public String[] permutation(String s) {
        len = s.length();
        dict = s.toCharArray();
        dfs(0);
        return (String[])res.toArray(new String[res.size()]);
    }
    void dfs(int x){
        if(x == len-1){
            res.add(String.valueOf(dict));
            return;  
        } 
        //为了防止同一层递归出现重复元素
        HashSet<Character> set = new HashSet<>();
        // 和X 后的依次交换位置
        for (int i=x;i<len;i++){
            //发生剪枝，当包含这个元素的时候，直接跳过
            if (set.contains(dict[i])){
                continue;
            }
            set.add(dict[i]);
            char temp = dict[x];
            // 交换
            dict[x] = dict[i];
            dict[i] = temp;
            dfs(x+1);
            // 复原
            dict[i] = dict[x];
            dict[x] = temp;
        }

    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目



