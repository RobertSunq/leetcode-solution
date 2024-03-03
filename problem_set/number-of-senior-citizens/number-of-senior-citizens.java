
```
// @Title: 老人的数目 (Number of Senior Citizens)
// @Author: robert.sunq
// @Date: 2023-10-23 22:46:41
// @Runtime: 1 ms
// @Memory: 40.2 MB

class Solution {
    public int countSeniors(String[] details) {
        int ans  = 0;
        for (String s : details) {
            if (Integer.parseInt(s.substring(11, 13)) > 60) {
                ans++;
            }
        }

        return ans;
    }
}
