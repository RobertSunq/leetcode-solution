
```
// @Title: 组合总和 (Combination Sum)
// @Author: robert.sunq
// @Date: 2021-08-08 22:23:19
// @Runtime: 2 ms
// @Memory: 38.4 MB

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        for(int i =0 ;i<candidates.length && candidates[i] <= target ;i++){
            // 目标值刚好和 元素相等，则直接放入结果集，且不用再查找后面的情况
            if(target - candidates[i] == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(candidates[i]);
                res.add(temp);
                break;
            }else{
                // 计算除当前元素后，剩余金额所以可能的组成情况
                List<List<Integer>> t = recur(candidates,target-candidates[i],i);
                // System.out.println("递归结果："+t);
                if(t != null){
                    for(List<Integer> s : t){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(candidates[i]);
                        temp.addAll(s);
                        res.add(temp);
                    }
                }
            } 
        }
        return res;
    }
    // target 当前需要组成的目标值
    // 当前可用组成元素的起始位置
    List<List<Integer>> recur(int[] sortResult , int target,int start){
        // 小于最小值，则不能组成
        if(target < sortResult[start]) return null;
        // System.out.println(target +"  "+ start);
        List<List<Integer>> res = new ArrayList<>();
        // 从start开始迭代，即起始位置是start，之前的情况已经计算完成
        for(int i = start ;i<sortResult.length && sortResult[i] <= target ;i++){
            // System.out.println(" -- " + i);
            // 目标值刚好和 元素相等，则直接放入结果集，且不用再查找后面的情况
            if(target - sortResult[i] == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(sortResult[i]);
                res.add(temp);
                break;
            }else{
                // 当前位置可用参与组成，查找扣除当前元素的组成情况
                List<List<Integer>> t = recur(sortResult,target-sortResult[i],i);
                // System.out.println(t);
                if(t != null){
                    for(List<Integer> s : t){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(sortResult[i]);
                        temp.addAll(s);
                        res.add(temp);
                    }
                }
            }
        }
        return res;

    }
}
