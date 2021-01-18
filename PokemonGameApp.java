import java.util.ArrayList;
import java.util.List;

public class PokemonGameApp {
    
    private static List<Pokemon> myFavoritePokemons = new ArrayList<>();
    
    public static void main(String[] args) {

        System.out.println("Welcome to my Simplified Pokemon Game App!");
        System.out.print("Here is where I take all my favorite Pokemon, and fight them to the death.");

        // create my favorite Pokemon and put them in my list
        myFavoritePokemons.add(new Pokemon("Jigglypuff", "Normal/Fairy", 125, 35));
        myFavoritePokemons.add(new Pokemon("Wigglytuff", "Normal/Fairy", 125, 35));
        myFavoritePokemons.add(new Pokemon("Chansey", "Normal", 125, 35));
        myFavoritePokemons.add(new Pokemon("Pickachu", "Electric", 150, 40));
        myFavoritePokemons.add(new Pokemon("Ditto", "Normal", 150, 40));
        myFavoritePokemons.add(new Pokemon("Raichu", "Electric", 175, 45));
        myFavoritePokemons.add(new Pokemon("Persian", "Normal", 175, 45));
        myFavoritePokemons.add(new Pokemon("Snorlax", "Normal", 200, 50));
        myFavoritePokemons.add(new Pokemon("Mew", "Psychic", 200, 50));
        myFavoritePokemons.add(new Pokemon("Likitung", "Normal", 200, 50));






        String x = "Testing!";
        System.out.println(x);


    }


}
