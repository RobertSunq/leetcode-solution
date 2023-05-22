
```
// @Title: 用 Rand7() 实现 Rand10() (Implement Rand10() Using Rand7())
// @Author: robert.sunq
// @Date: 2021-07-12 22:26:27
// @Runtime: 5 ms
// @Memory: 43.3 MB

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int res = 0;
        while(true){
            //构造1~49的均匀分布
            // 因为 (rand7() - 1) * 7 是  0,7,14,21,28,35,42 均匀出现
            // 之后再加上随机数 rand7() 从而使得 1 —— 49 均匀出现 
            res = (rand7() - 1) * 7 + rand7();
            //剔除大于40的值，1-40等概率出现
            if(res <= 40){
                break;
            }
        }
        // 构造1-10的均匀分布
        return res % 10 +1;
    }
}
