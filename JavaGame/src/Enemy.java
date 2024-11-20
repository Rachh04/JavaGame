import java.util.Scanner;

public class Enemy {
    String name;
    int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void attack(Player player) {
        int damage = (int) (Math.random() * 20) + 5;
        player.health -= damage;
        System.out.println(name + " attacks! You take " + damage + " damage. Your health: " + player.health);
    }

    public void combat(Player player) {
        System.out.println("You are fighting " + name + "!");
        while (player.health > 0 && health > 0) {
            System.out.println("What do you want to do? (Attack/Run)");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine().toLowerCase();
            if (action.equals("attack")) {
                int damage = (int) (Math.random() * 20) + 10;
                health -= damage;
                System.out.println("You attack! " + name + " takes " + damage + " damage.");
                System.out.println(name + " health: " + health);
                if (health <= 0) {
                    System.out.println("You defeated " + name + "!");
                    break;
                }
                attack(player);
            } else if (action.equals("run")) {
                System.out.println("You ran away!");
                break;
            }
        }
        if (player.health <= 0) {
            System.out.println("Game Over! You died.");
            System.exit(0);
        }
    }
}
