
```
// @Title: 拼车 (Car Pooling)
// @Author: robert.sunq
// @Date: 2023-12-02 21:01:41
// @Runtime: 1 ms
// @Memory: 42 MB

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        // 遍历计算每个tripes， 对每个节点的人数影响，得到每个节点的count数量来计算是否符合要求，是一个方案

        // 同时，也可以使用 差分数组
        // 差分数组是前缀和的逆运算。 即 count[0] = diff[0], count[1] = diff[0] + diff(1), count[n] = diff[1] + ... + diff(k)
        // 得  diff[k] = count[0] k = 0; 或者 diff[k] = count[k] - count[k - 1] k > 0
        
        // 所以，当 k == from_i 时， diff[k] 的值增加 num
        // 当 k = to_i 时， diff[k] 的值减少 num
        // 其他状态下，因为没有上下车的出现，所以 差分 不受到这个批次人的影响
        
        // 最后计算下前缀和，就得到了count 数组， 不用对每个 批次 进行循环遍历 [from_i, to_i] 的区间 都加 num_i 来计算了


        int toMax = 0;
        for (int[] trip : trips) {
            toMax = Math.max(toMax, trip[2]);
        }

        // 缩减计算，只用计算到能到达的最远距离即可
        int[] diff = new int[toMax + 1];

        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        int count = 0;
        for (int i = 0; i <= toMax; i++) {
            count += diff[i];
            // 中间存在某个时刻， 人数大于容量了
            if (count > capacity) {
                return false;
            }
        }

        // 一直在容量内，可以正常行驶。
        return true;
    }
}
