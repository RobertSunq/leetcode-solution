
```
// @Title: 电话号码的字母组合 (Letter Combinations of a Phone Number)
// @Author: robert.sunq
// @Date: 2023-09-19 21:20:14
// @Runtime: 0 ms
// @Memory: 39.8 MB

class Solution {
    List<String> ans = new ArrayList<>();
    char[] tmp;
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return ans;
        }
        tmp = new char[n];
        cur(digits, 0);
        return ans;
    }

    private void cur(String digits, int index) {
        if (index == digits.length()) {
            ans.add(String.valueOf(tmp));
            return;
        }
        char c = digits.charAt(index);
        int n = 3;
        if(c == '9' || c=='7') {
            n = 4;
        }
        for (int i = 0; i < n; i++) {
            int ci = (c - '2') * 3 + i + 'a';
            // 7 按钮之后，需要额外移动一位，因为7 上面是四个数字
            if (c > '7') {
                ci = ci + 1;
            }
            tmp[index] = (char) ci;
            cur(digits, index + 1);
        }
    }
}
