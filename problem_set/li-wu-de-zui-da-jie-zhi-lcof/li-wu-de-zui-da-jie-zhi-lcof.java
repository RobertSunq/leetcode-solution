
```
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
