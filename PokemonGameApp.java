import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PokemonGameApp {
    
    private static List<Pokemon> myFavoritePokemons = new ArrayList<>();
    
    public static void main(String[] args) {

        // create Scanner object to get user input because we can't use cin like C++...
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to my Simplified Pokemon Game App!");
        System.out.println("Here is where I take all my favorite Pokemon, and fight them to the death.\n");

        // create my favorite Pokemon and put them in my list
        myFavoritePokemons.add(new Pokemon("Jigglypuff",  125, 35));
        myFavoritePokemons.add(new Pokemon("Wigglytuff", 125, 35));
        myFavoritePokemons.add(new Pokemon("Chansey", 125, 35));
        // myFavoritePokemons.add(new Pokemon("Pickachu", 150, 40));
        // myFavoritePokemons.add(new Pokemon("Ditto", 150, 40));
        // myFavoritePokemons.add(new Pokemon("Raichu", 175, 45));
        // myFavoritePokemons.add(new Pokemon("Persian", 175, 45));
        // myFavoritePokemons.add(new Pokemon("Snorlax", 200, 50));
        // myFavoritePokemons.add(new Pokemon("Mew", 200, 50));
        // myFavoritePokemons.add(new Pokemon("Likitung", 200, 50));

        // print status at start of battle
        //printPokemonStatus();

        // simulate a fight between the Pokemons
        System.out.print("Enter your name: ");
        String userName = scan.nextLine(); 
        System.out.println("\nWhile taking a random stroll, " + userName + " stumbles upon a Pokemon gathering.");

        System.out.println("Now...let's start a fight!\n");
        System.out.println("Each pebble you pick up will start a single fight. Be generous.");
        System.out.print("Number of pebbles to pick up: ");
        int numPebbles = scan.nextInt();

        System.out.print("\n" + userName + " slowly picks up " + numPebbles + " pebbles...\n");
        System.out.print("Suddenly - " + userName + " throws all " + numPebbles + " pebbles!\n");
        System.out.print("The pebbles fly out and land on the Pokemon!\n");

        // *************************** UNDER CONSTRCUTION ***********************
        for (int i=0; i<numPebbles; i++){

            // generate a random number to choose a random pokemon from list
            int pokemonIndex = generateRandomIndex();
            Pokemon chosenPokemon = myFavoritePokemons.get(pokemonIndex);

            System.out.print(chosenPokemon.getName()); 
            System.out.print(myFavoritePokemons); 


            System.out.print("\nTUK! Pebble #" + (i+1) + " lands on " + chosenPokemon.getName() + "!\n");

            chosenPokemon.attackOnHp(chosenPokemon);

            // if Pokemon fainted, remove them from list
            if(chosenPokemon.isFainted()){
                myFavoritePokemons.remove(chosenPokemon);
            }

            //delay loop by 3 second - for dramatic purposes
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException interExp){
                Thread.currentThread().interrupt();
            }

            if(myFavoritePokemons.size() == 0){
                System.out.println("Size is 0 now. ");

                break;
            }
            System.out.println("Size: " + myFavoritePokemons.size());

        }







        // *************************** ABOVE CONSTRUCTION ***********************

        // print status at end of battle
        printPokemonStatus();

        finalMessage();

        // close scanner so it can rest in peace
        scan.close();
    }

    private static void printPokemonStatus() {

        int numAllPokemon = Pokemon.getNumPokemon();
        int numPokemonFainted = Pokemon.getFaintedPokemon();
        int numPokemonOkay = numAllPokemon - numPokemonFainted;

        System.out.println("********** Status Update **********");
        System.out.println("Total Pokemon still okay: " + numPokemonOkay);



        System.out.println("Total Pokemon fainted (you monster):" + numPokemonFainted);
        for (Pokemon pkmn: myFavoritePokemons){
            System.out.println(pkmn.getName() + " is still okay!");
        }
        System.out.println("***********************************");
    }

    // method to generate a random number
    private static int generateRandomIndex(){
        int rand = (int)(Math.random()*myFavoritePokemons.size());
        return rand;
    }

    private static void finalMessage() {

        // all Pokemon have fainted
        if(Pokemon.getFaintedPokemon() == Pokemon.getNumPokemon()){
            System.out.println("\nWell. Well. Well. Looks like all the Pokemon have fainted.");
            System.out.println("How do you sleep at night?\n");
        }

        // no Pokemon have fainted
        if(Pokemon.getFaintedPokemon() == 0){
            System.out.println("\n...what do we have here. Not a single Pokemon has fainted.");
            System.out.println("Look who has a heart...better run now...*takes out pebbles*\n");
        }

        System.out.println("\n***********************************");
        System.out.println("     *************************");
        System.out.println("          ***************");
        System.out.println("               *****");
        System.out.println("                 *");
        System.out.println("                Fin.");
    }

}