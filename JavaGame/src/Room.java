public class Room {
    String description;
    String[] exits;

    public Room(String description, String[] exits) {
        this.description = description;
        this.exits = exits;
    }

    public void printDescription() {
        System.out.println(description);
        System.out.print("Exits: ");
        for (String exit : exits) {
            System.out.print(exit + " ");
        }
        System.out.println();
    }
}
