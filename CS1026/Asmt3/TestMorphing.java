public class TestMorphing {
  public static void main(String[] args) {
    //Sets test boolean for while loop to true so it runs the first time
    boolean testB = true;
    //Loop to select two images again if they are not the same size
    while (testB){
      SimpleOutput.showInformation("Please select 2 images of the same size to be morphed.");
      //Finds file names of selected file images  
      String fileName= FileChooser.pickAFile();
      String fileName2= FileChooser.pickAFile();
      //Creates picture objects from files
      Picture startPicture = new Picture (fileName);
      Picture endPicture = new Picture (fileName2);
      //Tesrs if the images are the same size
      if (startPicture.getWidth()==endPicture.getWidth()&&startPicture.getHeight()==endPicture.getHeight()){
        //Runs if images are the same size
        //Creates intermediate picture that is the same size
        Picture interPicture = new Picture (startPicture.getWidth(),startPicture.getHeight());
        //Sets number of intermediate pictures to 3
        int interNum = 3;
        //Loop that runs and shows morphed pictures from beginning to end
        for (int i = 0;i < (interNum+2);i++){
          interPicture.morphStage (startPicture, endPicture, interNum, i);
          interPicture.explore();
          //Sets test boolean to false so the loop can be left
          testB = false;
        }
      }
      else{
        SimpleOutput.showInformation("Your two selected images were not the same size. Please select another pair.");
      }
    }
    //Sets second test boolean to true so loop can run first time
    boolean testB2 = true;
    //Loops until the selected images are the same size
    while (testB2){
    SimpleOutput.showInformation("Please select 2 images of the same size to be morphed.");
      String fileName3= FileChooser.pickAFile();
      String fileName4= FileChooser.pickAFile();
      Picture startPicture2 = new Picture (fileName3);
      Picture endPicture2 = new Picture (fileName4);
      //Runs the portion in braces if the pictures are the same size
      if (startPicture2.getWidth()==endPicture2.getWidth()&&startPicture2.getHeight()==endPicture2.getHeight()){
        //Creates new intermediate picture for morphs
        Picture interPicture = new Picture (startPicture2.getWidth(),startPicture2.getHeight());
        //Sets intermediate number of pictures to 9
        int interNum = 9;
        //Morphs and outputs every picture from beginning to end
        for (int i = 0;i < (interNum+2);i++){
          interPicture.morphStage (startPicture2, endPicture2, interNum, i);
          interPicture.explore();
          //Sets second test boolean value to false to exit the loop
          testB2 = false;
        }
      }
      else{
        SimpleOutput.showInformation("Your two selected images were not the same size. Please select another pair.");
      }
    }
  }
}