package Day18;
// Abstract classes cannot be instantiated
// Abstract methods have no body
// Use abstract classes when subclasses share structure but differ in behavior

// Abstract parent class
abstract class Shape {
    abstract double area(); // abstract method

    public void display() {
        System.out.println("Calculating area....");
    }
}

// child class
class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return  width * height;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
public class abs {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(5, 4);
        Shape s2 = new Circle(5);

        s1.display();
        System.out.println("Rectangle area: " + s1.area());

        s2.display();
        System.out.println("Circle area: " + s2.area());

    }
}
