import java.util.*;

public class DataSorter {

    private static int[] numbers = new int[0];
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a number (1–7): ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> enterNumbers();
                case 2 -> generateRandomNumbers();
                case 3 -> {
                    if (checkData()) displayResult(BubbleSort.performBubbleSort(numbers));
                }
                case 4 -> {
                    if (checkData()) displayResult(MergeSort.performMergeSort(numbers));
                }
                case 5 -> {
                    if (checkData()) displayResult(QuickSort.performQuickSort(numbers));
                }
                case 6 -> {
                    if (checkData()) compareAll();
                }
                case 7 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);
    }

    //  Validated manual input
    private static void enterNumbers() {
        System.out.print("Enter number of elements: ");

        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Please enter a number: ");
            sc.next();
        }
        int n = sc.nextInt();

        numbers = new int[n];
        System.out.println("Enter " + n + " integers:");

        for (int i = 0; i < n; i++) {
            while (!sc.hasNextInt()) {
                System.out.print("Invalid! Enter a valid integer: ");
                sc.next();
            }
            numbers[i] = sc.nextInt();
        }

        System.out.println("Numbers stored successfully!");
        System.out.println(Arrays.toString(numbers));
    }

    //  Validated random number generation
    private static void generateRandomNumbers() {
        System.out.print("Enter number of random elements: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid! Please enter a number: ");
            sc.next();
        }
        int n = sc.nextInt();

        System.out.print("Enter upper limit for random numbers: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid! Please enter a number: ");
            sc.next();
        }
        int limit = sc.nextInt();

        Random rand = new Random();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = rand.nextInt(limit + 1);
        }

        System.out.println("Random numbers generated successfully!");
        System.out.println(Arrays.toString(numbers));
    }

    //  Display single algorithm result
    private static void displayResult(SortResult result) {
        System.out.println("\nAlgorithm: " + result.algorithm);
        System.out.println("Sorted Array: " + Arrays.toString(result.sortedArray));
        System.out.printf("Time: %.3f ms | Steps: %d%n", result.time, result.steps);
    }

    //  Compare all three algorithms
    private static void compareAll() {
        SortResult bubble = BubbleSort.performBubbleSort(numbers);
        SortResult merge = MergeSort.performMergeSort(numbers);
        SortResult quick = QuickSort.performQuickSort(numbers);

        System.out.println("\n--- Algorithm Performance Comparison ---");
        System.out.printf("%-15s %-15s %-15s%n", "Algorithm", "Time (ms)", "Steps");
        System.out.println("---------------------------------------------");
        System.out.printf("%-15s %-15.3f %-15d%n", bubble.algorithm, bubble.time, bubble.steps);
        System.out.printf("%-15s %-15.3f %-15d%n", merge.algorithm, merge.time, merge.steps);
        System.out.printf("%-15s %-15.3f %-15d%n", quick.algorithm, quick.time, quick.steps);
    }

    //  Check if data available
    private static boolean checkData() {
        if (numbers.length == 0) {
            System.out.println("No data found! Please enter or generate numbers first.");
            return false;
        }
        return true;
    }
}
 {
    
}
