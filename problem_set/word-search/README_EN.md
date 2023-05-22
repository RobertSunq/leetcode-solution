
| English | [简体中文](README.md) |

# [79. Word Search](https://leetcode.cn//problems/word-search/)

## Description

<p>Given an <code>m x n</code> grid of characters <code>board</code> and a string <code>word</code>, return <code>true</code> <em>if</em> <code>word</code> <em>exists in the grid</em>.</p>

<p>The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>Input:</strong> board = [[&quot;A&quot;,&quot;B&quot;,&quot;C&quot;,&quot;E&quot;],[&quot;S&quot;,&quot;F&quot;,&quot;C&quot;,&quot;S&quot;],[&quot;A&quot;,&quot;D&quot;,&quot;E&quot;,&quot;E&quot;]], word = &quot;ABCCED&quot;
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>Input:</strong> board = [[&quot;A&quot;,&quot;B&quot;,&quot;C&quot;,&quot;E&quot;],[&quot;S&quot;,&quot;F&quot;,&quot;C&quot;,&quot;S&quot;],[&quot;A&quot;,&quot;D&quot;,&quot;E&quot;,&quot;E&quot;]], word = &quot;SEE&quot;
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>Input:</strong> board = [[&quot;A&quot;,&quot;B&quot;,&quot;C&quot;,&quot;E&quot;],[&quot;S&quot;,&quot;F&quot;,&quot;C&quot;,&quot;S&quot;],[&quot;A&quot;,&quot;D&quot;,&quot;E&quot;,&quot;E&quot;]], word = &quot;ABCB&quot;
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n = board[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 6</code></li>
	<li><code>1 &lt;= word.length &lt;= 15</code></li>
	<li><code>board</code> and <code>word</code> consists of only lowercase and uppercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you use search pruning to make your solution faster with a larger <code>board</code>?</p>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Backtracking](https://leetcode.cn//tag/backtracking)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions

- [Word Search II](../word-search-ii/README_EN.md)
