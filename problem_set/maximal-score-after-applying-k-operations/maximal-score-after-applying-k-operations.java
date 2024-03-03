
```
// @Title: 执行 K 次操作后的最大分数 (Maximal Score After Applying K Operations)
// @Author: robert.sunq
// @Date: 2023-10-18 21:36:11
// @Runtime: 147 ms
// @Memory: 59.1 MB

class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0L;
        PriorityQueue<Integer> integers = new PriorityQueue<>((a ,b) -> b - a);

        for (int n : nums) {
            integers.offer(n);
        }
        
        while (k > 0) {
            Integer tmp = integers.poll();
            ans = ans + tmp;
            tmp = (tmp + 2) / 3;
            integers.offer(tmp);
            k--;
        }
        
        return  ans;
    }
}
