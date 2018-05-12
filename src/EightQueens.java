import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class EightQueens {
	
public final static int SIZE = 8;
public final static int SCREEN_SIZE = 400;
	
private static int[] queens = new int[SIZE];

	
	/**
	 * @author Aidan-S
	 * date: May 13th, 2018
	 * method: main method to show one possible solution to the eight queens problem 
	 * @param args: array of string arguments
	 */
	public static void main(String[] args) {
		//create and set up the window 
		JFrame window = new JFrame("myWindow");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(SIZE,SIZE));
		window.setSize(SCREEN_SIZE, SCREEN_SIZE);
		
		//create board to hold the chess panels
		ChessSquarePanel[] board = new ChessSquarePanel[64];
		
		//alternate colored tiles
		for(int r = 0; r < SIZE; r++) {
			for(int c = 0; c < SIZE; c++) {
				if(c%2 == 0) {
					if(r%2 == 0) {
						board[(c * SIZE) + r] = (new ChessSquarePanel(Color.GREEN, false));
					} else {
						board[(c * SIZE) + r] = (new ChessSquarePanel(Color.BLUE, false));
					}
				}else {
					if(r%2 == 0) {
						board[(c * SIZE) + r] = (new ChessSquarePanel(Color.BLUE, false));
					} else {
						board[( c * SIZE) + r] = (new ChessSquarePanel(Color.GREEN, false));
					}
				}
				
			}
			
		}
		
		//put in the chess panels
		for(int b = 0; b < board.length; b++) {
			window.add(board[b]);
		}
		
		window.setLayout(new GridLayout(SIZE,SIZE));
		
		
		window.setVisible(true);
		

		//keep an array of where the queens are
		queens[0] = 6;
		queens[1] = 4;
		queens[2] = 2;
		queens[3] = 0;
		queens[4] = 5;
		queens[5] = 7;
		queens[6] = 1;
		queens[7] = 3;
		
		//set the Queens based on the queens array
		for(int q = 0; q < queens.length; q++) {
			board[( queens[q] * SIZE ) + q].setLetter(true);
		}
	
		
		window.repaint();
	
	
	}
	
}



