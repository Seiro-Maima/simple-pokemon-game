public class Pokemon {

    private String name;
    private int hp;

    // number of Pokemon instantiated (created)
    public static int numPokemon = 0;
    // number of fainted Pokemon
    public static int faintedPokemon = 0;

    public Pokemon(String name, int hp) {
        this.name = name;
        this.hp = hp;
        numPokemon++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public static int getNumPokemon() {
        return numPokemon;
    }

    public static int getFaintedPokemon() {
        return faintedPokemon;
    }

    // method when Pokemon hp < 0
    public boolean isFainted() {
        return(hp < 0);
    }

    public void attackOnHp(Pokemon pokemon) {

        int currentHp = pokemon.getHp();
        currentHp = currentHp - 60;
        pokemon.setHp(currentHp);

        if(isFainted()){
            System.out.println( name + " has fainted!\n");
            System.out.println("**Go Pokeball! Caught " + name + "!**");
            faintedPokemon++;
        }else if(hp == 0){
            System.out.println( name + " has fainted!\n");
            System.out.println("**Go Pokeball! Caught " + name + "!**");
        }else {
            hp--;
            System.out.println(name + " has been hit!");
        }
    }

    @Override
    public String toString() {

        int currentHp = getHp();
        // adding +1 since it keeps subtracting -1 from HP (?)
        currentHp = currentHp + 1;
        
        // don't display HP if it's a zero or negative number
        if(getHp() <= 0){
            return "";
        }

        return name + " has " + currentHp + " hp left.";
    }

}