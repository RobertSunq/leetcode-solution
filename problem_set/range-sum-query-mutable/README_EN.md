
| English | [简体中文](README.md) |

# [307. Range Sum Query - Mutable](https://leetcode.cn//problems/range-sum-query-mutable/)

## Description

<p>Given an integer array <code>nums</code>, handle multiple queries of the following types:</p>

<ol>
	<li><strong>Update</strong> the value of an element in <code>nums</code>.</li>
	<li>Calculate the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> where <code>left &lt;= right</code>.</li>
</ol>

<p>Implement the <code>NumArray</code> class:</p>

<ul>
	<li><code>NumArray(int[] nums)</code> Initializes the object with the integer array <code>nums</code>.</li>
	<li><code>void update(int index, int val)</code> <strong>Updates</strong> the value of <code>nums[index]</code> to be <code>val</code>.</li>
	<li><code>int sumRange(int left, int right)</code> Returns the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> (i.e. <code>nums[left] + nums[left + 1] + ... + nums[right]</code>).</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;NumArray&quot;, &quot;sumRange&quot;, &quot;update&quot;, &quot;sumRange&quot;]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
<strong>Output</strong>
[null, 9, null, 8]

<strong>Explanation</strong>
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>0 &lt;= index &lt; nums.length</code></li>
	<li><code>-100 &lt;= val &lt;= 100</code></li>
	<li><code>0 &lt;= left &lt;= right &lt; nums.length</code></li>
	<li>At most <code>3 * 10<sup>4</sup></code> calls will be made to <code>update</code> and <code>sumRange</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 区域和检索 - 数组可修改 (Range Sum Query - Mutable)
// @Author: robert.sunq
// @Date: 2023-11-13 22:30:17
// @Runtime: 123 ms
// @Memory: 71.8 MB

class NumArray {

    // sum[i] 表示第 i 个块的元素和
    private int[]  sum; 

    // 块的大小
    private int size;

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        size = (int) Math.sqrt(n);
        // 分组数量向上取整
        sum = new int[(n + size - 1) / size];
        for (int i = 0; i < n; i++) {
            sum[i / size] = sum[i / size] + nums[i];
        }
    }
    
    public void update(int index, int val) {
        sum[index / size] = sum[index / size] + (val - nums[index]);
        nums[index] = val;

    }
    
    public int sumRange(int left, int right) {
        int leftInSum = left / size;
        int leftIndexInSum = left % size;
        int rightInSum = right / size;
        int rightIndexInSum = right % size;
        
        // 区间 [left, right] 在同一个块中
        if (leftInSum == rightInSum) {
            int ans = 0;
            for (int j = leftIndexInSum; j <= rightIndexInSum; j++) {
                ans += nums[leftInSum * size + j];
            }
            return ans;
        }

        int ans = 0;
        for (int j = leftIndexInSum; j < size; j++) {
            ans += nums[leftInSum * size + j];
        }

        for (int j = 0; j <= rightIndexInSum; j++) {
            ans += nums[rightInSum * size + j];
        }

        for (int j = leftInSum + 1; j < rightInSum; j++) {
            ans += sum[j];
        }

        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Binary Indexed Tree](https://leetcode.cn//tag/binary-indexed-tree)
- [Segment Tree](https://leetcode.cn//tag/segment-tree)
- [Array](https://leetcode.cn//tag/array)

## Similar Questions

- [Range Sum Query - Immutable](../range-sum-query-immutable/README_EN.md)
- [Range Sum Query 2D - Mutable](../range-sum-query-2d-mutable/README_EN.md)
