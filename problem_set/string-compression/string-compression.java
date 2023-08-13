
```
// @Title: 压缩字符串 (String Compression)
// @Author: robert.sunq
// @Date: 2023-08-12 21:53:44
// @Runtime: 0 ms
// @Memory: 41.9 MB

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        // 记录当前要写入新字符的位置
        int wirte = 0;
        // 记录当前重复字段的开启
        int left = 0;
        for (int i = 0; i < n ; i++) {
            if (i == n - 1 || chars[i] != chars[i + 1]) {
                chars[wirte++] = chars[i];
                int num = i - left + 1;
                // 长度比1大，才有需要保存数字
                if (num > 1) {
                    int tmp = wirte;
                    while (num > 0) {
                        chars[wirte++] = (char) (num % 10 + '0');
                        num = num / 10;
                    }
                    // 翻转数字部分
                    revers(chars, tmp, wirte - 1);
                }
                left = i  + 1;
            }
        }
        // 结尾
        return wirte;
    }

    // 翻转数字部分
    private void revers(char[] chars , int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
