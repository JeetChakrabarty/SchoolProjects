/**
 * Class that represents a news feed as a list of news items
 * @author Jeet
 *
 */


public class Feed {
	private final int DEFAULT_MAX_ITEMS = 10;
	
	/* Attribute declarations */
	private String name;			//name of feed
	private String [] list;			//array of news items on feed
	private int size;				//current number of news items
	
	/**
	 * Constructor creates item array of default size
	 */
	public Feed (String feedName){
		name = feedName;
		list = new String[DEFAULT_MAX_ITEMS];
		size = 0;
	}
	/**
	 * add method adds a person to the list
	 * @param itemText item text
	 */
	public void add(String itemText){
	//doubles array capacity if not big enough
		if (size == list.length)
			expandArray();
		list [size] = itemText;
		size ++;
	}
	/**
	 * find method checks all the news items for the string parameter and
	 * prints them on the screen
	 * @param pattern test word
	 */
	public void find (String pattern){
		//search all the items for the specified text
		for (int i=0; i < size; i++){
			if (list[i].contains(pattern))
				System.out.println(name+": "+list[i]);
		}
	}
	/**
	 * readFrom method that prints all news items in list, from specified index
	 * @param start starting index
	 */
	public int readFrom(int start){
		for (int i = start;i<size; i++){
			System.out.println(name + ": " + list[i]);
		}
		return size;
	}
	
	/**
	 * toString method returns a string representation of the feed
	 * @return all feed items
	 */
	public String toString(){
		String str = name;
		for (int i = 0;i<size; i++){
			str = str + "\n" + list[i];
		}
		return str;
	}
	
	/**
	 * expandArray is a helper method that creates a new array double the capacity
	 * of the original one, essentially doubling the size of the array
	 */
	private void expandArray(){
		String [] biggerList = new String [list.length*2];
		for (int i = 0; i<list.length; i++){
			biggerList [i] = list[i];
		}
		list = biggerList;
	}
}
