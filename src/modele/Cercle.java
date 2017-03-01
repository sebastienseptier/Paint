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
public class Cercle extends Forme{

    //Un cercle est caractérisé par un point de départ, un point de fin on en détermine une largeur
    private Point pInit;
    private Point pFin;
    private int largeur;
    
    public Cercle(Point pInit, Point pFin, Color couleur) {
        super(couleur);
        this.pInit = new Point(pInit);
        this.pFin = new Point(pFin);
        this.largeur = Math.abs(pFin.getX()-pInit.getX());
    }
    
    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        
        //calcul direction du dessin
        int directionX = this.pInit.getX()-this.pFin.getX();
        int directionY = this.pInit.getY()-this.pFin.getY();
        
        //4 cas possibles
        if ((directionX > 0) && (directionY > 0)) {
            g.drawOval(this.pInit.getX()-this.largeur,this.pInit.getY()-this.largeur,this.largeur,this.largeur);
        }
        else if ((directionX < 0) && (directionY > 0)) {
            g.drawOval(this.pInit.getX(),this.pInit.getY()-this.largeur,this.largeur,this.largeur);
        }
        else if ((directionX > 0) && (directionY < 0)) {
            g.drawOval(this.pInit.getX()-this.largeur,this.pInit.getY(),this.largeur,this.largeur);
        }
        else {
            g.drawOval(this.pInit.getX(),this.pInit.getY(),this.largeur,this.largeur);
        }
    }
    
}
