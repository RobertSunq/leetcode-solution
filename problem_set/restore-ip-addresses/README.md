
| [English](README_EN.md) | 简体中文 |

# [93. 复原 IP 地址](https://leetcode.cn//problems/restore-ip-addresses/)

## 题目描述

<p><strong>有效 IP 地址</strong> 正好由四个整数（每个整数位于 <code>0</code> 到 <code>255</code> 之间组成，且不能含有前导 <code>0</code>），整数之间用 <code>'.'</code> 分隔。</p>

<ul>
	<li>例如：<code>"0.1.2.201"</code> 和<code> "192.168.1.1"</code> 是 <strong>有效</strong> IP 地址，但是 <code>"0.011.255.245"</code>、<code>"192.168.1.312"</code> 和 <code>"192.168@1.1"</code> 是 <strong>无效</strong> IP 地址。</li>
</ul>

<p>给定一个只包含数字的字符串 <code>s</code> ，用以表示一个 IP 地址，返回所有可能的<strong>有效 IP 地址</strong>，这些地址可以通过在 <code>s</code> 中插入&nbsp;<code>'.'</code> 来形成。你 <strong>不能</strong>&nbsp;重新排序或删除 <code>s</code> 中的任何数字。你可以按 <strong>任何</strong> 顺序返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "25525511135"
<strong>输出：</strong>["255.255.11.135","255.255.111.35"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "0000"
<strong>输出：</strong>["0.0.0.0"]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "101023"
<strong>输出：</strong>["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 20</code></li>
	<li><code>s</code> 仅由数字组成</li>
</ul>


## 题解


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



## 相关话题

- [字符串](https://leetcode.cn//tag/string)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目


- [IP 到 CIDR](../ip-to-cidr/README.md)
