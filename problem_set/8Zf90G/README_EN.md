
| English | [简体中文](README.md) |

# [剑指 Offer II 036. 后缀表达式](https://leetcode.cn//problems/8Zf90G/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 后缀表达式 (后缀表达式)
// @Author: robert.sunq
// @Date: 2023-06-29 22:36:35
// @Runtime: 6 ms
// @Memory: 42.1 MB

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<tokens.length; i++) {
            String str = tokens[i];

            if (str.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                a = b + a;
                stack.push(a);
                continue;
            }

            if (str.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                a = b - a;
                stack.push(a);
                continue;
            }

            if (str.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                a = b * a;
                stack.push(a);
                continue;
            }

            if (str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                a = b / a;
                stack.push(a);
                continue;
            }
            stack.push(Integer.valueOf(str));
        }

        return stack.pop();
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Array](https://leetcode.cn//tag/array)
- [Math](https://leetcode.cn//tag/math)

## Similar Questions


