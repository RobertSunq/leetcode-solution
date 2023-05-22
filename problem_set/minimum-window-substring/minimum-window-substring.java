
```
// @Title: 最小覆盖子串 (Minimum Window Substring)
// @Author: robert.sunq
// @Date: 2021-07-11 22:36:11
// @Runtime: 53 ms
// @Memory: 39.4 MB

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        // 记录待匹配字符串中每个字符的个数
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }
        int i = 0,j = 0;
        // 记录结果
        int resi = i,resj = j,min = s.length() + 5;
        while(i<s.length() && j<s.length()){
            // System.out.println(map);
            if(map.containsKey(s.charAt(j))){
                // 字符可以匹配，hash表中对应值减一
                map.put(s.charAt(j),map.get(s.charAt(j)) - 1);
                // 表示所有元素都找到
                if(recur(map)){
                    // System.out.println(i+"   " + j);
                    // 则以后前面的节点，来查询当前状态下最短的字符串
                    while(i<s.length()){
                        if(map.containsKey(s.charAt(i))){
                            // 当前起始位置的字符串已经是唯一一个匹配的，不能再右移
                            if(map.get(s.charAt(i)) == 0){
                                break;
                            }else{
                                // 表示当前起始位置的字符，包含多个，可以移除
                                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
                            }
                        }
                        i++;
                    }
                    // 当前子字符串长度最小时，保存结果集
                    if (min > (j-i + 1) ){
                        resi = i; 
                        resj = j;
                        min = j-i + 1;
                    }                     
                }
            }
            j++;
        }
        // 遍历完成，如果匹配成功，则输出结果
        if(recur(map)) return s.substring(resi,resj+1);
        return "";
    }
    // 如果hash表中某个字符没有被抵消完，则不能匹配
    boolean recur(HashMap<Character,Integer> map){
        for(Character key : map.keySet()){
            if(map.get(key) > 0 ) return false;
        }
        return true;
    }
}
