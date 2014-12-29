import java.awt.Color; 
public class TurtleArt 
{ 
  public static void main (String[] args) 
  { 
    World w1=new World ();
    Turtle t1=new Turtle (100,200, w1);
    int S_WIDTH = 640; //Screen Width
    int S_HEIGHT = 480; //Screen Height
    int oWidth; //Object Width
    int oHeight; //Object Height
    //Sets pen width to extremely large and colour to draw background
    t1.setPenColor(java.awt.Color.blue);
    int pwidth = S_WIDTH;
    t1.setPenWidth(pwidth);
    t1.moveTo(S_WIDTH,S_HEIGHT/2);
    //Draws all the stars
    pwidth=3;
    t1.setPenWidth(pwidth);
    t1.setPenColor(java.awt.Color.white);
    //Loop to arrange grid of stars, x-coordinates
    for(int x=S_WIDTH/10; x<S_WIDTH*1.1; x=x+S_WIDTH/10) 
      //Second grid for array, y-coordinates
      for (int y=S_HEIGHT/10; y<S_HEIGHT*0.8; y=y+S_HEIGHT/10)
    {
      {
        //Random term [1,40] to prevent grid-like appearance for stars
        int random = (int )(Math.random() * 40 - 70);
        t1.penUp();
        t1.moveTo(x+random,y+random);
        t1.penDown();
        t1.moveTo(x+1+random,y+random+1);//Creates diamond-shape
      } 
    }
    t1.drawCircle(80,80,50);//Draws the moon
    //Draws the building
    t1.penUp();
    pwidth=250;
    t1.setPenWidth(pwidth);
    oWidth=0; oHeight=350;
    t1.moveTo(oWidth,oHeight);
    t1.setPenColor(java.awt.Color.darkGray);
    t1.penDown();
    t1.drawRectangle(S_WIDTH,50);
    //Draws the roof squares
    for(int x=1; x<S_WIDTH+40+1; x=x+80)
    {
      t1.drawSolidSquare(x, oHeight-pwidth/2, 40);
    }
    t1.setPenColor(java.awt.Color.black);
    int WLENGTH = 50; //Window Length
    //Loop to draw windows and the frames
    for(int x=WLENGTH; x<S_WIDTH+1; x=x+100)
    {
      t1.drawSolidSquare(x, oHeight-WLENGTH, WLENGTH);
      pwidth=2;
      t1.setPenWidth(pwidth);
      t1.penUp();
      t1.moveTo(x-WLENGTH/2-5,oHeight-WLENGTH-WLENGTH/2-5);
      t1.penDown();
      t1.drawSquare(WLENGTH+WLENGTH/5);
      t1.penUp();
      t1.moveTo(x-WLENGTH/2-5,oHeight-WLENGTH -WLENGTH/2-15);
      t1.penDown();
      t1.drawRectangle(WLENGTH+WLENGTH/5,WLENGTH/5);
    }
    //Draws two solid squares and the black outline for the door
    oWidth=60;
    oHeight=90;
    t1.setPenColor(java.awt.Color.orange);
    t1.drawSolidSquare(S_WIDTH/2,S_HEIGHT-1,(oWidth));
    t1.drawSolidSquare(S_WIDTH/2,S_HEIGHT-(oWidth)-1,oWidth);
    t1.penUp();
    t1.moveTo(S_WIDTH/2-oWidth/2,S_HEIGHT-oHeight);
    t1.penDown();
    t1.setPenColor(java.awt.Color.black);
    pwidth=3;
    t1.setPenWidth(pwidth);
    t1.drawRectangle(oWidth,oHeight);
    //Door Decoration triangle
    t1.penUp();
    t1.moveTo(S_WIDTH/2-15,S_HEIGHT-1-100);
    t1.penDown();
    t1.setPenColor(java.awt.Color.red);
    pwidth=5;
    t1.setPenWidth(pwidth);
    t1.drawEquilateral(30);
    //Draws the torch fires
    t1.penUp();
    t1.moveTo(S_WIDTH/4,S_HEIGHT-(oHeight-20));
    t1.turn(-45);
    t1.penDown();
    t1.drawSquare(10);
    t1.penUp();
    t1.moveTo(3*S_WIDTH/4,S_HEIGHT-(oHeight-20));
    t1.penDown();
    t1.drawSquare(10);
    //Draws the torch-holders
    pwidth=3;
    t1.setPenWidth(pwidth);
    t1.setPenColor(java.awt.Color.black);
    t1.turn(-135);
    t1.penUp();
    t1.moveTo(S_WIDTH/4+22,S_HEIGHT-(oHeight-20));
    t1.penDown();
    t1.drawEquilateral(30);
    t1.penUp();
    t1.moveTo(3*S_WIDTH/4+22,S_HEIGHT-(oHeight-20));
    t1.penDown();
    t1.drawEquilateral(30);
  }
}