package Day21;
// Modifier	    Same Class	    Same Package	    Subclass	    Everywhere
// public	    ✅	          ✅	                 ✅	           ✅
// protected	✅	          ✅	                 ✅	           ❌
// default	    ✅	          ✅	                 ❌	           ❌
// private	    ✅	          ❌	                 ❌	           ❌

class Person {
    public String name;
    protected int age;
    private String secret;

    Person(String name, int age, String secret) {
        this.name = name;
        this.age = age;
        this.secret = secret;
    }

    private void showSecret() {
        System.out.println("Secret: " + secret);
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        showSecret();  // allowed inside the same class
    }
}

class Student extends Person {
    Student(String name, int age, String secret) {
        super(name, age, secret);
    }
    
    public void showStudentInfo() {
        System.out.println("Student name: " + name);
        System.out.println("Student age : " + age); // protected is accessible
        // secret is not accesible here
    }
}
public class access {
    public static void main(String[] args) {
        Person p = new Person("Seiju", 18, "Sobrang pogi");
        p.showInfo();

        Student s = new Student("Maria", 19, "Loves Java");
        s.showStudentInfo();

        System.out.println(p.name); // public OK
        // System.out.println(p.secret);  private not accessible
    }
}
