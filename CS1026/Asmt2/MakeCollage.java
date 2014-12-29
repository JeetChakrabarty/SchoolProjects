import java.awt.Color;
public class MakeCollage{
  public static void main(String[] args)  {
    //Pick the file using filechooser
    String filename = FileChooser.pickAFile();
    Picture canvas = new Picture(1280,960);  
    canvas.show();
    //Declare each picture seperately, using same filename and copy to canvas
    Picture pic1 = new Picture(filename);
    pic1.mirrorVertical();
    canvas.copyPictureTo(pic1,0,0);
    Picture pic2 = new Picture(filename);
    pic2.blurPicture(5);
    canvas.copyPictureTo(pic2,640,0);
    Picture pic3 = new Picture(filename);
    pic3.grayscale();
    canvas.copyPictureTo(pic3,0,480);
    Picture pic4 = new Picture(filename);
    pic4.increaseExposure(50);
    canvas.copyPictureTo(pic4,640,480);
    Picture pic5 = new Picture(filename);
    canvas.copyPictureTo(pic5,320,240);
    //Updates the canvas
    canvas.repaint();
    //Writes to computer
    canvas.write("C:/myCollage.jpg");  
  }
}