/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
  }
    /**
   * Method to blur a picture (minus the borders)
   */
  public void blurPicture(int pixelBlur){
    Pixel pixelObj = null;
    Pixel targetPixel = null;
    //Create new blank picture same size as object picture
    Picture pictureCopy = new Picture(this.getWidth(),this.getHeight());
    for (int x = 0; x < this.getWidth(); x++) {
      for (int y = 0; y < this.getHeight(); y++) {
        pixelObj = this.getPixel(x,y);
        targetPixel=pictureCopy.getPixel(x,y);
        //Set every pixel in the blank picture to the same as the object picture
        targetPixel.setColor(pixelObj.getColor());
      } 
    }
    //Second loop for being able to blur images
    for (int x = pixelBlur; x < this.getWidth()-pixelBlur; x++) {
      for (int y = pixelBlur; y < this.getHeight()-pixelBlur; y++) {
        //Counter to calculate number of pixels counted for "average pixel"
        int ccounter =0;
        //Initializes or resets variables to keep track of average pixel numerator
        int totalRed=0, totalGreen=0, totalBlue =0;
        //Initializes or resets variables for averages RGB values
        int avgRed=0, avgGreen=0, avgBlue=0;
        //Loop to average RGB values of pixels in an area, excluding borders because of bound limits
        for (int i=-pixelBlur; i<=pixelBlur; i++){
          for (int j=-pixelBlur; j<=pixelBlur; j++){
            targetPixel=pictureCopy.getPixel(x+i,y+j);
            //Calculates numerators for average calculation
            totalRed= totalRed+targetPixel.getRed();
            totalGreen= totalGreen+targetPixel.getGreen();
            totalBlue= totalBlue+targetPixel.getBlue();
            ccounter++;
          }
        }
        //Calculates average RGB values
        avgRed=totalRed/ccounter;
        avgGreen=totalGreen/ccounter;
        avgBlue=totalBlue/ccounter;
        //Copies over average RGB values
        pixelObj = this.getPixel(x,y);
        pixelObj.setRed(avgRed);
        pixelObj.setBlue(avgBlue);
        pixelObj.setGreen(avgGreen);
      }
    } 
  }
    /**
   * Method to change the exposure of a picture. Higher inputs mean darker colors.
   */
  public void increaseExposure (int divider){
    for (int x = 0; x < this.getWidth(); x++){
      for (int y = 0; y < this.getHeight(); y++){
        Pixel pixelObj = this.getPixel(x,y);
        //Squares all the RGB values and divides it by the divider
        pixelObj.setRed((int)pixelObj.getRed()*pixelObj.getRed()/divider);
        pixelObj.setBlue((int)pixelObj.getBlue()*pixelObj.getBlue()/divider);
        pixelObj.setGreen((int)pixelObj.getGreen()*pixelObj.getGreen()/divider);
      }
    }
  }
  /**
   * Method to change the picture to gray scale
   */
  public void grayscale()  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixelObj = null;
    int intensity = 0;
// loop through all the pixels
    for (int i = 0; i < 
         pixelArray.length; i++)    {
// get the current pixel
      pixelObj = pixelArray[i];
// compute the average intensity
      intensity =(pixelObj.getRed() + 
                  pixelObj.getGreen() +
                  pixelObj.getBlue()) / 3;
// set the pixel color
      pixelObj.setRed(intensity);
      pixelObj.setBlue(intensity);
      pixelObj.setGreen(intensity);
    }
  }
  public void mirrorVertical()  {
    int mirrorPoint = this.getWidth() / 2;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
// loop through the rows
    for (int y = 0; y < this.getHeight(); y++)    {
// loop from 0 to just before the mirror point
      for (int x = 0; x < mirrorPoint; x++)      {
        leftPixel = this.getPixel(x, y);
        int pixelPlaceholder = this.getWidth()-1-x;
        rightPixel = this.getPixel(pixelPlaceholder, y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  /**
   * Modified version of method from page 154 of the textbook for copying pictures
   */
  public void copyPictureTo(Picture sourcePicture, int xStart, int yStart){
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //loop through the columns
    try{
      for (int sourceX = 0, targetX = xStart;
           sourceX < sourcePicture.getWidth();
           sourceX++, targetX++){
        //loop through the rows
        for (int sourceY = 0,
             targetY = yStart;
             sourceY < sourcePicture.getHeight();
             sourceY++, targetY++){
          sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
          targetPixel = this.getPixel(targetX,targetY);
          targetPixel.setColor(sourcePixel.getColor());
             } 
           }
    }catch(IndexOutOfBoundsException ex){System.out.println("Either xStart or yStart is out of bounds");System.exit(0);}
  } 
  
}