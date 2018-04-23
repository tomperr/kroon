
package kroon;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanneauIntro extends JPanel
{
    public PanneauIntro()
    {
        super();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        // On appelle le constructeur "classique" du paintComponent
        super.paintComponent(g);
        
        // On délimite une zone rose
        g.setColor(new Color(200, 200, 200));
        g.fillRect(75, 225, 850, 260);
        //          x   y   L    H
        
        // On dessine le contour de la zone rose
        g.setColor(Color.black);
        g.drawRect(75, 225, 850, 260);
    }
            
}
