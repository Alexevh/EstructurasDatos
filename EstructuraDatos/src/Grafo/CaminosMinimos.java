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
                
                /* Comienzo a;adiendo el objetivo al que apunte */
		resInverso.add(objetivo);
                
                /*Ahora voy a tener el predecesor de objetivo*/
		int pre = predec[objetivo];
                
                /*Mientras el predecsor sea distinto de -1 o sea no soy el raiz del que salio */
		while(pre!=-1) {
                     
                        /*Agrego al resultado el predecsor*/
			resInverso.add(pre);
                        /*Predecesor ahora es el predesor de pre*/
			pre = predec[pre];
		}
		System.out.println("");
		return resInverso;
	}
        
        /* Obtuve una lista de caminos, su predecsor y el costo */
        public ArrayList<Integer> resultadoOrdenado(){
		
		ArrayList<Integer> resultado = new ArrayList();
		resultado.add(objetivo);
		int pre = predec[objetivo];
		while(pre!=-1) {
			resultado.add(pre);
			pre = predec[pre];
		}
		System.out.println("");
		return resultado;
	}
	
}
