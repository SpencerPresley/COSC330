package ToeTacTic;

public class Player {
    // private variables
    private char sym;
    private String name;

    public Player(String name, char sym) {
        this.name = name;
        this.sym = sym;
    }

    public char getSym() {
        return sym;
    }

    public String getName() {
        return name;
    }
}
