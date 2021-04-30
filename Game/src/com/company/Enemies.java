package com.company;

public class Enemies {
    private final int health;
    private final int attack;
    private final String name;

    public Enemies(int health, int attack, String name) {//constructor
        this.health = health;
        this.attack = attack;
        this.name = name;
    }
    public int score() {//gets default score
        return 1;
    }
    public int getAttack() {//gets default attack
        return attack;
    }

    public String getName() {//gets default name
        return name;
    }

    public int getHealth() {//gets default health
        return health;
    }
}

class Slime extends Enemies{
    public Slime() {
        super(25, 5, "Slime");
    }//overrides constructor

    @Override
    public int score() {//gets score
        return 10;
    }

    @Override
    public int getAttack() {//gets attack
        return super.getAttack();
    }

    @Override
    public String getName() {//gets name
        return super.getName();
    }

    @Override
    public int getHealth() {//gets health
        return super.getHealth();
    }
}

class Skeleton extends Enemies{
    public Skeleton() {
        super(50, 10, "Skeleton");
    }//overrides constructor

    @Override
    public int score() {//gets score
        return 20;
    }

    @Override
    public int getAttack() {//gets attack
        return super.getAttack();
    }

    @Override
    public int getHealth() {///gets health
        return super.getHealth();
    }

    @Override
    public String getName() {//gets name
        return super.getName();
    }
}

class Dragon extends Enemies{
    public Dragon() {
        super(175, 25, "Dragon");
    }//overrides constructor

    @Override
    public int score() {//gets score
        return 35;
    }

    @Override
    public int getAttack() {//gets attack
        return super.getAttack();
    }

    @Override
    public int getHealth() {//gets health
        return super.getHealth();
    }

    @Override
    public String getName() {//gets name
        return super.getName();
    }
}

class Goblin extends Enemies{
    public Goblin() {
        super(75, 15, "Goblin");
    }//overrides constructor

    @Override
    public int score() {//gets score
        return 20;
    }

    @Override
    public int getAttack() {//gets attack
        return super.getAttack();
    }

    @Override
    public int getHealth() {//gets health
        return super.getHealth();
    }

    @Override
    public String getName() {//gets name
        return super.getName();
    }
}

class BossGoblinKing extends Enemies{
    public BossGoblinKing() {
        super(200, 30, "GOBLIN KING!!!!");
    }//overrides constructor

    @Override
    public int score() {//gets score
        return 100;
    }

    @Override
    public int getAttack() {//gets attack
        return super.getAttack();
    }

    @Override
    public int getHealth() {//gets health
        return super.getHealth();
    }

    @Override
    public String getName() {//gets name
        return super.getName();
    }
}

class Miklos extends Enemies{

    public Miklos() {
        super(25, 100, "Miklos");
    }
    @Override
    public int score() {//gets score
        return 25;
    }

    @Override
    public int getAttack() {//gets attack
        return super.getAttack();
    }

    @Override
    public int getHealth() {//gets health
        return super.getHealth();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
