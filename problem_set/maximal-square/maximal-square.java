
```
// @Title: 最大正方形 (Maximal Square)
// @Author: robert.sunq
// @Date: 2021-06-17 00:51:36
// @Runtime: 10 ms
// @Memory: 41.5 MB

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[] hight = new int[matrix[0].length];
        int res = 0;
        for(int i=0;i<matrix.length;i++){
            // 记录该位置的柱状图 高度
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    hight[j] = hight[j]+1;
                }else{
                    hight[j] = 0;
                }
            }
            res = Math.max(res,recur(hight));
        }
        return res;
    }

    int recur(int[] hight){
        int len = hight.length;
        if(len == 0) return 0;
        if(len == 1) return Math.min(hight[0],1);
        int res = 0;
        // 递减栈
        Stack<Integer> st = new Stack<>();
        // 放入起点
        st.push(0);
        for(int i=0;i<hight.length;i++){
            // 栈顶大于当前值，则栈顶的元素 左边界为其在栈的下一个  右边界为当前元素位置
            while(!st.isEmpty() && hight[i] < hight[st.peek()]){
                int h = hight[st.pop()];
                int row = 0;
                if(st.isEmpty()){
                    // 表示到 I 位置，不包含hight[i] 当前位置的 最小值
                    row = i; 
                }else{
                    row = i-st.peek()-1;
                }
                // 即正方形最小面积  是在长方形中 长宽中最小值
                int temp = Math.min(h,row) * Math.min(h,row);
                res = Math.max(res,temp);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int h = hight[st.pop()];
            int row = 0;
            if(st.isEmpty()){
                // 即此时元素 为整个列表中最小值
                row = len; 
            }else{
                // 此时是栈中所有的元素 向左均可以连续到边界
                row = len-st.peek()-1;
            }
            // 即正方形最小面积  是在长方形中 长宽中最小值
            int temp = Math.min(h,row) * Math.min(h,row);
            res = Math.max(res,temp);            
        }

        return res;
    }
}
