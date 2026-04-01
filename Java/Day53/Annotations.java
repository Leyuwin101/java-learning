package Day53;

class Animal {
    void sound() {
        System.out.println("Animal makes sounds");
    }
}

class Dog extends Animal {
    ///  @Override tells Java:
    ///  “This method overrides a parent method”
    @Override
    void sound() {
        System.out.println("Woof Woof");
    }
}

class OldSystem {
    /// @Deprecated
    /// Marks a method or class as old / should not be used.
    @Deprecated
    void oldMethod() {
        System.out.println("Old method");
    }
}

///  @FunctionalInterface
/// Ensure only one abstract method
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

///  @SuppressWarnings
/// Tells Java to ignore warnings.
@SuppressWarnings("deprecation")


public class Annotations {
    public static void main(String[] args) {
        /// Annotation	            Purpose
        /// @Override               Ensure method override
        /// @Deprecated             Mark old code
        /// @SuppressWarnings       Ignore warnings
        /// @FunctionalInterface    Ensure only one abstract method



        Animal animal = new Animal();
        animal.sound();
        Dog dog = new Dog();
        dog.sound();

        OldSystem os = new OldSystem();
        os.oldMethod(); /// 'oldMethod()' is deprecated

        ///  Function Interface using lambda
        Greeting greet = (name) -> {
            System.out.println("Hello " + name + "!");
        };

        greet.sayHello("Seiju");

    }
}
