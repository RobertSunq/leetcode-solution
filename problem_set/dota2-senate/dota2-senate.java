
```
// @Title: Dota2 参议院 (Dota2 Senate)
// @Author: robert.sunq
// @Date: 2023-08-28 19:35:24
// @Runtime: 290 ms
// @Memory: 40.2 MB

class Solution {
    public String predictPartyVictory(String senate) {
        int RCount = 0;
        int DCount = 0;
        int n = senate.length();
        char[] cs = senate.toCharArray();
        for (char c : cs) {
            if (c == 'R') {
                RCount++;
            } else {
                DCount++;
            }
        }

        while(RCount != 0 && DCount != 0) {
            for (int i = 0; i < n; i++) {
                char c = cs[i];
                if (c == 'A') {
                    continue;
                } else if (c == 'R') {
                    if (DCount == 0) {
                        return "Radiant";
                    }
                    DCount--;
                    for (int j = (i + 1) % n; j != i; ) {
                        if (cs[j] == 'D') {
                            cs[j] = 'A';
                            break;
                        }
                        j = (j + 1) % n;
                    }
                } else {
                    if (RCount == 0) {
                        return "Dire";
                    } 
                    RCount--;
                    for (int j = (i + 1) % n; j != i;) {
                        if (cs[j] == 'R') {
                            cs[j] = 'A';
                            break;
                        }
                        j = (j + 1) % n;
                    }
                }
            }
        }

        return RCount == 0 ? "Dire" : "Radiant";
    }

/** 
    
     public String predictPartyVictory(String senate) {
        int n = senate.length();
        // 模拟投票队列
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            // 索引小的先投票，将另一个队列的队头删除。
            if (radiantIndex < direIndex) {
                // 如果索引不变，会影响当前轮次和下一轮次的比较优先级，所以 + n
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
*/
}
