public class Pokemon {

    private String name;
    private String type;
    private int hp;
    private int attackPoints;

    public Pokemon(String name, String type, int hp, int attackPoints) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attackPoints = attackPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    // method when Pokemon hp < 0
    public boolean isFainted() {
        return(hp < 0);
    }

    public void attackOnHp() {
        if(isFainted()){
            System.out.println(name + "has fainted!");
        }else if(hp == 0){
            System.out.println("Oh no! " + name + " has fainted!");
        }else {
            hp--;
            System.out.println("Poor " + name + " , has been hit!");
        }
    }

    @Override
    public String toString() {
        return name + " has " + hp + " hp left.";
    }

}