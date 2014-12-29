public class MorphingMovie {
  public static void main(String[] args) {
    SimpleOutput.showInformation("Please select 2 images of the same size.");
    //Picks files for starting and ending images
    String fileName= FileChooser.pickAFile();
    String fileName2= FileChooser.pickAFile();
    Picture startPicture = new Picture (fileName);
    Picture endPicture = new Picture (fileName2);
    //Checks if the selected pictures are the same size
    if (startPicture.getWidth()==endPicture.getWidth()&&startPicture.getHeight()==endPicture.getHeight()){
      //Executes if selected pictures are the same size
      int interNum = SimpleInput.getIntNumber("How many frames would you like?");
      //Gets directory path from user input
      String directoryName = SimpleInput.getString("Where do you want to save the file?");
      //Declare array to store all the pictures including beginning and ending picture
      Picture [] pictureSequence = new Picture [interNum+2];
      //Run framesequencer to add frames
      FrameSequencer frameSequencer = new FrameSequencer(directoryName);  
      //Loop to morph all beginning frames and ending frames
      for (int i = 0;i < (interNum+1);i++){
        //Create new picture for every item in array
        pictureSequence[i]= new Picture(startPicture.getWidth(),startPicture.getHeight());
        pictureSequence[i].morphStage (startPicture, endPicture, interNum, i);
        frameSequencer.addFrame(pictureSequence[i]);
      }
      //Add ending picture to sequence
      frameSequencer.addFrame(endPicture);
      //Play movie
      MoviePlayer movie1 = new MoviePlayer(directoryName);
      movie1.playMovie();
      //Gets directory name for second file
      String directoryName2 = SimpleInput.getString("Where do you want to save the second file?");
      FrameSequencer frameSequencer2 = new FrameSequencer(directoryName2);  
      //Morphs and adds frames from beginning to end to sequencer
      for (int i = 0;i < (interNum+1);i++){
        pictureSequence[i].morphStage (startPicture, endPicture, interNum, i);
        frameSequencer2.addFrame(pictureSequence[i]);
      }
      //Adds ending picture to sequencer
      frameSequencer2.addFrame(endPicture);
      //Adds morphed frames from ending to beginning to sequencer
      for (int i = interNum;i>= 0;i--){
        frameSequencer2.addFrame(pictureSequence[i]);
      }
      //Plays movie
      MoviePlayer movie2 = new MoviePlayer(directoryName2);
      movie2.playMovie();
    }
    //Shows error message if the images are not the same size
    else{
      SimpleOutput.showInformation("Your two selected images were not the same size. Please select another pair.");
    }
  }
}