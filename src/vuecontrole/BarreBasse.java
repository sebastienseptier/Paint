/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuecontrole;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sébastien
 */
public class BarreBasse extends JPanel {
    
    //La barre basse dispose de 2 labels pour donner les coordonnées de la souris, et d'un autre pour afficher un msg
    private JLabel x;
    private JLabel y;
    private JLabel message;
    
    public BarreBasse() {
        /* Création des labels */
        this.message = new JLabel("Bonne année"); 
        this.x = new JLabel("X = 0");
        this.y = new JLabel("Y = 0");
        
        /* Ajout des labels sur la barre */
        this.add(this.message);
        this.add(this.x);
        this.add(this.y);
        
        /* Couleurs */
        this.setBackground(new Color(50,120,200));
        this.message.setForeground(Color.white);
        this.x.setForeground(Color.white);
        this.y.setForeground(Color.white);
        
        /* visibilité*/
        this.setVisible(true);
    }
    
    /* ACCESSEURS */
    
    public JLabel getMessage() {
        return message;
    }
    
    public void setMessage(String msg) {
        this.message.setText(msg);
    }
    
    /* Méthodes */
    
     public void deplacementSouris(MouseEvent evt) {
         this.x.setText("X = " + evt.getX());
         this.y.setText("Y = " + evt.getY());
     }
    
    
    public static void main (String[] args) {
        
        /*JFrame fenetre = new JFrame();
        BarreBasse barre = new BarreBasse();
        
        fenetre.add(barre);
        fenetre.setVisible(true);*/
    }
}
