
| English | [简体中文](README.md) |

# [剑指 Offer 38. 字符串的排列  LCOF](https://leetcode.cn//problems/zi-fu-chuan-de-pai-lie-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
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
```



## Related Topics

- [String](https://leetcode.cn//tag/string)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions


