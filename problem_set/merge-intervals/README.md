
| [English](README_EN.md) | 简体中文 |

# [56. 合并区间](https://leetcode.cn//problems/merge-intervals/)

## 题目描述

<p>以数组 <code>intervals</code> 表示若干个区间的集合，其中单个区间为 <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> 。请你合并所有重叠的区间，并返回&nbsp;<em>一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,3],[2,6],[8,10],[15,18]]
<strong>输出：</strong>[[1,6],[8,10],[15,18]]
<strong>解释：</strong>区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,4],[4,5]]
<strong>输出：</strong>[[1,5]]
<strong>解释：</strong>区间 [1,4] 和 [4,5] 可被视为重叠区间。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目


- [插入区间](../insert-interval/README.md)
- [会议室](../meeting-rooms/README.md)
- [会议室 II](../meeting-rooms-ii/README.md)
- [提莫攻击](../teemo-attacking/README.md)
- [给字符串添加加粗标签](../add-bold-tag-in-string/README.md)
- [Range 模块](../range-module/README.md)
- [员工空闲时间](../employee-free-time/README.md)
- [划分字母区间](../partition-labels/README.md)
- [区间列表的交集](../interval-list-intersections/README.md)
