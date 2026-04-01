package Day55;

public class math {
    public static void main(String[] args) {
        /// The Math class provides built-in methods for:
        ///
        /// Calculations
        /// Rounding
        /// Random numbers
        /// Powers and roots

        ///  Basic Math Methods

        System.out.println(Math.abs(-10)); // 10
        System.out.println(Math.max(10, 20)); // 20
        System.out.println(Math.min(10, 20)); // 10

        ///  Rounding Methods
        double num = 5.7;

        System.out.println(Math.round(num)); // 6
        System.out.println(Math.floor(num)); // 5.0
        System.out.println(Math.ceil(num)); // 6.0


        /// Method  	Result
        /// round()	    nearest integer
        /// floor()	    round down
        /// ceil()	    round up


        ///  Power & Square Root
        System.out.println(Math.pow(2, 3)); // 8.0
        System.out.println(Math.sqrt(25)); // 5.0

        ///  Random Numbers
        int random = (int)(Math.random() * 100) + 1;
        System.out.println(random);

        ///  Trigonometric Methods
        System.out.println(Math.sin(Math.toRadians(90))); // 1.0
        System.out.println(Math.cos(Math.toRadians(0))); // 1.0
        System.out.println(Math.tan(Math.toRadians(45))); // ~1.0


    }
}
