/*
 * Implementacion de colas
 */
package Cola;

import Dominio.Punto;

/**
 *
 * @author alex
 */
public class Cola {
    
    NodoCola inicio;
    NodoCola fin;
    int tamano;
    
    public Cola()
    {
        inicio = null;
        fin=null;
        tamano =0;
    }
    
    public boolean estaVacia()
    {
        /* Si inicio es null esta vacia regresa true */
        return inicio==null;
    }
    
    public void insertar(Punto ele)
    {
        NodoCola nuevo = new NodoCola(ele);
        if (estaVacia())
        {
            inicio=nuevo;
        } else {
            fin.siguiente=nuevo;
        }
        
        /* El fin siempre apunta al nuevo */
        fin = nuevo;
        tamano++;
    }
    
    public NodoCola quitar()
    {
        NodoCola  aux = inicio;
        inicio = inicio.siguiente;
        tamano--;
        return aux;
        
    }
    
    public NodoCola inicoCola()
    {
        return inicio;
    }
    
    public int tamanoCola()
    {
        return tamano;
    }
}
