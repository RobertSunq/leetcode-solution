
| English | [简体中文](README.md) |

# [56. Merge Intervals](https://leetcode.cn//problems/merge-intervals/)

## Description

<p>Given an array&nbsp;of <code>intervals</code>&nbsp;where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, merge all overlapping intervals, and return <em>an array of the non-overlapping intervals that cover all the intervals in the input</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[1,3],[2,6],[8,10],[15,18]]
<strong>Output:</strong> [[1,6],[8,10],[15,18]]
<strong>Explanation:</strong> Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[1,4],[4,5]]
<strong>Output:</strong> [[1,5]]
<strong>Explanation:</strong> Intervals [1,4] and [4,5] are considered overlapping.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 合并区间 (Merge Intervals)
// @Author: robert.sunq
// @Date: 2021-07-06 23:36:28
// @Runtime: 7 ms
// @Memory: 40.5 MB

class Solution {
    public int[][] merge(int[][] intervals) {
        // 排序
        // sort(intervals , 0 , intervals.length-1);
        // 采用工具类中的 lambda表达式
        Arrays.sort(intervals,(a,b)->{
            return a[0] - b[0];
        });
        List<List<Integer>> res = new ArrayList<>();
        Integer[] temp = new Integer[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        int len = intervals.length;
        int i = 1;
        while(i<len){
            // 表示不连续
            if(temp[1] < intervals[i][0]){
                // List<Integer> t = new ArrayList(Arrays.asList(temp));
                res.add(new ArrayList(Arrays.asList(temp)));
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }else{
                // 否则连续 合并
                
                temp[1] = Math.max(temp[1],intervals[i][1]);
            }
            i++;
        }
        // List<Integer> t = new ArrayList(Arrays.asList(temp));
        res.add(new ArrayList(Arrays.asList(temp)));
        // System.out.println(res);
        int[][] ress = new int[res.size()][2];
        int j =0;
        for(List<Integer> list:res){
            ress[j][0] = list.get(0);
            ress[j][1] = list.get(1);
            j++;
        }
        return ress;
    }

    // 排序
    void sort(int[][] intervals , int left, int right){
        int start = left,end = right;
        if(left >= right) return;
        // 哨兵
        int temp0 = intervals[left][0];
        int temp1 = intervals[left][1];
        while(left < right){
            // 由后往前 找第一个小于哨兵的
            while(left < right && intervals[right][0] >= temp0) right--;
            if(left<right){
                intervals[left][0] = intervals[right][0];
                intervals[left][1] = intervals[right][1];
                left++;
            }
            // 由前往后 找第一个大于哨兵的
            while(left < right && intervals[left][0] <= temp0) left++;
            if(left<right){
                intervals[right][0] = intervals[left][0];
                intervals[right][1] = intervals[left][1];
                right--;
            }
        }
        intervals[left][0] = temp0;
        intervals[left][1] = temp1;
        sort(intervals,start,left-1);
        sort(intervals,left+1,end);
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions

- [Insert Interval](../insert-interval/README_EN.md)
- [Meeting Rooms](../meeting-rooms/README_EN.md)
- [Meeting Rooms II](../meeting-rooms-ii/README_EN.md)
- [Teemo Attacking](../teemo-attacking/README_EN.md)
- [Add Bold Tag in String](../add-bold-tag-in-string/README_EN.md)
- [Range Module](../range-module/README_EN.md)
- [Employee Free Time](../employee-free-time/README_EN.md)
- [Partition Labels](../partition-labels/README_EN.md)
- [Interval List Intersections](../interval-list-intersections/README_EN.md)
