package Day30;

public class miniProject30 {
    public static void main(String[] args) {
        // Create 3x3 matrix
        int[][] Matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        // Find largest element
        int largest = Matrix[0][0];
        for (int i = 0; i < Matrix.length; i++) {
            for ( int j =0; j < Matrix[i].length; j++) {
                if (Matrix[i][j] > largest) {
                    largest = Matrix[i][j];
                }
            }
        }
        System.out.println("Largest number: " + largest);

        // Sum of diagonals
        int leftDiagonal = 0;
        int rightDiagonal = 0;
        int length = Matrix.length;
        for ( int i = 0; i < Matrix.length; i++) {
                leftDiagonal += Matrix[i][i];
                rightDiagonal += Matrix[i][length - i - 1];
        }

        System.out.println("Left Diagonal: " + leftDiagonal);
        System.out.println("Right Diagonal: " + rightDiagonal);

        // Reverse each row
        System.out.println("Reversed 2D array: ");
        for (int i = 0; i < Matrix.length; i++ ) {
            for ( int j = Matrix[i].length - 1; j >= 0; j--) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }


        // Print in a formatted table
        System.out.println("Formatted Table: ");
        // this one 
        for (int[] row: Matrix) {
            for (int val: row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
