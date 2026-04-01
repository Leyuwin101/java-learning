package Day54;
import java.lang.reflect.*;

class Student {
    private String name = "Seiju";
    int age;

    public void sayHello() {
        System.out.println("Hello " + name);
    }
}

public class reflect {
    public static void main(String[] args) throws Exception{
        /// Reflection allows a program to:
        ///
        /// Inspect classes at runtime
        /// Access methods, fields, constructors
        /// Modify behavior dynamically

        /// Getting Class Info
        Class<?> cls = Student.class;

        System.out.println("Class Name: " + cls.getName() );
        /// Class Name: Day54.Student

        /// Getting Fields
        Field[] fields = cls.getDeclaredFields();

        for (Field f : fields) {
            System.out.println(f.getName());
            /// name
            /// age
        }


        /// Getting Methods
        Method[] methods = cls.getDeclaredMethods();

        for(Method m : methods) {
            System.out.println(m.getName());
           /// sayHello
        }


        /// Invoking a Method

        Object obj = cls.getDeclaredConstructor().newInstance();

        Method method = cls.getMethod("sayHello");

        method.invoke(obj); /// Hello

        /// Accessing Private Fields
        Field field = cls.getDeclaredField("name");
        field.setAccessible(true);

        System.out.println(field.get(obj)); /// Seiju


    }
}
