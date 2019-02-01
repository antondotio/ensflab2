import java.util.Scanner;

/**
 * This class takes care of all of the information about the player
 * and also where the game moves are executed.
 * 
 * @author Antonio Santos
 * @version 1.0
 * @since January 31, 2019
 */
public class Player implements Constants{
    /**
     * name of the player
     */
    private String name;
    /**
     * the game board that will be used in the game
     */
    private Board board;
    /**
     * the opponent of the current player
     */
    private Player opponent;
    /**
     * the mark of the player
     */
    private char mark;

    /**
     * Player constructor sets the name and mark
     * @param name name of the player
     * @param mark mark to be used by the player
     */
    public Player(String name, char mark){
        this.name = name;
        this.mark = mark;
    }

    /**
     * Where the game starts. Prompts players to make moves and checks
     * every turn if a player has won.
     */
    public void play(){
        while(true){
            makeMove();
            if(board.xWins() == true){
                board.display();
                System.out.println("GAME OVER: " + name + " is the winner.");
                break;
            }else if(board.oWins() == true){
                board.display();
                System.out.println("GAME OVER: " + name + " is the winner.");
                break;
            }else if(board.isFull() == true){
                board.display();
                System.out.println("GAME OVER: game ended in a tie");
                break;
            }
            board.display();
            opponent.play();
        }
        System.out.println("Game ended...");
        System.exit(1);
    }
    
    /**
     * Where the players make their moves.
     */
    public void makeMove(){
        System.out.print("\n" + name + ", what row would you like your next " + mark + " be placed in?");
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        System.out.print("\n" + name + ", what column would you like your next " + mark + " be placed in?");
        int col = scan.nextInt();
        if(board.getMark(row, col) == LETTER_O || board.getMark(row, col) == LETTER_X){
            System.out.println("\nSpot already taken, please choose an open space.");
            makeMove();
        }
        board.addMark(row, col, mark);

    }

    /**
     * sets the opponent of a player
     * @param player opponent of current player
     */
    public void setOpponent(Player player){
        opponent = player;
    }

    /**
     * sets board of the game
     * @param board board to be used by the game
     */
    public void setBoard(Board board){
        this.board = board;
    }
}