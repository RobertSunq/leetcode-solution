
| [English](README_EN.md) | 简体中文 |

# [380. O(1) 时间插入、删除和获取随机元素](https://leetcode.cn//problems/insert-delete-getrandom-o1/)

## 题目描述

<p>实现<code>RandomizedSet</code> 类：</p>

<div class="original__bRMd">
<div>
<ul>
	<li><code>RandomizedSet()</code> 初始化 <code>RandomizedSet</code> 对象</li>
	<li><code>bool insert(int val)</code> 当元素 <code>val</code> 不存在时，向集合中插入该项，并返回 <code>true</code> ；否则，返回 <code>false</code> 。</li>
	<li><code>bool remove(int val)</code> 当元素 <code>val</code> 存在时，从集合中移除该项，并返回 <code>true</code> ；否则，返回 <code>false</code> 。</li>
	<li><code>int getRandom()</code> 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 <strong>相同的概率</strong> 被返回。</li>
</ul>

<p>你必须实现类的所有函数，并满足每个函数的 <strong>平均</strong> 时间复杂度为 <code>O(1)</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
<strong>输出</strong>
[null, true, false, true, 2, true, false, 2]

<strong>解释</strong>
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
	<li>最多调用 <code>insert</code>、<code>remove</code> 和 <code>getRandom</code> 函数 <code>2 *&nbsp;</code><code>10<sup>5</sup></code> 次</li>
	<li>在调用 <code>getRandom</code> 方法时，数据结构中 <strong>至少存在一个</strong> 元素。</li>
</ul>
</div>
</div>


## 题解


### Java

```Java
// @Title: O(1) 时间插入、删除和获取随机元素 (Insert Delete GetRandom O(1))
// @Author: robert.sunq
// @Date: 2023-10-17 23:46:35
// @Runtime: 31 ms
// @Memory: 86.6 MB

class RandomizedSet {

    private List<Integer> nums;
    private Map<Integer, Integer> indexes;
    private Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        indexes = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        }
        int n = nums.size();
        nums.add(val);
        indexes.put(val, n);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexes.containsKey(val)) {
            return false;
        }

        int index = indexes.get(val);
        int n = nums.size();
        // 这里，可变数组，将最后一个数替换为需要删除的位置，然后删除最后一个元素\
        int lastVal = nums.get(n - 1);
        nums.set(index, lastVal);
        indexes.put(lastVal, index);
        nums.remove(n - 1);
        indexes.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [数学](https://leetcode.cn//tag/math)
- [随机化](https://leetcode.cn//tag/randomized)

## 相似题目


- [O(1) 时间插入、删除和获取随机元素 - 允许重复](../insert-delete-getrandom-o1-duplicates-allowed/README.md)
