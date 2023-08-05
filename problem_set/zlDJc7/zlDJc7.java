
```
// @Title: 打开转盘锁 (打开转盘锁)
// @Author: robert.sunq
// @Date: 2023-08-04 22:39:06
// @Runtime: 68 ms
// @Memory: 44.2 MB

class Solution {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<String>();
        for (String str : deadends) {
            dead.add(str);
        }

        // 一次都不用拨动，直接锁死
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        Set<String> seen = new HashSet<String>();
        seen.add("0000");

        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                // 拨动一个字符后，得到的下一个序列
                for (String nextStatus : bfs(status)) {
                    // 未访问过的，或者不是死亡状态
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        // 没找到
        return -1;
    }

    private List<String> bfs(String status) {
        List<String> ans = new ArrayList<>();
        char[] array = status.toCharArray();
        for (int i = 0; i <4 ; i++) {
            char c = array[i];
            // 前拨，  0  -- 1 -- 2
            array[i] = c == '9' ? '0' : (char) (c + 1);
            ans.add(new String(array));
            // 后拨    0  -- 9 -- 8
            array[i] = c == '0' ? '9' : (char) (c - 1);
            ans.add(new String(array));

            // 恢复现场
            array[i] = c;
        }

        return ans;
    }
}
