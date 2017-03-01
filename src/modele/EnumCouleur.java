/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Color;

/**
 *
 * @author Sébastien
 */
public enum EnumCouleur {
    
    ROUGE(Color.red),
    VERT(Color.green),
    BLEU(Color.blue),
    NOIR(Color.black);
    
    
    private Color color;
    
    EnumCouleur( Color couleur) {
        this.color = couleur;
    }
    
   
    
    public Color getColor() {
        return this.color;
    }
    
}
