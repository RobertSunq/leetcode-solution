
```
// @Title: 课程表 (Course Schedule)
// @Author: robert.sunq
// @Date: 2021-06-16 22:16:35
// @Runtime: 25 ms
// @Memory: 39 MB

class Solution {

    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 各点的入度
        int[] count = new int[numCourses];
        // 保存入度为零的点
        Stack<Integer> st = new Stack<>();
        // 保存拓扑排序序列
        for(int i=0;i<prerequisites.length;i++){
            count[prerequisites[i][0]]++;
        }
        for(int i=0;i<numCourses;i++){
            // 入读为零的点放入栈，
            if(count[i] == 0){
                st.push(i);
            }
        }
        // 记录访问点的个数
        int res = 0;
        while(!st.isEmpty()){
            int temp = st.pop();
            res++;
            // 将以temp为起点的 入度减一
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1] == temp){
                    count[prerequisites[i][0]]--;
                    // 出现入度为零，则该点放入栈
                    if(count[prerequisites[i][0]] == 0){
                        st.push(prerequisites[i][0]);
                    }
                }
                
            }
        }
        return res == numCourses;
    }
}
