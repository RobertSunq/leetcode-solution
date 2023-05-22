
```
// @Title: 1～n 整数中 1 出现的次数 (1～n整数中1出现的次数  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 19:38:44
// @Runtime: 0 ms
// @Memory: 35.2 MB

class Solution {
    public int countDigitOne(int n) {
        int di = 1,res = 0;
        // heighNum 高位，cur 当前位的值，低位
        int heighNum = n/10, cur = n%10 ,lowNum = 0;
        while(heighNum != 0 || cur != 0){
            if (cur == 0){
                res = res + heighNum * di ;
            }else if (cur == 1 ) {
                res = res + heighNum * di + lowNum + 1;
            }else{
                res = res + (heighNum + 1) * di;
            }
            di = di * 10;
            cur = heighNum % 10;
            heighNum = heighNum / 10;
            lowNum = n % di;
        }
        return res;
    }

}

/**

设计算 十分位上的出现次数
计算位数 di = 10；

case 1: cur=0
    2  3   0  4
    （保证所有排列组合都小于当前值）：
        将十分位固定为1，这高位范围为（00 ~~ 22）,低位范围为（0 ~~ 9） 组成数均小于 2304，共计 23*10 种。
    （固定高位和当前位，只变动低位）：
        将十分位固定为0，则高位固定，低位范围为（0 ~~ 4），但是这种情况再，计算低位个数的时候已经计算过了
    
case 2: cur=1
    2  3  1  4
    （保证所有排列组合都小于当前值）：
        同理，将十分位固定为1，这高位范围为（00 ~~ 22）,低位范围为（0 ~~ 1） 组成数均小于 2304，共计 23*10 种。
    （固定高位和当前位，只变动低位）：
       将十分位固定为为1，且高位固定，则范围为（0 ~~ 4）,共计（4 + 1）种，
   
    23 * 10 + 4 + 1
case 3: cur>1 即2-9
   2  3  2  4
   （保证所有排列组合都小于当前值）：
        同理，将十分位固定为1，这高位范围为（00 ~~ 23）,低位范围为（0 ~~ 1） 组成数均小于 2304，共计 24*10 种。
   （固定高位和当前位，只变动低位）：
        当十分位固定大于 1 时，则不存在所需计算的，这个状态会存在带有1的情，但是再计算低位的时候已经计算过了。
    
    (23 + 1) * 10


 */

