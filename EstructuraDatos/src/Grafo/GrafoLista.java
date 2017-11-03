/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Dominio.Punto;

/**
 *
 * @author Alex
 */
public class GrafoLista {

    /* Un grafo va a tener al menos lo siguiente, un entero con la cantidad 
    de vertices que tiene actualmente, un entero con la cantidad maxima, un
    vector con las listas deadyacencias y un vector de Puntos.
    
    En nuestro ejemplo, un Punto es un objeto que tiene un nombre y dos coorenadas
    numericas, una ubicacion en un mapa.
     */
    private int cantidadActual;
    private int cantidadMaxima;
    private ListaAdy[] listaAdyacencias;
    private Punto[] puntos;

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public ListaAdy[] getListaAdyacencias() {
        return listaAdyacencias;
    }

    public void setListaAdyacencias(ListaAdy[] listaAdyacencias) {
        this.listaAdyacencias = listaAdyacencias;
    }

    public Punto[] getPuntos() {
        return puntos;
    }

    public void setPuntos(Punto[] puntos) {
        this.puntos = puntos;
    }

    /* Construir el grafo con una cantidad n de vertices posibles */
    public GrafoLista(int cantidad) {

        this.cantidadActual = 0;
        this.cantidadMaxima = cantidad;

        /* El tamaño del vector de listas de adyacencias esta limitado por 
        la cantidad de vertices posibles, cada vertice tiene su propia lista */
        this.listaAdyacencias = new ListaAdy[cantidad];

        /* Luego de crear el vector de la lista de adyacencias, vamos a poblarlas
        para ello en cada posocion del vector generamos una lista vacia */
        for (int i = 0; i < cantidad; i++) {
            this.listaAdyacencias[i] = new ListaAdy();
        }

        /* Tambien generamos un vector vacio de Puntos donde el tamaño del mismo
        es la cantidad de vertices posibles*/
        this.puntos = new Punto[cantidad];
    }

    /* Devuelve true si el grafo esta lleno */
    public boolean estaLleno() {
        return cantidadActual == cantidadMaxima;
    }

    /*
    Este metodo devuelve un lugar libre que haya en el array de puntos, si el  
    vector de puntos esta lleno devuelve -1
     */
    private int buscarIndice() {
        int i = 0;

        /* Uso el metodo estalleno, si es true devuelvo -1*/
        if (estaLleno()) {
            i = -1;
        } else {
            boolean encontre = false;
            /* Voy a recorrer el vector de puntos hasta encontrar un lugar que 
            este en null, cuando encuentre uno salgo del while y regreso el valor
            de i que es la posicion en el vector donde hay un lugar*/
            while (i < cantidadMaxima && !encontre) {
                if (puntos[i] == null) {
                    encontre = true;
                } else {
                    i++;
                }
            }
        }
        return i;
    }

    /* Buscar el indice de un Punto especifico. Devuelve -1 si no se encontro
    Voy a recorrer el vector de puntos fijandome si el Punto p corresponde a
    uno en el vector, si lo encuentro devuelvo su posicion.
    . */
    public int buscarIndice(Punto p) {
        int i = 0;
        boolean encontre = false;
        while (i < cantidadMaxima && !encontre) {
            if (p.equals(puntos[i])) {
                encontre = true;
            } else {
                i++;
            }
        }
        if (!encontre) {
            i = -1;
        }
        return i;
    }

    /* Agregar una arista/tramo 
       
    Lo primero que tenemos que hacer es encontrar el indice de cada punto para
    poder guardarlo en la lista de adyacencias, el metodo agregarTramo entonces
    nos pide los dos Puntos, el peso del tramo y un boolean si es dirigido.
        
    Obtenemos la posicion en el vector de puntos de los puntos A y B y vamos a
    pasar esos paramteros al metodo agregar tramo que va a escribir propiamente 
    en la lista de adyacencias
     */
    public void agregarTramo(Punto puntoA, Punto puntoB, int peso, boolean dirigido) {
        int origen = buscarIndice(puntoA);
        int destino = buscarIndice(puntoB);
        agregarTramo(origen, destino, peso, dirigido);
    }

    /* Obtuvimos los indices en el vector de Puntos ahora usamos el metodo de
    la lista de adyacencias para agregar el tramo desde el origen al destino
    
    Si el tramo es dirijido basta con esa sola llamada, pero el metodo se va a
    cerciorar, si el valor de dirijido es false, entonces se genera la adyacencia
    no solo de A hacia B sino tambien de B hacia A, la navegacion es a ambos lados
    
    El metodo funciona asi, en el vector de lista de adyacencias se para en
    origen lista[origen] y ejecuta insertar con destino, peso, si es no dirjido
    tambien se para en lista[destino] y ejecuta lo mismo
    
     */
    public void agregarTramo(int origen, int destino, int peso, boolean dirigido) {
        listaAdyacencias[origen].insertar(destino, peso);
        if (!dirigido) {
            listaAdyacencias[destino].insertar(origen, peso);
        }
    }

    /* Eliminar una arista/tramo 
    Al igual que en agregar, lo primero que hacemos es obtener las posiciones de
    cada punto en el vector de Puntos.
    
    Luego si le pasamos al metodo encargado la eliminacion
    
     */
    public void eliminarTramo(Punto puntoA, Punto puntoB, boolean dirigido) {
        int origen = buscarIndice(puntoA);
        int destino = buscarIndice(puntoB);
        eliminarTramo(origen, destino, dirigido);
    }

    /* Nos paramos en la posicion[origen] del vector de listas de adyacencias
    y ejecutamos la funcion eliminar[destino] lo que va a romper el enlace
    entre los dos tramos, si el tramo no es dirijido tambien rompe la de B a A*/
    public void eliminarTramo(int origen, int destino, boolean dirigido) {
        listaAdyacencias[origen].eliminar(destino);
        if (!dirigido) {
            listaAdyacencias[destino].eliminar(origen);
        }
    }

    /* Agregar un vertice/punto 
    Dado un punto primero busco una posicion libre en el indice del vector de
    puntos, si la posicion obtenida es mayor o igual a cero agrego el punto en
    la posicion i del vector y aumento en uno la cantidad actual. 
     */
    public void agregarPunto(Punto punto) {
        int i = buscarIndice();
        if (i >= 0) {
            puntos[i] = punto;
            cantidadActual++;
        }
    }

    /* Eliminar un vertice
    Primero obtengo la posicion del Punto en el vector de puntos del grafo
    si el resultado es distinto de null, o sea que hay un punto me voy a parar
    en el vector de listas de adyacencias en la posicion i y voy a llamar al
    metodo destruir y luego en esa misma posicion voy a crear una lista vacia
    Luego, en la posicion i del vector de puntos voy a poner NULL y al final
    resto 1 a la cantidad de puntos que el grafo tiene actualmente suados
     */
    public void eliminarPunto(Punto punto) {
        int i = buscarIndice(punto);
        if (puntos[i] != null) {
            listaAdyacencias[i].destruir();
            listaAdyacencias[i] = new ListaAdy();
            puntos[i] = null;
            cantidadActual--;
        }
    }

    /*
	 * Destruir el grafo, destruye el array de listas de adyacencia y el array de
	 * vertices/puntos
    
    El grafo tiene una cantidad N de vertices y por cada vertice hay una lista
    de adyacencias, entonces lo que hacemos es recorrer esa cantidad.
  
    Por cada posocion en la lista de adyacencias llamaos a destruir y por cada
    posicion en el vector de puntos ponemos null.
    
    Luego seteamos en cero el contador de cantidad actual y cantidad maxima
    
     */
    public void destruir() {
        for (int i = 1; i < cantidadMaxima; i++) {
            listaAdyacencias[i].destruir();
            puntos[i] = null;
        }
        cantidadActual = 0;
        cantidadMaxima = 0;
    }

    /* Buscar un punto por coordenadas en el array de puntos
    Nos pasan dos coordenadas y con eso hacemos un punto, al punto en realidad 
    le falta eldato nombre, pero nosotros en el dominio se hicimos un override
    del metodo equals, asi que cuando hacemos equals solo comparamos los valores
    de las coordenadas para decidir si son el mismo objeto   
     */
    public Punto buscarPunto(Double coordX, Double coordY) {
        Punto pAux = new Punto(coordX, coordY);
        for (Punto p : puntos) {
            if (p != null && p.equals(pAux)) {
                return p;
            }
        }
        return null;
    }

    /* Dado un indice en el vector de Puntos devuelvo un punto*/
    public Punto buscarPunto(int indice) {
        if (indice >= 0 && indice < puntos.length) {
            return puntos[indice];
        }
        return null;
    }

    /*
    Buscar peso de un tramo entre dos puntos. Devuelve -1 si el tramo no existe.
    Primero obtenemos los indices de cada punto en el vector de puntos y luego
    pasamos esos indices al metodo buscarTramo
     */
    public int buscarTramo(Punto puntoA, Punto puntoB) {
        int origen = buscarIndice(puntoA);
        int destino = buscarIndice(puntoB);
        return buscarTramo(origen, destino);
    }

    /* Dado dos posiciones en el vector de Puntos buscamos el tramo
    Se asegura que hay un tramo, si hay me devuelve el peso y si no me devuelve
    un -1   
     */
    public int buscarTramo(int origen, int destino) {
        return listaAdyacencias[origen].buscarPeso(destino);
    }

    /* [DIJKSTRA] Buscar caminos m�nimos desde un v�rtice/punto */
    public CaminosMinimos buscarCaminosMinimos(Punto a, Punto b) {
        int origen = buscarIndice(a);
        int destino = buscarIndice(b);
        if (origen >= 0) {
            return buscarCaminosMinimos(origen, destino);
        }
        return null;
    }

    public CaminosMinimos buscarCaminosMinimos(int origen, int destino) {
        /* Primero vamos a generar los vectores una matriz que consiste en
        un vector de visitados, otro de costos y otro de predecesores, todos
        tienen el mismo tama;o que es la cantidad maxima*/

        boolean[] visitados = new boolean[cantidadMaxima];
        int[] costos = new int[cantidadMaxima];
        int[] predec = new int[cantidadMaxima];

        /* Comenzamos posicionandonos en origen, entonces, primero en el vector
        de predecesores en la posiicon origen ponemos -1 y en el vector de costos
        posicion otigen ponemos cero, eso es por que el origen no tiene prdecesor
        y el costo de llegar a si ismo es cero, asimosmo ponemos en el vector de
        visitados en la posiion origen TRUE*/
        predec[origen] = -1;
        costos[origen] = 0;
        visitados[origen] = true;

        /* Ahora recorremos el vector para saber si son adjayenctes
        1. Si origen es adyacente a i
        2. Actualizo el vector de costos en posocion i con el restultado del peso
        del tramo origen,i
        3. Actualizo en la tabla de predecesores en la posicon i pongo origen.
        4. Si no son adyacentes entonces en el vector de costos[i] pongo maxvalue
        que es un valor infinito
        
         */
        for (int i = 0; i < cantidadMaxima; i++) {
            if (i != origen) {
                if (sonAdyacentes(origen, i)) {
                    costos[i] = buscarTramo(origen, i);
                    predec[i] = origen;
                } else {
                    costos[i] = Integer.MAX_VALUE;
                }
            }
        }

        /* Vamos a buscar el destino*/
        int objetivo = -1;
        /* Obtengo el punto qye quiero comparar*/
        Punto dest = buscarPunto(destino);
        
        /* Vamos a recorrer el vector de puntos para buscar el camino minimo
        
        */
        for (int k = 0; k < cantidadMaxima; k++) {
            
            /* Voy a buscarpor cada posicion en el vector si hay uno con
            camino minimo*/
            int v = buscarPuntoSinVisitarConCostoMinimo(costos, visitados);
            
            /* Si v es mayor o igual a cero es que existe el nodo, de lo contrario
            el metodo buscarpuntossin visitar me hubiera devuelto -1
            EN ese caso lo primero que hacemos es actualizar la tabla devisitados
            marcando en el vector visitados[v] el valor true
            
            Si en el vector de puntos en la posicion v encontre el destino marco
            como objetivo el valor de V que es la posicion del camino minimo
            
            Si no lo encontre entonces sigo con el metodo
            
            
            
            */
            if (v >= 0) {
                visitados[v] = true;

                if (puntos[v].equals(dest)) {
                    objetivo = v;
                    break;

                }
                
                /* Si no encontre el objetivo sigo con el metodo
                Obtengo un nodo yle asigno el valor del nodo que se encuentra
                en la posocion v del vector de listas de adyacencias.inicio
                
                MIentras w no sea null hago lo siguiente:
                
                1. visitados[destino] es false, o sea no lo visite
                2. el nodo.peso + costo[v] sea menor costos[w.destino]
                Si el peso del nodo mas el valor que esta en el vector de costo
                en posicion v es menor a el valor del contenido de costos[w.destino]
                entonces encontre una mejor ruta
                3. Actualizo cel vector de costos en posoiocn w.destino es igual
                a costos[v]+ w.peso
                4. Luego hago w = w.sig para pararme en el siguiente nodo y hacer
                el mismo calculo a ver si es una mejor ruta
                
                */
                
                NodoListaAdy w = listaAdyacencias[v].inicio;
                while (w != null) {
                    if (!visitados[w.destino] && w.peso + costos[v] < costos[w.destino]) {
                        costos[w.destino] = costos[v] + w.peso;
                        predec[w.destino] = v;
                    }
                    w = w.sig;
                }
            }
        }

        /* Genero un objeto caminos minimos y lo devuelvo*/
        CaminosMinimos caminos = new CaminosMinimos(costos, predec);
        caminos.setObjetivo(objetivo);
        return caminos;
    }

    /*
    El metodo recibe un vector de costos (int) y un vector de visitados (boolean)
    1. Recorremos el vector de puntos del 0 al final
    2. Si en el vector de visitados[i] esta en false significa que no lo visite
    en ese caso me fijo si costos[i] es menor que costoMin
    3. En caso de que costos[i] sea menor al minimo es que encontre un camino mas
    corto, en ese caso actualizo costoMIn con el valor que encontre y pongo el
    indicePunto (indice en el vector de puntos) el valor de i, luego de toda
    la recorrida devuelvo el indice
    */
    public int buscarPuntoSinVisitarConCostoMinimo(int[] costos, boolean[] visitados) {
        int costoMin = Integer.MAX_VALUE;
        int indicePunto = -1;
        for (int i = 0; i < visitados.length; i++) {
            if (!visitados[i]) {
                if (costos[i] < costoMin) {
                    costoMin = costos[i];
                    indicePunto = i;
                }
            }
        }
        return indicePunto;
    }

    /* Buscar si dos vertices/puntos son adyacentes 
    Primero obtengo los indices en el vecor de puntos de A y B
    luego los paso al metodo sondayacentes para saber si lo son
    
    */
    public boolean sonAdyacentes(Punto puntoA, Punto puntoB) {
        int a = buscarIndice(puntoA);
        int b = buscarIndice(puntoB);
        return sonAdyacentes(a, b);
    }

    /*
    Llamo al metodo pertenece parado en la posoiocn a del vector de listas de
    adyacencia, pregunto si pertenece b
    */
    public boolean sonAdyacentes(int a, int b) {
        return this.listaAdyacencias[a].pertenece(b);
    }

}
