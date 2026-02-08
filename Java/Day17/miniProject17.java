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
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void area() {
        System.out.println(width * height);
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        System.out.println(Math.PI * radius * radius);
    }
}
public class miniProject17 {
    public static void main(String[] args) {
        // use parent reference to store child objects and print areas
        Shape s1 = new Shape();
        Shape s2 = new Rectangle(5, 3);
        Shape s3 = new Circle(1);

        s1.area();
        s2.area();
        s3.area();
    }
}
