/**
 * Dictionary to store Configurations and scores
 * @author Jeet Chakrabarty
 */
import java.util.LinkedList;

public class Dictionary implements DictionaryADT{
	
	private int pairs; //Number of entries in dictionary
	private LinkedList<DictEntry>[] hasht; //Hash table of linked lists
	
	//Creates a dictionary hash table with tSize lists
	
	public Dictionary(int size){
		hasht = (LinkedList<DictEntry>[])new LinkedList[size]; //Initializes table
		pairs = 0; //Total number of dictionary entries
	}
	
/**
 * Insert method adds configuration and score to dictionary
 * @param Dictionary entry being inputted
 * @return Returns 1 if collission occurred, 0 otherwise
 */
	public int insert(DictEntry pair) throws DictionaryException{
		int location = hash(pair.getConfig()); //Location in hash of configuration
		
		//Checks if location in hash is occupied
		if (hasht[location] != null){
			//Checks if this configuration is already in
			for (int i=0; i < hasht[location].size(); i++){
				//Checks if configurations are equal
				if (pair.getConfig().equals(hasht[location].get(i).getConfig())){
				//Throws exception if configuration already in the dictionary
				throw new DictionaryException("This configuration is already in the dicitonary");
			}
		}
			//Continues to execute if config not in dictionary
			hasht[location].add(pair);
			pairs ++;
			return 1;
		}
		//Executes if location in hash not occupied
		else {
			LinkedList<DictEntry> temp = new LinkedList<DictEntry>();
			temp.addFirst(pair);
			hasht[location] = temp;
			pairs ++;
			return 0;
		}
	}
	
/**
 * Remove method removes configuration if found in dictionary
 * @param Configuration being searched for
 */
	public void remove(String config) throws DictionaryException{
		int location = hash(config); //Location in hash of configuration
		
		if (hasht[location] == null){
			//Throws exception if location corresponding to configuration empty
			throw new DictionaryException("Configuration not found");
		}
		//Compares configuration to all in list
		for (int i=0; i < hasht[location].size(); i++){
			if (config.equals(hasht[location].get(i).getConfig()));
			//Removes if any matches are found
			hasht[location].remove(i);
			pairs -= 1;
			return;
		}
		
		//Throws error if not found in list
		throw new DictionaryException("Configuration not found");
	}
	
/**
 * Find method returns score of configuration found in dictionary
 * @param config Configuration being searched for
 * @return Score of configuration
 */
	public int find(String config){
		int location = hash(config); //Location in hash of configuration
		
		if (hasht[location] == null){
			//Returns -1 if location corresponding to configuration empty
			return -1;
		}
		//Compares configuration to all in list
		for (int i=0; i < hasht[location].size(); i++){
			if (config.equals(hasht[location].get(i).getConfig()));
			//Returns score if same configuration found
			return hasht[location].get(i).getScore();
		}
		
		//Returns -1 if configuration not found
		return -1;

	}
	
/**
 * Returns number of entries in dictionary
 * @return number of entries
 */
	public int numElements(){
		return pairs;
	}
	
/**
 * Hash function using polynomial hashcode to return corresponding location in table
 * @param config Configuration being hashed
 * @return Index corresponding to key
 */
	private int hash(String config){
		
		int sum = config.charAt(0); //Variable to record sum of int conversions of string component characters
		//Uses polynomial hashcode algorithm to calculate keys
		for (int i=1; i<config.length(); i++){
			sum = (sum*11+config.charAt(i)) % hasht.length;
			//Converts character to int and multiplies by prime ^ position
		}
		//Modulo by table's size to return index within table
		return sum % hasht.length;

	}
	
}
 