
| English | [简体中文](README.md) |

# [406. Queue Reconstruction by Height](https://leetcode.cn//problems/queue-reconstruction-by-height/)

## Description

<p>You are given an array of people, <code>people</code>, which are the attributes of some people in a queue (not necessarily in order). Each <code>people[i] = [h<sub>i</sub>, k<sub>i</sub>]</code> represents the <code>i<sup>th</sup></code> person of height <code>h<sub>i</sub></code> with <strong>exactly</strong> <code>k<sub>i</sub></code> other people in front who have a height greater than or equal to <code>h<sub>i</sub></code>.</p>

<p>Reconstruct and return <em>the queue that is represented by the input array </em><code>people</code>. The returned queue should be formatted as an array <code>queue</code>, where <code>queue[j] = [h<sub>j</sub>, k<sub>j</sub>]</code> is the attributes of the <code>j<sup>th</sup></code> person in the queue (<code>queue[0]</code> is the person at the front of the queue).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
<strong>Output:</strong> [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
<strong>Explanation:</strong>
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
<strong>Output:</strong> [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= people.length &lt;= 2000</code></li>
	<li><code>0 &lt;= h<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
	<li><code>0 &lt;= k<sub>i</sub> &lt; people.length</code></li>
	<li>It is guaranteed that the queue can be reconstructed.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 根据身高重建队列 (Queue Reconstruction by Height)
// @Author: robert.sunq
// @Date: 2021-06-20 23:39:52
// @Runtime: 29 ms
// @Memory: 39.5 MB

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 当第一个选择相同时，根据第二个元素升序
        // 否则，以第一大数字为主进行降序
        Arrays.sort(people,(person1,person2)->{
            if (person1[0] == person2[0]){
                return person1[1]-person2[1];
            }else {
                return person2[0]-person1[0];
            }
        });

        // 遍历people 根据第二个元素的数值，表示其插入位置.
        // 在结果序列中，所有的元素均大于当前元素，故，所在位置前就由几个大于当前元素的数
        LinkedList<Integer[]> temp = new LinkedList<>();
        for(int i=0;i<people.length;i++){
            // System.out.println(people[i][0] + "   "+people[i][1]);
            Integer[] t = new Integer[]{people[i][0],people[i][1]};
            temp.add(t[1],t);
        }
        int[][] res = new int[people.length][2];
        for(int i=0;i<people.length;i++){
            res[i][0] = temp.get(i)[0];
            res[i][1] = temp.get(i)[1];
        }
        return res;

    }


}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Binary Indexed Tree](https://leetcode.cn//tag/binary-indexed-tree)
- [Segment Tree](https://leetcode.cn//tag/segment-tree)
- [Array](https://leetcode.cn//tag/array)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions

- [Count of Smaller Numbers After Self](../count-of-smaller-numbers-after-self/README_EN.md)
