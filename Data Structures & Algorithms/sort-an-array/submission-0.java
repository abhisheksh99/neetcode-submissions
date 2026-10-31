class Solution {
    public void merge(int nums[], int s, int m, int e) {
        int n1 = m - s + 1;
        int n2 = e - m;
        
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            arr1[i] = nums[s + i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = nums[m + 1 + i];
        }

        // Merge the two subarrays
        int i = 0, j = 0, k = s;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                nums[k] = arr1[i];
                i++;
            } else {
                nums[k] = arr2[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of arr1[], if any
        while (i < n1) {
            nums[k] = arr1[i];
            i++;
            k++;
        }

        // Copy remaining elements of arr2[], if any
        while (j < n2) {
            nums[k] = arr2[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int nums[], int s, int e) {
        if (s < e) {
            int m = s + (e - s) / 2; // Calculate middle index
            mergeSort(nums, s, m);
            mergeSort(nums, m + 1, e);
            merge(nums, s, m, e); // Merge the sorted halves
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}
