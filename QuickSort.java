public class QuickSort {
    public static SortResult performQuickSort(int[] data) {
        int[] arr = data.clone();
        StepCounter steps = new StepCounter();
        long startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1, steps);
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1e6;
        return new SortResult("Quick Sort", arr, elapsedTime, steps.count);
    }

    private static void quickSort(int[] arr, int low, int high, StepCounter steps) {
        if (low < high) {
            int pi = partition(arr, low, high, steps);
            quickSort(arr, low, pi - 1, steps);
            quickSort(arr, pi + 1, high, steps);
        }
    }

    private static int partition(int[] arr, int low, int high, StepCounter steps) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            steps.count++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
