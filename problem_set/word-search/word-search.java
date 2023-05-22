
```
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
