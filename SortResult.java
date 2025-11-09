public class SortResult {
    String algorithm;
    int[] sortedArray;
    double time;
    int steps;

    public SortResult(String algorithm, int[] sortedArray, double time, int steps) {
        this.algorithm = algorithm;
        this.sortedArray = sortedArray;
        this.time = time;
        this.steps = steps;
    }
}
