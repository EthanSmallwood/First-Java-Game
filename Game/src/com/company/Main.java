package com.company;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();//starts
    }

    public static void mainMenu(){
        System.out.println("""
                \t------------------------------------------
                \t|                Start                   |
                \t|                Quit                    |
                \t------------------------------------------
                """);// main menu

        switch (scanner.nextLine().toLowerCase()) {
            case "start" -> start();//starts game
            case "quit" -> quit();//exits program
            default -> mainMenu();//loops back through until a valid option
        }
    }

    private static void quit() {//exit with thank you note
        System.out.println("Thank you for playing");
        exit(0);
    }

    private static void start() {
        UserInfo userInfo = new UserInfo();//initiates userinfo
        System.out.print("Please enter a username: ");
        String username =scanner.nextLine();//grabs username
        System.out.println("""	
                    ------------------------------------------
                	|               Choose class             |
                	|                                        |
                	|               Warrior                  |
                	|               Tank                     |
                	|               Quit                     |
                	|                                        |
                	------------------------------------------
                """);//shows options for class
        String userClassChoice = null;
        switch (scanner.nextLine().toLowerCase()) {//returns the right class class
            case "mage" -> userClassChoice = "mage";
            case "healer" -> userClassChoice = "healer";
            case "warrior" -> userClassChoice = "warrior";
            case "tank" -> userClassChoice = "tank";
            case "quit" -> quit();
            default -> start();
        }
        assert userClassChoice != null;
        CharacterClass userClass = getClass(userClassChoice);//gets the userClass
        assert userClass != null;
        userInfo.setClass(userClass);//sets the class
        userInfo.setUsername(username);//sets username

        int score =0;//initiates score
        mainGameWindow(userInfo,score);//game starts
    }

    private static void mainGameWindow(UserInfo userInfo,int score) {
        Enemies enemy = getEnemiesForAttack();//gets random enemy
        int enemyHealth = enemy.getHealth();// gets enemy health
        while (enemyHealth > 0) {//loop till enemy is dead
            System.out.println("--------------------------------------------");
            System.out.println(userInfo.getUsername()+"     Current score = "+score);//gets username
            System.out.println("Player health = " + userInfo.getHealth());///user health
            System.out.println("Attack 1: " + userInfo.getUserClass().attackOneName());//user attack one
            System.out.println("Attack 2: " + userInfo.getUserClass().attackTwoName());//user attack two
            System.out.println("""
                    
                    """);
            System.out.println(enemy.getName() + " HP: " + enemyHealth);//shows enemy hp
            System.out.print("Please enter 1 or 2 to attack or type exit: ");//asks for the attack
            String attack = scanner.nextLine();//gets attack
            System.out.println("--------------------------------------------");
            switch (attack.toLowerCase()) {//preforms attack
                case "1" -> {
                    enemyHealth -= userInfo.getUserClass().attackOne();//gets the attack
                    System.out.println("Attack " + attack + " executed.");//outputs which attack happened
                }
                case "2" -> {
                    enemyHealth -= userInfo.getUserClass().attackTwo();//gets attack
                    userInfo.heal(4);//heals for 4
                    System.out.println("Attack " + attack + " executed.");//output which attack happened
                }
                case"exit"->{
                    System.out.println("""
                            
                            """);
                    System.out.println("Score = "+score);//shows score
                    System.out.println("Thanks for playing");//thank you message
                    quit();//quits
                }
                default -> System.out.println("invalid attack. Turn missed");//wrong input you miss a go
            }
            int randomNumber = (int) (Math.random() * 3) + 1; //1 in 3 chance of hitting
            if (randomNumber == 1) {//if the enemy hits or not
                userInfo.damageTaken(enemy.getAttack());//health reduced
                System.out.println(enemy.getAttack() + " damage taken");//displays damage done
                System.out.println("Remaining health: " + userInfo.getHealth());//displays remaining health
            }
            if (userInfo.getHealth() <= 0) {
                System.out.println("""
                                   
                                    YOU HAVE DIED
                                    """);

                System.out.println("Score: " + score);//score output
                System.out.println("Thanks for playing :)");// thank you message
                quit();//you are dead
            }
        }
        System.out.println("Well done on killing "+enemy.getName()+" you get "+enemy.score()+" points.");//well done message
        System.out.println("Healing 20hp");// healing message
        userInfo.heal(20);//heals for 20
        score += enemy.score();//score adding
        mainGameWindow(userInfo, score);

    }

    private static Enemies getEnemiesForAttack() {//gets a random enemy
        int randomNumber = (int)(Math.random()*6)+1;//between 1 and 5
        return new Miklos();
//        return switch (randomNumber) {
//            case 1 -> new Slime();
//            case 2 -> new Dragon();
//            case 3 -> new Skeleton();
//            case 4 -> new Goblin();
//            case 5 -> new BossGoblinKing();
//            case 6 -> new Miklos();
//            default -> null;
//        };
    }

    public static CharacterClass getClass(String userClassChoice) {//easily expandable class system
        switch (userClassChoice) {
            case "warrior" -> {//warrior cass
                return new Warrior();
            }
            case "tank" -> {//tank class
                return new Tank();
            }
            default -> {
                return null;
            }
        }
    }
}
