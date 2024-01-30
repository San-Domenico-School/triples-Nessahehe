import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private Dealer dealer;
    private Card[] cardsSelected;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private ArrayList<GreenfootImage> originalImages;
    
    public Player(Dealer dealer)
    {
        this.dealer = dealer;
        cardsSelected = new Card[3];
        cardsOnBoard = new ArrayList<Card>();
        selectedCardsIndex = new ArrayList<Integer>();
        originalImages = new ArrayList<GreenfootImage>();
    }
    public void addedToWorld(World world)
    {
        cardsOnBoard = (ArrayList<Card>) getWorld().getObjects(Card.class);
    
        for (Card card : cardsOnBoard) 
        {
            originalImages.add(card.getImage());
        }
    }
    public void act()
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        if (threeCardsHaveBeenSelected)
        {
            dealer.checkIfTriple(cardsSelected);
            resetCardsSelected();
        }
    }

    public void selectCards() 
    {
    for (int i = 0; i < cardsOnBoard.size(); i++) 
    {
        Card card = cardsOnBoard.get(i);
        GreenfootImage originalImage = originalImages.get(i);

        if (Greenfoot.mouseClicked(card)) 
        {
            if (card.isSelected()) 
            {
                // If the card is already selected
                card.setIsSelected(false);
                card.setImage(originalImage);  // Restore to unselected card image
                selectedCardsIndex.remove(selectedCardsIndex.indexOf(i));
            } 
            else
                    card.setIsSelected(true);
                    card.setImage(originalImage);
                    selectedCardsIndex.add(i);
                }
            }
        }
    private boolean setCardsSelected() 
    {
        if (selectedCardsIndex.size() == 3) {
            for (int i = 0; i < 3; i++) {
                cardsSelected[i] = cardsOnBoard.get(selectedCardsIndex.get(i));
            }
            return true;
        }
        return false;
    }
    private void resetCardsSelected() 
    {
        for (int i = 0; i < cardsOnBoard.size(); i++) {
            cardsOnBoard.get(i).setImage(originalImages.get(i)); // Restore to original image
            cardsOnBoard.get(i).setIsSelected(false);
        }
        selectedCardsIndex.clear();
    }
}
