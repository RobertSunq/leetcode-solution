
```
// @Title: 拥有最多糖果的孩子 (Kids With the Greatest Number of Candies)
// @Author: robert.sunq
// @Date: 2023-08-09 21:55:58
// @Runtime: 1 ms
// @Memory: 40.3 MB

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for (int candie : candies) {
            max = max >= candie ? max : candie;
        }

        max = max - extraCandies;
        for (int candie : candies) {
            ans.add(candie >= max);
        }

        return ans;

    }
}
