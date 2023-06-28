
```
// @Title: 最小时间差 (最小时间差)
// @Author: robert.sunq
// @Date: 2023-06-28 23:56:07
// @Runtime: 8 ms
// @Memory: 42.9 MB

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();

        for (int i=0; i<timePoints.size(); i++) {
            String s = timePoints.get(i);
            times.add((s.charAt(0) - '0') * 10 * 60 + (s.charAt(1) - '0') * 60 + (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0'));
        }
        times.sort(Integer::compare);
        int sum = 24 * 60;
        int ans = Math.min(times.get(times.size() - 1) - times.get(0), sum + times.get(0) - times.get(times.size() - 1) );

        for (int i=1; i<times.size(); i++) {
            ans = Math.min(ans, times.get(i) - times.get(i-1));
            ans = Math.min(ans, sum + times.get(i-1) - times.get(i));
        }
        return ans;
    }
}
