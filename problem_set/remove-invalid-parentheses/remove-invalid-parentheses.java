
```
// @Title: 删除无效的括号 (Remove Invalid Parentheses)
// @Author: robert.sunq
// @Date: 2021-06-27 23:45:01
// @Runtime: 3 ms
// @Memory: 38.4 MB

class Solution {

    // 记录长度
    int len ;
    // 记录字符串
    char[] sToChar;
    // 记录结果集
    Set<String> res ;
    public List<String> removeInvalidParentheses(String s) {
        len = s.length();
        sToChar = s.toCharArray();
        // 作为去重
        res = new HashSet<String>();
        // 记录左括号要去除的字符个数
        int leftRemove = 0;
        // 记录右括号要去除的字符个数
        int rightRemove = 0;

        // 这样子统计的是  到I位置时，左右括号应该去除的个数
        for(int i = 0;i<len;i++){
            // 当前字符为左
            if(sToChar[i] == '('){
                leftRemove++;
            }
            if(sToChar[i] == ')'){
                // 如果左括号不为零 则两者可以抵消
                if(leftRemove >0){
                    leftRemove--;
                }else{
                    // 左括号个数为0  右加一
                    rightRemove++;
                }
            }
        }
        StringBuilder path = new StringBuilder();
        // 深度遍历左匹配
        dfs(0,0,0,leftRemove,rightRemove,path);
        return new ArrayList<>(res);
    }

    /**
    cur 当前遍历位置
    leftCur    当前左括号个数
    rightCur   当前右括号个数
    letfRemove 左括号还需要去除的个数
    rightRemove 右括号还需要去除的个数
    path 当前状态的匹配串
     */

    void dfs(int cur,int leftCur,int rightCur,int leftRemove,int rightRemove,StringBuilder path){
         if(cur == len){
             if(leftRemove == rightRemove){
                 res.add(path.toString());
             }
             return ;
         }
        char c = sToChar[cur];
         // 第一状态，去除删除当前位置的字符
         if(c == '(' && leftRemove >0){
             // 尝试删除左括号
             dfs(cur+1,leftCur,rightCur,leftRemove-1,rightRemove,path);
         }
         if(c == ')' && rightRemove >0){
             // 尝试删除右括号
             dfs(cur+1,leftCur,rightCur,leftRemove,rightRemove-1,path);
         }

         // 第二状态，不删除当前位置字符
        path.append(c);
        // 不是括号继续遍历
        if(c!='(' && c!=')'){
            dfs(cur+1,leftCur,rightCur,leftRemove,rightRemove,path);
        }else if(c == '(' ){
            // 保留的时左括号
            dfs(cur+1,leftCur+1,rightCur,leftRemove,rightRemove,path);
        }else if(rightCur < leftCur){
            // 以添加的右括号个数要小于左括号 才可以继续添加右
            dfs(cur+1,leftCur,rightCur+1,leftRemove,rightRemove,path);
        }

        // 将状态还原
        path.deleteCharAt(path.length()-1);
     }
}
