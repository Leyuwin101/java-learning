package Day63;

import java.util.Arrays;

public class miniProject63 {
    public static void main(String[] args) {
        /// 1. Create an Enum
        /// enum Course {
        ///     IT, CS, ENGINEERING, BUSINESS
        /// }
        /// 2. Create a Base Class
        /// class Person {
        ///     protected String name;
        ///
        ///     public Person(String name) {
        ///         this.name = name;
        ///     }
        /// }
        /// 3. Create Student Class
        /// Inherits Person
        /// Uses:
        /// this
        /// super
        /// encapsulation
        /// wrapper class (Integer, Double)
        ///
        /// Requirements:
        ///
        /// Fields:
        /// id (Integer)
        /// grade (Double)
        /// course (Enum)
        /// 4. Add Nested Class
        ///
        /// Inside Student, create:
        ///
        /// class Address {
        ///     String city;
        /// }
        /// 5. Use StringBuilder
        /// Format student info (clean output)
        /// 6. Use Arrays Utility
        /// Store students in an array
        /// Sort them by grade
        /// 7. Use Autoboxing
        ///
        /// Example:
        ///
        /// Integer id = 101; // auto-boxing
        /// int num = id;     // unboxing

        Student.Address a1 = new Student.Address("Gentri");
        Student s1 = new Student("Ojam", 101, 90.5, Course.IT, a1);
        Student s2 = new Student("Seiju", 102, 99.5, Course.ENGINEERING, a1);
        Student s3 = new Student("Baby", null, null, null, a1);

        Student[] students = { s1, s2, s3};

        for(Student s : students){
            System.out.print(s.getStudentInfo());
            System.out.println();
        }


    }
}
