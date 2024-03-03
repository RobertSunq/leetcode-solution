
```
// @Title: 情侣牵手 (Couples Holding Hands)
// @Author: robert.sunq
// @Date: 2023-11-11 21:58:34
// @Runtime: 1 ms
// @Memory: 39.1 MB

class Solution {

    // 贪心模拟出来就是正确结果了，也就是只要每次交换都保证会拉近一对情侣，交换次数就是最少的
    
    // 假如存在一次交换是拉近了两对情侣（正好这两个位置交换后都牵手了），但是这个时候用贪心只拉近了一对情侣，那交换次数不就变多了吗？
    // 这种情况其实只能选择拉近他们这两对，因为只有一种配对方法，答案这个 n-1 就是最后一次一定是满足两队的
    public int minSwapsCouples(int[] row) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int n = row.length;
        for (int i = 0; i < n; i+=2) {
            map.put(row[i], i);
            map.put(row[i + 1], i + 1);
        }

        for (int i = 0; i < n; i+=2) {
            int friend = getFriend(row[i]);
            if (row[i+1] == friend) {
                continue;
            }
            int move = map.get(friend);
            row[move] = row[i+1];
            map.put(row[i+1], move);
            row[i+1] = friend;
            map.put(friend, i + 1);
            count++;
        }

        return count;
    }

    public int getFriend(int i) {
        return (i / 2) * 2 == i ? i + 1 : i - 1;
    }
}
