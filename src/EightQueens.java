import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class EightQueens {
	
public final static int SIZE = 8;
//boolean[][] works;
	
	public static void main(String[] args) {
		JFrame window = new JFrame("myWindow");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(SIZE,SIZE));
		window.setSize(400, 400);
		
		
		
		boolean[][] works = {{false, false, false, true, false, false, false, false},
							 {false, false, false, false, false, false, true, false},
							 {false, false, true, false, false, false, false, false},
							 {false, false, false, false, false, false, false, true},
							 {false, true, false, false, false, false, false, false},
							 {false, false, false, false, true, false, false, false},
							 {true, false, false, false, false, false, false, false},
							 {false, false, false, false, false, true, false, false}};
		
		for(int r = 0; r < SIZE; r++) {
			for(int c = 0; c < SIZE; c++) {
				if(c%2 == 0) {
					if(r%2 == 0) {
						window.add(new ChessSquarePanel(Color.GREEN, works[r][c]));
					} else {
						window.add(new ChessSquarePanel(Color.BLUE, works[r][c]));
					}
				}else {
					if(r%2 == 0) {
						window.add(new ChessSquarePanel(Color.BLUE, works[r][c]));
					} else {
						window.add(new ChessSquarePanel(Color.GREEN, works[r][c]));
					}
				}
				
			}
			
		}
		
		
		window.setVisible(true);
	
	
	}
	
}
