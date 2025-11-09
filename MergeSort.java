public class MergeSort {
    public static SortResult performMergeSort(int[] data) {
        int[] arr = data.clone();
        StepCounter steps = new StepCounter();
        long startTime = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1, steps);
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1e6;
        return new SortResult("Merge Sort", arr, elapsedTime, steps.count);
    }

    private static void mergeSort(int[] arr, int left, int right, StepCounter steps) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, steps);
            mergeSort(arr, mid + 1, right, steps);
            merge(arr, left, mid, right, steps);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, StepCounter steps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            steps.count++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
