package stotskiy;

/**
 * A class that returns the user's reward for opening
 * regular (common) boxing
 * */
public class CommonBoxResult implements AbstractOpenBox {
    private final String st;

    public CommonBoxResult() {
        int max = 450;
        int min = -100;
        this.st = getLoot((int) (Math.random() * ((max - min) + 1)) + min);
    }

    /**
     * Returns the missing item from the chest
     * @param value - range value
     * @return - thing (loot)
     */
    private String getLoot(int value) {
        return "You fell out:" + switch (value / 150) {
            case 0 -> "A pile of cards";
            case 1 -> "Blunt sword";
            case 2 -> "Holy Blunt Sword";
            default -> "10 GOLD Orens";
        };
    }

    @Override
    public String result() {
        return this.st;
    }
}
