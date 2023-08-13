
```
// @Title: 字符串的最大公因子 (Greatest Common Divisor of Strings)
// @Author: robert.sunq
// @Date: 2023-08-08 22:03:22
// @Runtime: 1 ms
// @Memory: 39.8 MB

class Solution {
    public String gcdOfStrings(String str1, String str2) {

        //从最大可用长度开始枚举
        int n1 = str1.length();
        int n2 = str2.length();
        int subSize = Math.min(n1, n2);
        while (subSize > 0) {
            if (n1 % subSize == 0 && n2 % subSize == 0) {
                String x = str1.substring(0, subSize);
                if (isGcd(str1, x) && isGcd(str2, x)) {
                    return str1.substring(0, subSize);
                }
            }
            subSize--;
        }

        return "";

    }

    private boolean isGcd(String str, String x) {
        int lenx = str.length() / x.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < lenx; i++) {
            ans.append(x);
        }
        return str.equals(ans.toString());
    }
}
