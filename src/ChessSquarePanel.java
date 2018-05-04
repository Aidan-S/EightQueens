import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessSquarePanel extends JPanel{
	
private final static int FONTSIZE = 25;
private final static String QUEEN = "Q";
	
	private boolean isQueen;
	private Color backColor;
	
	ChessSquarePanel() {
		backColor = Color.BLUE;
		isQueen = false;
	}

	ChessSquarePanel(Color c, boolean b) {
		backColor = c;
		isQueen = b;
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		g.setFont(new Font("TimesRoman", Font.BOLD, FONTSIZE));
		this.setBackground(backColor);
		g.setColor(Color.BLACK);

        int x = (this.getWidth() / 2) - FONTSIZE/4; 
        int y = (this.getHeight() / 2) + FONTSIZE/4;
        if(isQueen) {
        	g.drawString(QUEEN, x, y);
		}
	}
  
   public void setBackColor(Color c) {
	   backColor = c;
	   repaint();   
   }


}
