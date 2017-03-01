/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuecontrole;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Sébastien
 */

public class EcouteurFenetre implements WindowListener {
    
    public EcouteurFenetre() {
        
    }

    @Override
    public void windowOpened(WindowEvent we) {
        System.out.println("Windows opened!");
    }

    @Override
    public void windowClosing(WindowEvent we) {
        System.out.println("Windows closing...");
    }

    @Override
    public void windowClosed(WindowEvent we) {
        System.out.println("Windows closed!");
    }

    @Override
    public void windowIconified(WindowEvent we) {
        System.out.println("Windows iconified!");
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        System.out.println("Windows deiconified!");
    }

    @Override
    public void windowActivated(WindowEvent we) {
        System.out.println("Windows activated!");
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        System.out.println("Windows deactivated!");
    }
    
}
