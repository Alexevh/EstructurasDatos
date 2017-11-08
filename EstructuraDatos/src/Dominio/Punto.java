/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author alex
 */
public class Punto {

    private String nombre;
    private Double coordX;
    private Double coordY;
    private int capacidadRequerida;
    private boolean visitado;

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    
    
    public int getCapacidadRequerida() {
        return capacidadRequerida;
    }

    public void setCapacidadRequerida(int capacidadRequerida) {
        this.capacidadRequerida = capacidadRequerida;
    }

    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCoordX() {
        return coordX;
    }

    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }

    public Double getCoordY() {
        return coordY;
    }

    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }

    public Punto(Double coordX, Double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.visitado=false;
    }

    public Punto(String nombre, Double coordX, Double coordY) {
        this.nombre = nombre;
        this.coordX = coordX;
        this.coordY = coordY;
        this.visitado=false;
    }

    @Override
    public boolean equals(Object o) {
        Punto p = (Punto) o;
        return this.coordX.equals(p.getCoordX()) && this.coordY.equals(p.getCoordY());
    }

}
