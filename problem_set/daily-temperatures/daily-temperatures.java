
```
// @Title: 每日温度 (Daily Temperatures)
// @Author: robert.sunq
// @Date: 2021-06-23 00:34:55
// @Runtime: 65 ms
// @Memory: 47.6 MB

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 栈中保存暂时无法确认等待天数的下标
        Stack<Integer> st = new Stack<>();

        int[] dp = new int[temperatures.length];
        for(int i =0 ;i<temperatures.length;i++){
            // 栈中所有小于当前元素的值，其最近更高的气温就是当前天数
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                dp[st.peek()] = i - st.peek();
                // 栈中天数的最近高温已找到，出栈
                st.pop();
            }
            // 当前元素入栈， 即当前元素的高温在之后
            st.push(i);
        }
        // 因为数组初始化默认值都是 0 所以，站内留着的元素不需要再特殊处理
        return dp;
    }
}
