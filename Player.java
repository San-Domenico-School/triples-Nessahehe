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
    private GreenfootImage cardImageInstance;
    private GreenfootImage selectedCardImageInstance;
    private boolean isSelected;
    
    
    public Player(Dealer dealer) 
    {
        this.dealer = dealer;
        this.cardImageInstance = cardImageInstance;
        this.selectedCardImageInstance = selectedCardImageInstance;
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
            dealer.setCardsSelected(cardsOnBoard, cardsSelected, selectedCardsIndex);
            dealer.checkIfTriple(cardsSelected);
            resetCardsSelected();
        }
    }
    
    public void selectCards() {
    for (int i = 0; i < cardsOnBoard.size(); i++) {
        Card card = cardsOnBoard.get(i);

        // Check if the card is clicked
        if (Greenfoot.mouseClicked(card)) {
            if (card.isSelected()) {
                // If the card is already selected, deselect it
                card.isSelected = false;
                card.setImage(cardImageInstance); // Set to unselected card image
                selectedCardsIndex.remove(Integer.valueOf(i)); // Remove from selectedCardIndex
            } else {
                // If the card is not selected, select it
                card.isSelected = true;
                card.setImage(selectedCardImageInstance); // Set to selected card image
                selectedCardsIndex.add(i); // Add to selectedCardIndex
            }
        }
    }
    }
    private boolean setCardsSelected() 
    {
    if (selectedCardsIndex.size() == 3) 
    {
        for (int i = 0; i < 3; i++) 
        {
            cardsSelected[i] = cardsOnBoard.get(selectedCardsIndex.get(i));
        }
        return true;
    }
    return false;
    }
    private void resetCardsSelected() 
    {
    for (int i = 0; i < cardsOnBoard.size(); i++) 
    {
        cardsOnBoard.get(i).setImage(originalImages.get(i)); // Restore to original image
        cardsOnBoard.get(i).isSelected = false;
    }
    selectedCardsIndex.clear();
    }
}
