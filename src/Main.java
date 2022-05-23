import java.util.Scanner;
public class Main implements colorInterface
{
    public static void main (String[]args)
    {
        //Setting up Scanner
        Scanner scan = new Scanner(System.in);
        //Variables to use for scanner
        String playerName,nameConfirm,notRightResponse,fightOrRun,itemChoice,fightGremlin;
        //Beginning of adventure
        System.out.println("First before you begin your adventure, What is your name?");
        System.out.print(">");
        //Utilizes Sccanner in the beginning
        playerName = scan.nextLine();
        //Setting up the Users Character name and stats
        playerStats newPlayer = new playerStats(playerName,10,4,5,7,0,0,0,0,0);
        //Confirms if your name is correct
        System.out.println("So your name is " + newPlayer.getPlayerName() + ". Is that right?");
        System.out.println(TEXT_GREEN + "Yes" + TEXT_RESET +" or "+ TEXT_RED + "No" + TEXT_RESET);
        System.out.print(">");
        nameConfirm = scan.nextLine();
        //Variable to make sure you entered a valid option
        boolean unknownOption = true;
        //if statement to check if user entered anything besides yes or no
        if (!nameConfirm.equalsIgnoreCase("Yes") && !nameConfirm.equalsIgnoreCase("No"))
        {
            while (unknownOption == true)
            {
                if (unknownOption == true)
                {
                    System.out.println("That is not a valid option please Enter " + TEXT_GREEN + "Yes" + TEXT_RESET + " or " + TEXT_RED + " No" + TEXT_RESET);
                    System.out.print(">");
                    notRightResponse = scan.next();
                    if (notRightResponse.equalsIgnoreCase("Yes") || notRightResponse.equalsIgnoreCase("No"))
                    {
                        unknownOption = false;
                    }//end of nested if
                    else
                    {
                        unknownOption = true;
                    }//end of nested else
                }//end of nested if
            }//end of while loop
        }//end of if Statement
        //Make boolean placeholder and set it to false until user likes name
        boolean likeName = false;
        //while loop to check if the user is satisfied with their name
        if (nameConfirm.equalsIgnoreCase("Yes")) //Checks if you entered yes
        {
            likeName = true;
        }
        //While loop to make sure you like your name
        while (likeName == false)
        {
            //Checks if user picked no so they can change name
            if(nameConfirm.equalsIgnoreCase("No"))
            {
                System.out.println("What is your name?");
                System.out.print(">");
                playerName = scan.nextLine();
                System.out.println(playerName + " is your desired name?");
                System.out.println(TEXT_GREEN + "Yes" + TEXT_RESET + " or " + TEXT_RED + "No" + TEXT_RESET);
                nameConfirm = scan.nextLine();
                if (nameConfirm.equalsIgnoreCase("Yes"))
                {
                    likeName = true;
                    newPlayer.setPlayerName(playerName);
                }//end of nested if
                else
                {
                    likeName = false;
                }//end of nested else statement
            }//end of if loop
        }//end of while loop
        //Starts story
        //Creating outsider enemy
        enemiesStats homelessMan = new enemiesStats("Outsider",4,5,1,2);
        System.out.println("You suddenly wake up to someone scratching the door."
                +"\nYou don't know who it is but you open the door anyways."
                + "\nYou got jumped by some outsider!!!"
                + "What will you do? Will you " + TEXT_RED + "fight " + TEXT_RESET + "or " + TEXT_GREEN + "run" + TEXT_RESET + "?");
        System.out.print(">");
        fightOrRun = scan.nextLine();
        while(homelessMan.getEnemyHealth() >= 0)
        {
            if (fightOrRun.equalsIgnoreCase("fight"))
            {

                int damageDealt = newPlayer.getAttackDamage() - homelessMan.getEnemyDefense();
                int remainingHP = homelessMan.getEnemyHealth() - damageDealt;
                homelessMan.setEnemyHealth(remainingHP);
                newPlayer.fighting();
                if (homelessMan.getEnemyHealth() <= 0)
                {
                    System.out.println("You dealt " + damageDealt + " damage to the " + homelessMan.getEnemyName() + "!");
                    System.out.println("You knock him down but you are surpised that he is still standing!");
                    System.out.println("What will you do?");
                    System.out.println("Will you " + TEXT_RED + "fight " + TEXT_RESET + "or " + TEXT_GREEN + "run" + TEXT_RESET +"?" );
                    System.out.print(">");
                    fightOrRun = scan.nextLine();
                }
            }
            else if (fightOrRun.equalsIgnoreCase("Run"))
            {
                newPlayer.run();
                System.out.println("You see the outsider creeping towards you slowly");
                System.out.println("Will you " + TEXT_RED + "fight " + TEXT_RESET + "or " + TEXT_GREEN + "run" + TEXT_RESET + "?");
                System.out.print(">");
                fightOrRun = scan.nextLine();
            }

        }
        //Happens after you defeat homeless man
        System.out.println("You defeated the outsider!!");
        System.out.println("After you defeat the outsider you start to run and see a shadowy figure chase you!"
                +"\nYou start to panic and find a shed nearby."
                +"\nYou quickly sprint towards the shed and break the door down"
                +"\nOnce in the shed you see three items, a " + TEXT_RED + "sword" + TEXT_RESET + ", a" + TEXT_BLUE + " dagger" + TEXT_RESET + ", and a " + TEXT_GREEN + "shield" + TEXT_RESET + "."
                +"\nWhich item will you choose?");
        System.out.print(">");
        itemChoice = scan.nextLine();
        //new enemy "gremlin" stats
        //boolean to make sure you die when your hp reaches 0
        boolean playerHealth = false;
        enemiesStats gremlin = new enemiesStats("gremlin",8,2,4,8);
        //making roles so player can choose it
        playerClasses assassinRole = new playerClasses(playerName, newPlayer.getHealth(), newPlayer.getAttackDamage(), newPlayer.getDefense(), newPlayer.getSpeed(), newPlayer.getCurrentBalance(), 4,4,1,1,false,false,false);
        playerClasses swordsmanRole = new playerClasses(playerName, newPlayer.getHealth(), newPlayer.getAttackDamage(), newPlayer.getDefense(), newPlayer.getSpeed(), newPlayer.getCurrentBalance(), 3,3,3,3,false,false,false);
        playerClasses tankRole = new playerClasses(playerName, newPlayer.getHealth(), newPlayer.getAttackDamage(), newPlayer.getDefense(), newPlayer.getSpeed(), newPlayer.getCurrentBalance(), 1,1,4,4,false,false,false);
        if (itemChoice.equalsIgnoreCase("sword"))
        {
            swordsmanRole.setClassSwordsman(true);
            swordsmanRole.setAttackDamage(swordsmanRole.getAttackDamage() + swordsmanRole.getAttackModifier());
            swordsmanRole.setDefense(swordsmanRole.getDefense() + swordsmanRole.getDefenseModifier());
            swordsmanRole.setSpeed(swordsmanRole.getSpeed() + swordsmanRole.getSpeedModifier());
            swordsmanRole.setHealth(swordsmanRole.getHealth() + swordsmanRole.getHealthModifer());
            System.out.println("You pick up the sword and defend yourself with it");
        }
        else if (itemChoice.equalsIgnoreCase("dagger"))
        {
            assassinRole.setClassAssassin(true);
            assassinRole.setSpeed(assassinRole.getSpeed() + assassinRole.getSpeedModifier());
            assassinRole.setAttackDamage(assassinRole.getAttackDamage() + assassinRole.getAttackModifier());
            assassinRole.setHealth(assassinRole.getHealth() + assassinRole.getHealthModifer());
            assassinRole.setDefense(assassinRole.getDefense() + assassinRole.getDefenseModifier());
            System.out.println("You pick up the dagger and start to defend yourself with it.");
        }
        else if(itemChoice.equalsIgnoreCase("shield"))
        {
            tankRole.setClassTank(true);
            tankRole.setHealth(tankRole.getHealth() + tankRole.getHealthModifer());
            tankRole.setDefense(tankRole.getDefense() + tankRole.getHealthModifer());
            tankRole.setAttackDamage(tankRole.getAttackDamage() + tankRole.getAttackModifier());
            System.out.println("You pick up the shield and start to defend yourself with it");
        }
        //boolean to see if you run away
        boolean runAway = false;
        //When you deal more damage than the enemy's defense you insta kill them
        boolean oneShotMechanic = false;
        while (gremlin.getEnemyHealth() > 0 && runAway == false && tankRole.getHealth() > 0 && swordsmanRole.getHealth() > 0 && assassinRole.getHealth() > 0 && oneShotMechanic == false)
        {
            System.out.println("What will you do?");
            System.out.println("Will you " + TEXT_RED + "fight " + TEXT_RESET + "or " + TEXT_GREEN + "run" + TEXT_RESET + "?");
            System.out.print(">");
            fightGremlin = scan.nextLine();
            //Checks if you fight this gremlin
            if (fightGremlin.equalsIgnoreCase("fight"))
            {
                //Variables to use when taking damage
                int enemyDamageDealt;
                int playerDamageDealt;
                int playerRemainingHP;
                int enemyRemaingHP;
                if(tankRole.getClassTank() == true)
                {
                    if (tankRole.getSpeed() > gremlin.getEnemySpeed())
                    {
                        System.out.println("You moved faster than this gremlin and hit him!");
                        //Math for when attacking
                        playerDamageDealt = tankRole.getAttackDamage() - gremlin.getEnemyDefense();
                        enemyRemaingHP = gremlin.getEnemyHealth() - playerDamageDealt;
                        gremlin.setEnemyHealth(enemyRemaingHP);
                        System.out.println("You hit the gremlin for " + TEXT_RED + playerDamageDealt + TEXT_RESET + " damage!");
                        System.out.println("The gremlin has " + TEXT_RED + gremlin.getEnemyHealth() + TEXT_RESET + "HP left!");
                        System.out.println("However the gremlin has hit you back!");
                        //Math for when enemy attacks you
                        enemyDamageDealt = tankRole.getDefense() - gremlin.getEnemyAttack();
                        playerRemainingHP = tankRole.getHealth() - enemyDamageDealt;
                        tankRole.setHealth(playerRemainingHP);
                        System.out.println("You got hit by the gremlin for " + TEXT_RED + enemyDamageDealt + TEXT_RESET + " damage!");
                        System.out.println("You have " + TEXT_RED + tankRole.getHealth() + TEXT_RESET + "HP left");
                    }
                    else if (tankRole.getAttackModifier() < gremlin.getEnemySpeed())
                    {
                        System.out.println("The gremlin speed blitzes you and you get hit");
                        enemyDamageDealt = Math.abs(gremlin.getEnemyAttack() - tankRole.getDefense());
                        playerRemainingHP = tankRole.getHealth() - enemyDamageDealt;
                        tankRole.setHealth(playerRemainingHP);
                        System.out.println("You got hit by the gremlin for " + TEXT_RED + enemyDamageDealt + TEXT_RESET + " damage!");
                        System.out.println("You have " + TEXT_RED + tankRole.getHealth() + TEXT_RESET + "HP left");
                        System.out.println("You start to get annoyed and strike back!");
                        playerDamageDealt = Math.abs(tankRole.getAttackDamage() - gremlin.getEnemyDefense());
                        enemyRemaingHP = gremlin.getEnemyHealth() - playerDamageDealt;
                        gremlin.setEnemyHealth(enemyRemaingHP);
                        System.out.println("You hit the gremlin for " + TEXT_RED + playerDamageDealt + TEXT_RESET + " damage!");
                        System.out.println("The gremlin has " + TEXT_RED + gremlin.getEnemyHealth() + TEXT_RESET + "HP left!");
                        //Warmed up Mechanic for tank
                        System.out.println("You feel like you are warming up and start getting serious! You gained a temporary " + TEXT_RED + "+1 "+ TEXT_RESET + "speed boost");
                        tankRole.setSpeed(tankRole.getSpeed() + 1);
                    }
                }
                else if (swordsmanRole.getClassSwordsman() == true)
                {
                    if (swordsmanRole.getSpeed() > gremlin.getEnemySpeed())
                    {
                        System.out.println("You surpise the gremlin by throwing your sword at him and slashing its back!!");
                        playerDamageDealt = Math.abs(swordsmanRole.getAttackDamage() - gremlin.getEnemyDefense());
                        enemyRemaingHP = gremlin.getEnemyHealth() - playerDamageDealt;
                        gremlin.setEnemyHealth(enemyRemaingHP);
                        System.out.println("You hit the gremlin for " + TEXT_RED + playerDamageDealt + TEXT_RESET + " damage!");
                        System.out.println("The gremlin has " + TEXT_RED + gremlin.getEnemyHealth() + TEXT_RESET + " HP left!");
                        enemyDamageDealt = gremlin.getEnemyAttack() - swordsmanRole.getDefense();
                        playerRemainingHP = swordsmanRole.getHealth() - enemyDamageDealt;
                        swordsmanRole.setHealth(playerRemainingHP);
                        System.out.println("The gremlin gets furious and attacks you for "  +  TEXT_RED + enemyDamageDealt + TEXT_RESET + " damage!");
                        System.out.println("You have " + TEXT_RED + playerRemainingHP + TEXT_RESET + " HP left");
                        //Blood thirsty mechanic for swordsman only
                        System.out.println("You start to feel that you are losing blood! You start to feel an undescribable rage! You temporarily gain " + TEXT_RED + "+2 " + TEXT_RESET + "attack damage");
                        swordsmanRole.setAttackDamage(swordsmanRole.getAttackDamage() + 2);
                    }
                }
                else if (assassinRole.getClassAssassin() == true)
                {
                    if (assassinRole.getSpeed() > gremlin.getEnemySpeed())
                    {
                        playerDamageDealt = assassinRole.getAttackDamage() - gremlin.getEnemyDefense();
                        if (playerDamageDealt > gremlin.getEnemyHealth() || assassinRole.getAttackDamage() > gremlin.getEnemyDefense())
                        {
                            oneShotMechanic = true;
                            System.out.println("You speed blitzed the gremlin and at the same time your dagger pierced his vitals and instantly dies");
                            gremlin.setEnemyHealth(-9999);
                        }
                    }
                    else if (assassinRole.getSpeed() < gremlin.getEnemySpeed())
                    {
                        //This would never happen you completly outspeed and one shot this enemy
                        //But if this does happen this will run
                        enemyDamageDealt = gremlin.getEnemyAttack() - assassinRole.getDefense();
                        System.out.println("The gremlin catches you off guard and does " + TEXT_RED + enemyDamageDealt + TEXT_RESET + " damage!!");
                        playerRemainingHP = assassinRole.getHealth() - enemyDamageDealt;
                        assassinRole.setHealth(playerRemainingHP);
                        System.out.println("You have " + TEXT_RED + assassinRole.getHealth() + TEXT_RESET + " HP left!!" );
                        System.out.println("You get really angry and throw the knife at his head, completly killing this goblin");
                        oneShotMechanic = true;
                    }
                }
            }
            else if(fightGremlin.equalsIgnoreCase("run"))
            {
                tankRole.running();
                System.out.println("You ran to a nearby farm and stopped there");
                runAway = true;
            }//end of else if
        }//end of while loop
        if (runAway == true)
        {
            //Ran away ending
            System.out.println("After running away from this ugly gremlin you started to get really tired");
            System.out.println("You started to feel the fatigue of running away and blacked out");
            System.out.println("To be continued?");
        }
        else if(oneShotMechanic == true)
        {
            //Completly annihiliated that gremlin ending
            System.out.println("After killing that gremlin and coming out victorious unscathed");
            System.out.println("You decided to flee the scence leaving the gremlins corpse behind.");
            System.out.println("You take a rest at a nearby farm and start to sleep");
            System.out.println("To be continued???");
            //Trying out assassin-only mechanic
            oneShotMechanic = false;
            //making Assassin only mechanic reset after every fight
            //Just a reminder if I do continue this project in the future :)
        }
        else if (tankRole.getHealth() <= 0 || assassinRole.getHealth()  <= 0 || swordsmanRole.getHealth() <= 0 && gremlin.getEnemyHealth() <= 0)
        {
            //Both player and gremlin 0 HP
            System.out.println("You both bleed out to death and die");
            System.out.println("However you wake up to someone dragging you");
            System.out.println("To be continued?");
        }
        else if (tankRole.getHealth() <= 0 || assassinRole.getHealth()  <= 0 || swordsmanRole.getHealth() <= 0)
        {
            //Got killed by gremlin ending
            System.out.println("You start to lose a lot of blood from this gremlin");
            System.out.println("You have died from multiple stab wounds the gremlin gave you");
            System.out.println("However you feel a sharp pain from the stab wounds and wake up");
            System.out.println("To be continued??");
        }
        else if (gremlin.getEnemyHealth() <= 0)
        {
            //Defeated gremlin
            System.out.println("With all the hardwork you put in you finished off the gremlin");
            System.out.println("You are heavily wounded and start to black out due to blood losee");
            System.out.println("You wake up to a sound of fire and the smell of food cooking");
            System.out.println("To be continued?");
        }
    }
}
