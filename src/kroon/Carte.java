package kroon;

/*  
On crée une classe Carte, qui va nous servir à rassembler toutes les caractéristiques
d'une carte (titre, texte, valeurs etc...) en un seul object.
On appelle instance de Carte, tout object de la classe Carte
Grâce à une boucle dans le main, on peut générer automatique des instances de Carte
Il devient alors plus simple de manipuler les variables de chaque instance.
*/

public class Carte 
{
    // Toutes les caractéristiques de chaque carte
    // Les variables sont privées, on utilise les fonctions pour récupérer ces valeurs
    
    private String titre;
    private String texte;
    
    private String r_oui;
    private int oui_eglise;
    private int oui_peuple;
    private int oui_armee;
    private int oui_finance;
    
    private String r_non;
    private int non_eglise;
    private int non_peuple;
    private int non_armee;
    private int non_finance;
    
    private String chemin_son;
    private String chemin_image;
    
    public Carte(String titre, String texte, String r_oui, int oui_eglise, int oui_peuple, int oui_armee, int oui_finance, String r_non, int non_eglise, int non_peuple, int non_armee, int non_finance, String chemin_son, String chemin_image)
    {
        // Chaque caractéristique prend une valeur qu'on lui donne lors de la création d'une carte
        
        this.titre = titre;
        this.texte = texte;
        
        this.r_oui = r_oui;
        this.oui_eglise = oui_eglise;
        this.oui_peuple = oui_peuple;
        this.oui_armee = oui_armee;
        this.oui_finance = oui_finance;
        
        this.r_non = r_non;
        this.non_eglise = non_eglise;
        this.non_peuple = non_peuple;
        this.non_armee = non_armee;
        this.non_finance = non_finance;
        
        this.chemin_son = chemin_son;
        this.chemin_image = chemin_image;
    }
    
    /* Les fonctions suivantes (encapsulation) servent à récupérer les variables
    d'un object Carte depuis notre interface graphique ou depuis notre main
    
    ex:
    Pour obtenir le texte de la Carte ma_carte, on utilise:
        
        ma_carte.getTitre();
    
    */
    
    public String getTitre()
    {
        return titre;
    }
    
    public String getTexte()
    {
        return texte;
    }
    public String getR_oui()
    {
        return r_oui;
    }
    public int getOui_eglise()
    {
        return oui_eglise;
    }
    public int getOui_peuple()
    {
        return oui_peuple;
    }
    public int getOui_armee()
    {
        return oui_armee;
    }
    public int getOui_finance()
    {
        return oui_finance;
    }
    public String getR_non()
    {
        return r_non;
    }
    public int getNon_eglise()
    {
        return non_eglise;
    }
    public int getNon_peuple()
    {
        return non_peuple;
    }
    public int getNon_armee() 
    {
        return non_armee;
    }
    public int getNon_finance()
    {
        return non_finance;
    }
    public String getChemin_son()
    {
        return chemin_son;
    }
    public String getChemin_image()
    {
        return chemin_image;
    }
    
}
