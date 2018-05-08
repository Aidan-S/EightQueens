import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class findingQueens {
	
	
	//private static ArrayList<Integer> queens;
	private static final int SIZE = 8;
	private static final int SCREEN_SIZE = 700;
	private static final int DELAY = 200;
	
	private JFrame window;
	ChessSquarePanel[] board;

	
	public findingQueens() {
		window = new JFrame("myWindow");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(SIZE,SIZE));
		window.setSize(SCREEN_SIZE, SCREEN_SIZE);
		
		
		board = new ChessSquarePanel[64];
		
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
		
		for(int b = 0; b < board.length; b++) {
			window.add(board[b]);
		}
		
		window.setLayout(new GridLayout(SIZE,SIZE));
		
		
		window.setVisible(true);
	}
	
	
	
	
	
	
	public boolean addQueens(ArrayList<Integer> array) {
		
		if(array.size() == SIZE) {
			this.setArray(array);
			String s = "";
			for(int y = 0; y < array.size(); y++) {
				s += "[" + array.get(y) + "][" + y + "], ";
			}
			System.out.println(s.substring(0, s.length()-2));
			return true;
		}
		
		
		
		for(int k = 0; k < SIZE; k++) {
	
		    if(available(array, k, array.size())) {
		        ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
		        arrayCopy.add(k);
		        setArray(arrayCopy);
		        addQueens(arrayCopy);
		    }		
		}
		
		return false;
		
	}
	
	
	public static boolean available(ArrayList<Integer> array, int newy, int newx) {
		
		for(int i = 0; i <= array.size()-1; i++) {
			if(newy == array.get(i)  ||  Math.abs(newx-i) == Math.abs(newy-array.get(i))  ||  newx + array.get(i) == newy + i) {
				return false;
			}
		}
		
		return true;
	}
	
	

	public void setArray(ArrayList<Integer> array) {
		for(int i = 0; i < board.length; i++) {
			board[i].setLetter(false);
		}
		
		
		for(int q = 0; q < array.size(); q++) {
			board[(array.get(q) * SIZE ) + q].setLetter(true);
		}
		
		
		try {
			if(array.size() == SIZE) {
				Thread.sleep(DELAY * 10);
			}else {
				Thread.sleep(DELAY);
			}
			
		} catch (InterruptedException e) {
			
		}
		this.window.repaint();
	}	
	
	
	public static void main(String[] args) {
		findingQueens test = new findingQueens();
		ArrayList<Integer> array = new ArrayList<Integer>();
		test.addQueens(array);
	}
	
}
