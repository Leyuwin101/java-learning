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
    }
}
