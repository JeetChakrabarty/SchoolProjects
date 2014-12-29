
/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////
  
  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture) 
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y, ModelDisplay modelDisplayer) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay) 
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    // let the parent constructor handle it
    super(p);
  }  
  
  /////////////////// methods ///////////////////////
  //Draws square from upper-left corner
  public void drawSquare(int width)
  {
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
  }
  //Draws vee from middle
  public void drawVee(int length)
  {
    this.turn(-30); 
    this.forward(length); 
    this.turn(180); 
    this.forward(length); 
    this.turn(-120); 
    this.forward(length);
    this.turn(180); 
    this.forward(length); 
    this.turn(150); 
  }
  //Draws recrangle from upper-left corner
  public void drawRectangle(int width, int height)
  {
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(height);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(height);
  }
  //Draws equilateral triangle from bottom-left corner
  public void drawEquilateral(int length)
  {
    this.turn(90); 
    this.forward(length); 
    this.turn(-120); 
    this.forward(length); 
    this.turn(-120); 
    this.forward(length); 
    this.turn(150); 
  }
  //Draws Circle from center using loop
  public void drawCircle(int a, int b, int radius) 
  {
    for (int x =1; x<361; x =x+1)
    {
      this.penUp();
      this.moveTo(a, b);
      this.setPenWidth(radius/20+1);
      //Draws line from center that is radius-length in all angles
      this.penDown();
      this.forward(radius);
      this.turn(1);
    } 
  } 
  //Draws Solid Square from center using pen-width
  public void drawSolidSquare(int x, int y, int length)
  {
    this.penUp();
    this.moveTo(x, y);
    this.setPenWidth(length);
    this.penDown();
    this.moveTo(x+1,y);
  }
} // end of class Turtle, put all new methods before this