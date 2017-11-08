/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import Dominio.Punto;

/**
 *
 * @author alex
 */
public class HashNodo {
    
    private Punto punto;
    private int indiceNodo;
    private HashNodo sig;

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public int getIndiceNodo() {
        return indiceNodo;
    }

    public void setIndiceNodo(int indiceNodo) {
        this.indiceNodo = indiceNodo;
    }

    public HashNodo getSig() {
        return sig;
    }

    public void setSig(HashNodo sig) {
        this.sig = sig;
    }
    
    	public HashNodo(Punto punto, int ind, HashNodo sig) {
		this.punto = punto;
		this.indiceNodo = ind;
		this.sig = sig;
	}
        
        
        public HashNodo(Punto punto, int ind) {
		this.punto = punto;
		this.indiceNodo = ind;
		this.sig = null;
	}
    
}
