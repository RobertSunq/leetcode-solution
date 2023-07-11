
```
// @Title: 日程表 (日程表)
// @Author: robert.sunq
// @Date: 2023-07-11 23:02:44
// @Runtime: 78 ms
// @Memory: 43.2 MB

class MyCalendar {
    List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int left = arr[0];
            int right = arr[1];
            // 不存在交集时，  end <= left || right <= start
            // 取反后，判断如下
            if (left < end && right > start) {
                return false;
            }
        }

        booked.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
