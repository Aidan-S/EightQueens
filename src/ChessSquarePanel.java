import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessSquarePanel {
	
	public final static int SIZE = 8;
	
	ChessSquarePanel(){
		
	}
	
	
	public static void main(String[] args) {
		JFrame window = new JFrame("myWindow");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(SIZE,SIZE));
		
		
		
		for(int i = 0; i < (SIZE^2); i++) {
			if(i%2 == 0) {
				window.add(new MyPanel());
			} else {
				window.add(new MyPanel(Color.GREEN, "Q"));
			}
			
		}
		
		
		
		//window.pack();
		window.setSize(1000, 1000);
		
		
		window.setVisible(true);
	
	
	}
}
