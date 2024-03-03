
```
// @Title: 搜索推荐系统 (Search Suggestions System)
// @Author: robert.sunq
// @Date: 2023-09-27 23:02:14
// @Runtime: 72 ms
// @Memory: 46.2 MB

class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node head = new Node();

        for (String s : products) {
            insert(head, s);
        }
        List<List<String>> ans = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String sub = searchWord.substring(0, i);
            Node p = startsWith(head, sub);
            if (p != null) {
                List<String> tmp = new ArrayList<>();
                search(p, tmp, new StringBuilder());
                List<String> result = new ArrayList<>();
                if (tmp.size() == 0) {
                    result.add(sub);
                } else {
                    for (String s : tmp) {
                        result.add(sub + s);
                    }
                }
                ans.add(result);
            } else {
                ans.add(new ArrayList<>());
            }
        }
        return ans;
    }


    public void search(Node p, List<String> result, StringBuilder str) {
        if (result.size() == 3 || p == null) {
            return;
        }
        if (p.end) {
            result.add(str.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (p.child[i] != null) {
                str.append((char) (i + 'a'));
                search(p.child[i], result, str);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }


    class Node {
        public Node[] child;
        public boolean end;

        public Node () {
            this.child = new Node[26];
            this.end = false;
        }
    }

    public void insert(Node head, String word) {

        Node p = head;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.child[index] == null) {
                p.child[index] = new Node();
            }
            p = p.child[index];
        }
        p.end = true;
    }

    public Node startsWith(Node head, String prefix) {
        Node p = head;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.child[index] == null) {
                return null;
            }
            p = p.child[index];
        }
        return p;
    }
}
