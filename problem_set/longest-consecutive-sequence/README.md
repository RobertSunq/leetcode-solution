
| [English](README_EN.md) | 简体中文 |

# [128. 最长连续序列](https://leetcode.cn//problems/longest-consecutive-sequence/)

## 题目描述

<p>给定一个未排序的整数数组 <code>nums</code> ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。</p>

<p>请你设计并实现时间复杂度为 <code>O(n)</code><em> </em>的算法解决此问题。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [100,4,200,1,3,2]
<strong>输出：</strong>4
<strong>解释：</strong>最长数字连续序列是 <code>[1, 2, 3, 4]。它的长度为 4。</code></pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,3,7,2,5,8,4,6,0,1]
<strong>输出：</strong>9
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [并查集](https://leetcode.cn//tag/union-find)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)

## 相似题目


- [二叉树最长连续序列](../binary-tree-longest-consecutive-sequence/README.md)
