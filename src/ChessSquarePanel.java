import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ChessSquarePanel extends JPanel{
	
private final static int FONTSIZE = 25;
private final static String QUEEN = "Q";
	
	private boolean isQueen;
	private Color backColor;

	ChessSquarePanel(Color c, boolean b) {
		backColor = c;
		isQueen = b;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setFont(new Font("TimesRoman", Font.BOLD, FONTSIZE));
		this.setBackground(backColor);
		g.setColor(Color.BLACK);
		
		if(isQueen) {
			int x = (this.getWidth() / 2) - FONTSIZE/4; 
			int y = (this.getHeight() / 2) + FONTSIZE/4;
        	g.drawString(QUEEN, x, y);
		}
	}
  
}
