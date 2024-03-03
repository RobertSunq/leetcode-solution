
| English | [简体中文](README.md) |

# [1402. Reducing Dishes](https://leetcode.cn//problems/reducing-dishes/)

## Description

<p>A chef has collected data on the <code>satisfaction</code> level of his <code>n</code> dishes. Chef can cook any dish in 1 unit of time.</p>

<p><strong>Like-time coefficient</strong> of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level i.e. <code>time[i] * satisfaction[i]</code>.</p>

<p>Return the maximum sum of <strong>like-time coefficient </strong>that the chef can obtain after preparing some amount of dishes.</p>

<p>Dishes can be prepared in <strong>any </strong>order and the chef can discard some dishes to get this maximum value.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> satisfaction = [-1,-8,0,5,-9]
<strong>Output:</strong> 14
<strong>Explanation:</strong> After Removing the second and last dish, the maximum total <strong>like-time coefficient</strong> will be equal to (-1*1 + 0*2 + 5*3 = 14).
Each dish is prepared in one unit of time.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> satisfaction = [4,3,2]
<strong>Output:</strong> 20
<strong>Explanation:</strong> Dishes can be prepared in any order, (2*1 + 3*2 + 4*3 = 20)
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> satisfaction = [-1,-4,-5]
<strong>Output:</strong> 0
<strong>Explanation:</strong> People do not like the dishes. No dish is prepared.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == satisfaction.length</code></li>
	<li><code>1 &lt;= n &lt;= 500</code></li>
	<li><code>-1000 &lt;= satisfaction[i] &lt;= 1000</code></li>
</ul>


## Solutions


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



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


