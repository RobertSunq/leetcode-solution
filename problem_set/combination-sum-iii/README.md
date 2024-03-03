
| [English](README_EN.md) | 简体中文 |

# [216. 组合总和 III](https://leetcode.cn//problems/combination-sum-iii/)

## 题目描述

<p>找出所有相加之和为&nbsp;<code>n</code><em> </em>的&nbsp;<code>k</code><strong>&nbsp;</strong>个数的组合，且满足下列条件：</p>

<ul>
	<li>只使用数字1到9</li>
	<li>每个数字&nbsp;<strong>最多使用一次</strong>&nbsp;</li>
</ul>

<p>返回 <em>所有可能的有效组合的列表</em> 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <em><strong>k</strong></em> = 3, <em><strong>n</strong></em> = 7
<strong>输出:</strong> [[1,2,4]]
<strong>解释:</strong>
1 + 2 + 4 = 7
没有其他符合的组合了。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> <em><strong>k</strong></em> = 3, <em><strong>n</strong></em> = 9
<strong>输出:</strong> [[1,2,6], [1,3,5], [2,3,4]]
<strong>解释:
</strong>1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
没有其他符合的组合了。</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> k = 4, n = 1
<strong>输出:</strong> []
<strong>解释:</strong> 不存在有效的组合。
在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 &gt; 1，没有有效的组合。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>2 &lt;= k &lt;= 9</code></li>
	<li><code>1 &lt;= n &lt;= 60</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 组合总和 III (Combination Sum III)
// @Author: robert.sunq
// @Date: 2023-09-19 22:20:48
// @Runtime: 2 ms
// @Memory: 39.2 MB

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            List<Integer> tmp = Arrays.asList(i, i);
            ans.add(tmp);
        }

        for (int i = 1; i < k; i++) {
            // 选 k 论 共计 k 个数
            List<List<Integer>> tmpCombiation = new ArrayList<>();
            for (List<Integer> t : ans) {
                // 注意，这里是为了避免重复计算相同需要， 
                // 1开始的序列可以在2——9之间选
                // 2开始的可以在3——9之间选，2开始不选 1 就可以不用与 1 开始的重复了
                // 即 通过最后一位确定从什么序列开始遍历， 呈倒三角访问
                for (int j = t.get(i) + 1; j < 10; j++) {
                    int tmpSum = t.get(0) + j;
                    // 到最后一位了，只放入符合要求的序列
                    if (i == k - 1) {
                        // 符合之后，就不用继续尝试其他值了，因为其他值去和都大
                        if (tmpSum == n) {
                            List<Integer> tmp = new ArrayList<>(t.subList(1, t.size()));
                            tmp.add(j);
                            tmpCombiation.add(tmp);
                            break;
                        }
                    } else {
                        // 序列和大于 所求值 之后也不用在参与计算了
                        if (tmpSum < n) {
                            List<Integer> tmp = new ArrayList<>(t);
                            tmp.add(j);
                            tmp.set(0, tmpSum);
                            tmpCombiation.add(tmp);
                        }
                    }
                }
            }
            ans = tmpCombiation;
        }
        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目


- [组合总和](../combination-sum/README.md)
