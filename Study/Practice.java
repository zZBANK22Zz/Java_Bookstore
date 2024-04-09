package Study;

import java.util.Arrays;

public class Practice {
public static void main(String[] args) {
        double[] numbers = { 13, 18, 13, 14, 13, 16, 14, 21, 13 };

        Arrays.sort(numbers);

        double median;
        int length = numbers.length;

        if (length % 2 == 0) {
            median = (numbers[length / 2 - 1] + numbers[length / 2]) / 2.0;
        } else {
            median = numbers[length / 2];
        }

        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        System.out.println("Median: " + median);

    }
}
