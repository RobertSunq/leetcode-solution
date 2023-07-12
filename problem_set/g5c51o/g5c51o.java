
```
// @Title: 出现频率最高的 k 个数字 (出现频率最高的 k 个数字)
// @Author: robert.sunq
// @Date: 2023-07-12 22:35:25
// @Runtime: 14 ms
// @Memory: 46.5 MB

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> que = new PriorityQueue<>(count.size() + 1, (a , b) -> a[1] - b[1]);
        int[] tmp;
        for (int n : count.keySet()) {
            tmp = new int[]{n, count.get(n)};
            que.offer(tmp);
            if(que.size() > k) {
                que.poll();
            }
        }

        tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = que.poll()[0];
        }
        return tmp;
    }
}
