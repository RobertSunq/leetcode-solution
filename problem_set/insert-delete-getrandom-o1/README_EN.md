
| English | [简体中文](README.md) |

# [380. Insert Delete GetRandom O(1)](https://leetcode.cn//problems/insert-delete-getrandom-o1/)

## Description

<p>Implement the <code>RandomizedSet</code> class:</p>

<ul>
	<li><code>RandomizedSet()</code> Initializes the <code>RandomizedSet</code> object.</li>
	<li><code>bool insert(int val)</code> Inserts an item <code>val</code> into the set if not present. Returns <code>true</code> if the item was not present, <code>false</code> otherwise.</li>
	<li><code>bool remove(int val)</code> Removes an item <code>val</code> from the set if present. Returns <code>true</code> if the item was present, <code>false</code> otherwise.</li>
	<li><code>int getRandom()</code> Returns a random element from the current set of elements (it&#39;s guaranteed that at least one element exists when this method is called). Each element must have the <b>same probability</b> of being returned.</li>
</ul>

<p>You must implement the functions of the class such that each function works in&nbsp;<strong>average</strong>&nbsp;<code>O(1)</code>&nbsp;time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;RandomizedSet&quot;, &quot;insert&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;]
[[], [1], [2], [2], [], [1], [2], []]
<strong>Output</strong>
[null, true, false, true, 2, true, false, 2]

<strong>Explanation</strong>
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
	<li>At most <code>2 *&nbsp;</code><code>10<sup>5</sup></code> calls will be made to <code>insert</code>, <code>remove</code>, and <code>getRandom</code>.</li>
	<li>There will be <strong>at least one</strong> element in the data structure when <code>getRandom</code> is called.</li>
</ul>


## Solutions


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



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Math](https://leetcode.cn//tag/math)
- [Randomized](https://leetcode.cn//tag/randomized)

## Similar Questions

- [Insert Delete GetRandom O(1) - Duplicates allowed](../insert-delete-getrandom-o1-duplicates-allowed/README_EN.md)
