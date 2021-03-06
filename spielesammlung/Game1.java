import java.util.Random;

/**
 * This class defines the game 'Kruemelmonster'
 * @author TnTGamesTV
 */
public class Game1
{
    private int points, z1, z2, z3; //Defining all integers at once. Tricky thing ;)

    /**
     * Creates a new game of type 'Kruemelmonster'
     * @param points the start cookies of the player
     */
    public Game1(int points){ 
        this.points = points; //Init. of cookies
        this.z1 = -1; //Init. of a random integer
        this.z2 = -1; //Init. of a random integer
        this.z3 = -1; //Init. of a random integer
    }

    /**
     * Generate the (random) integers of the player
     */
    public void random(){ 
        z1 = (int) (Math.random() * 6) + 1; //Generate a random integer
        z2 = (int) (Math.random() * 6) + 1; //Generate a random integer
        z3 = (int) (Math.random() * 6) + 1; //Generate a random integer
    }

    /**
     * Return the cookies (points)
     * @return the cookies (points) of the player
     */
    public int getPoints(){ 
        return this.points; //Return the cookies
    }

    /**
     * Adding the given points to the players amount of cookies
     * @param points the points to add
     */
    public void addPoints(int points){
        this.setPoints(this.getPoints() + points); //Setting the cookies
        if(points > 0){
            System.out.println("Herzlichen Glückwunsch. Du hast " + points + " Kekse gewonnen."); //If the player won something, he will be notified
        }else{
            System.out.println("Schade, du hast keine Kekse gewonnen."); //Well, he got nothin'
        }
    }

    /**
     * Printing the players cookies
     */
    public void printPoints(){
        System.out.println("Keksguthaben: " + this.getPoints());
    }

    /**
     * Printing all (random) integers
     */
    public void printRandom(){
        System.out.println("}============================================================{");
        System.out.println("Deine Zahlen: " + z1 + ", " + z2 + ", " + z3);
        System.out.println("}============================================================{");
    }

    /**
     * set the points
     * @param points the points to set
     */
    public void setPoints(int points){ 
        this.points = points;
    }

    /**
     * Play the game
     * @param items the amount of rounds a user wants to play
     */
    public void play(int times){ 
        for(int i = 0; i < times; i++){ //Run the game n (times) rounds
            System.out.print("\f"); //Clear the screen
            this.points -= 2; //Remove some cookies
            System.out.println("}============================================================{"); //Inform the player about it
            System.out.println("Dir wurden 2 Kekse als Einsatz abgezogen");                       //Inform the player about it
            System.out.println("}============================================================{"); //Inform the player about it
            try{ //Try
                Thread.sleep(2000); //stopping the main thread for 2000 milliseconds (2 seconds)
            }catch(Exception e){ //and catch some exceptiones on your way
                e.printStackTrace(); //and print their stacktrace (See error log)
            }
            random(); //generate the random ints
            logic(); //do all the logic
            try{ //Try
                Thread.sleep(2000); //stopping the main thread for 2000 milliseconds (2 seconds)
            }catch(Exception e){ //and catch some exceptiones on your way
                e.printStackTrace(); //and print their stacktrace (See error log)
            }
        }
    }

    /**
     * This void is handling all the logic
     * <ul>
     * <li>Give the player 4 cookies if his integers are all the same</li>
     * <li>Give the player 2 cookies if two of his integers are the same</li>
     * <li>Give the player 1 cookie if all integers together are between 8 and 12</li>
     * </ul>
     */
    public void logic(){
        int all = z1 + z2 + z3; //Throwing all integers together
        int toAdd = 0; //Some variable init.
        if(z1 == z2 && z2 == z3 && z1 == z3) toAdd += 4; //Case 1
        if(z1 == z2 || z2 == z3 || z1 == z3) toAdd += 2; //Case 2
        if(all >= 8 && all <= 12) toAdd += 1; //Case 3

        printRandom(); //Printing the players integers

        addPoints(toAdd); //Adding cookies the player won

        System.out.println("}============================================================{"); //Informing the player
        this.printPoints();                                                                   //Informing the player
        System.out.println("}============================================================{"); //Informing the player
    }
}
