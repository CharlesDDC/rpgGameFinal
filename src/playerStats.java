public class playerStats
{
    //Instance Variables
    private String playerName;
    private int health;
    private int attackDamage;
    private int defense;
    private int speed;
    private int currentBalance;
    private int attackModifier;
    private int speedModifier;
    private int defenseModifier;
    private int healthModifer;

    //Constructor
    public playerStats(String playerName, int health, int attackDamage, int defense, int speed, int currentBalance,int attackModifier, int speedModifier, int defenseModifier, int healthModifer)
    {
        this.playerName = playerName;
        this.health = health;
        this.attackDamage = attackDamage;
        this.defense = defense;
        this.speed = speed;
        this.currentBalance = currentBalance;
        this.attackModifier = attackModifier;
        this.speedModifier = speedModifier;
        this.defenseModifier = defenseModifier;
        this.healthModifer = healthModifer;
    }

    //Getters
    public String getPlayerName()
    {
        return playerName;
    }
    public int getHealth()
    {
        return health;
    }
    public int getAttackDamage()
    {
        return attackDamage;
    }
    public int getDefense()
    {
        return defense;
    }
    public int getSpeed()
    {
        return speed;
    }
    public int getCurrentBalance()
    {
        return currentBalance;
    }
    public int getAttackModifier()
    {
        return attackModifier;
    }
    public int getSpeedModifier()
    {
        return speedModifier;
    }
    public int getDefenseModifier()
    {
        return defenseModifier;
    }
    public int getHealthModifer()
    {
        return healthModifer;
    }
    //Setters
    public void setPlayerName(String newPlayerName)
    {
        playerName = newPlayerName;
    }
    public void setHealth(int newHealth)
    {
        health = newHealth;
    }

    public void setAttackDamage(int newAttackDamage)
    {
        attackDamage = newAttackDamage;
    }

    public void setDefense(int newDefense)
    {
        defense = newDefense;
    }

    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }

    public void setCurrentBalance(int newCurrentBalance)
    {
        currentBalance = newCurrentBalance;
    }

    public void setAttackModifier(int newAttackModifier)
    {
        attackModifier =newAttackModifier;
    }
    public void setSpeedModifier(int newSpeedModifier)
    {
        speedModifier = newSpeedModifier;
    }
    public void setDefenseModifier(int newDefenseModifier)
    {
        defenseModifier = newDefenseModifier;
    }
    public void setHealthModifer(int newHealthModifier)
    {
        healthModifer = newHealthModifier;
    }
    //Brain Methods
    public void fighting()
    {
        System.out.println("SMACK");
    }
    public void run()
    {
        System.out.println("You run as fast as you can. But... you trip and fall");
    }
    //toString
    public String toString()
    {
        String output;
        output = "Player Stats: "
                + "\nPlayer Name: " + playerName
                + "\nPlayer Health: " + health
                + "\nPlayer Attack Damage: " + attackDamage
                + "\nPlayer Defense: " + defense
                + "\nPlayer Speed: " + speed
                + "\nTotal Balance: " + currentBalance;
        return output;
    }
}
