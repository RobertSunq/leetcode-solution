
| English | [简体中文](README.md) |

# [剑指 Offer 12. 矩阵中的路径  LCOF](https://leetcode.cn//problems/ju-zhen-zhong-de-lu-jing-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 矩阵中的路径 (矩阵中的路径  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 21:15:48
// @Runtime: 5 ms
// @Memory: 40.2 MB

class Solution {

    int[][] boardFlag ;
    public boolean exist(char[][] board, String word) {
        if(board.length <=0 || word.length() <= 0) return false;
        char[] words = word.toCharArray();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(recur(board,words,i,j,0)) {
                   return true; 
                }
            }
        }
        return false;
    }

    boolean recur(char[][] board ,char[] words, int row,int col,int k){
        if(board[row][col] != words[k]) return false;
        // 等于字符串最后一位时，寻路完成
        if(k == words.length-1) return true;
        // 用于恢复状态
        char temp = board[row][col];
        board[row][col] = '*';
        boolean flag = false; 
        // up
        if(row > 0) flag = flag || recur(board,words,row-1,col,k+1);
        // down 
        if(row < board.length - 1)  flag = flag || recur(board,words,row+1,col,k+1);
        // left
        if(col > 0)  flag = flag || recur(board,words,row,col-1,k+1);
        // right
        if(col <board[0].length - 1)  flag = flag || recur(board,words,row,col+1,k+1);
        board[row][col] = temp;
        return flag;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Backtracking](https://leetcode.cn//tag/backtracking)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions


