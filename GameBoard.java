import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard extends World
{
    public static final int NUM_CARDS_IN_DECK = 27;
    
    public GameBoard()
    {   
    super(430, 600, 1, false); 
    prepareScene();
    }
    public void prepareScene()
    {
        Player player = new Player(dealer);
        Dealer dealer = new Dealer(NUM_CARDS_IN_DECK);
        
        addObject(player, -30, -30);
    }
}
