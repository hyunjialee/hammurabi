package hammurabi.docs.matuszek;
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
        int bushels = 2800;
        int acresOwned = 1000;
        int deaths = 0;
        int price = 19;
        int year = 1;
        int immigrant = 5;
        int bushelsPerAcre = 3;
        int ratDestory = 200;


        while (year <= 10) {
            System.out.println(printSummary(year,  deaths,  immigrant,  population,  bushels,  bushelsPerAcre,  ratDestory,  acresOwned,  price));



            // if player buys -> do not sell
            // else if player doesnt buy -> sell

            int acresBought = askHowManyAcresToBuy(price, bushels);
            acresOwned += acresBought;
            bushels -= acresBought * price;


            if (acresBought == 0) {
                int soldAcres = askHowManyAcresToSell(acresOwned);
                acresOwned -= soldAcres;
                bushels += soldAcres * price;
            }

            int bushelsUsedToFeed = askHowMuchGrainToFeedPeople(bushels);
            bushels -= bushelsUsedToFeed;

            int plantedAcres = askHowManyAcresToPlant(acresOwned, population, bushels);

            int plagueDeaths = plagueDeaths(population);
            System.out.println("\n" + plagueDeaths + " have died from the plague.");

            int starvedDeaths = starvationDeaths(population, bushelsUsedToFeed);;

            System.out.println("\n"+ starvedDeaths + " have died from starvation.");

            if (uprising(population, starvedDeaths)){
                System.out.println("\nAN UPRISING IS HAPPENING, GOODBYE RULER\n");
                break;
            }
            deaths = starvedDeaths + plagueDeaths;
            population -= deaths;

            if (starvedDeaths == 0){
                immigrant = immigrants(population, acresOwned, bushels);
                population +=  immigrant;
                System.out.println("\n" + immigrant + "have came into the city!\n");
            }

            int bushelsHarvested= harvest(plantedAcres);
            bushels += bushelsHarvested;

            System.out.println("\n" + bushelsHarvested + " bushels have been harvested.\n");

            ratDestory = grainEatenByRats(bushels);

            System.out.println("\n" + ratDestory + " bushels have been eaten by rats. \n");
            bushels -= ratDestory;




            System.out.println(printSummary(year,  deaths,  immigrant,  population,  bushels,  bushelsPerAcre,  ratDestory,  acresOwned,  price));




            price = newCostOfLand();

            System.out.println("\nThe new price for land next year is " + price);

            System.out.println("\n======================================================\n======================================================\n======================================================\n");


            // Generates new price of the year 17-23 price
            year++;
        }

        System.out.println(finalSummary(year,  deaths,  immigrant,  population,  bushels,  bushelsPerAcre,  ratDestory,  acresOwned,  price));
        // This goes at the end of the loop




        // Start of the game
            // - 100 People
            // - 2800 bushels of grain in storage
            // - 1000 acres of land
            // - Land value is 19 bushels/acre
    }
    public int askHowManyAcresToBuy (int price, int bushels) {
        // ask how many acres to buy
        // if player doesnt have enough to buy acres = return "cannot buy statement"
        // int brushel -> get acres
        // return back acres increased to the original amount
        // if no purchases -> the case of 0 then return the original amount needed;
        int acresToBuy = 0;

        int totalAmountOfBushels = Integer.MAX_VALUE;

        while (totalAmountOfBushels > bushels){
            acresToBuy = getNumber("\nHow many acres would you like to purchase? ");

            totalAmountOfBushels = acresToBuy * price;

            if (totalAmountOfBushels > bushels) {
                System.out.println("The amount is too large! You have " + bushels + " bushels, but you are trying to purchase " + totalAmountOfBushels + " bushels\n");
            }


//            if (totalAmountOfBushels > bushels){
//                System.out.println("You do not have enough bushels. You only have " + bushels + ". This costs " + totalAmountOfBushels);
//            }  THIS IS EXTRA STATEMENT -----------------
        }
        return acresToBuy;
    }

    public int askHowManyAcresToSell(int acresOwned){
        // must have more acres (# of brushels = 1 acre) than you can own
        // ask how many they want to sell
        // if acresOwned <= acresOfLand able to sell

        int acresToSell = Integer.MAX_VALUE;

        while (acresOwned < acresToSell) {
            acresToSell = getNumber("How many acres would you like to sell? ");

            if(acresOwned < acresToSell) {
                System.out.println("The amount is too large. You have " + acresOwned + " acres. You cannot sell " + acresToSell + " acres.\n");
            }

        }

        //similar to the buy method but subtract the acres
        return acresToSell;
    }

    public int askHowMuchGrainToFeedPeople(int bushels){

        int grains = Integer.MAX_VALUE;

        while (grains > bushels) {
            grains = getNumber("How many grains do you want to use to feed your population? ");

            if (grains > bushels){
                System.out.println("You do not have enough bushels to feed your people. \nCurrent bushels: " + bushels + "\n How much bushels you want to feed: " + grains);
            }
        }
        // number need to survive on grain for people
        // you cant feed more grain than you own

        return grains;
    }

    public int askHowManyAcresToPlant (int acresOwned, int population, int bushels){

        int acresToPlant = Integer.MAX_VALUE;

        while (acresToPlant > acresOwned) {
            acresToPlant = getNumber("How many acres would you like to plant? ");


            if (acresToPlant * 2 > bushels && population * 10  < acresToPlant){
                System.out.println("\nYou are planting more than you own. \n Acres Owned: " + acresOwned + ".\n Acres needed: " + acresToPlant);

                System.out.println("\n Current Population: " + population + ".\n Population needed: " + acresToPlant/10);

                System.out.println("\n Current Bushels: " + bushels + "\n Bushels needed: " + acresToPlant/2 + "\n");

                acresToPlant = Integer.MAX_VALUE;
            }

        }
        return acresToPlant;

        // each person can farm 10 acres
        // it takes 2 bushels -> 1 acre
        // have enough acres, population, and bushels to plant (AND STATEMENTS)
    }

    public int plagueDeaths(int population){

        if (rand.nextInt(100) < 15) {
            return population / 2;
        }
        return 0;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople){
        int totalBushelsNeeded;
        int totalDed = 0;
        totalBushelsNeeded = population * 20;

        if (bushelsFedToPeople < totalBushelsNeeded){
            totalDed = population - (bushelsFedToPeople / 20);
        }


        return totalDed;
    }

    public boolean uprising (int population, int howManyPeopleStarved){

        return howManyPeopleStarved > (population * .45);
    }

    public int immigrants (int population, int acresOwned, int grainInStorage){
        return ((20 * acresOwned + grainInStorage)/ (100 * population)) + 1;
    }

//    public int  harvest (int acres, int bushelsUsedAsSeed)
    // THIS WAS IN THE README BUT THE TEST CASE TAKES IN ONE PARAMETER.....
    public int  harvest (int acres) {
        int x = rand.nextInt(6 ) + 1;

        return acres * x;
    }

    public int grainEatenByRats (int bushels){
        int grainsEaten = (rand.nextInt(30 - 10 + 1) + 10);

        if (rand.nextInt(100) < 40) {
             return bushels * grainsEaten / 100;
        }
        return 0;
    }

    public int newCostOfLand(){
        return rand.nextInt(23 - 17 + 1) + 17;
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

    public String printSummary(int year, int deaths, int immigrant, int population, int bushels, int bushelsPerAcre, int ratDestory, int acresOwned, int price){
        return "O great Hammurabi!\n" +
                "    You are in year " + year + " of your ten year rule.\n" +
                "    In the previous year " + deaths + " people starved to death.\n" +
                "    In the previous year " + immigrant + " people entered the kingdom.\n" +
                "    The population is now " + population + ".\n" +
                "    We harvested " + bushels + " bushels at " + bushelsPerAcre + " bushels per acre.\n" +
                "    Rats destroyed " + ratDestory + " bushels, leaving " + bushels + " bushels in storage.\n" +
                "    The city owns " + acresOwned + " acres of land.\n" +
                "    Land is currently worth " + price + " bushels per acre.";
    }

    public String finalSummary (int year, int deaths, int immigrant, int population, int bushels, int bushelsPerAcre, int ratDestory, int acresOwned, int price){
                if (deaths >= population * .66 || acresOwned/population >= 7) {
                    return "\nYou have been impeached and thrown out of office for letting your people starve";
                } else if (deaths >= population * .90 || acresOwned/population >= 9) {
                    return "\nYou have completed a Heavy-handed performance";
                } else if (deaths >= population * .97 || acresOwned/population >= 10){
                    return "\nYour performance could have been better";
                } else
                    return "\nO great Hammurabi! You have completed the game.\n" +
                            "    You are in year " + year + " of your ten year rule.\n" +
                            "    In the previous year" + deaths + " people starved to death.\n" +
                            "    In the previous year " + immigrant + " people entered the kingdom.\n" +
                            "    The population is now " + population + ".\n" +
                            "    We harvested " + bushels + " bushels at " + bushelsPerAcre + " bushels per acre.\n" +
                            "    Rats destroyed " + ratDestory + " bushels, leaving " + bushels + " bushels in storage.\n" +
                            "    The city owns " + acresOwned + " acres of land.\n" +
                            "    Land is currently worth " + price + " bushels per acre.\n" +
                            " =============================================================================\n";
    }
}