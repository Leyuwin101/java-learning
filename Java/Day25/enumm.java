package Day25;

// Enum values are objects, not just numbers
// Enums are type-safe
// You can add constructors, fields, and methods
// Enum constructors are private by default

enum Day {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
}

public class enumm {
    public static void main(String[] args) {
        Day today = Day.Tuesday;

        switch(today) {
            case Monday: 
                System.out.println("Today is Monday");
                break;
            case Tuesday: 
                System.out.println("Today is Tuesday");
                break;
            case Wednesday: 
                System.out.println("Today is Wednesday");
                break;
            case Thursday: 
                System.out.println("Today is Thursday");
                break;
            case Friday: 
                System.out.println("Today is Friday");
                break;
            case Saturday: 
                System.out.println("Today is Saturday");
                break;
            case Sunday: 
                System.out.println("Today is Sunday");
                break;
            default: 
                System.out.println("Invalid Day");
        }
    }
}
