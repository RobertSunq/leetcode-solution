
```
// @Title: 字符串的排列 (字符串的排列  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 00:58:49
// @Runtime: 9 ms
// @Memory: 42.6 MB

class Solution {
    char[] dict;
    // StringBuilder res = new StringBuilder();
    ArrayList<String> res = new ArrayList();
    int len ;
    public String[] permutation(String s) {
        len = s.length();
        dict = s.toCharArray();
        dfs(0);
        return (String[])res.toArray(new String[res.size()]);
    }
    void dfs(int x){
        if(x == len-1){
            res.add(String.valueOf(dict));
            return;  
        } 
        //为了防止同一层递归出现重复元素
        HashSet<Character> set = new HashSet<>();
        // 和X 后的依次交换位置
        for (int i=x;i<len;i++){
            //发生剪枝，当包含这个元素的时候，直接跳过
            if (set.contains(dict[i])){
                continue;
            }
            set.add(dict[i]);
            char temp = dict[x];
            // 交换
            dict[x] = dict[i];
            dict[i] = temp;
            dfs(x+1);
            // 复原
            dict[i] = dict[x];
            dict[x] = temp;
        }

    }
}
