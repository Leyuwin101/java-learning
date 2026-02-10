package Day24;
// Inner Classes can access all members of the outer class ( even private )
// static nested classes cannot access instance members of the outer class
// Used to group related logic and improve encapsulation

class Outer {
    private String message = "Hello from outer class";

    // Inner Class
    class Inner {
        public void showMessage() {
            System.out.println(message); // access outer class private member
        }
    }

    // Static nested class
    static class StaticInner {
        public void show() {
            System.out.println("Hello from Static inner class");
        }
    }
}
public class nest {
    public static void main(String[] args) {
        Outer outer = new Outer();

        // Creating inner class object
        Outer.Inner inner = outer.new Inner();
        inner.showMessage();

        // Creating static nested class object
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.show();
    }
}
