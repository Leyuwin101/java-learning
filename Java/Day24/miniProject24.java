package Day24;
// Create Computer class
class Computer {
    
    // Inner class CPU with method process
    class CPU {
        public void process() {
            System.out.println("I process, Interprets, and executes from software and hardware");
        }
    }

    // Static nested class USB with method connect
    static class USB {
        public void connect() {
            System.out.println("To use me, U need to connect me through the computer");
        }
    }
}
public class miniProject24 {
    public static void main(String[] args) {
        // Access both from main
        Computer computer = new Computer();

        Computer.CPU cpu = computer.new CPU();
        cpu.process();

        Computer.USB usb = new Computer.USB();
        usb.connect();
    }
}
