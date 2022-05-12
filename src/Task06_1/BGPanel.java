package Task06_1;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

public class BGPanel extends JPanel {

    public Image image;
    private String s;
    private Font font;

    public BGPanel() 
    {
        this.image = new ImageIcon("./resources/T06_bg.jpg").getImage();
        setPreferredSize(new Dimension(370, 300));
        s = "I love PDC :)";
        
        
    }
    
    public String getString()
    {
        return s;
    }
    
    public void setString(String s)
    {
        this.s = s;
    }
    
    /**
     * Draw the background of this panel.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        FontMetrics fm = g.getFontMetrics();
        g.drawImage(this.image, 0, 0, null);
        g.setFont(font);
        int stringWidth = fm.stringWidth(s);
        int stringX = (getWidth()/2) - stringWidth/2;
        g.drawString(s, stringX, 50);
    }
}
