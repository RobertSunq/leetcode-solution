
```
// @Title: 每棵子树内缺失的最小基因值 (Smallest Missing Genetic Value in Each Subtree)
// @Author: robert.sunq
// @Date: 2023-10-31 23:29:30
// @Runtime: 68 ms
// @Memory: 79 MB

class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;

        List<Integer>[] children = new List[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        // 创建子节点列表， 每个数组表示其子节点
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }

        Set<Integer> geneSet = new HashSet<>();
        boolean[] visited = new boolean[n];

        int[] ans = new int[n];

        // 初始化结果， 因为基因值种最小值为1， 所以存在的最小 缺失 基因值默认为 1 
        // 对于 不包含 基因 1 的节点的树，其最小 缺失 基因值就是 1
        Arrays.fill(ans, 1);

        // 记录已经找到的 缺失 基因值
        int iNode = 1;
        // 记录 1 所在的节点
        int node = -1;

        // 找现有的基因值种 1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i]  == 1) {
                node = i;
                break;
            }
        }

        // 即 如果存在 1， 那么所有包含 1 基因 的树中，缺失的最小值都不是 1， 那么就需要dfs遍历这个树
        // 的所有基因， 来找到其最小的 缺失 基因值
        // 从 基因 1 的树开始 向上遍历树， 因为 包含父节点时包含子节点的所有节点的， 所有父节点的最小缺失值是 大于等于 子节点的最小缺失值
        while (node != -1) {
            dfs(node, nums, children, geneSet, visited);

            // 这里的技巧， 将基因值 从小到大一步一步遍历， 当某个基因值不存在于 树中时，这个基因值就是最小缺失的
            while (geneSet.contains(iNode)) {
                iNode++;
            }

            // 当前处理的子树
            ans[node] = iNode;
            
            // 向上找其夫节点的最小值， 其父节点的最小 缺失 一定是 大于或等于子节点的， 因为包含关系
            node = parents[node];

        }
        // 对于不包含 基因1 的树，其最小缺失值就是 1
        return ans;
    }

    public void dfs(int node, int[] nums, List<Integer>[] children, Set<Integer> geneSet, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        geneSet.add(nums[node]);
        for (int child : children[node]) {
            dfs(child, nums, children, geneSet, visited);
        }
    }
}
