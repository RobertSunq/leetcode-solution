
```
// @Title: 根据规则将箱子分类 (Categorize Box According to Criteria)
// @Author: robert.sunq
// @Date: 2023-10-20 21:47:21
// @Runtime: 0 ms
// @Memory: 38.6 MB

class Solution {

    public String categorizeBox(int length, int width, int height, int mass) {
        Map<Integer, String> map = new HashMap<>();


        // 1 1 = heavy Bulky
        map.put(0, "Neither");
        map.put(3, "Both");
        map.put(1, "Bulky");
        map.put(2, "Heavy");

        int cnt = 0;
        if (length >= 10000 || width >= 10000 || height >= 10000 || (1L * length * width * height) >= 1000000000L ) {
            cnt = (cnt | 1);
        }

        if (mass >= 100) {
            cnt = (cnt | 2);
        }

        return map.get(cnt);
    }
}
