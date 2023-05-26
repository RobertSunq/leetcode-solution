
```
// @Title: 二进制加法 (二进制加法)
// @Author: robert.sunq
// @Date: 2023-05-25 16:41:32
// @Runtime: 2 ms
// @Memory: 41.3 MB

class Solution {
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        // 进位值
        int add = 0;
        // 记录索引
        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        // 
        String result = "";
        while (aIndex >=0 || bIndex >= 0) {
            int aChar = 0;
            int bChar = 0;
            if (aIndex >= 0) {
                aChar = a.charAt(aIndex) - '0';
                aIndex--;
            }
            if (bIndex >= 0) {
                bChar = b.charAt(bIndex) - '0';
                bIndex--;
            }
            int sum = aChar + bChar + add;
            // 进位除法， 当前位取余数
            add = sum / 2;
            result = String.valueOf(sum % 2) + result;
        }
        if (add > 0) {
            result = "1" + result;
        }

        return result;
    }
}
