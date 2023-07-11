
| English | [简体中文](README.md) |

# [剑指 Offer II 058. 日程表](https://leetcode.cn//problems/fi9suh/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 日程表 (日程表)
// @Author: robert.sunq
// @Date: 2023-07-11 23:02:44
// @Runtime: 78 ms
// @Memory: 43.2 MB

class MyCalendar {
    List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int left = arr[0];
            int right = arr[1];
            // 不存在交集时，  end <= left || right <= start
            // 取反后，判断如下
            if (left < end && right > start) {
                return false;
            }
        }

        booked.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Segment Tree](https://leetcode.cn//tag/segment-tree)
- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Ordered Set](https://leetcode.cn//tag/ordered-set)

## Similar Questions


