
| English | [简体中文](README.md) |

# [715. Range Module](https://leetcode.cn//problems/range-module/)

## Description

<p>A Range Module is a module that tracks ranges of numbers. Design a data structure to track the ranges represented as <strong>half-open intervals</strong> and query about them.</p>

<p>A <strong>half-open interval</strong> <code>[left, right)</code> denotes all the real numbers <code>x</code> where <code>left &lt;= x &lt; right</code>.</p>

<p>Implement the <code>RangeModule</code> class:</p>

<ul>
	<li><code>RangeModule()</code> Initializes the object of the data structure.</li>
	<li><code>void addRange(int left, int right)</code> Adds the <strong>half-open interval</strong> <code>[left, right)</code>, tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval <code>[left, right)</code> that are not already tracked.</li>
	<li><code>boolean queryRange(int left, int right)</code> Returns <code>true</code> if every real number in the interval <code>[left, right)</code> is currently being tracked, and <code>false</code> otherwise.</li>
	<li><code>void removeRange(int left, int right)</code> Stops tracking every real number currently being tracked in the <strong>half-open interval</strong> <code>[left, right)</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;RangeModule&quot;, &quot;addRange&quot;, &quot;removeRange&quot;, &quot;queryRange&quot;, &quot;queryRange&quot;, &quot;queryRange&quot;]
[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
<strong>Output</strong>
[null, null, null, true, false, true]

<strong>Explanation</strong>
RangeModule rangeModule = new RangeModule();
rangeModule.addRange(10, 20);
rangeModule.removeRange(14, 16);
rangeModule.queryRange(10, 14); // return True,(Every number in [10, 14) is being tracked)
rangeModule.queryRange(13, 15); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
rangeModule.queryRange(16, 17); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= left &lt; right &lt;= 10<sup>9</sup></code></li>
	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>addRange</code>, <code>queryRange</code>, and <code>removeRange</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: Range 模块 (Range Module)
// @Author: robert.sunq
// @Date: 2023-11-12 20:39:01
// @Runtime: 53 ms
// @Memory: 48.1 MB

    class RangeModule {

        private TreeMap<Integer, Integer> intervals;

        public RangeModule() {
            intervals = new TreeMap<>();
        }

        // 主要是，融合区间
        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
            
            if (entry != intervals.firstEntry()) {
                Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
                // 存在一个[i, j)  i 是最接近小于 left 的区间， 且 j 大于 right，  即  [i, j) 包含 [left, right)
                if (start != null && start.getValue() >= right) {
                    return;
                }
                // 存在一个[i, j)  i 是最接近小于 left 的区间， 且 j 大于 left，  即 [i, j) 在 [left, right) 的左侧且 j 在区间内，此时可以合并区间
                if (start != null && start.getValue() >= left) {
                    left = start.getKey();
                    intervals.remove(start.getKey());
                }
            }
            
            // 将所有被 [left, right) 包围的 [i, j) 的区间删除
            while (entry != null && entry.getKey() <= right) {
                right = Math.max(right, entry.getValue());
                intervals.remove(entry.getKey());
                entry = intervals.higherEntry(entry.getKey());
            }
            
            // 添加新的区间
            intervals.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
            
            if (entry == intervals.firstEntry()) {
                return false;
            }
            
            entry = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
            return entry != null && right <= entry.getValue();
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
            
            if (entry != intervals.firstEntry()) {
                Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
                // 存在一个[i, j)  i 是最接近小于 left 的区间， 且 j 大于 right，  即  [i, j) 包含 [left, right)
                if (start != null && start.getValue() >= right) {
                    int ri = start.getValue();
                    // 如果左边界相同，直接删除原本的区间， 然后在判断右区间是否相同， 来判断是否将剩余的区间写入
                    if (start.getKey() == left) {
                        intervals.remove(start.getKey());
                    } else {
                        // 保留左侧剩余的
                        intervals.put(start.getKey(), left);
                    }
                    // 保留右侧剩余的
                    if (right != ri) {
                        intervals.put(right, ri);
                    }
                // 存在一个[i, j)  i 是最接近小于 left 的区间， 且 j 大于 left，  即 [i, j) 在 [left, right) 的左侧且 j 在区间内，此时可以合并区间
                } else if (start != null && start.getValue() > left) {
                    // 且注意，这里和添加的时候不一样，因为右区间是开区间， 所以要使用  > 
                    if (start.getKey() == left) {
                        intervals.remove(start.getKey());
                    } else {
                        intervals.put(start.getKey(), left);
                    }
                }
                
                while (entry != null && entry.getKey() < right) {
                    if (entry.getValue() <= right) {
                        intervals.remove(entry.getKey());
                        entry = intervals.higherEntry(entry.getKey());
                    } else {
                        intervals.put(right, entry.getValue());
                        intervals.remove(entry.getKey());
                        break;
                    }
                }
            } 
        }
    }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Segment Tree](https://leetcode.cn//tag/segment-tree)
- [Ordered Set](https://leetcode.cn//tag/ordered-set)

## Similar Questions

- [Merge Intervals](../merge-intervals/README_EN.md)
- [Insert Interval](../insert-interval/README_EN.md)
- [Data Stream as Disjoint Intervals](../data-stream-as-disjoint-intervals/README_EN.md)
