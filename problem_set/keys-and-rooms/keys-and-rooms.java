
```
// @Title: 钥匙和房间 (Keys and Rooms)
// @Author: robert.sunq
// @Date: 2023-09-08 22:27:59
// @Runtime: 4 ms
// @Memory: 41.9 MB

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i<rooms.size(); i++) {
            ans.add(i);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int n : rooms.get(0)) {
            queue.add(n);
        }
        ans.remove(0);

        while(!queue.isEmpty()) {
            int n = queue.poll();
            if (ans.contains(n)) {
                for (int k : rooms.get(n)) {
                    queue.add(k);
                }
                ans.remove(n);
            }
        }
        return ans.isEmpty();
    }
}
