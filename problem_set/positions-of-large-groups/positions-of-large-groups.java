
```
// @Title: 较大分组的位置 (Positions of Large Groups)
// @Author: robert.sunq
// @Date: 2021-08-02 15:44:13
// @Runtime: 1 ms
// @Memory: 38.8 MB

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        // 数据初始化
        int left = -1,right = -1;
        while(left < s.length() && right < s.length()){
            // 判断指向连续字符的头尾是否包含三个字符
            if(right-left>=2){
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                res.add(temp);
            }
            // 跳过当前字符串，到达下一位
            left = right+1;
            right = right+1;
            // 将右指针尤以到，下一位不相同的位置
            while(right<s.length()-1 && s.charAt(right) == s.charAt(right+1)){
                right++;
            }
        }
        return res;

    }
}
