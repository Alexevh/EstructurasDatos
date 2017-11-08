/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

/**
 *
 * @author alex
 */
public class Pila {
    
    private NodoPila cima;
    
    private int tamano;

    public NodoPila getCima() {
        return cima;
    }

    public void setCima(NodoPila cima) {
        this.cima = cima;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    
    
    
    public  Pila()
    {
        this.cima=null;
        this.tamano = 0;
        
    }
    
    
    /* Saber si la pila esta vacia */
    public boolean estaVacia()
    {
        return this.cima==null;
    }
    
    /* Insertar elemento en la pila */
    
    public void push(NodoPila nodo)
    {
        nodo.setSiguiente(cima);
        cima=nodo;
        tamano++;
    }
    
    /* Sacar un elemento de la pila */
    public NodoPila sacar()
    {
        NodoPila aux = cima;
        cima = cima.getSiguiente();
        tamano--;
        return aux;
    }
    
    /* Saber quien esta en la cima de la pila */
    public NodoPila cima()
    {
        return cima;
    }
    
    /* Saber tama;o de la pila */
    public int tamano()
    {
        return tamano;
    }
    
    /* Limpiar o vaciar la pila */
    public void vaciar()
    {
        while (!estaVacia())
        {
            sacar();
        }
    }
}
