package Day53;

class Shape {
    void draw() {
        System.out.println("Drawing a generic shape");
    }

    @Deprecated
    public void oldDrawMethod() {
        System.out.println("This is the old draw method (deprecated)");
    }
}

class Circle extends Shape{

    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

public class miniProject53 {
    public static void main(String[] args) {
        /// Create parent class Shape with method draw()
        /// Create child class Circle and override draw()
        /// Add @Override
        /// Create a deprecated method and call it

        Shape shape = new Shape();
        shape.draw();

        Circle circle = new Circle();
        circle.draw();

        shape.oldDrawMethod();
    }
}
