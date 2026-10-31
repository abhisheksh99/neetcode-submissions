class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        // Ensure arr1 is the shorter array for optimization
        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }

        int len1 = arr1.length;
        int len2 = arr2.length;

        int left = 0;
        int right = len1;

        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = (len1 + len2 + 1) / 2 - partition1;

            int left1 = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int right1 = (partition1 == len1) ? Integer.MAX_VALUE : arr1[partition1];
            int left2 = (partition2 == 0) ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int right2 = (partition2 == len2) ? Integer.MAX_VALUE : arr2[partition2];

            if (left1 <= right2 && left2 <= right1) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }

        
        return 0.0;
    }
}
