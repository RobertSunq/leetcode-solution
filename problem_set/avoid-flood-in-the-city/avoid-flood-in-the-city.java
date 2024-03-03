
```
// @Title: 避免洪水泛滥 (Avoid Flood in The City)
// @Author: robert.sunq
// @Date: 2023-10-13 20:36:46
// @Runtime: 60 ms
// @Memory: 59 MB

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        
        // 保存可以用作来抽干的天， 在某个湖泊第二次下雨的时候，
        // 找到 大于等于上次下雨时间，的最小的晴天，来达到对晴天抽干的最大利用
        TreeSet<Integer> st = new TreeSet<>();

        // 保存  湖泊rains[i] 和上次下雨积满的日期 i
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                st.add(i);
            } else {
                // 雨天， - 1
                ans[i] = -1;

                // 说明该湖泊已经下雨积满了一次，需要吧前一次的选则日期排空
                if (map.containsKey(rains[i])) {
                    // 从现有的晴天中，找到大于上次积满时的最小的晴天，
                    Integer tmp = st.ceiling(map.get(rains[i]));

                    // 每找到，也就是无法及时排空
                    if (tmp == null) {
                        return new int[0];
                    }

                    // 找到的排空日期，放入需要排空的湖泊
                    ans[tmp] = rains[i];

                    st.remove(tmp);
                }
                // 注意这里， 排空一次后，需要把这次填满的时间，及时放入
                map.put(rains[i], i);
            }
        }

        return ans;
    }
}
