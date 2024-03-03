
```
// @Title: 组合总和 III (Combination Sum III)
// @Author: robert.sunq
// @Date: 2023-09-19 22:20:48
// @Runtime: 2 ms
// @Memory: 39.2 MB

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            List<Integer> tmp = Arrays.asList(i, i);
            ans.add(tmp);
        }

        for (int i = 1; i < k; i++) {
            // 选 k 论 共计 k 个数
            List<List<Integer>> tmpCombiation = new ArrayList<>();
            for (List<Integer> t : ans) {
                // 注意，这里是为了避免重复计算相同需要， 
                // 1开始的序列可以在2——9之间选
                // 2开始的可以在3——9之间选，2开始不选 1 就可以不用与 1 开始的重复了
                // 即 通过最后一位确定从什么序列开始遍历， 呈倒三角访问
                for (int j = t.get(i) + 1; j < 10; j++) {
                    int tmpSum = t.get(0) + j;
                    // 到最后一位了，只放入符合要求的序列
                    if (i == k - 1) {
                        // 符合之后，就不用继续尝试其他值了，因为其他值去和都大
                        if (tmpSum == n) {
                            List<Integer> tmp = new ArrayList<>(t.subList(1, t.size()));
                            tmp.add(j);
                            tmpCombiation.add(tmp);
                            break;
                        }
                    } else {
                        // 序列和大于 所求值 之后也不用在参与计算了
                        if (tmpSum < n) {
                            List<Integer> tmp = new ArrayList<>(t);
                            tmp.add(j);
                            tmp.set(0, tmpSum);
                            tmpCombiation.add(tmp);
                        }
                    }
                }
            }
            ans = tmpCombiation;
        }
        return ans;
    }
}
