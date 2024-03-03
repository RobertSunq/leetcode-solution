
```
// @Title: 奖励最顶尖的 K 名学生 (Reward Top K Students)
// @Author: robert.sunq
// @Date: 2023-10-11 21:55:15
// @Runtime: 75 ms
// @Memory: 53.1 MB

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : positive_feedback) {
            words.put(word, 3);
        }

        for (String word : negative_feedback) {
            words.put(word, -1);
        }

        int n = report.length;
        int[] sorces = new int[n];
        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (String word : report[i].split(" ")) {
                tmp = tmp + words.getOrDefault(word, 0);
            }

            pos[i] = new int[] {tmp, student_id[i]};
        }

        Arrays.sort(pos, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(pos[i][1]);
        }

        return ans;
    }
}
