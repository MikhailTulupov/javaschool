package stotskiy;

import java.util.Random;
import java.util.stream.IntStream;

/**
 *A class that returns the user's reward for opening
 * rare boxing
 * */
public class RareBoxResult implements AbstractOpenBox {
    private final String rt;
    public int backspin;

    /**
     * @param backspin -the value increases the chance of a rare drop
     * */
    public RareBoxResult(int backspin){
        this.backspin = backspin;
        this.rt = getLoot(generate());
    }


    /**
     * Method of generating a random number
     * @return - a number for further loot selection
     * */
    private int generate(){
        Random random = new Random();
        int[] number = new int[] {1,2,3,4,5};
        int[] chance = new int[] {100,100 - backspin/2,100 - backspin /3,100 - backspin/4,100- backspin/5};
        int count = IntStream.of(chance).sum();

        int index = random.nextInt(count);

        for (int i = 0; i < chance.length; i++) {
            index -=chance[i];
            if(index < 0){
                return number[i];
            }
        }
        return 5;
    }

    /**
     * Returns the missing item from the chest
     * @param val -the value of the random number that fell out
     * @return - thing (loot)
     * */
    private String getLoot(int val){
       return "You fell out:" + switch (val){
            case 1 -> "Sword of the Horseman of the Apocalypse";
            case 2 -> "The Skull Crasher";
            case 3 -> "A sharpened sword";
            case 4 -> "Ply a blunt sword";
            default -> "50 GOLD Orens";
        };
    }

    @Override
    public String result() {
        return this.rt;
    }
}
