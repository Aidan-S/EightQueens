import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class EightQueens {
	
public final static int SIZE = 8;
	
private ArrayList<Integer> queens; 
	
	public boolean addQueens(ArrayList<Integer> array) {
		if(array.size() == 8) {
			queens = array;
			return true;
		}
		for(int i = 0; i < array.size(); i++) {
			int x = array.get(i);
			int y = i;
			
			x = newX(array, x, y);
			
		}
		
		
	}

	public int newX(ArrayList<Integer> array, int newx, int newy) {
		if(array.size() == 0) {
			return (int)(Math.random() * 8);
		}
		
		for(int k = 0; k < SIZE; k++) {
			for(int i = 0; i < array.size(); i++) {
				int x = array.get(i);
				int y = i;
				
				if(k != x) {
					if() {
					
					}
				}
				
				
			}
		}
		return -1;
	}


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
