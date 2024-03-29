import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @Vanessa Sumski
 * @1/8/23
 */


public class Card extends Actor
{
   public enum Shape 
   {
           TRIANGLE, SQUARE, CIRCLE, NO_SHAPE
   }
   public enum Color 
   {
       RED, GREEN, BLUE, NO_COLOR
   }
   
   private Shape shape;
   private Color color;
   public boolean isSelected;
   private GreenfootImage cardImage, selectedCardImage;
   private int numberOfShapes, shading;
   private int value; 
   
   public Card(Shape shape, Color color, int numberOfShapes, int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage) 
   {
       this.shape = shape;
       this.color = color;
       this.numberOfShapes = numberOfShapes;
       this.shading = shading;
       this.cardImage = cardImage;
       this.selectedCardImage = selectedCardImage;
       
       setImage(cardImage);
    }
    public Shape getShape() 
    {
        return shape;
    }
    public Color getColor()
    {
        return color;
    }
    public int getNumberOfShapes()
    {
        return numberOfShapes;
    }
    public int getShading()
    {
        return shading;
    }
    public GreenfootImage getCardImage()
    {
        return cardImage;
    }
    public GreenfootImage getSelectedCardImage()
    {
        return selectedCardImage;
    }
    public boolean getIsSelected()
    {
        return isSelected;
    }
    public void setIsSelected(boolean selected)
    {
        isSelected = selected;
    }
    public Card(int value) 
    {
        this.value = value;
    }
    public int getValue() 
    {
        return value;
    }
}

