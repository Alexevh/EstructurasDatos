/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class CaminosMinimos {
    
    /* un objeto CaminosMInimos es una tabla de pesos, por un lado tenemos 
    primero un vector de enteros de costos, un vector de enteros de predecesores
    y un entero que es el objetivo*/
    
    
    	private int[] costos;
	private int[] predec;
	private int objetivo;
	
	public void setObjetivo(int value) {
		objetivo = value;
	}
	
	public int getObjetivo() {
		return objetivo;
	}
	
	public int[] getCostos() {
		return costos;
	}
	
	public int[] getPredec() {
		return predec;
	}
	
	public CaminosMinimos(int[] costos, int[] predec) {
		this.costos = costos;
		this.predec = predec;
	}
	
	public int getOrigen() {
		int i = 0;
		int origen = -1;
		boolean encontreOrigen = false;
		while (i < predec.length && !encontreOrigen) {
			if(predec[i] == -1) {
				origen = i;
			}
		}
		return origen;
	}
	
	public ArrayList<Integer> resultadoOrdenadoInverso(){
		
		ArrayList<Integer> resInverso = new ArrayList();
		resInverso.add(objetivo);
		int pre = predec[objetivo];
		while(pre!=-1) {
			resInverso.add(pre);
			pre = predec[pre];
		}
		System.out.println("");
		return resInverso;
	}
	
}
