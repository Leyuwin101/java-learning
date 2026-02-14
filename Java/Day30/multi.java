package Day30;

public class multi {
    public static void main(String[] args) {
        
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        System.out.println("2d Matrix: ");
        // this one 
        for (int[] row: matrix) {
            for (int val: row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        // is just like this
        // for(int i = 0; i < nums.length; i++) {         // rows
        //     for(int j = 0; j < nums[i].length; j++) {  // columns
        //         System.out.print(nums[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int[][][] Matrix3d = new int[2][3][4];
        // 2 → number of layers
        // 3 → rows per layer
        // 4 → columns per row

        System.out.println("3d Array");
        for ( int i = 0; i < Matrix3d.length; i++ ) {
            System.out.println("Layer " + (i + 1) + ":");

            for ( int j = 0; j < Matrix3d[i].length; j++) {
                for ( int k = 0; k < Matrix3d[i][j].length; k++) {
                    System.out.print(Matrix3d[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        // sum of all elements
        int sum = 0;
        for (int[] row: matrix) {
            for (int val: row) {
                sum += val;
            }
        }
        System.out.println("Sum of all elements: " + sum);
    }
}
