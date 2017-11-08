/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

import Dominio.Punto;

/**
 *
 * @author alex
 */
public class NodoCola {
    
    Punto dato;
    NodoCola siguiente;
    
    public NodoCola(Punto i)
    {
        this.dato=i;
        this.siguiente =null;
    }
            
}
