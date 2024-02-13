/**
 * Write a description of class Scorekeeper here.
 * 
 * @Vanessa Sumski
 * @01/11/2024
 */
public class Scorekeeper  
{
    private static final int NUM_CARDS_IN_DECK = 27;
    private static int deckSize;
    public static int score;
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
        score += 35 - (System.currentTimeMillis() - startTime) / 1000 > 5 ? (int) (30 - (System.currentTimeMillis() - startTime) / 1000) : 5;
        startTime = System.currentTimeMillis();
    }
    public static int getScore()
    {
        return score;
    }
}
