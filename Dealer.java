import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    private Deck deck;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private Card[] cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        this.triplesRemaining = numCardsInDeck / 3;
        
        this.deck = new Deck(numCardsInDeck);
        
        this.cardsOnBoard = new ArrayList<Card>();
        this.selectedCardsIndex = new ArrayList<Integer>();
        
        this.cardsSelected = new Card[3];
    }
    public void addedToWorld(World world)
    {
        dealBoard();
        setUI();
    }
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
        
        int rows = 5;
        int columns = 3;
        if(deck.getNumCardsInDeck() >= rows * columns)
        { 
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < columns; col++)
            {
                Card topCard = deck.getTopCard();
                
                if (topCard != null)
                {
                    int cardX = col * 60;
                    int cardY = row * 60;
                    
                    getWorld().addObject(topCard, cardX, cardY);
                    cardsOnBoard.add(topCard);
                }
            }
        }
    }
    }
    public void setUI()
    {
        
    }
    public void endGame()
    {
        
    }
    public void checkIfTriple()
    {
        
    }
    public void actionIfTriple()
    {
        
    }
    public void setCardsSelected(ArrayList<Card> cards, ArrayList<Integer> indices, Card[] selectedCards)
    {
        
    }
}
