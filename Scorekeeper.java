/**
 * Write a description of class Scorekeeper here.
 * 
 * @Vanessa Sumski
 * @1/11/2024
 */
public class Scorekeeper  
{
    private static final int NUM_CARDS_IN_DECK = 27;
    private static int deckSize;
    private static int score;
    private static long startTime;

    //Initializing startTime with the current system time
    static 
    {
        startTime = System.currentTimeMillis();
    }
    public static void setDeckSize(int newDeckSize)
    {
        deckSize = newDeckSize;
    }
    public static void updateScore()
    {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        
        int timeBonus = (int) (1000 - elapsedTime / 1000);
        
        timeBonus = Math.min(timeBonus, NUM_CARDS_IN_DECK);
        
        score += timeBonus;
    }
    public static int getScore()
    {
        return score;
    }
}
