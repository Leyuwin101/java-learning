package activities;

import java.util.Scanner;

class Character {
    protected String name;
    protected int hp;
    protected int attackPower;

    public Character(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }
    public void attack(Character enemy) {
        int damage = attackPower + (int)(Math.random() * 6) - 3;
        if ( damage < 0 ) damage = 0;

        enemy.hp -= this.attackPower;
        if ( enemy.hp < 0)  enemy.hp = 0;

        System.out.println(this.name + " attacked " + enemy.name + " for " + this.attackPower + " damage!");
    }

    public boolean isAlive() { return hp > 0; }

    public void displayStatus() {
    System.out.println(name + " HP: " + hp);
    }
}

class Player extends Character {
    private int maxHp;

    public Player(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
        this.maxHp = hp;
    }

    public void heal() {
        int healAmount = 20;
        hp += healAmount;

        if ( hp > maxHp) hp = maxHp;

        System.out.println(name + " healed for " + healAmount + " HP!");
    }


}

class Enemy extends Character {

    public Enemy(String name, int hp, int attackPower) { super(name, hp, attackPower); }

    public void specialAttack(Character player) {
        double chance = Math.random();

        if (chance < 0.3) {
            int damage = attackPower * 2;
            player.hp -= damage;
            if ( player.hp < 0) player.hp = 0;

            System.out.println(name + " used Special ATTACK");
            System.out.println(name + " dealt " + damage + " damage!");
        } else {
           attack(player);
        }
    }
}

public class activity9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player player = new Player("Hero", 100, 15);
        Enemy enemy = new Enemy("Goblin", 80, 10);

        System.out.println("Battle Start!!!!");

        while(player.isAlive() && enemy.isAlive()) {

            System.out.println("\n--- STATUS ---");
            player.displayStatus();
            enemy.displayStatus();

            System.out.println("\n1. Attack");
            System.out.println("2. Heal");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                player.attack(enemy);
            } else if (choice == 2) {
                player.heal();
            } else {
                System.out.println("Invalid choice!");
                continue;
            }

            if (enemy.isAlive()) {
                enemy.specialAttack(player);
            }
        }

        System.out.println("\n--- RESULT ---");
        if(player.isAlive()) {System.out.println("Player Won!");}
        else {System.out.println("Enemy won");}

        sc.close();
    }
}
