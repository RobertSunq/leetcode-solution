
```
// @Title: 岛屿数量 (Number of Islands)
// @Author: robert.sunq
// @Date: 2021-06-15 23:40:15
// @Runtime: 2 ms
// @Memory: 41.1 MB

class Solution {
    public int numIslands(char[][] grid) {
        int cur = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    cur++;
                    recur(grid,i,j);
                }
            }
        }
        return cur;
    }

    /**
        将dps访问到的点这是为海，这样一个“岛”就只放问一次
     */
    public void recur(char[][] grid,int i,int j){
        if(i < 0 || i>= grid.length || j<0 || j>= grid[0].length || grid[i][j] == '0') return ;
        // 将陆地设置为海
        grid[i][j] = '0';
        // 访问四周可以访问的点
        recur(grid,i-1,j);
        recur(grid,i,j-1);
        recur(grid,i+1,j);
        recur(grid,i,j+1);
    }
}
