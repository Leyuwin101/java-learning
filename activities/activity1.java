package activities;

// 1. Create a class name ITAccount with these ATTRIBUTES, name, user, age, password AND APPLY encapulation
// 2. In class declare 3 virtual methods
// 2.1 void addUser(4 parameters)
// 2.2 bool authenticate(2 parameters)
// 2.3 void showInfo()
// 3. Create a classe name ITManager, APPLY INHERITANCE AND POLYMORPHISM METHOD OVERRIDING
// 4. in main class, implement the registration and login inputs and call the needed methods

class ITAccount {
    private String name;
    private String username;
    private int age;
    private String password;

    public ITAccount() {}

    public ITAccount(String name, String username, int age, String password) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public String getName() { return name; }
    public String getUsername() { return username; }
    public int getAge() { return age; }
    public String getPassword() { return password; }


    public void addUser(String name, String username, int age, String password) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        if (inputUsername == null || inputPassword == null || inputPassword.length() < 6)
            return false;

        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void showInfo() {
        System.out.println("==================================");
        System.out.println("Name: " + getName());
        System.out.println("Username: " + getUsername());
        System.out.println("Age: " + getAge());
        System.out.println("Password: " + getPassword());
    }
}

class ITManager extends ITAccount {
    String work;
    
    public ITManager (String name, String username, int age, String password, String work) {
        super(name, username, age, password);
        this.work = work;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Work: " + work);
    }
}


public class activity1 {
    public static void main(String[] args) {
        ITAccount a1 = new ITAccount("Seiju", "Seijuhajime", 18, "SeijuKo");
        ITAccount a2 = new ITManager("Hajime", "HajimeBato", 28, "HAHA", "Manager");
        ITAccount a3 = new ITAccount();
        a3.addUser("Kenshin", "KenshinHimura", 30, "KenshinPogi");

        a1.showInfo();
        a2.showInfo();
        a3.showInfo();

        if (a1.authenticate("Seijuhajime", "SeijuKo")) {
            System.out.println("Login Succesful");
        } else {
            System.out.println("Login Failed");
        }

        if (a2.authenticate("HajimeBato", "HAHA")) {
            System.out.println("Login Succesful");
        } else {
            System.out.println("Login Failed");
        }
    }
}
