public class Pokemon {

    private String name;
    private int hp;
    private int attackPoints;

    // number of Pokemon instantiated (created)
    public static int numPokemon = 0;
    // number of fainted Pokemon
    public static int faintedPokemon = 0;

    public Pokemon(String name, int hp, int attackPoints) {
        this.name = name;
        this.hp = hp;
        this.attackPoints = attackPoints;
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

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
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
        currentHp = currentHp - 50;
        pokemon.setHp(currentHp);

        if(isFainted()){
            System.out.println("\nOH MY GOD! What is WRONG with you?! " + name + " has fainted!\n");
            faintedPokemon++;
        }else if(hp == 0){
            System.out.println("\nOH MY GOD! What is WRONG with you?! " + name + " has fainted!\n");
        }else {
            hp--;
            System.out.println("\nPoor " + name + ", has been hit!\n");
        }
    }

    @Override
    public String toString() {
        return name + " has " + hp + " hp left.";
    }

}