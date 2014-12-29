/**
 * DictEntry class to represent entries in Dictionary object
 * @author Jeet
 *
 */
public class DictEntry {
	
	String configuration; //String representing configuraiton of board
	int dictScore; //Score of outcome
	
	/**
	 * Constructor for entry
	 * @param config is string representing configuration of symbols
	 * @param score of outcome
	 */
	public DictEntry(String config, int score){
		configuration = config;
		dictScore = score;
	}
	
	/**
	 * Get method to retrieve configuration of entry
	 * @return string representing configuration of symbols
	 */
	public String getConfig(){
		return configuration;
	}
	
	/***
	 * Get method to retrieve configuration of entry
	 * @return value of score of configuration
	 */
	public int getScore(){
		return dictScore;
	}
}
