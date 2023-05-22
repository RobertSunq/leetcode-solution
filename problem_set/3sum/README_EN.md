
| English | [简体中文](README.md) |

# [15. 3Sum](https://leetcode.cn//problems/3sum/)

## Description

<p>Given an integer array nums, return all the triplets <code>[nums[i], nums[j], nums[k]]</code> such that <code>i != j</code>, <code>i != k</code>, and <code>j != k</code>, and <code>nums[i] + nums[j] + nums[k] == 0</code>.</p>

<p>Notice that the solution set must not contain duplicate triplets.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,0,1,2,-1,-4]
<strong>Output:</strong> [[-1,-1,2],[-1,0,1]]
<strong>Explanation:</strong> 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,1]
<strong>Output:</strong> []
<strong>Explanation:</strong> The only possible triplet does not sum up to 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,0]
<strong>Output:</strong> [[0,0,0]]
<strong>Explanation:</strong> The only possible triplet sums up to 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 3000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions

- [Two Sum](../two-sum/README_EN.md)
- [3Sum Closest](../3sum-closest/README_EN.md)
- [4Sum](../4sum/README_EN.md)
- [3Sum Smaller](../3sum-smaller/README_EN.md)
