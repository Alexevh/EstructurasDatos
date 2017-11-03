/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author alex
 */
public class ListaAdy {

    private int cantidad;
    NodoListaAdy inicio;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public NodoListaAdy getInicio() {
        return inicio;
    }

    public void setInicio(NodoListaAdy inicio) {
        this.inicio = inicio;
    }

    public ListaAdy() {
        this.inicio = null;
    }

    /* Metodo para insertar un nodo 
    Si tanto el destino como el peso son mayores o iguales a cero, creamos un
    nodo.
    
    Luego vemos, si en la lista de adyacencias el inicio no esta en null significa
    que no esta vacia, entonces seteamos como el nodo anterior al actual inicio
    el nodo nuevo y el nodo nuevo se convierte en el inicio.
    
    De lo contrario, la lista esta vacia y solo hacemos que el inicio sea el nodo nuevo
    
    EL grafo no contiene una lista de adyacencias, contiene un vector de listas
    cuyo tama;o es igual a la cantidad de verices, cada vertice mantiene su propia
    lista
    
     */
    public void insertar(int destino, int peso) {
        if (destino >= 0 && peso >= 0) {
            NodoListaAdy nodo = new NodoListaAdy(destino, peso);
            if (inicio != null) {
                inicio.ant = nodo;
                nodo.sig = inicio;
            }
            inicio = nodo;
            cantidad++;
        }
    }

    /* Voy a recorrer la lista para saber si la posocion que me pasand de punto
    es adyacente o no o sea si esta o no en mi lista
    
    Recorro todos los nodos, si encuentro uno con la posocion devuelvo true
    
    */
    public boolean pertenece(int posPunto) {
        NodoListaAdy nodo = inicio;
        boolean encontrado = false;
        while (nodo != null && !encontrado) {
            if (nodo.destino == posPunto) {
                encontrado = true;
            } else {
                nodo = nodo.sig;
            }
        }
        return encontrado;
    }

    /* Primero obtenemos el nodo con el metodo buscarNOdo
    Si el nodo es nulo devolvemos -1
    
    Si no es nulo devolvemos su peso.
    */
    public int buscarPeso(int posPunto) {
        NodoListaAdy nodo = buscarNodo(posPunto);
        if (nodo == null) {
            return -1;
        } else {
            return nodo.peso;
        }
    }

    /* 
    Vamos a buscar un nodo dado una posicion del punto, para eso hacemos>
    
    1. Vamos a comenzar en el inicio, asi que hacemos un nodo = inicio y otro
    nodoRet = null. (nodoRet es el que voy a retornar)
    
    2. Recoremos mientras nodo no sea nulo y no encontre.
    
    3. Si nodo.Destino == posPunto, nodoRet = nodo, encontre es true asi que
    devuelvo el nodo
    
    */
    public NodoListaAdy buscarNodo(int posPunto) {
        NodoListaAdy nodo = inicio;
        NodoListaAdy nodoRet = null;
        boolean encontre = false;
        while (nodo != null && !encontre) {
            if (nodo.destino == posPunto) {
                nodoRet = nodo;
                encontre = true;
            }
            nodo = nodo.sig;
        }
        return nodoRet;
    }

    /* Vamos a eliminar un nodo de la lista de adyacencias, para ello primero
    necesitamos encontrarlo
    
    Si inicio no es null o sea, la lista no esta vacia, vamos a obtener el nodo 
    inicio y lo recorremos con un while.
    
    Mientras nodo.destino (su adyacente) sea distinto de D que es lo que estamos
    buscando entonces nos paramos en el nodo siguiente nodo=nodo.sig.
    
    Cuando termine el while, si nodo obtenido es distinto de null vamos a unir
    el nodo anterior a el con el posterior a el, de esa manera eliminamos el
    actual
    
    */
    public void eliminar(int d) {
        if (inicio != null) {
            NodoListaAdy nodo = inicio;

            while (nodo.destino != d && nodo != null) {
                nodo = nodo.sig;
            }

            if (nodo != null) {
                unir(nodo.ant, nodo.sig);
                nodo = null;
                cantidad--;
            }
        }
    }
    
    /* Este metodo se usa en la funcion anterio para unir dos nodos al borrar otro
    Recibe dos nodos A y B, se agrega a A.sig=B y B.ant = A siempre que ninguno
    sea null    
    */
     public void unir(NodoListaAdy nodoA, NodoListaAdy nodoB) {
        if (nodoA != null) {
            nodoA.sig = nodoB;
            if (nodoB != null) {
                nodoB.ant = nodoA;
            }
        }
    }

     /* Voy a recorrer cada uno de los nodos de la lista de adyacencias y lo
     pongo en null
     
     Primero obtengo un nodo que referencio al inicio, luego un nodoaux
     mientras nodo sea distinto de null, voy a colocar en la variable auxiliar el
     valor del nodo, luego voy a poner nodo = nodo.sig (asigno a nodo el valor del
     siguiente nodo y luego pongo la auxiliar en null, al final resto 1 al contador
     de  cantidad)
     
     En cada ciclo la variable auxiliar toma el valor del ultimo nodo, el nodo
     toma el valor del siguiente, la auxiliar se pone en null y se repite el ciclo 
     hasta que el nodo.sig sea null.
     */
    public void destruir() {
        NodoListaAdy nodo = inicio;
        NodoListaAdy nodoAux = nodo;

        while (nodo != null) {
            nodoAux = nodo;
            nodo = nodo.sig;
            nodoAux = null;
            cantidad--;
        }
    }

   

}
