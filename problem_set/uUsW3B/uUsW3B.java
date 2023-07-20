
```
// @Title: 含有 k 个元素的组合 (含有 k 个元素的组合)
// @Author: robert.sunq
// @Date: 2023-07-20 23:50:38
// @Runtime: 1 ms
// @Memory: 43.5 MB

class Solution {

    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }


    // cur 当前需要处理的数字
    private void dfs(int cur, int n, int k) {
        // 当前缓存队列中 + 剩余元素不够 k 个了， 直接退出
        if (tmp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录复合要求的缓存队列
        if (tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
            // 剪枝， 因为一旦缓存队列等于结果长度， 就没必要继续递归添加元素了，因为添加了也不会符合长度需求
            return;
        }

        // 当前值参与队列
        tmp.add(cur);
        // 递归处理下一个值
        dfs(cur + 1, n , k);
         
        // 不考虑当前值
        tmp.remove(tmp.size() - 1);

        // 递归处理下一个值
        dfs(cur + 1, n , k); 
    }
}
