
| [English](README_EN.md) | 简体中文 |

# [1402. 做菜顺序](https://leetcode.cn//problems/reducing-dishes/)

## 题目描述

<p>一个厨师收集了他&nbsp;<code>n</code>&nbsp;道菜的满意程度&nbsp;<code>satisfaction</code>&nbsp;，这个厨师做出每道菜的时间都是 1 单位时间。</p>

<p>一道菜的 「&nbsp;<strong>like-time 系数&nbsp;</strong>」定义为烹饪这道菜结束的时间（包含之前每道菜所花费的时间）乘以这道菜的满意程度，也就是&nbsp;<code>time[i]</code>*<code>satisfaction[i]</code>&nbsp;。</p>

<p>返回厨师在准备了一定数量的菜肴后可以获得的最大 <strong>like-time 系数</strong> 总和。</p>

<p>你可以按&nbsp;<strong>任意</strong>&nbsp;顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>satisfaction = [-1,-8,0,5,-9]
<strong>输出：</strong>14
<strong>解释：</strong>去掉第二道和最后一道菜，最大的 like-time 系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>satisfaction = [4,3,2]
<strong>输出：</strong>20
<strong>解释：可以</strong>按照任意顺序做菜 (2*1 + 3*2 + 4*3 = 20)
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>satisfaction = [-1,-4,-5]
<strong>输出：</strong>0
<strong>解释：</strong>大家都不喜欢这些菜，所以不做任何菜就可以获得最大的 like-time 系数。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == satisfaction.length</code></li>
	<li><code>1 &lt;= n &lt;= 500</code></li>
	<li><code>-1000 &lt;= satisfaction[i] &lt;= 1000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 做菜顺序 (Reducing Dishes)
// @Author: robert.sunq
// @Date: 2023-10-22 18:06:48
// @Runtime: 6 ms
// @Memory: 39.7 MB

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int ans = 0;

        List<Integer> good = new ArrayList<>();
        List<Integer> bad = new ArrayList<>();

        for (int i : satisfaction) {
            if (i >= 0) {
                good.add(i);
            } else {
                bad.add(i);
            }
        }

        good.sort(Comparator.comparingInt(a -> a));
        bad.sort(Comparator.comparingInt(a -> -a));

        int sum = 0;
        for (int i = 0; i < good.size(); i++) {
            sum = sum + good.get(i);
            ans = ans + (i * good.get(i));
        }

        ans = ans + sum;

        int badSum = 0;
        int badAns = 0;
        for (Integer i : bad) {

            // 判断如果加上一个差评可以促使评分更高，就加上一个差评
            int badSumTmp = badSum + i;
            int badAnsTmp = badAns + badSumTmp;
            int tmp = ans + sum + badAnsTmp;
            if (tmp <= (ans + badAns)) {
                break;
            }
            ans = ans + sum;
            badSum = badSumTmp;
            badAns = badAnsTmp;
        }

        return ans + badAns;


    }
}
```



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



