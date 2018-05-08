import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class EightQueens {
	
public final static int SIZE = 8;
	
private static int[] queens = new int[8];


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
		
		window.setLayout(new GridLayout(SIZE,SIZE));
		
		
		window.setVisible(true);
		

		
		queens[0] = 0;
		queens[1] = 4;
		queens[2] = 7;
		queens[3] = 5;
		queens[4] = 2;
		queens[5] = 6;
		queens[6] = 1;
		queens[7] = 3;
		
		for(int q = 0; q < queens.length; q++) {
			board[( queens[q] * 8 ) + q].setLetter(true);
		}
		
	
		
		
		
		window.repaint();
	
	
	}
	
}



