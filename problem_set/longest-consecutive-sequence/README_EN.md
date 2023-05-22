
| English | [简体中文](README.md) |

# [128. Longest Consecutive Sequence](https://leetcode.cn//problems/longest-consecutive-sequence/)

## Description

<p>Given an unsorted array of integers <code>nums</code>, return <em>the length of the longest consecutive elements sequence.</em></p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [100,4,200,1,3,2]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest consecutive elements sequence is <code>[1, 2, 3, 4]</code>. Therefore its length is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,3,7,2,5,8,4,6,0,1]
<strong>Output:</strong> 9
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## Solutions


### C++

```C++
// @Title: 最长连续序列 (Longest Consecutive Sequence)
// @Author: robert.sunq
// @Date: 2020-05-13 14:27:54
// @Runtime: 116 ms
// @Memory: 11.9 MB

class Solution {
private: map<int,int> u,counts;

int finds(int x){
    return (x == u[x]) ? x:finds(u[x]);
}

int meges(int x,int y){
    x = finds(x);
    y = finds(y);
    if (x == y) return counts[x];
    u[x] = y;
    counts[x] += counts[y];
    counts[y] = counts[x];
    return counts[x];
}
public:
    int longestConsecutive(vector<int>& nums) {
      if(nums.size() == 0) return 0;
      for(int i=0;i<nums.size();i++){
          u[nums[i]] = nums[i];
          counts[nums[i]] = 1;
      }
      int count = 1;
      for(int i=0;i<nums.size();i++){
          if( u.find(nums[i]+1 ) != u.end()) 
            count = max(count,meges(nums[i],nums[i]+1));
      }
      return count;

    }
};
```



### Java

```Java
// @Title: 最长连续序列 (Longest Consecutive Sequence)
// @Author: robert.sunq
// @Date: 2021-08-03 00:12:53
// @Runtime: 15 ms
// @Memory: 53.6 MB

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i= 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int res = 0;
        for(int i : set){
            // 找到每组序列开始的最小元素，及前一位不在set中
            if(!set.contains(i-1)){
                int curNum = i;
                int curLen = 1;
                // 开始从这个最小的开始往后找其最长序列长度
                while(set.contains(curNum+1)){
                    curNum++;
                    curLen++;
                }
                res = Math.max(res,curLen);
            }
        }
        return res;
    }
}
```



## Related Topics

- [Union Find](https://leetcode.cn//tag/union-find)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)

## Similar Questions

- [Binary Tree Longest Consecutive Sequence](../binary-tree-longest-consecutive-sequence/README_EN.md)
