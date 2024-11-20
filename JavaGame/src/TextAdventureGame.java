import java.util.Scanner;

public class TextAdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();

        // Room setup
        Room entrance = new Room("You are at the entrance of a mysterious castle.", new String[]{"north"});
        Room forest = new Room("You are in a dense forest. There are paths leading north and south.", new String[]{"north", "south"});
        Room dungeon = new Room("You are in a dark dungeon. It smells damp. There are exits to the east and west.", new String[]{"east", "west"});
        Room treasureRoom = new Room("You are in a room filled with golden treasure!", new String[]{});

        // NPC setup
        NPC oldMan = new NPC("Old Man", "Beware of the monster in the dungeon. Take this potion, it may help.");

        // Enemy setup
        Enemy goblin = new Enemy("Goblin", 50);

        // Game loop
        String currentRoom = "entrance";

        while (true) {
            Room room = null;
            switch (currentRoom) {
                case "entrance":
                    room = entrance;
                    break;
                case "forest":
                    room = forest;
                    break;
                case "dungeon":
                    room = dungeon;
                    break;
                case "treasureRoom":
                    room = treasureRoom;
                    break;
            }

            room.printDescription();

            // Display action options
            displayActions();

            // Get player input
            System.out.println("What do you want to do?");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("go north") && contains(room.exits, "north")) {
                if (currentRoom.equals("entrance")) currentRoom = "forest";
                else if (currentRoom.equals("forest")) currentRoom = "dungeon";
            } else if (command.equals("go south") && contains(room.exits, "south")) {
                if (currentRoom.equals("forest")) currentRoom = "entrance";
            } else if (command.equals("go east") && contains(room.exits, "east")) {
                if (currentRoom.equals("dungeon")) currentRoom = "treasureRoom";
            } else if (command.equals("go west") && contains(room.exits, "west")) {
                if (currentRoom.equals("dungeon")) currentRoom = "forest";
            } else if (command.equals("check inventory")) {
                player.checkInventory();
            } else if (command.equals("use potion")) {
                player.usePotion();
            } else if (command.equals("talk") && currentRoom.equals("forest")) {
                oldMan.talk();
                player.addItem("Potion");
            } else if (command.equals("attack") && currentRoom.equals("dungeon")) {
                goblin.combat(player);
            } else if (command.equals("run") && currentRoom.equals("dungeon")) {
                System.out.println("You ran from the battle.");
                currentRoom = "forest";  // Going back to forest
            } else if (currentRoom.equals("treasureRoom")) {
                System.out.println("Congratulations! You reached the treasure room and won the game!");
                break;
            } else {
                System.out.println("Invalid command or action.");
            }

            if (player.health <= 0) {
                System.out.println("Game Over! You died.");
                break;
            }
        }

        scanner.close();
    }

    // Method to display available actions
    private static void displayActions() {
        System.out.println("\nAvailable actions:");
        System.out.println("1. go north | go south | go east | go west (to move between rooms)");
        System.out.println("2. check inventory (to see items you've collected)");
        System.out.println("3. use potion (to heal with a potion, if you have one)");
        System.out.println("4. talk (to speak with NPCs)");
        System.out.println("5. attack (to fight enemies)");
        System.out.println("6. run (to escape from combat)");
        System.out.println("7. quit (to exit the game)\n");
    }

    private static boolean contains(String[] exits, String exit) {
        for (String s : exits) {
            if (s.equals(exit)) return true;
        }
        return false;
    }
}
