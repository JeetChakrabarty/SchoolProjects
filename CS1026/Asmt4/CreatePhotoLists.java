/* Define a class for testing the PhotoInfo method
 * and the PhotoList method
 * By Jeet Chakrabarty
 */
public class CreatePhotoLists{ 
  //Main method
  public static void main(String[] args){ 
    //Inputs tect file containing all the information
    SimpleOutput.showInformation("Please select the text file containing the information for your album.");
    String fileName= FileChooser.pickAFile();
    //Inputs directory to store all the photoarray items with the labels
    String directory = SimpleInput.getString("Please enter the file location for your album.");
    //Creates and initializes a Photolist object
    PhotoList listOfPhotos = new PhotoList(fileName);
    //Sorts photos
    listOfPhotos.sortPhotosByDate();
    //Lists information of resorted photos
    listOfPhotos.listPhotos();
    //Shows ordered photos
    listOfPhotos.showPhotos();
    //Writes photos to directory
    listOfPhotos.storePhotos(directory);
  } 
} 