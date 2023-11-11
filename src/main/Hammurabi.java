package hammurabi;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }
    // How the game is played :

    // 100 people,  2800 bushels of grain, 1000 acres of land, land value is 19 bushels/acre

    // Each year print out summary
    // 10 turns total
    /** O great Hammurabi!
    You are in year 1 of your ten year rule.
    In the previous year 0 people starved to death.
    In the previous year 5 people entered the kingdom.
    The population is now 100.
    We harvested 3000 bushels at 3 bushels per acre.
    Rats destroyed 200 bushels, leaving 2800 bushels in storage.
    The city owns 1000 acres of land.
    Land is currently worth 19 bushels per acre.
    */

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declartions
        int population = 100;
        int bushelsGrain = 2000;
        int acres = 1000;
        int landValue = 19;
        int deaths = 0;
        int price = 0;
        int year = 0;


        System.out.println("How many acres would you like to purchase?: "); // value of acre input

        //Need the method to take in int statements


        // Start of the game
            // - 100 People
            // - 2800 bushels of grain in storage
            // - 1000 acres of land
            // - Land value is 19 bushels/acre
    }
    public int askHowManyAcresToBuy (int price, int bushesl) {
        // ask how many acres to buy
        // if player doesnt have enough to buy acres = return "cannot buy statement"
        // int brushel -> get acres
        // return back acres increased to the original amount
        // if no purchases -> the case of 0 then return the original amount needed

        // need integer response to the question


        return 0;
    }

    public int askHowManyAcresToSell(int acresOwned){
        // must have more acres (# of brushels = 1 acre) than you can own
        // ask how many they want to sell
        // if acresOwned <= acresOfLand able to sell

        //similar to the buy method but subtract the acres
        return 0;
    }

    public int askHowMuchGrainToFeedPeople(int bushels){
        // number need to survive on grain for people
        // you cant feed more grain than you own


        return 0;
    }

    public int askHowManyAcresToPlant (int acresOwned, int population, int bushels){

        // have enough acres, population, and bushels to plant (AND STATEMENTS)
        return 0;
    }
    // for each question do sanity checking, that is test whether the answer is possible and keep asking until you get a possible value
    // at each question, have a restatement of bushels, acres, population left, how people came to the city

    public int plagueDeaths(int population){
        return 0;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople){
        return 0;
    }

    public boolean uprising (int population, int howManyPeopleStarved){
        return false;
    }

    public int immigrants (int population, int acresOwned, int grainInStorage){
        return 0;
    }
    public int harvest (int acres, int bushelsUsedAsSeed) {
        return 0;
    }

    public int grainEatenByRats (int bushels){
        return 0;
    }

    public int newCostOfLand(){
        // new cost of land ranges from 17 to 23
        return 0;
    }

    /**
     * Prints the given message (which should ask the user for some integral
     * quantity), and returns the number entered by the user. If the user's
     * response isn't an integer, the question is repeated until the user
     * does give a integer response.
     *
     * @param message The request to present to the user.
     * @return The user's numeric response.
     */
    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }

}