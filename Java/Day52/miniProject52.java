package Day52;

class InvalidGradeException extends Exception {

    public InvalidGradeException(String message) {
        super(message);
    }
}


public class miniProject52 {
    public static void checkGrade(int grade) throws InvalidGradeException {
        if ( grade < 75 ) {
            throw new InvalidGradeException("Invalid grade");
        } else {
            System.out.println("Passed");
        }
    }
    public static void main(String[] args) {
        /// Create InvalidGradeException
        /// If grade < 75 → throw exception
        /// Catch it and print message
        /// If valid → print "Passed"

        try {
            checkGrade(89);
            checkGrade(99);
            checkGrade(74);
        } catch (InvalidGradeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
