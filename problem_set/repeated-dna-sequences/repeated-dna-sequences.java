
```
// @Title: 重复的DNA序列 (Repeated DNA Sequences)
// @Author: robert.sunq
// @Date: 2023-11-05 17:02:33
// @Runtime: 22 ms
// @Memory: 50.6 MB

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();

        Map<String, Integer> count = new HashMap<>();

        int n = s.length();

        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i , i + 10);
            count.put(sub, count.getOrDefault(sub, 0) + 1);

            if (count.get(sub) == 2) {
                ans.add(sub);
            }
        }

        return ans;
    }
}
