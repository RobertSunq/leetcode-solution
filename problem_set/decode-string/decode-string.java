
```
// @Title: 字符串解码 (Decode String)
// @Author: robert.sunq
// @Date: 2021-06-20 22:16:42
// @Runtime: 2 ms
// @Memory: 36.4 MB

class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        // 保存数字
        Stack<Integer> stNum = new Stack<>();
        // 保存当前密码串
        Stack<String> stSt = new Stack<>();
        // 记录数组
        int num = 0;
        for(Character c:s.toCharArray()){
            // 字符等于【 将重复次数放入栈，将序列放入栈，开始统计需要重复的字符串
            if(c == '['){
                stNum.push(num);
                stSt.push(res.toString());
                res = new StringBuilder();
                num = 0;
            }else if(c == ']'){
                // 字符串等于】 数字出栈，将当前字符重复 出栈的次数
                int tempNum = stNum.pop();
                StringBuilder temp = new StringBuilder();
                for(int i=0;i<tempNum;i++){
                    temp.append(res);
                }
                res = new StringBuilder(stSt.pop()+temp.toString());
            }else if( c <= '9' && c>='0'){
                // 计算重复数字
                num = num * 10 + Integer.parseInt(c.toString());
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
