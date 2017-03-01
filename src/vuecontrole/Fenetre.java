
package vuecontrole;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Sébastien
 */
public class Fenetre extends JFrame {
    
    private BarreBasse barreBasse;
    private BarreHaute barreHaute;
    private ZoneGraphique zoneGraphique;
    private EcouteurFenetre ecouteurFenetre;
    
    
    /* Constructeur par défaut */
    public Fenetre() {
        //initialisation
        this.barreBasse = new BarreBasse();
        this.barreHaute = new BarreHaute(this);
        this.zoneGraphique = new ZoneGraphique(barreBasse, barreHaute);
        this.ecouteurFenetre = new EcouteurFenetre();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Ma fenêtre Java");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //ajout des éléments de la fenêtre
        this.add(barreHaute, BorderLayout.NORTH);
        this.add(barreBasse, BorderLayout.SOUTH);
        this.add(zoneGraphique);
        //ajout écouteur
        this.addWindowListener(ecouteurFenetre);
        
        this.setVisible(true);
    }
    
    public void effacer() {
        this.zoneGraphique.effacer();
    }
    
    public void defaire() {
        this.zoneGraphique.defaire();
    }
    
    
    public static void main (String[] args) {
        Fenetre maFenetre = new Fenetre();
    }
}
