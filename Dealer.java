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
        
        this.deck = new Deck();
        
        this.cardsOnBoard = new ArrayList<Card>();
        this.selectedCardsIndex = new ArrayList<Integer>();
        
        this.cardsSelected = new Card[3];
    }
    public void addedToWorld(World world)
    {
        
    }
    public void dealBoard()
    {
        
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
