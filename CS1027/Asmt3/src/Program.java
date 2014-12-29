
/**Program class to hold multiple SimpleFunctions
 * @author Jeet
 *
 */
import java.util.*;
public class Program {
	private ArraySimpleList<SimpleFunction> func;	//creates list to hold SimpleFunction components
	/**Constructor that makes a Program from a pre-specified list of SimpleFunctions
	 * @param st StringTokenizer for file with all the SimpleFunctions
	 */
	public Program(StringTokenizer st){
		func = new ArraySimpleList<SimpleFunction>();	//Initializes
		String tempFunction = "";	//Creates and initializes placeholder value
		//Repeats as long as there are more tokens
		while(st.hasMoreTokens()){
			String temp = st.nextToken();
			//Concatenates tokens to original string until } is encountered while keeping spaces
			if (!temp.equals("}")){
				tempFunction = tempFunction + temp +" ";
			}
			//Concatenates } and creates SimpleFunction out of placeholder string
			else {tempFunction = tempFunction + temp;
				func.addToRear(new SimpleFunction(new 
						StringTokenizer (tempFunction)));
			tempFunction="";	//Resets tempFunction so next SimpleFunction is not concatenated to first
			}
		}
	}
	
	/**Find method to search program for SimpleFunction with a specific name
	 * @param name Name of SimpleFunction being searched for
	 * @return Returns SimpleFunction with specified name
	 */
	public SimpleFunction find (String name){
		return func.find(name);
	}
}
