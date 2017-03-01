/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuecontrole;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import modele.EnumCouleur;
import modele.EnumForme;
import modele.Forme;
import modele.Droite;
import modele.Cercle;
import modele.Ovale;
import modele.Point;
import modele.Rectangle;
import modele.Triangle;

/**
 *
 * @author Sébastien
 */
public class ZoneGraphique extends Canvas implements MouseMotionListener,MouseListener {
    
    //la zone graphique dispose d'une barre basse et une barre haute, toute forme a un point de debut et de fin
    private BarreBasse barreBasse;
    private BarreHaute barreHaute;
    private Point pInit;
    private Point pFin;
    
    boolean intermediaire; // variable pour savoir si ce qu'on dessine est temporaire ou non (clic continu ou non)
    private LinkedList<Forme> mesFormes;
    
    public ZoneGraphique(BarreBasse barreBasse, BarreHaute barreHaute) {
        
        //initialisation des éléments
        this.barreBasse = barreBasse;
        this.barreHaute = barreHaute;
        this.pInit = new Point();
        this.pFin = new Point();
        mesFormes = new LinkedList<Forme>();
        
        //ajout des ecouteurs
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        
        this.setBackground(Color.white);
        this.intermediaire = false;
    }

    
    @Override
    public void mouseDragged(MouseEvent me) {
        System.out.println("Mouse dragged!");
        pFin.setX(me.getX());
        pFin.setY(me.getY());
        intermediaire = true; //clic continu de la souris
        dessin(); //on dessine une forme
        
        barreBasse.deplacementSouris(me);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        System.out.println("Mouse moved!");
        barreBasse.deplacementSouris(me);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("Mouse clicked!");
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        pInit.setX(me.getX());
        pInit.setY(me.getY());
        barreBasse.setMessage("Relâcher pour voir la forme");
        System.out.println("Mouse pressed! Coor X:" + pInit.getX() + ", Y:" + pInit.getY());
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        pFin.setX(me.getX());
        pFin.setY(me.getY());
        intermediaire = false; //souris lachée
        dessin(); //on dessine la dernière forme à faire
        barreBasse.setMessage("Cliquez pour initier une forme");
        System.out.println("Mouse released! Coor X:" + pFin.getX() + ", Y:" + pFin.getY());
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        System.out.println("Mouse entered!");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        System.out.println("Mouse exited!");
    }
    
    
    
    private void dessin(){
         
        //selection forme et couleur
        EnumForme forme = this.barreHaute.getFormeSelectionnee();
        Color couleur = this.barreHaute.getCouleurSelectionnee().getColor();
        
        switch (forme) {
            case DROITE:
                
                //crée la droite
                Droite droite = new Droite(pInit, pFin, couleur);
                System.out.println("Droite!");
                //on l'ajoute à la liste
                mesFormes.add(droite);
                paint(getGraphics()); //on la trace
                
                //si c'est une droite intermédiaire
                if (intermediaire) {
                    //on retire le dernier trait effectué de la liste
                    System.out.println(mesFormes.size());
                    mesFormes.remove(this.mesFormes.size()-1);
                    
                   update(getGraphics());
                }
                
                break;
            case CERCLE:
                
                Cercle cercle = new Cercle(pInit, pFin, couleur);
                System.out.println("Cercle!");
                mesFormes.add(cercle);
                
                cercle.seDessiner(getGraphics());
                
                if (intermediaire) {
                    System.out.println(mesFormes.size());
                    mesFormes.remove(this.mesFormes.size()-1);
                }
                
                update(getGraphics());
                break;
            case OVALE:

                Ovale ovale = new Ovale(pInit, pFin, couleur);
                System.out.println("Ovale!");
                mesFormes.add(ovale);
                
                ovale.seDessiner(getGraphics());
                
                if (intermediaire) {
                    System.out.println(mesFormes.size());
                    mesFormes.remove(this.mesFormes.size()-1);   
                }
                
                update(getGraphics());
                break;
            case RECTANGLE:
                
                Rectangle rect = new Rectangle(pInit, pFin, couleur);
                System.out.println("Rectangle!");
                mesFormes.add(rect);
                
                rect.seDessiner(getGraphics());
                
                if (intermediaire) {
                    System.out.println(mesFormes.size());
                    mesFormes.remove(this.mesFormes.size()-1);
                }
                
                update(getGraphics());
                break;
            case TRIANGLE:

                Triangle triangle = new Triangle(pInit, pFin, couleur);
                System.out.println("Triangle!");
                mesFormes.add(triangle);
                
                triangle.seDessiner(getGraphics());
                
                if (intermediaire) {
                    System.out.println(mesFormes.size());
                    mesFormes.remove(this.mesFormes.size()-1);
                }
                
                update(getGraphics());
                break;
            default:
                
                break;                
        }   
    }
    
    @Override
    public void paint(Graphics g) {
        for (Forme forme : mesFormes) {
            forme.seDessiner(g);
        }
    }
    
    @Override
    public void update(Graphics g ) {
        paint(g);
    }
    
    public void effacer() {
        //s'il y a des choses à effacer...
        if (this.mesFormes.size()>0) {
            System.out.println("Effacer tout!");
            this.mesFormes.clear(); //on supprime et on rafraîchit
            update(getGraphics());
        }
    }
    
    public void defaire() {
        //s'il y a qqchose à effacer...
        if (this.mesFormes.size()>0) {
            System.out.println("Effacer précédent!");
            this.mesFormes.remove(this.mesFormes.size()-1);//on supprime la dernière forme et on rafraîchit
            update(getGraphics());
        }
    }
    
}
