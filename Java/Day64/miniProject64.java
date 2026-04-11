package Day64;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class miniProject64 {
    public static void main(String[] args) {
        /// 1. Create a 2D array (matrix)
        /// Fill it manually or randomly
        /// int[][] matrix = new int[3][3];

        /// 2. Add a recursive method
        /// Example: sum all elements
        /// int sumMatrix(int[][] m, int row, int col) { /* recursion */ }

        /// 3. Command-line input
        /// Let user specify rows/columns or initial values
        /// // args[0] = rows, args[1] = columns

        /// 4. Generic method
        /// Example: calculate max/min for any numeric type
        /// <T extends Number> T findMax(T[] array) { ... }

        /// 5. Lambda + Functional Interface
        /// Example: filter numbers > threshold
        /// Predicate<Integer> isLarge = n -> n > 10;

        /// 6. Method reference
        /// Example: Arrays.sort(array, Integer::compareTo);

        int rows = 3;
        int cols = 3;

        if (args.length >= 2) {
            rows = Integer.parseInt(args[0]);
            cols = Integer.parseInt(args[1]);

        }

        System.out.println("Matrix size: " + rows + " x " + cols);

        int[][] matrix = new int[rows][cols];
        Random r = new Random();

        System.out.println("\nGenerated Matrix: ");

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = r.nextInt(10);
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        int total = sumMatrix(matrix, 0, 0);
        System.out.println("Sum: " + total);

        Integer[] nums = {5, 12, 3, 99, 18};
        Double[] decimals = {2.5, 9.1, 4.8, 10.2};

        System.out.println("\nMax Integer: " + findMax(nums));
        System.out.println("\nMax Double: " + findMax(decimals));

        Predicate<Integer> isLarge = n -> n > 10;

        System.out.println("\nLambda Filter(>10):");
        for (int n : nums) {
            if (isLarge.test(n)) {
                System.out.print(n + " ");
            }
        }

        List<Integer> filtered = Arrays.stream(nums)
                .filter(n -> n > 10)
                .collect(Collectors.toList());

        System.out.println("\nStream Filter Result: " + filtered);

        Integer[] arr = {7, 2, 9, 1, 5};

        Arrays.sort(arr, Integer::compareTo);

        System.out.println("\nSorted using Method Reference:");
        System.out.println(Arrays.toString(arr));

    }

    public static int sumMatrix(int[][] m, int row, int col) {
        /// base case: if we've gone past the last row, stop recursion
        if (row >= m.length) {return 0;}

        /// if we've reached the end of the current row, move to the next row
        if ( col >= m[row].length) { return sumMatrix(m, row + 1, 0); }

        /// sum current element + sum of the rest
        return m[row][col] + sumMatrix(m, row, col + 1);
    }

    public static <T extends Number> T findMax(T[] array) {
        T max = array[0];

        for (T num : array) {
            if ( num.doubleValue() > max.doubleValue()) {
                max = num;
            }
        }

        return max;
    }



}
