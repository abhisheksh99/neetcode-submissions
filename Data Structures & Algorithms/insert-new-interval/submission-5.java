

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<List<Integer>> res = new ArrayList<>();

        // 1) add intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        // 2) merge overlaps with newInterval
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(Arrays.asList(newInterval[0], newInterval[1]));

        // 3) add remaining intervals
        while (i < n) {
            res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        // convert List<List<Integer>> → int[][]
        int[][] ans = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            ans[j][0] = res.get(j).get(0);
            ans[j][1] = res.get(j).get(1);
        }
        return ans;
    }
}
