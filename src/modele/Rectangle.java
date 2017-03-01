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
public class Rectangle extends Forme{

    private Point pInit;
    private Point pFin;
    private int largeur;
    private int hauteur;
    
    public Rectangle(Point pInit, Point pFin, Color couleur) {
        super(couleur);
        this.pInit = new Point(pInit);
        this.pFin = new Point(pFin);
        this.largeur = Math.abs(pFin.getX()-pInit.getX());
        this.hauteur = Math.abs(pFin.getY()-pInit.getY());
    }
    
    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        
        //calcul direction du dessin
        int directionX = this.pInit.getX()-this.pFin.getX();
        int directionY = this.pInit.getY()-this.pFin.getY();
        
        //4 cas possibles
        if ((directionX > 0) && (directionY > 0)) {
            g.drawRect(this.pInit.getX()-this.largeur,this.pInit.getY()-this.hauteur,this.largeur,this.hauteur);
        }
        else if ((directionX < 0) && (directionY > 0)) {
            g.drawRect(this.pInit.getX(),this.pInit.getY()-this.hauteur,this.largeur,this.hauteur);
        }
        else if ((directionX > 0) && (directionY < 0)) {
            g.drawRect(this.pInit.getX()-this.largeur,this.pInit.getY(),this.largeur,this.hauteur);
        }
        else {
            g.drawRect(this.pInit.getX(),this.pInit.getY(),this.largeur,this.hauteur);
        }
    }
    
}
