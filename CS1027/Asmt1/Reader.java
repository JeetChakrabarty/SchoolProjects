
/**
 * Class that allows news feed items to be read and printed
 * @author Jeet
 */
public class Reader {
	/*Attribute declarations*/
	private Feed testFeed;							//feed to be read and printed
	private int nextItem = 0;						//index that tracks last item printed
	
	/**
	 * Constructor creates reader that reads feed
	 * @param feed the feed that will be read
	 */
	public Reader(Feed feed){
		testFeed = feed;
	}
	
	/**
	 * find method prints all news items with specified keyword
	 * @param pattern specified keyword that needs to be found
	 */
	public void find(String pattern){
		testFeed.find(pattern);
	}
	
	/**
	 * reader method that prints all news items since the last one printed
	 */
	public void read(){
		nextItem = testFeed.readFrom(nextItem);
	}
}
