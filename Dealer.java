import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Dealer deals the cards.
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
    private int numCardsInDeck, triplesRemaining;
    private Scorekeeper scorekeeper;
    private Animation animation;
    
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        this.scorekeeper = new Scorekeeper();
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck(numCardsInDeck);
        cardsSelected = new Card[3];
    }
    public void addedToWorld(World i)
    {
        dealBoard();
        setUI();
    }
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
        
        int marginY = 45;
        int marginX = 73;
        
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 5; column++)
            {
                getWorld().addObject(deck.getTopCard(), marginX + row * 140, marginY + column * 80);
            }
        }
    
    }  
    public void setUI()
    {
        Integer score = new Integer(Scorekeeper.getScore());
        // Display on board
        getWorld().showText(" " + deck.getNumCardsInDeck(), 300, 470); // Cards remaining
        getWorld().showText(" " + Scorekeeper.getScore(), 300, 505); // Score
    }
    public void endGame()
    {
        
    }
    public void checkIfTriple() 
    {
        Card card0 = cardsSelected[0];
        Card card1 = cardsSelected[1];
        Card card2 = cardsSelected[2];
        
        //variable to verify if mod 3 == 0
        boolean cardSides = (card0.getNumberOfShapes() + card1.getNumberOfShapes() + card2.getNumberOfShapes()) % 3 == 0;
        boolean cardShading = (card0.getShading() + card1.getShading() + card2.getShading()) % 3 == 0;
        boolean cardColor = (card0.getColor().ordinal() + card1.getColor().ordinal() + card2.getColor().ordinal()) % 3 == 0;
        boolean cardShape = (card0.getShape().ordinal() + card1.getShape().ordinal() + card2.getShape().ordinal()) % 3 == 0;
        
        if (cardSides && cardShading && cardColor && cardShape)
        {
            actionIfTriple();
        }
        else
        {
            animation.wobble(cardsSelected);
        }
    }
    public void actionIfTriple()
    {
        animation.slideAndTurn(cardsSelected);
        
        for (Card card: cardsSelected)
        {
            int x = card.getX();
            int y = card.getY();
            
            getWorld().removeObject(card);
            cardsOnBoard.remove(card);
            
            Card cardAdded = deck.getTopCard();
            
            if(cardAdded != null)
            {
                cardsOnBoard.add(cardAdded);
                getWorld().addObject(cardAdded, x, y);
            }
        }
        triplesRemaining--;

    // Update the score
    scorekeeper.updateScore();

    // Set the new UI
    setUI();

    // Check if the game is over
    if (triplesRemaining == 0) 
    {
        endGame();
        }
    }
    public void setCardsSelected(ArrayList<Card> cardsOnBoard, Card[] cardsSelected, ArrayList<Integer> selectedCardsIndex) {
        this.cardsOnBoard = cardsOnBoard;
        this.selectedCardsIndex = selectedCardsIndex;
        this.cardsSelected = cardsSelected;
    }
}
