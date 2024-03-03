
```
// @Title: 猜数字大小 (Guess Number Higher or Lower)
// @Author: robert.sunq
// @Date: 2023-09-16 16:38:09
// @Runtime: 0 ms
// @Memory: 38 MB

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int ans;
        while (true) {
            ans = left + (right - left) / 2;
            int tmp = guess(ans);
            if (tmp == 0) {
                break;
            } else if (tmp < 0) {
                right = ans - 1;
            } else {
                left = ans + 1;
            }
        }
        return ans;
    }
}
