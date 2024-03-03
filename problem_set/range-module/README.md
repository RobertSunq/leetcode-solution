
| [English](README_EN.md) | 简体中文 |

# [715. Range 模块](https://leetcode.cn//problems/range-module/)

## 题目描述

<p>Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 <strong>半开区间</strong> 的范围并查询它们。</p>

<p><strong>半开区间</strong>&nbsp;<code>[left, right)</code>&nbsp;表示所有&nbsp;<code>left &lt;= x &lt; right</code>&nbsp;的实数 <code>x</code> 。</p>

<p>实现 <code>RangeModule</code> 类:</p>

<ul>
	<li><code>RangeModule()</code>&nbsp;初始化数据结构的对象。</li>
	<li><code>void addRange(int left, int right)</code> 添加 <strong>半开区间</strong>&nbsp;<code>[left, right)</code>，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间&nbsp;<code>[left, right)</code>&nbsp;中尚未跟踪的任何数字到该区间中。</li>
	<li><code>boolean queryRange(int left, int right)</code>&nbsp;只有在当前正在跟踪区间&nbsp;<code>[left, right)</code>&nbsp;中的每一个实数时，才返回 <code>true</code>&nbsp;，否则返回 <code>false</code> 。</li>
	<li><code>void removeRange(int left, int right)</code>&nbsp;停止跟踪 <strong>半开区间</strong>&nbsp;<code>[left, right)</code>&nbsp;中当前正在跟踪的每个实数。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入</strong>
["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
<strong>输出</strong>
[null, null, null, true, false, true]

<strong>解释</strong>
RangeModule rangeModule = new RangeModule();
rangeModule.addRange(10, 20);
rangeModule.removeRange(14, 16);
rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= left &lt; right &lt;= 10<sup>9</sup></code></li>
	<li>在单个测试用例中，对&nbsp;<code>addRange</code>&nbsp;、&nbsp; <code>queryRange</code>&nbsp;和 <code>removeRange</code> 的调用总数不超过&nbsp;<code>10<sup>4</sup></code>&nbsp;次</li>
</ul>


## 题解


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



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [线段树](https://leetcode.cn//tag/segment-tree)
- [有序集合](https://leetcode.cn//tag/ordered-set)

## 相似题目


- [合并区间](../merge-intervals/README.md)
- [插入区间](../insert-interval/README.md)
- [将数据流变为多个不相交区间](../data-stream-as-disjoint-intervals/README.md)
