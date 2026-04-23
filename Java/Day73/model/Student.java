package Day73.model;

public class Student {
    private String name;
    private String section;
    private int age;

    public Student(String name, String section, int age) {
        this.name = name;
        this.section = section;
        this.age = age;
    }

    public String getName() { return name;}
    public String getSection() { return section; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setSection(String section) { this.section = section; }
    public void setAge(int age) { this.age = age; }

}
