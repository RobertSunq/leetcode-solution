
| English | [简体中文](README.md) |

# [830. Positions of Large Groups](https://leetcode.cn//problems/positions-of-large-groups/)

## Description

<p>In a string <code><font face="monospace">s</font></code>&nbsp;of lowercase letters, these letters form consecutive groups of the same character.</p>

<p>For example, a string like <code>s = &quot;abbxxxxzyy&quot;</code> has the groups <code>&quot;a&quot;</code>, <code>&quot;bb&quot;</code>, <code>&quot;xxxx&quot;</code>, <code>&quot;z&quot;</code>, and&nbsp;<code>&quot;yy&quot;</code>.</p>

<p>A group is identified by an interval&nbsp;<code>[start, end]</code>, where&nbsp;<code>start</code>&nbsp;and&nbsp;<code>end</code>&nbsp;denote the start and end&nbsp;indices (inclusive) of the group. In the above example,&nbsp;<code>&quot;xxxx&quot;</code>&nbsp;has the interval&nbsp;<code>[3,6]</code>.</p>

<p>A group is considered&nbsp;<strong>large</strong>&nbsp;if it has 3 or more characters.</p>

<p>Return&nbsp;<em>the intervals of every <strong>large</strong> group sorted in&nbsp;<strong>increasing order by start index</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abbxxxxzzy&quot;
<strong>Output:</strong> [[3,6]]
<strong>Explanation:</strong> <code>&quot;xxxx&quot; is the only </code>large group with start index 3 and end index 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abc&quot;
<strong>Output:</strong> []
<strong>Explanation:</strong> We have groups &quot;a&quot;, &quot;b&quot;, and &quot;c&quot;, none of which are large groups.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcdddeeeeaabbbcd&quot;
<strong>Output:</strong> [[3,5],[6,9],[12,14]]
<strong>Explanation:</strong> The large groups are &quot;ddd&quot;, &quot;eeee&quot;, and &quot;bbb&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> contains lowercase English letters only.</li>
</ul>


## Solutions


### C++

```C++
// @Title: 较大分组的位置 (Positions of Large Groups)
// @Author: robert.sunq
// @Date: 2020-03-20 17:33:08
// @Runtime: 12 ms
// @Memory: 9.2 MB

class Solution {
public:
    vector<vector<int>> largeGroupPositions(string S) {
        vector<vector<int> > an;
        if(S.size() == 0) return an;
        int len = S.size();
        int i=0;
        int j=0;
        while(i<len-2){
            vector <int> indexs;
            int counts =0;
            for(j=i;j<len;j++){
                if(S[i] == S[j]){
                    counts++;
                }
                else break;

            }
            if(counts >= 3){
                indexs.push_back(i);
                indexs.push_back(j-1);
                an.push_back(indexs);
                indexs.clear();
                i = j;
            }
            else i++;
        }

        return an;

    }
};
```



### Java

```Java
// @Title: 较大分组的位置 (Positions of Large Groups)
// @Author: robert.sunq
// @Date: 2021-08-02 15:44:13
// @Runtime: 1 ms
// @Memory: 38.8 MB

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        // 数据初始化
        int left = -1,right = -1;
        while(left < s.length() && right < s.length()){
            // 判断指向连续字符的头尾是否包含三个字符
            if(right-left>=2){
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                res.add(temp);
            }
            // 跳过当前字符串，到达下一位
            left = right+1;
            right = right+1;
            // 将右指针尤以到，下一位不相同的位置
            while(right<s.length()-1 && s.charAt(right) == s.charAt(right+1)){
                right++;
            }
        }
        return res;

    }
}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)

## Similar Questions


