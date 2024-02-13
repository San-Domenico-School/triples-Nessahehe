import greenfoot.*;

/**
 * Write a description of class Animations here.
 * 
 * @Vanessa Sumski
 * @01/11/2024
 */
public class Animation  
{
    public Animation()
    {
        
    }
    public static void wobble(Card[] cards)
    {
        Greenfoot.playSound("wobble.wav");
    }
    public static void slideAndTurn(Card[] cards)
    {
        Greenfoot.playSound("swoosh.wav");
    }
}