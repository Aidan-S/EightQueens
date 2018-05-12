import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;


public class findingQueens {

	private static final int SIZE = 8;
	private static final int SCREEN_SIZE = 700;
	private static final int DELAY = 10;	

	private JFrame window;
	ChessSquarePanel[] board;	

	
	/**
	 * @author Aidan-S
	 * date: May 13th, 2018
	 * method: default constructor that sets up the window
	 */
	public findingQueens() {
		//create the starting parameters for the window
		window = new JFrame("myWindow");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(SIZE,SIZE));
		window.setSize(SCREEN_SIZE, SCREEN_SIZE);
		
		//have an array to hold all the panels in the grid layout
		board = new ChessSquarePanel[64];

		//fill the board with chessPanels of alternating color
		for(int r = 0; r < SIZE; r++) {
			for(int c = 0; c < SIZE; c++) {
				if(c%2 == 0) {
					if(r%2 == 0) {
						board[(c*SIZE)+r] = (new ChessSquarePanel(Color.GREEN, false));
					} else {
						board[(c*SIZE)+r] = (new ChessSquarePanel(Color.BLUE, false));
					}
				}else {
					if(r%2 == 0) {
						board[(c*SIZE)+r] = (new ChessSquarePanel(Color.BLUE, false));
					} else {
						board[(c*SIZE)+r] = (new ChessSquarePanel(Color.GREEN, false));
					}
				}
			}	
		}

		//add the panels to the window
		for(int b = 0; b < board.length; b++) {
			window.add(board[b]);
		}

		window.setLayout(new GridLayout(SIZE,SIZE));
		window.setVisible(true);

	}

	

	/**
	 * @author Aidan-S
	 * date: May 13th, 2018
	 * method: recursive method that goes through all the possible ways to set up eight queens
	 * @param queens: arraylist that says how far down each queen is in its column
	 * @return: boolean that determines if the method has succeeded in finding a solution or if it has hit a road block
	 */
	public boolean addQueens(ArrayList<Integer> queens) {
		//if the size is SIZE then the board is full and is a solution
		if(queens.size() == SIZE) {
			this.setArray(queens);
			String s = "";
			//print the solution
			for(int y = 0; y < queens.size(); y++) {
				s += "[" + queens.get(y) + "][" + y + "], ";
			}
			System.out.println(s.substring(0, s.length()-2));
			return true;
		}

		//check all the slots I can put the next queen into for the next column
		for(int k = 0; k < SIZE; k++) {
		    //can the queen be put in this spot?
			if(available(queens, k)) {
		    	//clone array so when I send it in the different recursive iterations don't effect each other
				ArrayList<Integer> arrayCopy = (ArrayList<Integer>) queens.clone();
		        arrayCopy.add(k);
		        setArray(arrayCopy);
		        //recurse
		        addQueens(arrayCopy);
		    }
		}
		//no way to put stuff
		return false;
	}

	

	
	/**
	 * @author Aidan-S
	 * date: May 13th, 2018
	 * method: checks to see if a new queen can be added at a certain spot
	 * @param queens: arraylist that says how far down each queen is in its column
	 * @param newy: what row the program intends to put in the queen in 
	 * @return: whether or not the new y is available
	 */
	public static boolean available(ArrayList<Integer> queens, int newy) {
		int newx = queens.size();
		//checks all the queens in the array to see if the new queen conflicts
		for(int i = 0; i <= queens.size()-1; i++) {
			//if it is in the same row or diagonal then this is not a possible spot
			if(newy == queens.get(i)  ||  Math.abs(newx-i) == Math.abs(newy-queens.get(i))  ||  newx + queens.get(i) == newy + i) {
				return false;
			}
		}
		return true;
	}

	

	
	/**
	 * @author Aidan-S
	 * date: May 13th, 2018
	 * method: changes the letters of the queens on the window
	 * @param queens: arraylist that says how far down each queen is in its column
	 */ 
	public void setArray(ArrayList<Integer> queens) {
		//reset the board
		for(int i = 0; i < board.length; i++) {
			board[i].setLetter(false);
		}
		
		//make the queens in the array have a Q
		for(int q = 0; q < queens.size(); q++) {
			board[(queens.get(q) * SIZE ) + q].setLetter(true);
		}

		//delay, based on if there is a solution
		try {
			if(queens.size() == SIZE) {
				Thread.sleep(DELAY * 10);
			}else {
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {

		}
		
		this.window.repaint();
	}	

	/**
	 * @author Aidan-S
	 * date: May 13th, 2018
	 * method: main method that creates a findingQueens object and then runs addQueens
	 * @param args: array of string arguments
	 */
	public static void main(String[] args) {
		//test running the addQueens method
		findingQueens test = new findingQueens();
		ArrayList<Integer> queens = new ArrayList<Integer>();
		test.addQueens(queens);
	}


}


