
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 45. 把数组排成最小的数](https://leetcode.cn//problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)

## 题目描述

<p>输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> <code>[10,2]</code>
<strong>输出:</strong> &quot;<code>102&quot;</code></pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> <code>[3,30,34,5,9]</code>
<strong>输出:</strong> &quot;<code>3033459&quot;</code></pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>0 &lt; nums.length &lt;= 100</code></li>
</ul>

<p><strong>说明: </strong></p>

<ul>
	<li>输出结果可能非常大，所以你需要返回一个字符串而不是整数</li>
	<li>拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0</li>
</ul>


## 题解


### Java

```Java
// @Title: 把数组排成最小的数 (把数组排成最小的数 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 21:48:12
// @Runtime: 7 ms
// @Memory: 38 MB

class Solution {
    public String minNumber(int[] nums) {
        String[] num = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            num[i] = String.valueOf(nums[i]);
        }
        quickSort(num,0,num.length-1);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<num.length;i++){
            res.append(num[i]);
        }
        return res.toString();

    }

    void quickSort(String[] num,int left,int right){
        int i = left,j = right;
        if (left >= right) return;
        // 哨兵
        String temp = num[left];
        while(i < j){
            // 找到第一个“大于”哨兵的值
            while(i<j && compare(num[j],temp)) j--;
            if(i <j){
                num[i] = num[j];
                i++;
            }
            // 找到第小个“大于”哨兵的值
            while(i<j && !compare(num[i],temp)) i++;
            if(i <j){
                num[j] = num[i];
                j--;
            }
        }
        num[i] = temp;
        quickSort(num,left,i-1);
        quickSort(num,i+1,right);

    }

    // true 大， false 小
    boolean compare(String a,String b){
        long am = Long.parseLong(a+b);
        long bm = Long.parseLong(b+a);
        // 及 A 在前 大于 B 在前
        if(am >= bm) return true;
        return false;
    }
}
```



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [字符串](https://leetcode.cn//tag/string)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



