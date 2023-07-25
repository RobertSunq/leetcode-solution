
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 087. 复原 IP ](https://leetcode.cn//problems/0on3uN/)

## 题目描述

<p>给定一个只包含数字的字符串 <code>s</code> ，用以表示一个 IP 地址，返回所有可能从&nbsp;<code>s</code> 获得的 <strong>有效 IP 地址 </strong>。你可以按任何顺序返回答案。</p>

<p><strong>有效 IP 地址</strong> 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 <code>0</code>），整数之间用 <code>&#39;.&#39;</code> 分隔。</p>

<p>例如：&quot;0.1.2.201&quot; 和 &quot;192.168.1.1&quot; 是 <strong>有效</strong> IP 地址，但是 &quot;0.011.255.245&quot;、&quot;192.168.1.312&quot; 和 &quot;192.168@1.1&quot; 是 <strong>无效</strong> IP 地址。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;25525511135&quot;
<strong>输出：</strong>[&quot;255.255.11.135&quot;,&quot;255.255.111.35&quot;]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;0000&quot;
<strong>输出：</strong>[&quot;0.0.0.0&quot;]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;1111&quot;
<strong>输出：</strong>[&quot;1.1.1.1&quot;]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;010010&quot;
<strong>输出：</strong>[&quot;0.10.0.10&quot;,&quot;0.100.1.0&quot;]
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;10203040&quot;
<strong>输出：</strong>[&quot;10.20.30.40&quot;,&quot;102.0.30.40&quot;,&quot;10.203.0.40&quot;]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 3000</code></li>
	<li><code>s</code> 仅由数字组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 93&nbsp;题相同：<a href="https://leetcode-cn.com/problems/restore-ip-addresses/">https://leetcode-cn.com/problems/restore-ip-addresses/</a>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 复原 IP  (复原 IP )
// @Author: robert.sunq
// @Date: 2023-07-25 23:08:43
// @Runtime: 4 ms
// @Memory: 40.7 MB

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> tmp = new ArrayList<>();

        dfs(ans, tmp , s, 0);
        return ans;
    }

    private void dfs(List<String> ans, List<String> tmp, String s, int index) {
        if (tmp.size() == 4 && index  == s.length()) {
            ans.add(String.join(".", tmp));
            return;
        }

        if(tmp.size() > 4 || index == s.length()) {
            return;
        }

        String sub = s.substring(index, index + 1);
        // 如果当前的字符 不能作为 ip 中的一个数字，直接退回
        if (!isNumInIp(sub)) {
            return;
        }

        // 作为一个新数字填入 
        tmp.add(sub);
        dfs(ans, tmp, s, index + 1);
        tmp.remove(tmp.size() - 1);

        // 连接上上一个数字
        if (tmp.size() == 0) {
            return;
        }

        String tmpSt = tmp.get(tmp.size() - 1);
        if (isNumInIp( tmpSt + sub)) {
            
            tmp.set(tmp.size() - 1, tmpSt + sub);
            dfs(ans, tmp, s, index + 1);
            // 恢复现场
            tmp.set(tmp.size() - 1, tmpSt);
        }

    }


    private boolean isNumInIp(String s) {
        if (s == null || s.length() == 0 || s.length() > 3) {
            return false;
        }

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }

            num = num * 10 + (c - '0');
        }

        if (num > 255) {
            return false;
        }

        // 比较数值和原始字符串长度，来判断首位是不是 0 开头的非一位数字
        return s.length() == String.valueOf(num).length();
    }
}
```



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目



