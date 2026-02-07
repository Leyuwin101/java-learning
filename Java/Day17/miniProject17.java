package Day17;
// Create Shape parent class with area() method
class Shape {
    public void area() {
        System.out.println("All the shape has areas");
    }
}

// Create Rectangle and Circle child classes
// Override area() in each child
class Rectangle extends Shape {
    @Override
    public void area() {
        System.out.println("Rectangle has an area of 1");
    }
}

class Circle extends Shape {
    @Override
    public void area() {
        System.out.println("Circle has an area of 3.14");
    }
}
public class miniProject17 {
    public static void main(String[] args) {
        // use parent reference to store child objects and print areas
        Shape s1 = new Shape();
        Shape s2 = new Rectangle();
        Shape s3 = new Circle();

        s1.area();
        s2.area();
        s3.area();
    }
}
