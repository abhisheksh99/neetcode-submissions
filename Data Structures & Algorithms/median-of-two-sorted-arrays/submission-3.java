class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int median1 = 0, median2 = 0;
        int i = 0, j = 0;

        for (int k = 0; k <= total / 2; k++) {
            median1 = median2;
            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                median2 = nums1[i++];
            } else {
                median2 = nums2[j++];
            }
        }

        if (total % 2 == 0) return (median1 + median2) / 2.0;
        else return median2;
    }
}
