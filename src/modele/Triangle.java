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
public class Triangle extends Forme{

    private Point pInit;
    private Point pFin;
    private int hauteur;
    private int largeur;
    private int[] tabX;
    private int[] tabY;
    
    public Triangle(Point pInit, Point pFin, Color couleur) {
        super(couleur);
        //initialisation tableaux
        this.tabX = new int[3];
        this.tabY = new int[3];
        this.pInit = new Point(pInit);
        this.pFin = new Point(pFin);
        this.largeur = Math.abs(pFin.getX()-pInit.getX());
        this.hauteur = Math.abs(pFin.getY()-pInit.getY());
        
        //calcul des coordonnées des 3 points du triangle
        this.tabX[0] = pInit.getX() + Math.abs(pFin.getX()-pInit.getX())/2;
        this.tabY[0] = pInit.getY();
        
        this.tabX[1] = pInit.getX();
        this.tabY[1] = pFin.getY();
        
        this.tabX[2] = pFin.getX();
        this.tabY[2] = pFin.getY();
    }
    
    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        g.drawPolygon(this.tabX,this.tabY,3);
    } 
}
