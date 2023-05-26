
```
// @Title: 单词长度的最大乘积 (单词长度的最大乘积)
// @Author: robert.sunq
// @Date: 2023-05-27 00:01:37
// @Runtime: 6 ms
// @Memory: 42.1 MB

class Solution {
    public int maxProduct(String[] words) {
        // 第一行保存每个字符串的特征值，第二行保存字符串的长度
        int[][] abstractKeyToSize = new int[2][words.length];

        int result = 0;
        for(int i = 0; i < words.length; i++) {
            int tmp = 0;
            String word = words[i];

            // 将字符串中每个字符传为 int 数值上的对应位的 1。 作为字符串的特征值
            for (int j = 0; j < word.length(); j ++) {
                char a = word.charAt(j);
                // 计算每个字符所在位置
                // 注意是或，因为这里是用 高位 来标记字符的存在，存在两个相同的字符也要是高位，而不是进位
                tmp = tmp | (1 << (a - 'a'));
            }

            // 存储当字符串的状态
            abstractKeyToSize[0][i] = tmp;
            abstractKeyToSize[1][i] = word.length();

            // 和已经计算出特征做对比
            for (int j = 0; j < i; j ++) {
                int abstractKey = abstractKeyToSize[0][j];
                // 位与， 如果大于1 则证明两个字符串有相同的字符，就不参与计算
                if ((abstractKey & tmp) > 0) {
                    continue;
                }
                // 没有相同字符，计算最大值
                result = max(result, abstractKeyToSize[1][j] * word.length());
            }
        }

        return result;
    }

    /**
    返回最大值
     */
    private int max(int a, int b) {
        return a >= b ? a : b;
    }
}
