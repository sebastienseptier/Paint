/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuecontrole;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modele.EnumCouleur;
import modele.EnumForme;

/**
 *
 * @author Sébastien
 */
public class BarreHaute extends JPanel implements ActionListener {
    
    //la barre haute dispose de 2 comboBox pour selectionner la couleur et la forme
    JComboBox combo;
    JComboBox combo2;
    //...ainsi que 2 boutons pour effacer ou défaire
    JButton effacer;
    JButton defaire; 
    EcouteurEﬀacer ecouteur1;
    Fenetre maFenetre;
    
    public BarreHaute(Fenetre maFenetre) {
        this.maFenetre = maFenetre;
        
        //classe interne locale
        class EcouteurDefaire implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("bouton appuyé : Defaire");
                BarreHaute.this.maFenetre.defaire();
            }
        }
        
        
        EnumCouleur [] color = EnumCouleur.values();
        EnumForme [] forme = EnumForme.values();
        EcouteurEﬀacer ecouteur1 = new EcouteurEﬀacer();
        EcouteurDefaire ecouteur2 = new EcouteurDefaire();
        
        /*Initialisation et Ajout écouteurs*/
        
        this.combo = new JComboBox();
        this.combo.addActionListener(this);
        this.combo2 = new JComboBox();
        this.combo2.addActionListener(this);
        
        effacer = new JButton("Effacer");
        this.effacer.addActionListener(ecouteur1); //on ajoute l'écouteur que l'on vient de créer dans la classe interne
        defaire = new JButton("Defaire");
        this.defaire.addActionListener(ecouteur2); //on ajoute l'écouteur2 que l'on vient de créer dans la classe interne locale
        
        for(EnumCouleur c : color) {
            this.combo.addItem(c);
        }
        
        for(EnumForme f : forme) {
            this.combo2.addItem(f);
        }
        
        this.add(combo);
        this.add(combo2);

        this.add(effacer);
        this.add(defaire);
        
        /* Couleurs */
        this.setBackground(new Color(80,80,80));
 
        this.setVisible(true);
        
        
    }//constructeur
    
    
    public EnumCouleur getCouleurSelectionnee(){
        return (EnumCouleur)this.combo.getSelectedItem();
    }
    
    public EnumForme getFormeSelectionnee() {
        return (EnumForme)this.combo2.getSelectedItem();
    }
    
    public static void main (String[] args) {
        /*JFrame fenetre = new JFrame();
        BarreHaute barre = new BarreHaute(maFenetre);
        fenetre.add(barre);
        fenetre.setVisible(true);*/
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(combo))
            System.out.println("comboBox appuyée : Couleur "+ this.getCouleurSelectionnee());
        if(ae.getSource().equals(combo2))
            System.out.println("comboBox appuyée : Forme "+ this.getFormeSelectionnee());

    }

   
    //Clase interne
    class EcouteurEﬀacer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("bouton appuyé : Effacer");
            maFenetre.effacer();
        }
        
    }
    

    
}
