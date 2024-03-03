
```
// @Title: 从数量最多的堆取走礼物 (Take Gifts From the Richest Pile)
// @Author: robert.sunq
// @Date: 2023-10-28 18:48:25
// @Runtime: 5 ms
// @Memory: 40.3 MB

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int g : gifts) {
            queue.offer(g);
        }

        while (k >0) {
            k--;
            int x = queue.poll();
            queue.offer((int) Math.sqrt(x));
        }

        long ans = 0;
        while (!queue.isEmpty()) {
            ans = ans + queue.poll();
        }

        return ans;
    }
}
