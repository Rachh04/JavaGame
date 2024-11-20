import java.util.ArrayList;

public class Player {
    int health;
    ArrayList<String> inventory;

    public Player() {
        health = 100;
        inventory = new ArrayList<>();
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public void usePotion() {
        if (inventory.contains("Potion")) {
            health += 20;
            inventory.remove("Potion");
            System.out.println("You used a Potion! Health: " + health);
        } else {
            System.out.println("You don't have a Potion.");
        }
    }

    public void checkInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory: " + inventory);
        }
    }
}
