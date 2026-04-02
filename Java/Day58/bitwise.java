package Day58;

public class bitwise {
    public static void main(String[] args) {
        /// Common Bitwise Operators
        /// Operator	            Symbol	            Description
        /// AND                  	&	                1 & 1 → 1; else 0
        /// OR	                    |	                0 | 0 → 0; else 1
        /// XOR	                    ^	                1 ^ 1 → 0; 1 ^ 0 → 1
        /// NOT	                    ~	                Inverts bits
        /// Left shift	            <<	                Shift bits left (multiply by 2 per shift)
        /// Right shift         	>>	                Shift bits right (divide by 2 per shift)
        /// Unsigned right shift	>>>	                Shift right, fill zero


        int a = 5; // 0101 in binary
        int b = 3; // 0011 in binary

        System.out.println("a & b = " + (a & b)); // 1 (0001)
        System.out.println("a | b = " + (a | b)); // 7 (0111)
        System.out.println("a ^ b = " + (a ^ b)); // 6 (0110)
        System.out.println("~a = " + (~a)); // -6 (two's complement)
        System.out.println("a << 1 = " + (a << 1)); // 10 (1010)
        System.out.println("a >> 1 = " + (a >> 1)); // 2 (0010)
        System.out.println("a >>> 1 = " + (a >>> 1)); // 2


    }
}
