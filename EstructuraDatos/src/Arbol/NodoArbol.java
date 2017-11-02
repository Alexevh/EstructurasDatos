/*
 * Nuestro arbol es simple, cada nodo solo va a tener 2 posibles hijos
 */
package Arbol;

/**
 *
 * @author Alexev
 */
public class NodoArbol {
    
    
      private int dato;
    
    private NodoArbol nodoIzq;
    
    private NodoArbol nodoDer;

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(NodoArbol nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public NodoArbol getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(NodoArbol nodoDer) {
        this.nodoDer = nodoDer;
    }
    
     public NodoArbol(int x)
    {
        this.dato =x;
    }
    
    
}
