/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

import Dominio.Punto;

/**
 *
 * @author alex
 */
public class NodoPila {
    
    private Punto dato;
    private NodoPila siguiente;

    public Punto getDato() {
        return dato;
    }

    public void setDato(Punto dato) {
        this.dato = dato;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    public NodoPila(Punto elemento)
    {
        this.dato = elemento;
        this.siguiente = null;
    }
    
    
    
}
