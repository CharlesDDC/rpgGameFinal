public class playerClasses extends playerStats
{
    private boolean classTank;
    private boolean classSwordsman;
    private boolean classAssassin;
    //constructors
    public playerClasses(String playerName, int health, int attackDamage, int defense, int speed, int currentBalance,int attackModifier ,int speedModifier, int defenseModifier, int healthModifier,boolean classTank, boolean classSwordsman, boolean classAssassin)
    {
        super(playerName, health, attackDamage, defense, speed, currentBalance, attackModifier, speedModifier, defenseModifier, healthModifier);
        this.classTank = classTank;
        this.classSwordsman = classSwordsman;
        this.classAssassin = classAssassin;
    }
    //Getters
    public boolean getClassTank()
    {
        return classTank;
    }

    public boolean getClassSwordsman()
    {
        return classSwordsman;
    }

    public boolean getClassAssassin()
    {
        return classAssassin;
    }

    //Setters
    public void setClassTank(boolean newClassTank)
    {
        classTank = newClassTank;
    }
    public void setClassSwordsman(boolean newClassSwordsman)
    {
        classSwordsman = newClassSwordsman;
    }
    public void setClassAssassin(boolean newClassAssassin)
    {
        classAssassin = newClassAssassin;
    }

    //Brain Method
    public void fighting()
    {
        System.out.println("THWACK");
    }
    public void running()
    {
        System.out.println("You start to run. And you escape successfully!!");
    }
    //Change Player Stats off of what Class the user picked
    //toString
    public String toString()
    {
        String output;
        output = super.toString()
                + "\nClass Tank: "  + classTank
                + "\nClass Swordsman: "  + classSwordsman
                + "\nClass Assassin: " + classAssassin;
        return output;
    }


}
