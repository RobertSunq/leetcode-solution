
| English | [简体中文](README.md) |

# [剑指 Offer II 042. 最近请求次数](https://leetcode.cn//problems/H8086Q/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
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
```



### Python3

```Python3
# @Title: 最近请求次数 (最近请求次数)
# @Author: robert.sunq
# @Date: 2023-07-04 22:15:06
# @Runtime: 220 ms
# @Memory: 21.7 MB

class RecentCounter:

    def __init__(self):
        # 使用队列维护发送请求的时间， 队中只保存 [t - 3000, t] 的数据
        self.q = deque()


    def ping(self, t: int) -> int:
        self.q.append(t)
        # 因为是递增队列。   从队首，将小于 t - 3000, 的时间弹出，
        while self.q[0] < t - 3000:
            self.q.popleft()
        # 剩下的队列长度就是所需的结果
        return len(self.q)



# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Queue](https://leetcode.cn//tag/queue)
- [Data Stream](https://leetcode.cn//tag/data-stream)

## Similar Questions


