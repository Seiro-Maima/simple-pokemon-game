import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PokemonGameApp {
    
    private static List<Pokemon> listOfPokemons = new ArrayList<>();
    
    public static void main(String[] args) {

        // create Scanner object to get user input because we can't use cin like C++...
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWelcome to my Simplified Pokemon Game App!");
        System.out.println("Here is where I take some of my favorite Pokemon, and set a Charizard to attack them.\n");

        // create my favorite Pokemon and put them in my list
        listOfPokemons.add(new Pokemon("Jigglypuff",  125));
        listOfPokemons.add(new Pokemon("Pickachu", 150));
        listOfPokemons.add(new Pokemon("Raichu", 175));
        listOfPokemons.add(new Pokemon("Persian", 175));
        listOfPokemons.add(new Pokemon("Snorlax", 200));
        listOfPokemons.add(new Pokemon("Mew", 200));

        // simulate a fight between the Pokemons
        System.out.print("\nEnter your name: ");
        String userName = scan.nextLine(); 
        System.out.println("\nWhile taking a random stroll, " + userName + " stumbles upon a Pokemon gathering.");

        System.out.println("Oh..how nice...GO CHARIZARD! DRAGON BREATH!\n");
        System.out.print("How many times should Charizard attack? ");
        int numAttacks = scan.nextInt();

        for (int i=0; i<numAttacks; i++){

            // generate a random number to choose a random pokemon from list
            int pokemonIndex = generateRandomIndex();
            Pokemon chosenPokemon = listOfPokemons.get(pokemonIndex);

            System.out.print("\nAttack " + (i+1) + " of " + numAttacks + " lands!\n");

            chosenPokemon.attackOnHp(chosenPokemon);
            System.out.println(chosenPokemon.toString());

            // if Pokemon fainted, remove them from list
            if(chosenPokemon.isFainted()){
                listOfPokemons.remove(chosenPokemon);
            }

            // delay loop by 4 second - for dramatic purposes
            try{
                TimeUnit.SECONDS.sleep(4);
            }catch (InterruptedException interExp){
                Thread.currentThread().interrupt();
            }

            // if there are no more Pokemon in the List, end game
            if(listOfPokemons.size() == 0){
                break;
            }
            
        }

        // if there are still pokemon in the List, they will escape
        if(listOfPokemons.size() > 0){
            System.out.println("\nThe rest of the Pokemon escape!\n");
        }

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

        System.out.println("\n********** Status Update **********");
        System.out.println("Total Pokemon escaped: " + numPokemonOkay);

        System.out.println("Total Pokemon caught: " + numPokemonFainted);
        System.out.println("***********************************\n");
    }

    // method to generate a random number
    private static int generateRandomIndex(){
        int rand = (int)(Math.random()*listOfPokemons.size());
        return rand;
    }

    private static void finalMessage() {

        // all Pokemon have fainted
        if(Pokemon.getFaintedPokemon() == Pokemon.getNumPokemon()){
            System.out.println("\nWell. Well. Well. Looks like all the Pokemon have fainted.");
            System.out.println("I guess you did catch them all huh?\n");
        }

        // no Pokemon have fainted
        if(Pokemon.getFaintedPokemon() == 0){
            System.out.println("\n...what do we have here. Not a single Pokemon has fainted.");
            System.out.println("Looks like it's just you and Charizard back on the road.\n");
        }

        System.out.println("            [Fin]");
    }

}