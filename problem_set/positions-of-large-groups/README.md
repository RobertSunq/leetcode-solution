
| [English](README_EN.md) | 简体中文 |

# [830. 较大分组的位置](https://leetcode.cn//problems/positions-of-large-groups/)

## 题目描述

<p>在一个由小写字母构成的字符串 <code>s</code> 中，包含由一些连续的相同字符所构成的分组。</p>

<p>例如，在字符串 <code>s = "abbxxxxzyy"</code> 中，就含有 <code>"a"</code>, <code>"bb"</code>, <code>"xxxx"</code>, <code>"z"</code> 和 <code>"yy"</code> 这样的一些分组。</p>

<p>分组可以用区间 <code>[start, end]</code> 表示，其中 <code>start</code> 和 <code>end</code> 分别表示该分组的起始和终止位置的下标。上例中的 <code>"xxxx"</code> 分组用区间表示为 <code>[3,6]</code> 。</p>

<p>我们称所有包含大于或等于三个连续字符的分组为 <strong>较大分组</strong> 。</p>

<p>找到每一个 <strong>较大分组</strong> 的区间，<strong>按起始位置下标递增顺序排序后</strong>，返回结果。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "abbxxxxzzy"
<strong>输出：</strong>[[3,6]]
<strong>解释</strong><strong>：</strong><code>"xxxx" 是一个起始于 3 且终止于 6 的较大分组</code>。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "abc"
<strong>输出：</strong>[]
<strong>解释：</strong>"a","b" 和 "c" 均不是符合要求的较大分组。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "abcdddeeeeaabbbcd"
<strong>输出：</strong>[[3,5],[6,9],[12,14]]
<strong>解释：</strong>较大分组为 "ddd", "eeee" 和 "bbb"</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = "aba"
<strong>输出：</strong>[]
</pre>
 

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 1000</code></li>
	<li><code>s</code> 仅含小写英文字母</li>
</ul>


## 题解


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



## 相关话题

- [字符串](https://leetcode.cn//tag/string)

## 相似题目



