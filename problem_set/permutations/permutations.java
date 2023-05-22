
```
// @Title: 全排列 (Permutations)
// @Author: robert.sunq
// @Date: 2021-06-03 23:22:11
// @Runtime: 2 ms
// @Memory: 38.6 MB

class Solution {
    int[] dict;
    int N;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        this.dict = nums;
        this.N = nums.length;
        dfs(0);
        return res;

    }

    void dfs(int x){
        if(x == N){

            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<this.N;i++){
                temp.add(dict[i]);
            }
            res.add(temp);
            return;
        }
        // 防止同一层递归中出现交换重复的元素
        HashSet<Integer> set = new HashSet<>();
        for(int i = x;i<this.N;i++){
            if(set.contains(dict[i])){
                continue;
            }
            set.add(dict[i]);
            // 交换顺序
            int temp = dict[x];
            dict[x] = dict[i];
            dict[i] = temp;
            dfs(x+1);
            // 恢复原状
            dict[i] = dict[x];
            dict[x] = temp;
        }
    }
}
