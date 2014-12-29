/* Define a class for reading information from a file and
 * applying it to the PhotoInfo method
 * By Jeet Chakrabarty
 */
import java.util.*;
import java.io.*;
public class PhotoList {
  /* attributes (instance variables) */
  private PhotoInfo[] photoArray;
  private int numPhoto = 0;
   /* constructors */
  public PhotoList(String fileName){
    //Creates SimpleReader object to read from file
    SimpleReader reader = new SimpleReader(fileName);
    String []lineArray = reader.readFile();
    //Sets class variable to equal length of photoArray
    numPhoto = reader.getFileLength();
    //Initializes photoArray
    photoArray = new PhotoInfo[reader.getFileLength()];
    //Prompts user for location of photos described in text file
    String folder = SimpleInput.getString("Please enter the file location of your photos.");
    //Loop to initialize each component of the photoArray
    for (int i=0; i < reader.getFileLength(); i++){
      StringTokenizer  tokenizer = new StringTokenizer(lineArray[i]);
      /*Directly reads all variables from the text file into the parameters of the PhotoInfo object
       * Integer.parInt is necessary to convert from type String to int
       */
      photoArray[i] = new PhotoInfo (tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()), 
                                     Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()),
                                     tokenizer.nextToken(),tokenizer.nextToken(),folder+ tokenizer.nextToken()+"\\");
    }
  }
      /* methods */
  //Lists the characteristics of every photo in the array
  public void listPhotos(){
    for (int i=0; i < numPhoto; i++){
      System.out.println(photoArray[i].toString());
    }
  }
  //Shows every photo in the array
  public void showPhotos(){
    for (int i=0; i < numPhoto; i++){
      photoArray[i].show();
    }
  }
  /*Saves photoArray into a file directory location that is passed from the parameter
   * Beginning part adds relevant slashes or backslashes if omitted by the user
   */
  public void storePhotos(String directory){
    char end = directory.charAt(directory.length() - 1);
    if (end != '/' || end != '\\')
      directory = directory + '/';
    File directoryFile = new File(directory);
    if (!directoryFile.exists())
      directoryFile.mkdirs();
    for (int i=0; i < numPhoto; i++){
      photoArray[i].write(directory+photoArray[i].getId()+"_"+photoArray[i].getCategory()+".jpg");
    }
  }
  /*Uses bubble sort to order photos in array according to their weighted date
   * Uses temporary variable to store value so they can be switched
   * Structure of loop ensures comparisons are not repeated
   */
  public void sortPhotosByDate(){
    for (int j=0; j < numPhoto; j++){
      for (int i = 1; i<numPhoto-j; i++){
        if (photoArray[i-1].getWeightedDate()<photoArray[i].getWeightedDate()){
          PhotoInfo temp = photoArray[i-1];
          photoArray[i-1]=photoArray[i];
          photoArray[i]=temp;
        }
        
      }
    }
  }
}