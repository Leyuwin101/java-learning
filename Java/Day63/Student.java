package Day63;

class Student extends Person {
    private Integer id;
    private Double grade;
    private Course course;
    private Address address;

    public Student(String name, Integer id, Double grade, Course course, Address address) {
        super(name);
        this.id = id;
        this.grade = grade;
        this.course = course;
        this.address = address;
    }


    public String getName() { return name; }
    public Course getCourse() { return course; }

    static class Address {
        String city;

        public Address(String city) { this.city = city; }

        public String getCity() { return city; }
    }

    public String getStudentInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append("===== STUDENT INFO ====\n");
        sb.append("Name: ").append(getName()).append("\n");

        // Handle Safely using ternary operator
        sb.append("ID: ").append(id != null ? id : "N/A").append("\n");
        sb.append("Grade: ").append(grade != null ? grade : "N/A").append("\n");
        sb.append("Course: ").append(course != null ? getCourse() : "N/A").append("\n");
        sb.append("Address: ").append(address != null ? address.getCity() : "N/A").append("\n");

        return sb.toString();
    }

    @Override
    public String toString() {return getStudentInfo();}
}
