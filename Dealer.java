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
    private int numCardsInDeck, triplesRemaining;
    
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
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
        getWorld().showText(String.valueOf(numCardsInDeck),300, 470); // Cards remaining
        getWorld().showText(String.valueOf(score), 300, 505); // Score
    }
    public void endGame()
    {
        
    }
    public boolean checkIfTriple(Card[] cards) {
        if (cards.length == 3) {
            boolean isTriple = cards[0].getValue() == cards[1].getValue() && cards[1].getValue() == cards[2].getValue();
            return isTriple;
        }
        return false;
    }
    public void setCardsSelected(ArrayList<Card> cardsOnBoard, Card[] cardsSelected, ArrayList<Integer> selectedCardsIndex) {
        if (cardsOnBoard.size() == selectedCardsIndex.size()) 
        {
            for (int i = 0; i < selectedCardsIndex.size(); i++) 
            {
                cardsSelected[i] = cardsOnBoard.get(selectedCardsIndex.get(i));
            }
        }
    }
}
