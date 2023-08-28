
```
// @Title: 从字符串中移除星号 (Removing Stars From a String)
// @Author: robert.sunq
// @Date: 2023-08-25 21:14:54
// @Runtime: 20 ms
// @Memory: 43.3 MB

class Solution {
    public String removeStars(String s) {
        int left = 0;
        char[] chars = s.toCharArray();
        for (int right = 0; right < s.length(); right++) {
            if (chars[right] != '*') {
                // 表示放到了结尾位置
                chars[left++] = chars[right];
            } else {
                // 前缀前移，表示删除了一个最近的字符
                left--;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = 0 ; i < left; i++) {
            ans.append(chars[i]);
        }

        return ans.toString();
    }
}
