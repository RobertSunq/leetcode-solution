
| English | [简体中文](README.md) |

# [93. Restore IP Addresses](https://leetcode.cn//problems/restore-ip-addresses/)

## Description

<p>A <strong>valid IP address</strong> consists of exactly four integers separated by single dots. Each integer is between <code>0</code> and <code>255</code> (<strong>inclusive</strong>) and cannot have leading zeros.</p>

<ul>
	<li>For example, <code>&quot;0.1.2.201&quot;</code> and <code>&quot;192.168.1.1&quot;</code> are <strong>valid</strong> IP addresses, but <code>&quot;0.011.255.245&quot;</code>, <code>&quot;192.168.1.312&quot;</code> and <code>&quot;192.168@1.1&quot;</code> are <strong>invalid</strong> IP addresses.</li>
</ul>

<p>Given a string <code>s</code> containing only digits, return <em>all possible valid IP addresses that can be formed by inserting dots into </em><code>s</code>. You are <strong>not</strong> allowed to reorder or remove any digits in <code>s</code>. You may return the valid IP addresses in <strong>any</strong> order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;25525511135&quot;
<strong>Output:</strong> [&quot;255.255.11.135&quot;,&quot;255.255.111.35&quot;]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;0000&quot;
<strong>Output:</strong> [&quot;0.0.0.0&quot;]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;101023&quot;
<strong>Output:</strong> [&quot;1.0.10.23&quot;,&quot;1.0.102.3&quot;,&quot;10.1.0.23&quot;,&quot;10.10.2.3&quot;,&quot;101.0.2.3&quot;]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 20</code></li>
	<li><code>s</code> consists of digits only.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 复原 IP 地址 (Restore IP Addresses)
// @Author: robert.sunq
// @Date: 2021-07-18 17:36:19
// @Runtime: 2 ms
// @Memory: 38.3 MB

class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        // 长度不在范围内，直接跳出
        if(len<4 || len>12){
            return res;
        }
        // 保存路径
        LinkedList<String> path = new LinkedList<>();
        int splitTime = 0;
        dfs(s,len,splitTime,0,path,res);
        return res;

    }
    /**
    s 原字符串
    len 字符串长度
    splitTime 已分割的长度
    begin 当前ip段开始位置
    path 路径表
    res
     */
    void dfs(String s,int len , int splitTime,int begin,LinkedList<String> path,List<String> res){
        if(begin == len){
            if(splitTime == 4){
                res.add(String.join(".",path));
            }
            return;
        }
        // 剩下的长度过长或者过短，就返回不再进行遍历 len - begin 表示剩余还未进行分割的字符串
        if(len-begin<(4-splitTime) || len-begin>(3*(4-splitTime))){
            return;
        }
        // 遍历，即当前位数，可以站1 —— 3 位字符
        for(int i=0;i<3;i++){
            if(begin+i >= len){
                break;
            }
            // 将当前判断的长度，转为数字
            int ipnum = stringToNum(s,begin,begin+i);
            if(ipnum != -1){
                path.addLast(String.valueOf(ipnum));
                dfs(s,len,splitTime+1,begin+i+1,path,res);
                // 状态还原
                path.removeLast();
            }
        }
    }
    int stringToNum(String  s ,int begin,int end){
        int len = end-begin+1;
        // 大于1位时，不能以0开头
        if(len>1 && s.charAt(begin) == '0'){
            return -1;
        }
        int res = 0;
        for(int i=begin;i<=end;i++){
            // 不是数字，则不能转换
            if(s.charAt(i)>'9' || s.charAt(i) < '0'){
                return -1;
            }
            res = res*10+s.charAt(i)-'0';
            if(res > 255){
                return -1;
            }
        }
        return res;
    }

}
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions

- [IP to CIDR](../ip-to-cidr/README_EN.md)
