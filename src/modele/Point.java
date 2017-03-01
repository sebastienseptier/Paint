/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Sébastien
 */
public class Point {
    
    /*attributs*/
    
    private int x;
    private int y;
    
    /*Constructeur*/
    
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point (Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }
            

    /*Getter*/
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    @Override
    public String toString() {
        String str = "{";
        str += "(X : " + this.x + ", Y : " + this.y + ")\n}";
        return str;
    }
    
    public static void main(String[] args) {
        Point point = new Point(50,40);
        System.out.println(point.toString());
    }
    
}
