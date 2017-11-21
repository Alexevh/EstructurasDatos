/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestArboles;

import Arbol.Arbol;
import Arbol.NodoArbol;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author alex
 */
public class PruebasArbol {
    
    public Arbol generarArbol(){
     
        Arbol a = new Arbol();
        a.insertar(50);
        a.insertar(45);
        a.insertar(59);
        a.insertar(30);
        a.insertar(46);
        a.insertar(51);
        a.insertar(60);
        
        return a;
    }
    
       public Arbol generarArbolPares(){
     
        Arbol a = new Arbol();
        a.insertar(50);
        a.insertar(44);
        a.insertar(58);
        a.insertar(30);
        a.insertar(46);
        a.insertar(52);
        a.insertar(60);
        
        return a;
    }
    
    @Test
    public void saberSiUnElementoExiste()
    {
        Arbol a = this.generarArbol();
        
        boolean existeRaiz = a.pertenece(50);
        boolean existeHojaIz = a.pertenece(30);
        boolean existeNodoDer = a.pertenece(59);
        
       
        Assert.assertTrue(existeHojaIz);
        Assert.assertTrue(existeNodoDer);
        Assert.assertTrue(existeRaiz);
    }
    
    
    @Test
    public void listarAscendente()
    {
        Arbol a = generarArbol();
        a.listarAscendente();
    }
    
    @Test
    public void borrarMinimo()
    {
        Arbol a = generarArbol();
        a.borrarMinimo();
        Assert.assertFalse(a.pertenece(30));
    }
    
    @Test
    public void buscar(){
        Arbol a = generarArbol();
        NodoArbol nodo = a.buscar(a.getRaiz(), 50);
        
        Assert.assertNotNull(nodo);
        
        
    }
    
    @Test
    public void cantidadHojas()
    {
        Arbol a = generarArbol();
        int hojas = a.cantHojas();
        /* En el arbol generado hay 7 nodos pero solo 4 de ellos no tienen hijos
        por lo que son hojas*/
        Assert.assertEquals(4, hojas);
    }
    
    @Test
    public void altura()
    {
        Arbol a = generarArbol();
        
        int altura = a.altura();
        Assert.assertEquals(2, altura);
    }
    
    @Test
    public void borrarElementos()
    {
        Arbol a = generarArbol();
        /* Borro una hoja */
        a.borrarElementoV2(46);
        /* Borro un nodo intermedio*/
        a.borrarElementoV2(59);
        /* Borro la raiz*/
        a.borrarElementoV2(50);
        /* Imprimo el arbol resultante*/
        a.listarAscendente();
    }
    
    @Test
    public void cantidadNodos()
    {
        Arbol a = generarArbol();
        int cantidad = a.cantidadNodos();
        Assert.assertEquals(7, cantidad);
    }
    
    @Test
    public void todosPares()
    {
        Arbol a = generarArbol();
        boolean impares = a.todosPares();
        Assert.assertFalse(impares);
        
        Arbol b =generarArbolPares();
        boolean pares = b.todosPares();
        Assert.assertTrue(pares);
    }
    
    @Test
    public void sonIguales()
    {
        Arbol a = generarArbol();
        Arbol b= generarArbol();
        
        boolean iguales = a.sonIGuales(a, b);
        Assert.assertTrue(iguales);
    }
    
    @Test
    public void clonarArbol()
    {
        Arbol a = generarArbol();
        Arbol b = a.clonarArbol(a);
        
          boolean iguales = a.sonIGuales(a, b);
        Assert.assertTrue(iguales);
    }
}
