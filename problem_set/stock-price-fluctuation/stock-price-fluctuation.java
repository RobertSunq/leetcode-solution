
```
// @Title: 股票价格波动 (Stock Price Fluctuation )
// @Author: robert.sunq
// @Date: 2023-10-08 23:01:08
// @Runtime: 136 ms
// @Memory: 101.6 MB

class StockPrice {

    int currentTimestamp;
    // 按照价格排序， value保存价格出现的次数
    TreeMap<Integer, Integer> prices;
    Map<Integer, Integer> cache;


    public StockPrice() {
        this.currentTimestamp = 0;
        this.cache = new HashMap();
        this.prices = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        this.currentTimestamp = Math.max(this.currentTimestamp, timestamp);
        int prevPrice = this.cache.getOrDefault(timestamp, 0);
        this.cache.put(timestamp, price);
        // 是更新的价格
        if (prevPrice > 0) {
            // 将旧的价格的个数 - 1
            this.prices.put(prevPrice, this.prices.get(prevPrice) - 1);
            // 如果这个价格不存在对应的时间戳了， 就删除
            if (this.prices.get(prevPrice) == 0) {
                this.prices.remove(prevPrice);
            }
        }
        // 将价格填入
        this.prices.put(price, prices.getOrDefault(price, 0) + 1);

    }
    
    public int current() {
        return this.cache.get(this.currentTimestamp);
    }
    
    public int maximum() {
        return prices.lastKey();
    }
    
    public int minimum() {
        return prices.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
