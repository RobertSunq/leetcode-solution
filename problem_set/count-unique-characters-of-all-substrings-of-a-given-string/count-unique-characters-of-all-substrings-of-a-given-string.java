
```
// @Title: 统计子串中的唯一字符 (Count Unique Characters of All Substrings of a Given String)
// @Author: robert.sunq
// @Date: 2023-11-26 15:39:13
// @Runtime: 45 ms
// @Memory: 45.7 MB

class Solution {
    public int uniqueLetterString(String s) {
        // 注意， 这里统计的时子字符串， 不是元素的排列组合
        // 当字符 c 出现在i位置时，如果在某个子字符串中出现一次，就对结果有贡献
        // 所以 记 c 上一次出现的位置位  j, 则从j (不包含) 到 i 位置开始的所有字符串都只有一个 c
        // 同理，记 c 下一次出现的位置位 k， 则从 i 到 k (不包含) 位置结束的所有字符串都只有一个 c
        // 所以，这个j 到 k 区间内的所有可能为  (i - j) * (k - i)

        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }


        int ans = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            // 注意这里， 字符的最后结束位置为字符串的长度，方便计算
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                ans = ans + ((arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i)));
            }
        }


        return ans;
    }
}
