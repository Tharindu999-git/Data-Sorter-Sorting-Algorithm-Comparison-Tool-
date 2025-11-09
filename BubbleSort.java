import java.util.Arrays;

public class BubbleSort {
    public static SortResult performBubbleSort(int[] data) {
        int[] arr = data.clone();
        int steps = 0;
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                steps++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1e6;
        return new SortResult("Bubble Sort", arr, elapsedTime, steps);
    }
}
