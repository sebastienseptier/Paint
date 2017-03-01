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
public class Droite extends Forme {

    //Une droie est caractérisée par 2 points
    private Point p1;
    private Point p2;
    
    public Droite(Point p1, Point p2, Color couleur) {
        super(couleur);
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }
    
    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
    
}
