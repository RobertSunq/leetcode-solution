
| [English](README_EN.md) | 简体中文 |

# [15. 三数之和](https://leetcode.cn//problems/3sum/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> ，判断是否存在三元组 <code>[nums[i], nums[j], nums[k]]</code> 满足 <code>i != j</code>、<code>i != k</code> 且 <code>j != k</code> ，同时还满足 <code>nums[i] + nums[j] + nums[k] == 0</code> 。请</p>

<p>你返回所有和为 <code>0</code> 且不重复的三元组。</p>

<p><strong>注意：</strong>答案中不可以包含重复的三元组。</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,0,1,2,-1,-4]
<strong>输出：</strong>[[-1,-1,2],[-1,0,1]]
<strong>解释：</strong>
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,1]
<strong>输出：</strong>[]
<strong>解释：</strong>唯一可能的三元组和不为 0 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,0]
<strong>输出：</strong>[[0,0,0]]
<strong>解释：</strong>唯一可能的三元组和为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 3000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 三数之和 (3Sum)
// @Author: robert.sunq
// @Date: 2021-06-02 21:33:00
// @Runtime: 23 ms
// @Memory: 42.5 MB

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        while(i < nums.length){
            if(nums[i] > 0) break;
            int j = i+1,t = nums.length-1;
            while(j < t){
                if(nums[j]+ nums[t] == -nums[i]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[t]);
                    res.add(temp);
                    while(j < nums.length && nums[j] == temp.get(1)) j++;
                }else if(nums[j] + nums[t] > -nums[i]){
                    t--;
                }else{
                    j++;
                }
            }
            i++;
            while(i < nums.length && nums[i] == nums[i-1])i++;
        }
        return res;
    }
}
```



### C++

```C++
// @Title: 三数之和 (3Sum)
// @Author: robert.sunq
// @Date: 2020-05-13 18:15:02
// @Runtime: 92 ms
// @Memory: 20.5 MB

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {

        vector<vector<int> > res;
        int n = nums.size();
        if(n<3) return res;
        sort(nums.begin(),nums.end());
        int str = 0,sto = 0,i=0;
        while(i<n-2){
            if(nums[i] >0 ) break;
            // if(nums[i+1] == nums[i]) continue;
            str = i+1;
            sto = n-1;
            while(str<sto){
                    int temp = nums[i]+nums[sto]+nums[str];
                    if(temp==0){
                        vector<int> b(3,0) ;
                        b[0]= nums[i];
                        b[1] = nums[str];
                        b[2] = nums[sto];
                        res.push_back(b);
                        while(str<sto && nums[str+1] == nums[str])
                            str++;
                        while(str<sto && nums[sto-1] == nums[sto])
                            sto--;
                        str++;
                        sto--;
                    }
                    else if(temp >0) sto--;
                    else str++;
                    
                }
            i++;
            while(i<n-2 && nums[i] == nums[i-1]) i++;
            
            
        }
        return res;

    }
};
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [双指针](https://leetcode.cn//tag/two-pointers)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目


- [两数之和](../two-sum/README.md)
- [最接近的三数之和](../3sum-closest/README.md)
- [四数之和](../4sum/README.md)
- [较小的三数之和](../3sum-smaller/README.md)
