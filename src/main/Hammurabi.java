package hammurabi;
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
        // statements go after the declations
    }
    public int askHowManyAcresToBuy (int price, int bushesl) {
        return 0;
    }

    public int askHowManyAcresToSell(int acresOwned){
        return 0;
    }

    public int askHowMuchGrainToFeedPeople(int bushels){
        return 0;
    }

    public int askHowManyAcresToPlant (int acresOwned, int population, int bushels){
        return 0;
    }
    // for each question do sanity checking, that is test whether the answer is possible and keep asking until you get a possible value

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
        return 0;
    }

}