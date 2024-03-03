
```
// @Title: 可获得的最大点数 (Maximum Points You Can Obtain from Cards)
// @Author: robert.sunq
// @Date: 2023-12-03 18:25:20
// @Runtime: 5 ms
// @Memory: 54 MB

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        // 通过求出剩余卡牌点数之和的最小值，来求出拿走卡牌点数之和的最大值
        
        int n = cardPoints.length;
        int windowSize = n - k;

        int sum = 0;

        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }

        int minSum = sum;
        for (int i = windowSize; i < n; i++) {
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }

        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
