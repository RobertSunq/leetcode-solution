
| English | [简体中文](README.md) |

# [剑指 Offer 47. 礼物的最大价值 LCOF](https://leetcode.cn//problems/li-wu-de-zui-da-jie-zhi-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 礼物的最大价值 (礼物的最大价值 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 23:34:25
// @Runtime: 5 ms
// @Memory: 41.2 MB

class Solution {
    int max = 0;
    public int maxValue(int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(i == 0 && j == 0){
                    temp[i][j] = grid[i][j];
                }else if(i == 0){
                    temp[i][j] = grid[i][j] + temp[i][j-1];
                }else if(j == 0){
                    temp[i][j] = grid[i][j] + temp[i-1][j];
                }else{
                    temp[i][j] = grid[i][j] + Math.max(temp[i-1][j],temp[i][j-1]);
                }
            }
        }
        return temp[grid.length-1][grid[0].length-1];
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


