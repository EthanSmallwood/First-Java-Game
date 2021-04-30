package com.company;

public class CharacterClass {
    private final int health;
    //potential for mana for mages etc

    public CharacterClass(int health) {//constructor
        this.health = health;//sets health
    }

    public String attackOneName() {//default attack
        return "default attack one";
    }
    public int attackOne(){//default attack
        return 5;
    }
    public String attackTwoName() {//default attack
        return "default attack two";
    }
    public int attackTwo(){//default attack
        return 6;
    }
    public int getHealth() {//gets health
        return health;
    }
}

class Warrior extends CharacterClass{
    public Warrior() {
        super(100);
    }//overrides default health
    @Override
    public int getHealth() {//gets health
        return super.getHealth();
    }


    @Override
    public int attackOne() {// random attack between 1 anf 10
        return (int)(Math.random()*10)+1;
    }

    @Override
    public String attackOneName() {//name of attack
        return "Large swing";
    }

    @Override
    public int attackTwo() {// random attack between 1 anf 5
        return (int)(Math.random()*5)+1;
    }

    @Override
    public String attackTwoName() {//name of attack
        return "Short Swing and gain 4hp";
    }
}//overrides character class with the correct class

class Tank extends CharacterClass{
    public Tank() {
        super(175);
    }//overrides default health

    @Override
    public int getHealth() {
        return super.getHealth();
    }//gets health

    @Override
    public int attackOne() {// random attack between 1 anf 8
        return (int)(Math.random()*8)+1;
    }
    @Override
    public String attackOneName() {//name of attack
        return "Sharp Stab";
    }

    @Override
    public int attackTwo() {// random attack between 1 anf 5
        return (int)(Math.random()*5)+1;
    }
    @Override
    public String attackTwoName() {//attack name
        return "Blunt Stab and gain 4hp";
    }

}//overrides character class with the correct class

