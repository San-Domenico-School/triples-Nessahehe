import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @Vanessa Sumski
 * @1/8/23
 */


public class Card extends Actor
{
   public enum Shape {
       SQUARE, CIRCLE, TRIANGLE
   }
   public enum Color {
       RED, GREEN, BLUE
   }
   
   private Shape shape;
   private Color color;
   private boolean isSelected;
   private GreenfootImage cardImage, selectedCardImage;
   private int numberOfShapes, shading;
   
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
    public void setIsSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }
}

