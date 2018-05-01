import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessSquarePanel {
	
	public final static int SIZE = 8;
	public final static int SIZE2 = 64;
	
	ChessSquarePanel(){
		
	}
	
	
	public static void main(String[] args) {
		JFrame window = new JFrame("myWindow");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(SIZE,SIZE));
		
		
		boolean green = false;
		for(int i = 0; i < (SIZE2); i++) {
			if(green) {
				window.add(new MyPanel(Color.GREEN, "Q"));
				if(i+1 % 8 != 0) {
					green = false;
			}else {
				window.add(new MyPanel());
				green = true;
			}
			
		}
		//window.add(new MyPanel(Color.GREEN, "Q"));
		
		
		//window.pack();
		window.setSize(1000, 1000);
		
		
		window.setVisible(true);
	
	
	}
}
