
```
// @Title: 加油站 (Gas Station)
// @Author: robert.sunq
// @Date: 2023-11-10 22:48:12
// @Runtime: 3 ms
// @Memory: 54.2 MB

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int i = 0;
        while ( i < n) {
            int gasSum = 0;
            int costSum = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                gasSum = gasSum + gas[j];
                costSum = costSum + cost[j];
                if (costSum > gasSum) {
                    break;
                }
                cnt++;
            }

            if (cnt == n) {
                return i;
            } else {
                // 加速计算， 如果无法到达p, 则从 i 到 p 中任意一个节点 j 出发也是无法到达的（毕竟 从 i 触发到 j 是有油量的，比直接用 j 出发 要多出剩余的部分）
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
