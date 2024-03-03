
```
// @Title: 最小和分割 (Split With Minimum Sum)
// @Author: robert.sunq
// @Date: 2023-10-09 21:50:36
// @Runtime: 2 ms
// @Memory: 38.2 MB

class Solution {
    public int splitNum(int num) {
        List<Integer> tmp = new ArrayList<>();
        while(num > 0) {
            tmp.add(num%10);
            num /=10;
        }
        tmp.sort(Comparator.comparingInt(a -> a));

        // 位排序后， 错位拆分成两个最小的数
        int first = 0;
        int second = 0;
        for(int i = 0; i < tmp.size(); i++) {
            if ((i & 1) == 0) {
                first = first * 10 + tmp.get(i);
            } else {
                second = second * 10 + tmp.get(i);
            }
        }

        return first + second;

    }
}
