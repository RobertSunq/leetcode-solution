
```
// @Title: 任务调度器 (Task Scheduler)
// @Author: robert.sunq
// @Date: 2021-06-23 22:09:57
// @Runtime: 2 ms
// @Memory: 39.8 MB

class Solution {
    public int leastInterval(char[] tasks, int n) {
        //  不管任务代号是多少，都是一样的，所以主要针对的是不同的词频
        // 统计词频
        int[] dict = new int[26];
        int N = tasks.length;
        for(int  i = 0;i<N;i++){
            dict[tasks[i] - 'A']++;
        }
        // 此时 词频最高的地方再最后面
        Arrays.sort(dict);
        // 需要完成N个任务
        int res = 0;
        int i = 25;
        while(i >=0 && dict[i] == dict[25]) {res++;i--;}

        /**
        * 解题思路：
            * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
            * 2、对数组进行排序，优先排列个数（count）最大的任务，
            *      如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
            * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
            *      则retCount++ ==> A->B->X->A->B->X->A->B
            * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，
            *      因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间 
            */
        return Math.max((dict[25]-1) * (n+1) + res , N);
    }
}
