import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dealer here.
 * 
 * @Vanessa Sumski 
 * @01/25/24
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
        
        int xOffset = 5;
        int yOffset = 5;
        int rowSpacing = 10;
        int colSpacing = 30;
        
        for (int row = 0; row < 5; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                Card topCard = deck.getTopCard();
                if (topCard != null) {
                Card dealtCard = new Card(topCard);
                GameBoard world = (GameBoard) getWorld();
                world.addObject(dealtCard, xOffset + col * colSpacing, yOffset + row * rowSpacing);
            }
                }
        }
    }
    public void setUI()
    {
        int cardsRemaining = deck.getNumCardsInDeck();
        int currentScore = calculateScore();
        
        // Convert values to String
        String cardsRemainingStr = Integer.toString(cardsRemaining);
        String currentScoreStr = Integer.toString(currentScore);
        
        // Display on board
        getWorld().showText(cardsRemainingStr,300, 470); // Cards remaining
        getWorld().showText(currentScoreStr, 300, 505); // Score
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
    private int calculateScore()
    {
        return 0;
    }
}
