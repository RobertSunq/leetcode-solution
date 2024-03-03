
```
// @Title: 雇佣 K 位工人的总代价 (Total Cost to Hire K Workers)
// @Author: robert.sunq
// @Date: 2023-09-15 21:29:24
// @Runtime: 57 ms
// @Memory: 54 MB

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        // 注意 是 long， 避免溢出
        long ans = 0;

        PriorityQueue<Integer> leftQueue = new PriorityQueue<>((a, b) -> costs[a] - costs[b]);
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>((a, b) -> costs[a] - costs[b]);
        int left = 0;
        int right = n - 1;
        for (; left < candidates && left < n; left++) {
            leftQueue.offer(left);
        }
        // 如果，right < left, 则证明元素已经被队列分割完，不需要再入队列了，避免重复
        for (; right >= 0 && right >= (n - candidates) && right >= left; right--) {
            rightQueue.offer(right);
        }
        int patch = 0;
        boolean leftPoll = true;
        while (patch++ < k) {
            // 因为 k < n， 所以不肯两个同时为空
            int leftPeek = leftQueue.isEmpty() ? -1 : leftQueue.peek();
            int rightPeek = rightQueue.isEmpty() ? -1 : rightQueue.peek();

            if (leftPeek == -1) {
                ans = ans + costs[rightPeek];
                rightQueue.poll();
                leftPoll = false;
            } else if (rightPeek == -1) {
                ans = ans + costs[leftPeek];
                leftQueue.poll();
                leftPoll = true;
            } else if (costs[leftPeek] <= costs[rightPeek]) {
                ans = ans + costs[leftPeek];
                leftQueue.poll();
                leftPoll = true;
            } else {
                ans = ans + costs[rightPeek];
                rightQueue.poll();
                leftPoll = false;
            }
            // 元素已经被队列分割完, 每次获取两边最小的即可，所以，不需要入列新元素。
            // 反之，则需要对有元素消耗的队列，录入新元素
            if (left <= right) {
                if (leftPoll) {
                    leftQueue.offer(left++);
                } else {
                    rightQueue.offer(right--);
                }
            }
        }

        return ans;
    }
}
