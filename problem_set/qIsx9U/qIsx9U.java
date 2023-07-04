
```
// @Title: 滑动窗口的平均值 (滑动窗口的平均值)
// @Author: robert.sunq
// @Date: 2023-07-04 21:55:30
// @Runtime: 37 ms
// @Memory: 46.7 MB

class MovingAverage {

    int[] window;
    int sum;
    int size;
    int index;
    int count;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.window = new int[size];
        this.sum = 0;
        this.size = size;
        this.index = -1;
        this.count = 0;
    }
    
    public double next(int val) {
        index = (index + 1) % size;
        if (count < size) {
            window[index] = val;
            sum = sum + val;
            count++;
            return sum * 1.0 / count;
        }
        sum = sum - window[index] + val;
        window[index] = val;
        return sum * 1.0 / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
