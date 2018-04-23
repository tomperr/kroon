package kroon;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound 
{
    private File fichier_son;
    private Clip clip;
    private AudioInputStream flux_audio;
    
    // Valeur de l'ajustement du son par défaut
    private float modifDB = 0f;
    
    public void start()
    {
        // Joue le son une seule fois
        clip.start();
    }
    
    public void infinity()
    {
        // Joue le son en boucle (infini)
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void setSon(String chemin) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        // Fonction pour changer le son à jouer
        
        // Changement du fichier son
        fichier_son = new File(chemin);
        
        // Création d'un flux sonore jouable
        flux_audio = AudioSystem.getAudioInputStream(fichier_son);
        clip = AudioSystem.getClip();
        clip.open(flux_audio);
        
        // On modifie le volume sonore selon la variable modifDB (private)
        modifierSon();
    }
    
    public void setModifDB(float db)
    {
        // Fonction pour modifier la valeur du volume à ajuster
        modifDB = db;
    }
    
    public void modifierSon()
    {
        // Fonction qui modifie le volume sonore en fonction de la valeur de la variable modifDB (private)
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(modifDB);
    }

}
