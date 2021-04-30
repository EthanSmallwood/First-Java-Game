package com.company;

public class UserInfo {
    private String username;
    private CharacterClass userClass;
    private int health;

    public void heal(int healthHeal){//heal function
        this.health+=healthHeal;//adds health to current health
    }

    public void setClass(CharacterClass userClass) {//sets health and class
        this.userClass = userClass;//sets class
        this.health = userClass.getHealth();//sets health
    }

    public void setUsername(String username) {
        this.username = username;
    }//sets username

    public String getUsername() {//gets username
        return username;
    }

    public CharacterClass getUserClass() {//gets class
        return userClass;
    }

    public void damageTaken(int damage){
        this.health -=damage;
    }//takes health away

    public int getHealth() {
        return health;
    }//gets health
}
