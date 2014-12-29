import java.awt.Color;
public class TestMethods
{
  public static void main(String[] args)
  {
    //Pick each file using file chooser
    String filename = FileChooser.pickAFile();
    Picture pic1 = new Picture(filename);
    pic1.show();
    //Create new object to create a different window
    Picture pic2 = new Picture(filename);
    pic2.blurPicture(5);
    pic2.show();
    String filename2 = FileChooser.pickAFile();
    Picture pic3 = new Picture(filename2);
    pic3.show();
    Picture pic4 = new Picture(filename2);
    pic4.increaseExposure(50);
    pic4.show();
  }
}