
| English | [简体中文](README.md) |

# [39. Combination Sum](https://leetcode.cn//problems/combination-sum/)

## Description

<p>Given an array of <strong>distinct</strong> integers <code>candidates</code> and a target integer <code>target</code>, return <em>a list of all <strong>unique combinations</strong> of </em><code>candidates</code><em> where the chosen numbers sum to </em><code>target</code><em>.</em> You may return the combinations in <strong>any order</strong>.</p>

<p>The <strong>same</strong> number may be chosen from <code>candidates</code> an <strong>unlimited number of times</strong>. Two combinations are unique if the <span data-keyword="frequency-array">frequency</span> of at least one of the chosen numbers is different.</p>

<p>The test cases are generated such that the number of unique combinations that sum up to <code>target</code> is less than <code>150</code> combinations for the given input.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2,3,6,7], target = 7
<strong>Output:</strong> [[2,2,3],[7]]
<strong>Explanation:</strong>
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2,3,5], target = 8
<strong>Output:</strong> [[2,2,2,2],[2,3,3],[3,5]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2], target = 1
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= candidates.length &lt;= 30</code></li>
	<li><code>2 &lt;= candidates[i] &lt;= 40</code></li>
	<li>All elements of <code>candidates</code> are <strong>distinct</strong>.</li>
	<li><code>1 &lt;= target &lt;= 40</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 组合总和 (Combination Sum)
// @Author: robert.sunq
// @Date: 2021-08-08 22:23:19
// @Runtime: 2 ms
// @Memory: 38.4 MB

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        for(int i =0 ;i<candidates.length && candidates[i] <= target ;i++){
            // 目标值刚好和 元素相等，则直接放入结果集，且不用再查找后面的情况
            if(target - candidates[i] == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(candidates[i]);
                res.add(temp);
                break;
            }else{
                // 计算除当前元素后，剩余金额所以可能的组成情况
                List<List<Integer>> t = recur(candidates,target-candidates[i],i);
                // System.out.println("递归结果："+t);
                if(t != null){
                    for(List<Integer> s : t){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(candidates[i]);
                        temp.addAll(s);
                        res.add(temp);
                    }
                }
            } 
        }
        return res;
    }
    // target 当前需要组成的目标值
    // 当前可用组成元素的起始位置
    List<List<Integer>> recur(int[] sortResult , int target,int start){
        // 小于最小值，则不能组成
        if(target < sortResult[start]) return null;
        // System.out.println(target +"  "+ start);
        List<List<Integer>> res = new ArrayList<>();
        // 从start开始迭代，即起始位置是start，之前的情况已经计算完成
        for(int i = start ;i<sortResult.length && sortResult[i] <= target ;i++){
            // System.out.println(" -- " + i);
            // 目标值刚好和 元素相等，则直接放入结果集，且不用再查找后面的情况
            if(target - sortResult[i] == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(sortResult[i]);
                res.add(temp);
                break;
            }else{
                // 当前位置可用参与组成，查找扣除当前元素的组成情况
                List<List<Integer>> t = recur(sortResult,target-sortResult[i],i);
                // System.out.println(t);
                if(t != null){
                    for(List<Integer> s : t){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(sortResult[i]);
                        temp.addAll(s);
                        res.add(temp);
                    }
                }
            }
        }
        return res;

    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions

- [Letter Combinations of a Phone Number](../letter-combinations-of-a-phone-number/README_EN.md)
- [Combination Sum II](../combination-sum-ii/README_EN.md)
- [Combinations](../combinations/README_EN.md)
- [Combination Sum III](../combination-sum-iii/README_EN.md)
- [Factor Combinations](../factor-combinations/README_EN.md)
- [Combination Sum IV](../combination-sum-iv/README_EN.md)
