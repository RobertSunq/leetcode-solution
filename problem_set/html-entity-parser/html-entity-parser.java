
```
// @Title: HTML 实体解析器 (HTML Entity Parser)
// @Author: robert.sunq
// @Date: 2023-11-23 22:03:24
// @Runtime: 47 ms
// @Memory: 43.4 MB

class Solution {
    public String entityParser(String text) {
        Map<String, Character> map = new HashMap<>();

        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');

        int len = text.length();
        int i = 0;
        StringBuffer ans = new StringBuffer();
        while (i < len) {
            boolean parser = false;
            if (text.charAt(i) == '&') {
                for (Map.Entry<String, Character> entry : map.entrySet()) {
                    if (i + entry.getKey().length() <= len && text.substring(i, i + entry.getKey().length()).equals(entry.getKey())) {
                        ans.append(entry.getValue());
                        i = i + entry.getKey().length();
                        parser = true;
                        break;
                    }
                }
            }
            if (!parser) {
                ans.append(text.charAt(i++));
            }
        }

        return ans.toString();
    }
}
