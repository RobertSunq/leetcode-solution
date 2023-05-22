
| English | [简体中文](README.md) |

# [剑指 Offer 62. 圆圈中最后剩下的数字 LCOF](https://leetcode.cn//problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 圆圈中最后剩下的数字 (圆圈中最后剩下的数字 LCOF)
// @Author: robert.sunq
// @Date: 2021-08-04 23:04:24
// @Runtime: 4 ms
// @Memory: 35.1 MB

class Solution {
    public int lastRemaining(int n, int m) {
        // ArrayList<Integer> res = new ArrayList<>();
        // for (int i =0 ;i<n;i++){
        //     res.add(i);
        // }
        // int d = 0;
        // while(n>1){
        //     d = (d+m-1)% n;
        //     res.remove(d);
        //     n--;
        // }
        // return res.get(0);
        // 最后剩下的人员编号
        int res = 0;
        // 最后一次删除是是两个数字，所以从2开始
        for(int i=2;i<=n;i++){
            res = (res + m) % i;
        }
        return res;
    }
}
```



## Related Topics

- [Recursion](https://leetcode.cn//tag/recursion)
- [Math](https://leetcode.cn//tag/math)

## Similar Questions


