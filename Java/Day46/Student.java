package Day46;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    public String name;
    public int age;
    // transient Keyword
    transient String password;
    // password will NOT be saved.

    public Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
