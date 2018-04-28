// github : https://github.com/Yoshinker/kroon

package kroon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Kroon 
{
    
    private static BufferedReader fR;
    private static String chemin_carte = "src/cartes/cartes.txt";
    private static String chemin_sauvegarde = "src/sauvegarde/score.txt";
        
    public static void main(String[] args) throws FileNotFoundException, IOException, UnsupportedAudioFileException, LineUnavailableException 
    {        

        // Nombre de cartes
        int nbCartes = nbCartes(chemin_carte);
        
        // Tableaux contenants toute nos cartes
        Carte mes_cartes[] = new Carte[nbCartes];
        
        // Ouverture du canal (on commence à la première ligne)
        fR = new BufferedReader(new FileReader(new File(chemin_carte)));
        
        for (int loop = 0; loop < mes_cartes.length; loop++)
        {
            // Pour chaque tour de boucle, une carte sera créée
            // Le fichier texte sera lu, et chaque ligne remplira une caractéristique de la carte
            
            // Lecture des lignes
            
            String mon_titre = lecture(fR);
            String mon_texte = lecture(fR);
            
            String mon_r_oui = lecture(fR);
            int mon_eglise_oui = Integer.parseInt(lecture(fR));
            int mon_peuple_oui = Integer.parseInt(lecture(fR));
            int mon_armee_oui = Integer.parseInt(lecture(fR));
            int mon_finance_oui = Integer.parseInt(lecture(fR));
            
            String mon_r_non = lecture(fR);
            int mon_eglise_non = Integer.parseInt(lecture(fR));
            int mon_peuple_non = Integer.parseInt(lecture(fR));
            int mon_armee_non = Integer.parseInt(lecture(fR));
            int mon_finance_non = Integer.parseInt(lecture(fR));
            
            String chemin_son = lecture(fR);
            String chemin_image = lecture(fR);
            
            // La ligne contenant "#" est inutile, et est purement visuel pour rendre le fichier texte plus lisible
            String inutile = lecture(fR);
            
            // Création de notre carte avec ses caractéristiques
            Carte ma_carte = new Carte(mon_titre, mon_texte, mon_r_oui, mon_eglise_oui,
                    mon_peuple_oui, mon_armee_oui, mon_finance_oui, mon_r_non, mon_eglise_non,
                    mon_peuple_non, mon_armee_non, mon_finance_non, chemin_son, chemin_image);
            
            // On ajoute cette carte à notre tableau de carte
            mes_cartes[loop] = ma_carte;
        }
        
        // On ferme le canal
        fR.close();     
        
        // Ouverture du canal de lecture pour le fichier de sauvegarde
        fR = new BufferedReader(new FileReader(new File(chemin_sauvegarde)));
        
        int score_facile = Integer.parseInt(lecture(fR));
        int score_difficile = Integer.parseInt(lecture(fR));

        // Ouverture de la fenêtre (interface graphique)
        Fenetre fenetre = new Fenetre(mes_cartes, score_facile, score_difficile, chemin_sauvegarde);

    }
    
    public static int nbCartes(String chemin) throws IOException
    {        
        // Fonction qui renvoie le nombre de carte dans le fichier
        
        // On ouvre le canal pour être à la première ligne
        BufferedReader fR = new BufferedReader(new FileReader(new File(chemin)));        
        
        // Compteur de lignes
        int compteur = 0;
        boolean loop = true;
        
        do
        {
            String maLigne = fR.readLine();
            if (maLigne != null)
            {
                // Si la ligne n'est pas vide
                compteur++;
            }
            else
            {
                // Si la ligne est vide
                loop = false;
            }
        } while (loop);
        
        fR.close();
        
        // On renvoie le nombre de ligne divisé par 13
        // car 13 lignes correspondent à une carte
        
        return compteur/15;
    }

    public static String lecture(BufferedReader reader) throws IOException
    { 
        // Fonction qui renvoie la ligne suivante d'un fichier OUVERT
        // (avec un BufferedReader déjà déclaré)
        
        String ligneFichier = reader.readLine();
        return ligneFichier;
    }
    
}
