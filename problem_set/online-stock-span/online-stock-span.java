
```
// @Title: 股票价格跨度 (Online Stock Span)
// @Author: robert.sunq
// @Date: 2023-10-07 18:54:56
// @Runtime: 19 ms
// @Memory: 53.7 MB

class StockSpanner {
    
    List<int[]> dp;
    
    public StockSpanner() {
      this.dp = new ArrayList<>();
    }
    
    public int next(int price) {
      int n = this.dp.size();
      int p = n - 1;
      while (p > -1) {
        // 第一个大于当前价格的日子
        if (dp.get(p)[0] > price) {
          break;
        }
        // 小于当前价格时，找到下一个大于比较价格的位置
        p = dp.get(p)[1];
      }

      int[] tmp = new int[2];
      tmp[0] = price;
      tmp[1] = p;
      this.dp.add(tmp);
      return n - p;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
