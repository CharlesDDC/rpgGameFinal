public class enemiesStats
{
    //instance variables
    private String enemyName;
    private int enemyHealth;
    private int enemyAttack;
    private int enemyDefense;
    private int enemySpeed;

    //Constructor
    public enemiesStats(String enemyName, int enemyHealth, int enemyAttack, int enemyDefense,int enemySpeed)
    {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyAttack = enemyAttack;
        this.enemyDefense = enemyDefense;
    }
    //Getters
    public String getEnemyName()
    {
        return enemyName;
    }
    public int getEnemyHealth()
    {
        return enemyHealth;
    }
    public int getEnemyAttack()
    {
        return enemyAttack;
    }
    public int getEnemyDefense()
    {
        return enemyDefense;
    }
    public int getEnemySpeed()
    {
        return enemySpeed;
    }
    //Setter
    public void setEnemyName(String newEnemyName)
    {
        enemyName = newEnemyName;
    }
    public void setEnemyHealth(int newEnemyHealth)
    {
        enemyHealth = newEnemyHealth;
    }
    public void setEnemyAttack(int newEnemyAttack)
    {
        enemyAttack = newEnemyAttack;
    }
    public void setEnemyDefense(int newEnemyDefense)
    {
        enemyDefense = newEnemyDefense;
    }
    public void setEnemySpeed(int newEnemySpeed)
    {
        enemySpeed = newEnemySpeed;
    }
    //toString
    public String toString()
    {
        String output;
        output = "Enemy Stats:"
                + "\nEnemy Health: " + enemyHealth
                + "\nEnemy Attack: " + enemyAttack
                + "\nEnemy Defense: " + enemyDefense
                + "\nEnemy Speed: " + enemySpeed;
        return output;
    }

}
