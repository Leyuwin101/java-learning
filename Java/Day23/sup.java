package Day23;

// super = parent object
// Must be the first line when calling parent constructor
// Used when child overrides a parent method
// this → current class, super → parent class

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Name: " + name);
    }
}

class Student extends Person {
    public int id;

    public Student(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Student Id: " + id);
    }
}
public class sup {
    public static void main(String[] args) {
        Person p = new Person("John");
        p.display();
        Student s = new Student("Maria", 101);
        s.display();
    }
}