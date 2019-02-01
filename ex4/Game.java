
import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/** 
 * Provides data fields and methods to create a tic-tac-toe game 
 * in a Java application
 * This class is the starting point of the program
 * 
 * @author Antonio Santos
 * @version 1.0
 * @since January 31, 2019
*/
public class Game implements Constants {
	/**
	 * The board that will be used in the game
	 */
	private Board theBoard;
	/**
	 * The moderator that will be in charge of watching the game
	 */
	private Referee theRef;
	
	/**
	 * Creates a new Board object to play on
	 */
    public Game( ) {
        theBoard  = new Board();
	}
	
	/**
	 * Sets the referee and tells it to start the game
	 * @param r	sets the referee that will be running the game
	 * @throws IOException
	 */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}
