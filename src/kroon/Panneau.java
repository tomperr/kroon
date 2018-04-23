package kroon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panneau extends JPanel
{
    // Image de fond, affiché tout le long de la partie (la variable n'est jamais modifié)
    private Image img_background = new ImageIcon("src/images/background.png").getImage();
    
    private Image img_carte;
    
    public Panneau(String chemin_img_carte)
    {
        // On appelle le constructeur de classe de JPanel
        // Cela nous permet d'avoir toutes les fonctions (appelées méthodes de classes)
        // d'un JPanel classique
        super();
        
        // On définit l'image à afficher
        setImgCarte(chemin_img_carte);
    }
    
    @Override
    protected void paintComponent(Graphics g) {

        // On appelle le constructeur "classique" du paintComponent
        super.paintComponent(g);
        
        // On affiche le fond d'écran
        g.drawImage(img_background, 0, 0, null);
        
        // On délimite une zone rose
        g.setColor(new Color(234, 180, 156));
        g.fillRect(300, 0, 400, 600);
        
        // On affiche l'image de la carte
        g.drawImage(img_carte, 325, 150, null);
        
        // On dessine les contours de la carte
        g.setColor(Color.black);
        g.drawRect(325, 150, 350, 350);
                
        // On dessine le contour de la zone rose
        g.setColor(Color.black);
        g.drawRect(300, 0, 400, 600);
        
        // On délimite la zone où seront les statistiques
        g.setColor(new Color(240,240,240));
        g.fillRect(300, 600, 400, 100);
        
        // On dessine les contours de la zone des statistiques
        g.setColor(Color.black);
        g.drawRect(300, 600, 400, 100);
        
        // On délimite la zone du nom de la carte
        g.setColor(new Color(240,240,240));
        g.fillRect(400, 535, 200, 30);
        
        // On déssine le contour de la zone du nom de la carte      
        g.setColor(Color.black);
        g.drawRect(400, 535, 200, 30);
        
    }
    
    public void setImgCarte(String chemin)
    {
        // Fonction pour changer l'image de la carte à afficher
        
        img_carte = new ImageIcon("src/images/" + chemin).getImage();
    }
}
