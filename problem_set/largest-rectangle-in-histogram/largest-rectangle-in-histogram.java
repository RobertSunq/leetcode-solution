
```
// @Title: 柱状图中最大的矩形 (Largest Rectangle in Histogram)
// @Author: robert.sunq
// @Date: 2021-06-08 23:27:12
// @Runtime: 44 ms
// @Memory: 48.4 MB

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len <= 0) return 0;
        if(len == 1) return heights[0];
        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1;i<heights.length;++i){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int height = heights[st.pop()];
                // 及此时栈空了，表示刚刚出栈的为 0————i之间最小的数，所以此时出栈位置元素的最大面积极为，高*当前长度
                if(st.isEmpty()){
                    res = Math.max(res,i*height);
                }else{
                    int right = st.peek();
                    res = Math.max(res,(i-right-1) * height);
                }
                
            }
            st.push(i);
        }
        while(!st.isEmpty()){
                int height = heights[st.pop()];
                if(st.isEmpty()){
                    res = Math.max(res,len*height);
                }else{
                    int right = st.peek();
                    res = Math.max(res,(len-right-1) * height);
                }
            }
        return res;
    }
}
