/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsGrafos;

import Dominio.Punto;
import Grafo.GrafoLista;
import Pila.Pila;
import org.junit.Test;

/**
 *
 * @author alex
 */
public class Grafos {
    
    @Test
    public void probarDFS()
    {
        
        GrafoLista grafo = new GrafoLista(10);
        Punto p1 = new Punto("A", 200.0, 150.0);
        Punto p2 = new Punto("B", 200.0, 160.0);
        Punto p3 = new Punto("C", 200.0, 170.0);
        Punto p4 = new Punto("D", 200.0, 180.0);
        Punto p5 = new Punto("E", 200.0, 151.0);
        Punto p6 = new Punto("F", 200.0, 152.0);
        Punto p7 = new Punto("G", 200.0, 153.0);

        grafo.agregarPunto(p1);
        grafo.agregarPunto(p2);
        grafo.agregarPunto(p3);
        grafo.agregarPunto(p4);
        grafo.agregarPunto(p5);
        grafo.agregarPunto(p6);
        grafo.agregarPunto(p7);
        
       grafo.agregarTramo(p1, p2, 100, true);
       grafo.agregarTramo(p1, p3, 101, true);
       grafo.agregarTramo(p1, p4, 102, true);
       grafo.agregarTramo(p4, p5, 103, true);
       grafo.agregarTramo(p4, p6, 104, true);
       grafo.agregarTramo(p2, p3, 105, true);
       
       grafo.buscarDFS(p1);

        
    }
    
}
