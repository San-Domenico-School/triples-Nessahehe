import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard extends World
{
    public static final int NUM_CARDS_IN_DECK = 81;
    
    public GameBoard()
    {   
    super(430, 600, 1, false); 
    prepareScene();
    }
    private void prepareScene()
    {
        Dealer Dealer = new Dealer(NUM_CARDS_IN_DECK);
        
        addObject(Dealer, -30, -30);
    }
}
