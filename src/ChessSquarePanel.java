import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ChessSquarePanel extends JPanel{
	
private final static int FONTSIZE = 25;
private final static String QUEEN = "Q";
	
	private boolean isQueen;
	private Color backColor;
	
	/**
	 * @author Aidan-S
	 * date: May 13th, 2018
	 * method: constructor that sets a background color and if the panel is a queen
	 * @param c: the color the background will be
	 * @param b: if the panel will be a queen
	 * @return: none
	 */
	ChessSquarePanel(Color c, boolean b) {
		backColor = c;
		isQueen = b;
	}
	
	/**
	 * @author Aidan-S
	 * date: May 13th, 2018
	 * method: sets if a panel is a queen
	 * @param b: if the panel will be a queen or not
	 */
	public void setLetter(boolean b) {
		isQueen = b;
	}
	
	
	/**
	 * @author Aidan-S
	 * date: May 13th, 2018
	 * method: paints the panel, adding a Q if the panel is a queen
	 * @param g: inherited graphics components
	 */
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
