/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsGrafos;

import Dominio.Punto;
import Grafo.CaminosMinimos;
import Grafo.GrafoLista;
import Pila.Pila;
import java.util.Arrays;
import org.junit.Test;

/**
 *
 * @author alex
 */
public class Grafos {
    
    public GrafoLista obtenerGrafo()
    {
         GrafoLista grafo = new GrafoLista(10);
        Punto a = new Punto("A", 200.0, 150.0);
        Punto b = new Punto("B", 200.0, 160.0);
        Punto c = new Punto("C", 200.0, 170.0);
        Punto d = new Punto("D", 200.0, 180.0);
        Punto e = new Punto("E", 200.0, 151.0);
        Punto f = new Punto("F", 200.0, 152.0);
        Punto g = new Punto("G", 200.0, 153.0);
        

        grafo.agregarPunto(a);
        grafo.agregarPunto(b);
        grafo.agregarPunto(c);
        grafo.agregarPunto(d);
        grafo.agregarPunto(e);
        grafo.agregarPunto(f);
        grafo.agregarPunto(g);
        
       grafo.agregarTramo(a, b, 100, false);
       grafo.agregarTramo(a, c, 101, false);
       grafo.agregarTramo(b, f, 102, false);
       grafo.agregarTramo(c, d, 103, false);
       grafo.agregarTramo(d, g, 105, false);
       grafo.agregarTramo(f, g, 104, false);
       grafo.agregarTramo(b, c, 10, false);
       grafo.agregarTramo(f, e, 1, false);
       grafo.agregarTramo(g, e, 100, false);
       grafo.agregarTramo(b, d, 1, false);
       return grafo;
    }
    
    @Test
    public void probarBFS()
    {
        GrafoLista g =obtenerGrafo();
        Punto z = new Punto("Z", 200.0, 222.0);
        Punto y = new Punto("Y", 200.0, 223.0);
        g.agregarPunto(y);
        g.agregarPunto(z);
        g.agregarTramo(g.buscarPunto(4), z, 10, false);
        g.agregarTramo(g.buscarPunto(4), y, 100, false);
        
         for (int i=0; i< g.getCantidadActual(); i++)
      {
          g.getPuntos()[i].setVisitado(false);
      }
         
      Punto a = g.buscarPunto(0);
      
     
      
       g.recorrerBFS(a);
    }
    
    @Test
    public void probarDFS()
    {
        
        GrafoLista g =obtenerGrafo();
        Punto z = new Punto("Z", 200.0, 222.0);
        Punto y = new Punto("Y", 200.0, 223.0);
        g.agregarPunto(y);
        g.agregarPunto(z);
        g.agregarTramo(g.buscarPunto(4), z, 10, false);
        g.agregarTramo(g.buscarPunto(4), y, 100, false);
        
      Punto a = g.buscarPunto(0);
      
      for (int i=0; i< 7; i++)
      {
          g.getPuntos()[i].setVisitado(false);
      }
      
       g.buscarDFS2(a);

        
    }
    
    @Test
    public void buscarCaminosMInimos()
    {
        GrafoLista g =obtenerGrafo();
        Punto a = g.buscarPunto(3);
        Punto b = g.buscarPunto(4);
        
        CaminosMinimos c = g.buscarCaminosMinimos(a, b);
        System.out.println(c.resultadoOrdenadoInverso());
    }
    
    
}
