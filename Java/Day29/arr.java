package Day29;

import java.util.Arrays;

public class arr {
    public static void main(String[] args) {
        
        int[] number = {10, 31, 30, 40, 50};

        System.out.println("Original arrays: ");
        for (int num: number) {
            System.out.println(num + " ");
        }

        Arrays.sort(number);

        System.out.println("\nSorted arrays: ");
        for (int num: number) {
            System.out.println(num + " ");
        }

        int sum = 0;
        for (int num: number) {
            sum += num;
        }

        System.out.println("\nSum: " + sum);

        
        int[] numbers = {8, 3, 6, 1, 9};

        System.out.println("Original: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers));

        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copy: " + Arrays.toString(copy));

        Arrays.fill(copy, 100);
        System.out.println("Filled Copy: " + Arrays.toString(copy));

        System.out.println("Arrays equal? " + Arrays.equals(numbers, copy));

        int index = Arrays.binarySearch(numbers, 6);
        System.out.println("Index of 6: " + index);
    }
}
