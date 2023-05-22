
```
// @Title: 复原 IP 地址 (Restore IP Addresses)
// @Author: robert.sunq
// @Date: 2021-07-18 17:36:19
// @Runtime: 2 ms
// @Memory: 38.3 MB

class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        // 长度不在范围内，直接跳出
        if(len<4 || len>12){
            return res;
        }
        // 保存路径
        LinkedList<String> path = new LinkedList<>();
        int splitTime = 0;
        dfs(s,len,splitTime,0,path,res);
        return res;

    }
    /**
    s 原字符串
    len 字符串长度
    splitTime 已分割的长度
    begin 当前ip段开始位置
    path 路径表
    res
     */
    void dfs(String s,int len , int splitTime,int begin,LinkedList<String> path,List<String> res){
        if(begin == len){
            if(splitTime == 4){
                res.add(String.join(".",path));
            }
            return;
        }
        // 剩下的长度过长或者过短，就返回不再进行遍历 len - begin 表示剩余还未进行分割的字符串
        if(len-begin<(4-splitTime) || len-begin>(3*(4-splitTime))){
            return;
        }
        // 遍历，即当前位数，可以站1 —— 3 位字符
        for(int i=0;i<3;i++){
            if(begin+i >= len){
                break;
            }
            // 将当前判断的长度，转为数字
            int ipnum = stringToNum(s,begin,begin+i);
            if(ipnum != -1){
                path.addLast(String.valueOf(ipnum));
                dfs(s,len,splitTime+1,begin+i+1,path,res);
                // 状态还原
                path.removeLast();
            }
        }
    }
    int stringToNum(String  s ,int begin,int end){
        int len = end-begin+1;
        // 大于1位时，不能以0开头
        if(len>1 && s.charAt(begin) == '0'){
            return -1;
        }
        int res = 0;
        for(int i=begin;i<=end;i++){
            // 不是数字，则不能转换
            if(s.charAt(i)>'9' || s.charAt(i) < '0'){
                return -1;
            }
            res = res*10+s.charAt(i)-'0';
            if(res > 255){
                return -1;
            }
        }
        return res;
    }

}
