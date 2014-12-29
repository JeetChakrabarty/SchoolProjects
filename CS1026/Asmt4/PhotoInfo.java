/* Define a class for modelling information for individual photos
 * using labeled photos
 * By Jeet Chakrabarty
 */
public class PhotoInfo {
  /* attributes (instance variables) */
  private String id;
  private String category;
  private int year;
  private int month;
  private int day;
  private String caption;
  private String photoFile;
  private Picture labelPic;
  private Picture canvas;
  /* constructors */
  public PhotoInfo(String ident, int nday, int nmonth, int
                     nyear, String cat, String cap, String picFile){
    //Copies all the parameters to the class attributes
    this.id = ident; 
    this.category = cat;
    this.year = nyear;
    this.month = nmonth;
    this.day = nday;
    this.caption = cap;
    this.photoFile = picFile;
    this.labelPic = new Picture(picFile);
    //Concactenates a date from the day, month and year
    String date = day+"/"+month+"/"+year;
    int FONT_SIZE = 16;
    //Creates a canvas slightly longer than the picture
    canvas = new Picture (labelPic.getWidth(),labelPic.getHeight()+7*FONT_SIZE);
    /*Draws the category, caption, and date in an approximation of the center and spaced apart
     * The second parameter divides the width in half and goes left an amount approximately equal to the string width 
     The third parameter spaces the labels vertically according to font size*/
    canvas.drawString(category, labelPic.getWidth()/2-category.length()*FONT_SIZE/4, labelPic.getHeight()
                        +2*FONT_SIZE, FONT_SIZE);
    canvas.drawString(caption.replaceAll("_"," "), labelPic.getWidth()/2-caption.length()*FONT_SIZE/4, 
                      labelPic.getHeight()+4*FONT_SIZE, FONT_SIZE);
    canvas.drawString(date, labelPic.getWidth()/2-date.length()*FONT_SIZE/4, labelPic.getHeight()
                        +6*FONT_SIZE, FONT_SIZE);
    //Copies the picture to the canvas
    canvas.copyPictureTo(labelPic,0,0);
  }
  /* methods */
//Accessor methods to obtain attributes of PhotoInfo object
//Gets the identifier
  public  String getId(){
   return  id;
  }
  //Gets the category
  public  String getCategory(){
    return category;
  }
  //Gets the year
  public  int getYear(){
    return year;
  }
  //Gets the month
  public  int getMonth(){
    return month;
  }
  //Gets the day
  public int getDay(){
    return day;
  }
  //Gets the caption
  public String getCaption(){
    return caption;
  }
  //Gets the photo
  public Picture getPhotoPic(){
    return labelPic;
  }
  //Gets the photo name
  public String getNamePic(){
    return photoFile;
  }
  //To String method displays all the information about the object
  public String toString(){
    return caption + "(" + id +", " + category + ", "
      + photoFile + ", " + day + "/" + month + "/" + year+")";
  }
  //Shows the image
  public void show(){
   canvas.show(); 
  }
  //Writes the image to a directory
  public void write(String directory){
    canvas.write(directory);
  }
  //(For the purpose of ordering by date)Weights the components of the date so they can be sorted
  public int getWeightedDate(){
    return year*10000+month*100+day;
  }
  /* for testing: main method for testing the class */
  public static void main (String[] args) {
    // create a sample PhotoInfo object
    String fileName = FileChooser.pickAFile();
    String identifier = "Funny";
    int picDay = 9;
    int picMonth = 12;
    int picYear = 1995;
    String picCategory = "Summer";
    String picCaption = "My funny picture taken last semester!";
    PhotoInfo example1 = new PhotoInfo (identifier, picDay, picMonth, picYear, picCategory
                                          ,picCaption, fileName);
    //Display information about new object
    System.out.println(example1.getId() + example1.getYear()+example1.getMonth()+example1.getDay()
                         +example1.getCaption()+example1.getPhotoPic());
    System.out.println(example1.toString());
    //Show example PhotoInfo object
    example1.show();
  }// end of main method
}// end of PhotoInfo class definition