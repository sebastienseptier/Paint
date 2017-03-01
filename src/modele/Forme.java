/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Sébastien
 */
public abstract class Forme {
    
    private Color couleur;
    
    public Forme(Color couleur) {
        this.couleur = couleur;
    }
    
    public void seDessiner(Graphics g) {
        g.setColor(this.couleur);
    }
}
