/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author Alex
 */
public class NodoListaAdy {
    
    
    /* Esta clase es cada nodo de la lista de ayacencia tiene un int que es el
    destino, otro entero que es el peso, una referencia al nodo anterior y otra
    referencia al nodo siguiente*/
    
    	public int destino;
	public int peso;
	public NodoListaAdy ant;
	public NodoListaAdy sig;

        /* Si creamos un nodo vacio le ponemos estos valores por defecto*/
	public NodoListaAdy() {
		this.destino = -1;
		this.peso = -1;
		this.ant = null;
		this.sig = null;
	}

	public NodoListaAdy(int d, int p) {
		this.destino = d;
		this.peso = p;
		this.ant = null;
		this.sig = null;
	}

}
