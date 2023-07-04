
```
// @Title: 最近请求次数 (最近请求次数)
// @Author: robert.sunq
// @Date: 2023-07-04 22:10:38
// @Runtime: 251 ms
// @Memory: 51.7 MB

class RecentCounter {

    int n = 0;
    List<Integer> list;

    public RecentCounter() {
        this.list = new ArrayList<>();
    }
    
    public int ping(int t) {
        int ans = 1;;
        list.add(t);
        n++;
        int tmp;
        int min = t - 3000;
        for (int i = n - 2; i>=0;i--) {
            tmp = list.get(i);
            if (tmp >= min) {
                ans++; 
            } else {
                return ans;
            }
        }
        return ans;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
