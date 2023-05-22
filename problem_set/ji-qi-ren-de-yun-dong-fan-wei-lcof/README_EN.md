
| English | [简体中文](README.md) |

# [剑指 Offer 13. 机器人的运动范围  LCOF](https://leetcode.cn//problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 机器人的运动范围 (机器人的运动范围  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 21:45:20
// @Runtime: 1 ms
// @Memory: 35.3 MB

class Solution {

    int maxStep = 0;
    public int movingCount(int m, int n, int k) {
        // 默认值为 0
        boolean[][] stage = new boolean[m][n];
        recur(stage,0,0,k);  
        return maxStep;  
    }

    public void recur(boolean[][] stage , int row , int col,int k){
        if(row < 0 || row >= stage.length || col < 0 
        || col >= stage[0].length || stage[row][col] || sum(row,col) > k) return;
        maxStep++;
        // 标志位设置为 true 表示来到
        stage[row][col] = true;
        recur(stage,row-1,col,k);
        recur(stage,row+1,col,k);
        recur(stage,row,col-1,k);
        recur(stage,row,col+1,k);
        return;
    }
    


    // 计算数位之和
    public int sum(int row , int col){
        int result = 0;
        while(row > 0){
            result = result + (row % 10);
            row = row/10;
        }
        while(col > 0){
            result = result + (col % 10);
            col = col/10;
        }
        return result;
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


