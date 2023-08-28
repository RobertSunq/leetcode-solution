
```
// @Title: 独一无二的出现次数 (Unique Number of Occurrences)
// @Author: robert.sunq
// @Date: 2023-08-22 22:12:52
// @Runtime: 2 ms
// @Memory: 39.3 MB

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int n : arr) {
            numCount.put(n, numCount.getOrDefault(n, 0) + 1);
        }

        Set<Integer> num = new HashSet<>();
        for (int n : numCount.values()) {
            if (num.contains(n)) {
                return false;
            }
            num.add(n);
        }

        return true;
    }
}
