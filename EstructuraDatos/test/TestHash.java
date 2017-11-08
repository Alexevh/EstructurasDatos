
import Dominio.Punto;
import Hash.HashTable;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class TestHash {
    
    @Test
    public void listarNodos()
    {
        HashTable tabla = new HashTable(10);
        Punto p1 = new Punto(200.00, 300.00);
        Punto p2 = new Punto(300.00, 300.00);
        Punto p3 = new Punto(400.00, 300.00);
        tabla.agregar(p1, tabla.buscarIndice(p1.getCoordX(), p1.getCoordY()));
        tabla.agregar(p2, tabla.buscarIndice(p1.getCoordX(), p1.getCoordY()));
        tabla.agregar(p3, tabla.buscarIndice(p1.getCoordX(), p1.getCoordY()));
        System.out.println(tabla.getTamanio());
        
        tabla.eliminar(p1.getCoordX(), p1.getCoordY());
     
        
        
    }
}
