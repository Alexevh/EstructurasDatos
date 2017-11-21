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
    boolean visitado;

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    

    public Punto getDato() {
        return dato;
    }

    public void setDato(Punto dato) {
        this.dato = dato;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    public NodoCola(Punto i)
    {
        this.dato=i;
        this.siguiente =null;
    }
            
}
