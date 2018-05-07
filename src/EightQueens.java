import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class EightQueens {
	
public final static int SIZE = 8;
	
private static int[] queens = new int[8];


	public boolean addQueens(ArrayList<Integer> array) {
		if(array.size() == 8) {
			queens = array;
			return true;
		}
		
		for(int k = 0; k < SIZE; k++) {
			for(int i = 0; i <= array.size()-1; i++) {
				int x = array.get(i);
				int y = i;
				int newx = k;
				int newy = array.size();
				
				
				if(k != x  &&  Math.abs(newx-x) != Math.abs(newy-y)  &&  newx + x != newy + y) {
					ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
					arrayCopy.add(k);
					return addQueens(arrayCopy);
				}
				
				
			}
		}
		
		return false;
		
	}

	


	public static void main(String[] args) {
		JFrame window = new JFrame("myWindow");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(SIZE,SIZE));
		window.setSize(400, 400);
		
		
		ChessSquarePanel[] board = new ChessSquarePanel[64];
		
		for(int r = 0; r < SIZE; r++) {
			for(int c = 0; c < SIZE; c++) {
				if(c%2 == 0) {
					if(r%2 == 0) {
						board[(c*8)+r] = (new ChessSquarePanel(Color.GREEN, false));
					} else {
						board[(c*8)+r] = (new ChessSquarePanel(Color.BLUE, false));
					}
				}else {
					if(r%2 == 0) {
						board[(c*8)+r] = (new ChessSquarePanel(Color.BLUE, false));
					} else {
						board[(c*8)+r] = (new ChessSquarePanel(Color.GREEN, false));
					}
				}
				
			}
			
		}
		
		for(int b = 0; b < board.length; b++) {
			window.add(board[b]);
		}
		
		
		queens[0] = 0;
		queens[1] = 2;
		queens[2] = 4;
		queens[3] = 6;
		queens[4] = 1;
		queens[5] = 3;
		queens[6] = 5;
		queens[7] = 7;
		
		for(int q = 0; q < queens.length; q++) {
			board[( queens[q] * 8 ) + q].setLetter(true);
		}
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		
		
		
		
		window.setLayout(new GridLayout(SIZE,SIZE));
		
		
		window.setVisible(true);
	
	
	}
	
}



