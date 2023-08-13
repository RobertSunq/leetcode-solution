
```
// @Title: 反转字符串中的元音字母 (Reverse Vowels of a String)
// @Author: robert.sunq
// @Date: 2023-08-10 21:59:10
// @Runtime: 4 ms
// @Memory: 42.3 MB

class Solution {
    public String reverseVowels(String s) {
        if (s.length() < 2) {
            return s;
        }
        Set<Character> o = new HashSet<>();
        o.add('a');
        o.add('e');
        o.add('i');
        o.add('o');
        o.add('u');
        o.add('A');
        o.add('E');
        o.add('I');
        o.add('O');
        o.add('U');
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length - 1;
        while ( i < j) {
            if (o.contains(a[i]) && o.contains(a[j])) {
                char t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
                continue;
            } 
            if (!o.contains(a[i]) ) {
                i++;
            }
            if (!o.contains(a[j])) {
                j--;
            }
        }

        return new String(a);
    }
}
