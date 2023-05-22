
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 12. 矩阵中的路径](https://leetcode.cn//problems/ju-zhen-zhong-de-lu-jing-lcof/)

## 题目描述

<p>给定一个&nbsp;<code>m x n</code> 二维字符网格&nbsp;<code>board</code> 和一个字符串单词&nbsp;<code>word</code> 。如果&nbsp;<code>word</code> 存在于网格中，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。</p>

<p>&nbsp;</p>

<p>例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;" /></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>board = [["a","b"],["c","d"]], word = "abcd"
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n = board[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 6</code></li>
	<li><code>1 &lt;= word.length &lt;= 15</code></li>
	<li><code>board </code>和<code> word </code>仅由大小写英文字母组成</li>
</ul>

<p><strong>注意：</strong>本题与主站 79 题相同：<a href="https://leetcode-cn.com/problems/word-search/">https://leetcode-cn.com/problems/word-search/</a></p>


## 题解


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



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [回溯](https://leetcode.cn//tag/backtracking)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



