
```
// @Title: 最大矩形 (Maximal Rectangle)
// @Author: robert.sunq
// @Date: 2021-06-09 00:14:28
// @Runtime: 9 ms
// @Memory: 41.3 MB

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length <= 0) return 0;
        // 保存每一行的 第I列 所组成的连续矩形最长高度
        int[] hight = new int[matrix[0].length];
        int res = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    hight[j] = hight[j] + 1;
                }else{
                    hight[j] = 0;
                }
            }
            res = Math.max(res,recur(hight));
        }
        return res;
    }

    // 第84题的逻辑，每一行中的柱状图中最大的巨星
    int recur(int[] matrix){
        int len = matrix.length;
        if(len <= 0) return 0;
        if(len == 1) return matrix[0];
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.push(0);
        for(int i = 1;i<len;i++){
            while(!st.isEmpty() && matrix[i] < matrix[st.peek()]){
                int hight = matrix[st.pop()];
                if(st.isEmpty()){
                    res = Math.max(res,i*hight);
                }else{
                    res = Math.max(res,(i - st.peek() - 1) * hight);
                }
            }
            st.push(i);
        }
        // 栈不为空，则表示剩余的每一个小矩形，都可以到最左侧
        while(!st.isEmpty()){
            int hight = matrix[st.pop()];
            if(st.isEmpty()){
                res = Math.max(res,len*hight);
            }else{
                res = Math.max(res,(len - st.peek() - 1) * hight);
            }
        }
        return res;
    }
}
