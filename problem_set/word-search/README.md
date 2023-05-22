
| [English](README_EN.md) | 简体中文 |

# [79. 单词搜索](https://leetcode.cn//problems/word-search/)

## 题目描述

<p>给定一个 <code>m x n</code> 二维字符网格 <code>board</code> 和一个字符串单词 <code>word</code> 。如果 <code>word</code> 存在于网格中，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
<strong>输出：</strong>true
</pre>

<p><strong>示例 3：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n = board[i].length</code></li>
	<li><code>1 <= m, n <= 6</code></li>
	<li><code>1 <= word.length <= 15</code></li>
	<li><code>board</code> 和 <code>word</code> 仅由大小写英文字母组成</li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你可以使用搜索剪枝的技术来优化解决方案，使其在 <code>board</code> 更大的情况下可以更快解决问题？</p>


## 题解


### Java

```Java
// @Title: 单词搜索 (Word Search)
// @Author: robert.sunq
// @Date: 2021-06-05 23:46:42
// @Runtime: 111 ms
// @Memory: 36.6 MB

class Solution {
    boolean[][] flags;
    public boolean exist(char[][] board, String word) {
        for(int i=0 ;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    // 开始进行匹配
                    flags = new boolean[board.length][board[0].length];
                    boolean flag = recur(board,word,i,j,0);
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean recur(char[][] board,String word,int i, int j, int end){
        // 表示可以匹配
        if(end == word.length()) return true;
        if(i< 0 || j<0 || i>= board.length || j>= board[0].length) return false;
        // 已经走过的 不能再走
        if(flags[i][j]) return false;
        if(board[i][j] != word.charAt(end)) return false;
        // 表示已经到过
        flags[i][j] = true;
        // System.out.println("  "+ i+"  " + j+"  " + end);
        // 开始向上，向下，向左，向右 搜素
        boolean res = recur(board,word,i-1,j,end+1) ||
                recur(board,word,i+1,j,end+1) ||
                recur(board,word,i,j-1,end+1) ||
                recur(board,word,i,j+1,end+1);
        // 复原标志位
        flags[i][j] = false;
        return  res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [回溯](https://leetcode.cn//tag/backtracking)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目


- [单词搜索 II](../word-search-ii/README.md)
