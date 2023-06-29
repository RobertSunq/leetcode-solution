
| English | [简体中文](README.md) |

# [剑指 Offer II 037. 小行星碰撞](https://leetcode.cn//problems/XagZNi/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 小行星碰撞 (小行星碰撞)
// @Author: robert.sunq
// @Date: 2023-06-29 23:33:45
// @Runtime: 11 ms
// @Memory: 43.9 MB

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i<asteroids.length; i++) {
            int a = asteroids[i];
            if(st.isEmpty()) {
                st.push(a);
                continue;
            }

            while(!st.isEmpty()) {
                int b = st.pop();
                // 两者同方向运动，或者 两者背向运动，即 b 往左, a 往右
                if (b * a > 0 || ( b < 0 && a > 0)) {
                    st.push(b);
                    st.push(a);
                    a = 0;
                    break;
                }

                if (a+b == 0) {
                    a = 0;
                    break;
                }

                if (Math.abs(b) > Math.abs(a)) {
                    st.push(b);
                    a = 0;
                    break;
                }
            }
            // a != 0 表示 A 没有被撞掉 
            if(a != 0) {
                st.push(a);
            }
        }


        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i>=0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Array](https://leetcode.cn//tag/array)
- [Simulation](https://leetcode.cn//tag/simulation)

## Similar Questions


