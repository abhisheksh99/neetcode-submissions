

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) < interval[0]) {
                // no overlap: add new interval
                res.add(Arrays.asList(interval[0], interval[1]));
            } else {
                // overlap: merge with last interval
                List<Integer> last = res.get(res.size() - 1);
                last.set(1, Math.max(last.get(1), interval[1]));
            }
        }

        // convert List<List<Integer>> -> int[][]
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }
        return ans;
    }
}
