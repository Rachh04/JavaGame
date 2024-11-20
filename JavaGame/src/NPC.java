public class NPC {
    String name;
    String dialogue;

    public NPC(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    public void talk() {
        System.out.println(name + ": " + dialogue);
    }
}
