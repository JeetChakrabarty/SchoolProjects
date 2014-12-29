/**
 * TicTacToe class that implements all the methods necessary for computerPlay
 * @author Jeet
 *
 */
public class TicTacToe {

	private int size; //size of board
	private int symwin; //number of consecutive symbols needed to win
	private int levels; //maximum levels of analysis
	private char [][] gameBoard;
	
	/**
	 * TicTacToe constructor class that creates instance
	 * @param board_size size of board
	 * @param inline number of consecutive symbols needed to win
	 * @param max_levels maximum number of levels of analysis
	 */
	public TicTacToe (int board_size, int inline, int max_levels){
		size = board_size; //initalize parameters
		symwin = inline;
		levels = max_levels;
		gameBoard = new char [size][size]; //creates square gameboard with size x size squares
		for(int i=0; i<size; i++){ //populate empty gameboard with spaces
			for(int j=0; j<size; j++){
				gameBoard[i][j] = ' ';
			}
		}
	}
	
	/**
	 * Method to construct dictionary object
	 * @return Dictionary object
	 */
	public Dictionary createDictionary(){
		return new Dictionary(4999); //creates a dictionary of size 4999
	}
	
	/**
	 * 
	 * Method represents content of gameBoard as string and checks if in dictionary
	 * @param configurations dictionary of configurations
	 * @return score of configuration or -1 if configuration not present
	 */
	public int repeatedConfig(Dictionary configurations){
		String configRep = ""; //string to represent configuration
		for (int i=0; i < size; i++){ //goes through gameboard and concatenates characters onto string
			for (int j=0; j < size; j++){
				configRep = configRep + gameBoard[i][j];
			}
		}
		return configurations.find(configRep); //searches dictionary and returns score or -1 if not there
	}
	
	/**
	 * Method to represent content of gameBoard as string then add to dictionary
	 * @param configurations dictionary of configurations
	 * @param score calculated score of configuration
	 */
	public void insertConfig(Dictionary configurations, int score){
		String configRep = ""; //String to represent configuration
		for (int i=0; i < size; i++){ //goes through gameboard and concatenates characters onto string
			for (int j=0; j < size; j++){
				configRep = configRep + gameBoard[i][j];
			}
		} //try-catch statement to acoid case where entry already in dictionary
		try {
			configurations.insert(new DictEntry (configRep, score)); //inserts configuration
		} catch (DictionaryException e){
			System.out.println("That is already in the dictionary.");
		}
	}
	
	/**
	 * Stores symbol in gameboard
	 * @param row to be stored
	 * @param col column to be stored
	 * @param symbol to be stored
	 */
	public void storePlay(int row, int col, char symbol){
		gameBoard[row][col]=symbol;
	}
	
	/**
	 * Checks whether square in question is empty or not
	 * @param row to be stored
	 * @param col column to be stored
	 * @return true if empty square, false if populated with symbol
	 */
	public boolean squareIsEmpty (int row, int col){
		return gameBoard[row][col]== ' ';
	}
	
	/**
	 * Returns true if there are a winning number of consecutive squares on same row, column or diagonal
	 * @param symbol to be checked against gameboard
	 * @return true if winning combination present, false if otherwise
	 */
	public boolean wins (char symbol){
		int counterv =0, counterh = 0; //two seperate counters for columns and rows
		//for loop to check every square for vertical and horizontal wins
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
			   if (gameBoard[x][y] == symbol) { //checks columns for symbols
				   counterv ++; //increments count if symbol found
				   if (counterv == symwin)
						return true; //returns true if count reaches requisite number of symbols for win
			   }
				else
					counterv =0; //resets count to 0 if not symbol being considered
			 
			   if (gameBoard[y][x] == symbol) {//checks rows for symbols
				   counterh ++; //increments count if symbol found
					if (counterh == symwin)
						return true; //returns true if count reaches requisite number of symbols for win
			   }
			   else
					counterh =0; //resets count to 0 if not symbol being considered
			}
			counterv=0; //resets count for every column
			counterh=0; //resets count for every row
		}
		//Diagonal loops use algorithm specially made to model behaviour of TTT in this problem.
		//See attached images for why this algorithm works
		//loop for traversing diagonals from up-left to down-right, from left to right
		for (int i=0; i < 2*(size-symwin)+1; i++){ //inner loop continues for relevant number of diagonals
			int counter=0; //Resets counter for checks
			if ((size - symwin)-i <0){ //checks if diagonals are special cases
				for(int j=0; Math.abs((size-symwin)-i)+j <size; j++){ //loops through squares in same diagonal
					if(gameBoard[Math.abs((size-symwin)-i)+j][j] == symbol){
						counter++; //increments count if symbol found
						if (counter == symwin)
							return true; //returns true if count reaches requisite number of symbols for win
					}
					else
						counter =0; //resets counnt to 0 if not symbol being considered
				}
			}
			else { //loop for up-left to down-right diagonals in normal case
				for(int j=0; ((size-symwin)-i)+j <size; j++){ //inner loop continues for relevant number of diagonals
					if(gameBoard[j][((size-symwin)-i)+j] == symbol){
						counter++; //increments count if symbol found
						if (counter == symwin)
							return true; //returns true if count reaches symwin
					}					
					else
						counter =0; //resets count to 0 if not symbol being considered
				}
			}
			if (i < (size-symwin)+1){ //checks if diagonals are normal cases
				for(int j=0; j < symwin + i; j++){ //Loops through squares in same diagonal
					if(gameBoard[j][(symwin +i-1-j)] == symbol){
						counter++; //increments count if symbol found
						if (counter == symwin)
							return true; //returns true if count reaches symwin
					}
					else
						counter =0; //resets count to 0 if not symbol being considered
				}
			}
			else { //executes if diagonals are special cases
				for(int j=0; i-(size-symwin)+j < size; j++){ //loops through squares in same diagonal
					if(gameBoard[i-(size-symwin)+j][size-1-j] == symbol){
						counter++; //increments counter if symbol found
						if (counter == symwin)
							return true; //returns true if count reaches symwin
					}					
					else
						counter =0; //resets count to 0 if not symbol being considered
				}
			}
		}
		return false; //Returns false if no wins
	}
	
	/**
	 * Method returns true if gameboard is filled with symbols and no winner
	 * @return true if gameboard has no spaces and neither player has won
	 */
	public boolean isDraw(){
		boolean answer = true; //assumes return value is true
		//for loop goes through gameboard and changes return value to false if space found
		for (int i=0; i < size; i++){
			for (int j=0; j < size; j++){
				if (gameBoard[i][j]==' ')
					answer = false;
			}
		}
		return answer && !wins('X') && !wins('O'); //adds check whether either symbol has won
	}
	
	/**
	 * Method to evaluate score of each configuration
	 * @return score of configuration
	 */
	public int evalBoard(){
		if (this.isDraw())
			return 2;
		if (wins('O'))
			return 3; //if O won
		if (wins('X')) //if X won
			return 0;
		return 1; //if game is undecided
	}
	
}