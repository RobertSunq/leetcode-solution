
```
// @Title: 做菜顺序 (Reducing Dishes)
// @Author: robert.sunq
// @Date: 2023-10-22 18:06:48
// @Runtime: 6 ms
// @Memory: 39.7 MB

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int ans = 0;

        List<Integer> good = new ArrayList<>();
        List<Integer> bad = new ArrayList<>();

        for (int i : satisfaction) {
            if (i >= 0) {
                good.add(i);
            } else {
                bad.add(i);
            }
        }

        good.sort(Comparator.comparingInt(a -> a));
        bad.sort(Comparator.comparingInt(a -> -a));

        int sum = 0;
        for (int i = 0; i < good.size(); i++) {
            sum = sum + good.get(i);
            ans = ans + (i * good.get(i));
        }

        ans = ans + sum;

        int badSum = 0;
        int badAns = 0;
        for (Integer i : bad) {

            // 判断如果加上一个差评可以促使评分更高，就加上一个差评
            int badSumTmp = badSum + i;
            int badAnsTmp = badAns + badSumTmp;
            int tmp = ans + sum + badAnsTmp;
            if (tmp <= (ans + badAns)) {
                break;
            }
            ans = ans + sum;
            badSum = badSumTmp;
            badAns = badAnsTmp;
        }

        return ans + badAns;


    }
}
