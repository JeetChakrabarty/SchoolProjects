/**Simple Function
 * @author Jeet Chakrabarty
 *Class used to represent SimpleFunctions in postfix form represented by strings and
 *implemented using 
 */
import java.util.*;

public class SimpleFunction {
	private String name;	//function name
	private String current;	//variable to represent current token
	private SimpleListADT<String> arguments;	//function arguments
	private SimpleListADT<String> steps;		//function steps
	
	/**Constructor for a SimpleFunction object
	 * @param input StringTokenizer represented in String form
	 */
	public SimpleFunction(StringTokenizer input){
		arguments = new ArraySimpleList<String>(); //initializes variables
		steps = new ArraySimpleList<String>();
		name = input.nextToken();		//sets name as the first token
		current = input.nextToken();	//sets placeholder as next token
	    while (!(current.equals("{"))){	//adds placeholder token to arguments until { encountered
	    	arguments.addToRear(current);
	      current = input.nextToken();
	    }
	    current = input.nextToken(); //sets placeholder token again to avoid including {
	    while (!(current.equals("}"))){
	    	steps.addToRear(current);	//adds placeholder token to ateps until } is encountered
	    	current = input.nextToken();
	    }
	}
	    /**Evaluator class to evaluate SimpleFunction files
	     * @param stack A stack to pop numbers from
	     */
	    public void eval(StackADT <Integer>stack){
	    		//Cycles through all the steps
	    		for(int i = 0; i< steps.size(); i++){
	    	      	String s = steps.get(i);
		    	    	try{
		    	    	//Pushes step onto stack if it is an integer
		    	    		Integer j = Integer.parseInt(s);
			    		stack.push(j);
		    	    }
		    	    catch(NumberFormatException e){ 
			    	    	  //Checks if string is an addition sign
	    	      if (s.equals("+")){
	    		Integer i1 = stack.pop();
	    		Integer i2 = stack.pop();
	    		stack.push(i1+i2);
	    	      }
	    	      //checks if string is a subtraction sign
	    	      if (s.equals("-")){
	    		Integer i2 = stack.pop();
	    		Integer i1 = stack.pop();
	    		stack.push(i2-i1);
	    	      }
	    	      //checks if string is a multiplication sign
	    	      if (s.equals("*")){
	    		Integer i1 = stack.pop();
	    		Integer i2 = stack.pop();
	    		stack.push(i1*i2);
	    	      }

	    	    }
	    	}
	
	    }
	    /**
	     * Evaluates SimpleFunction's algorithm on stack
	     * @param stack Stack from which to pop numbers
	     * @param prog Program to hold multiple SimpleFunction references
	     */
	    public void eval(StackADT <Integer>stack, Program prog){
	    	Integer i1 =0;	//Integer placeholders for operations
	    	Integer i2 =0;	//Integer placeholders for operations
	    	SimpleFunction func = null; 	//Initializes function placeholder
	    	ArraySimpleList<Integer> vals = 
	                new ArraySimpleList<Integer>();	//Initializes vals list to hold arguments values
	    	//Unloads all arguments into a list
	    	for (int i = 0; i< arguments.size();i++){
	    		vals.addToRear(stack.pop());
	    	}	    	
	    	for(int i = 0; i< steps.size(); i++){
	    	      String s = steps.get(i);	//Gets single step from SimpleFunction definition
	    	      try{
	    	    	  //Pushes onto stack if step is a number
	  	    		Integer j = Integer.parseInt(s);
	  	    		stack.push(j);
	  	    	      }
	  	    	      catch(NumberFormatException e){ 
	    	      //Checks if argument is already defined and pushes onto stack if it is
	  	    	    	  if (arguments.indexOf(s)!= -1){
	    	    	  stack.push(vals.get(arguments.indexOf(s)));  
	  	    	    	  }
	  	    	    	 //Checks if step is a function in the program 
	  	    	    	  	if (prog!=null)
	  	    	    	  		func = prog.find(s);
	  	    	    	  	if (func!= null){
	  	    	    	  		func.eval(stack, prog);  
	    	      }
	  	    	    	  	//Checks operations like previous eval method
	    	      else if (s.equals("+")){
	    		i1 = stack.pop();
	    		i2 = stack.pop();
	    		stack.push(i1+i2);
	    	      }
	    	      else if (s.equals("-")){
	    		i1 = stack.pop();
	    		i2 = stack.pop();
	    		stack.push(i2-i1);
	    	      }
	    	      else if (s.equals("*")){
	    		i1 = stack.pop();
	    		i2 = stack.pop();
	    		stack.push(i1*i2);
	    	      }
	    	}
	    	}
	    }
	    /* String representation of function
	     * @return returns name of function
	     */
	    public String toString (){
	    	return name;
	    }
	}
