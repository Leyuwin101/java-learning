package Day57;

public class TypeConversion {
    public static void main(String[] args) {
        /// Two Types of Conversion
        /// Type	                Description
        /// Implicit (Widening)	    Automatic conversion
        /// Explicit (Casting)	    Manual conversion

        /// Implicit Conversion
        /// smaller to larger type
        int a = 10;
        double b = a;

        System.out.println(b); // 10.0

        /// Explicit Conversion
        /// Larger to smaller type
        double x = 9.78;
        int y = (int) x;

        System.out.println(y); // 9
        /// Data loss possible

        /// String to Number
        int num = Integer.parseInt("100");
        double d = Double.parseDouble("12.34");

        System.out.println(num + 10);
        System.out.println(d + 12);

        /// Number to String
        String s1 = String.valueOf(num);
        String s2 = String.valueOf(d);
        String s3 = Integer.toString(num);
        String s4 = Double.toString(d);

        System.out.println(s1);

        /// Boolean Conversion
        boolean bol = Boolean.parseBoolean("true");
        System.out.println(bol);

    }
}
