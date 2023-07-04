
```
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
