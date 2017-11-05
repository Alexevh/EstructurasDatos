/*
 * 
 */
package Arbol;

/**
 *
 * @author Alexev
 */
public class Arbol {

    private NodoArbol raiz;

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    /* Insertamos un elemento de manera ordenada
    
     */
    public void insertar(int x) {
        if (this.raiz == null) {
            /* Si raiz es null significa que el arbol esta vacio asi que
            en ese caso simplemente seteamos el nodo como la raiz*/
            NodoArbol nodo = new NodoArbol(x);
            raiz = nodo;
        } else {

            /*Si no esta vacio, entonces usamos la funcion */
            insertarElemento(x, raiz);
        }

    }

    /* Funcion recursiva que lo inserta 
    En el arbol que construimos solo tenemos 2 hijos por padre, arbitrariamente
    elejimos que dado un punto, si el valor es mayor va a ir al izquierdo y si
    es menor va a ir a la derecha.
    
    El algoritmo funciona asi: 
    
    a) El metodo recibe dos valores, un entero que es nuevo dato a insertar y 
    un Nodo (que su dato dentro es un entero).
    
    b) La primera vez que se llama al metodo se pasa el numero y el nodo raiz
    
    Imaginemos que en el raiz tenemos guardado un 2 y nos pasan un 4, entonces
    el algoritmo lo que hace es, compara si 4 es mayor que 2, como 4 si es mayor
    que dos entra en el primer IF, se fija si el nodo de la izquierda esta vacio
    y si esta vacio entonces guarda ahi el numero.
    
    Imaginemos que el nodo de la izquierda no estaba vacio y tenia 3, entonces
    el algoritmo vuelve a ejecutarse esta vez pasando como paramtero el valor 4
    y el nodo de la izquierda.
    
    Compara entonces si 4 es mayor que 3, como 4 es mayor que 3 vuelve a ejecutar
    el primer IF, si esta vacio entonces se guarda ahi, de lo contrario vuelve
    a ejecutar el procedimiento.
    
    Imaginemos que debajo del 3 habia un 5, Se ejecuta nuevamente el algoritmo
    pasando el numero 4 y el nodo izquierdo de 3 con valor 5, el algoritmo 
    pregunta, 4 es mayor que 5? como 4 es menor, entonces entra en el 2do IF ya
    que lo va a tener que colocar a la derecha del nodo cuyo valor era 5.
    
    Este segundo IF es identico al primero salvo por que la recursividad va
    sobre el nodo derecho
    
    
     */
    private void insertarElemento(int x, NodoArbol n) {
        /* Si el valor es mayor a X */
        if (n.getDato() > x) {
            /* Nos fijamos si el nodo izquierdo esta vacio, si eso es asi 
            entonces ponemos en el nodo izquiero el nuevo nodo*/
            if (n.getNodoIzq() == null) {
                n.setNodoIzq(new NodoArbol(x));

            } else {
                /* Si el nodo izquierdo no estaba vacio ejecutamos la funcion
                nuevamente para insertar*/
                insertarElemento(x, n.getNodoIzq());
            }

            /* Si el valor no fue mayor a X entonces lo ponemos e el derecho*/
        } else if (n.getNodoDer() == null) {
            n.setNodoDer(new NodoArbol(x));
        } else {
            insertarElemento(x, n.getNodoDer());
        }

    }

    /* Saber si un entero pertenece al arbol o sea si existe */
    public boolean pertenece(int x) {
        return pertenece(x, this.raiz);
    }

    /* Recursiva para saber si pertenece o no
    El algoritmo funciona asi:
    
    La primera vez que es llamado obtiene el numero a saber sipertenece y el nodo
    raiz que es donde empezaremos a buscar.
    
    Lo primero que se fija es si el nodo que le pasamos es null, en cuyo caso
    retorna false
    
    Si el dato del nodo es igual a X entonces el nodo contiene el dato y lo
    encontramos, por lo que retornamos true
    
    Si el dato no es null, pero tampoco es el que buscamos, nos fijamos si el
    dato es mayor a X, en cuyo caso ejecutamos el pertenece con el valor X y el
    nodoIzquierdo, en cambio si no es mayor (o sea es menor) hacemos lo mismo
    pero pasando como segundo paramtero el nodoDerecho.
    
     */
    public boolean pertenece(int x, NodoArbol n) {
        if (n == null) {
            return false;
        }

        if (n.getDato() == x) {
            return true;
        }

        if (n.getDato() > x) {
            return pertenece(x, n.getNodoIzq());
        } else {
            return pertenece(x, n.getNodoDer());
        }

    }

    /* Listar Acendente -In order -*/
    public void listarAscendente() {
        listarAscendente(this.raiz);

    }

    /* Recursiva para listar ascendente 
    El algoritmo funciona asi:
    
    El metodo recibe un nodo del cual partir, generalmente va a ser desde la raiz
    
    Si el nodo es null hacemos un return
    
    EN caso contrario ejecutamosla funcion dandole comonodo el izquierdo, luego
    hacemos un print del dato y luego ejecutamos la funcion con el derecho.
    
    El algoritmo no parece gran cosa, pero es una forma de demostrar como podemos
    recorrer un arbol recursivamente
    
    
     */
    private void listarAscendente(NodoArbol n) {
        if (n == null) {
            return;

        } else {
            listarAscendente(n.getNodoIzq());
            System.out.println(n.getDato());
            listarAscendente(n.getNodoDer());
        }
    }

    /* Vamos a borrar el nodo con el minimo valor*/
    private void borrarMinimo() {
        raiz = eliminarMin(raiz);
    }

    /* Recursiva que hace el trabajo de borrar el minimo
    
    Funciona asi:
    
    El algoritmo recibe un nodo, si es nodo es null lregresa ese nodo
    
    Si el nodo que nos pasaron no es nulo,entonces si fija, si el nodo A tiene
    un nodo izquierdo distinto de null  trata de setear como nodoIZq el resultado
    de eliminarMin a su nodo izquierdo actual y regresa A, de lo contrario retrna
    a.nododerecho.
    
    Imaginemos lo siguiente, nos pasan la raiz que tiene un 10, el algoritmo se
    fija, a == null? la respuesta es NO, entonces sigue con lo demas, si hubiera
    sido null regresaba el nodo.
    
    Entonces se fija el nodo A tiene un valor en la izquierda distinto de null?
    si A tiene un valor en la izquierda distinto de null significa que ahi hay
    un nodo en cuyo caso va a hacer a.setnodoizquierdo eliminarminimo de su nodo
    izquierdo, si nodo izquierdo tiene un nodo izquierdo en null, se va a retornar
    A que es null, por lo que el nodo izquierdo anterio se elimina.
    
    Si el nodo izquierdo ya era null regersamos el nodo derecho como uevo valor 
    de A
    
    */
    private NodoArbol eliminarMin(NodoArbol a) {
        if (a == null) {
            return a;
        }

        if (a.getNodoIzq() != null) {
            a.setNodoIzq(eliminarMin(a.getNodoIzq()));
            return a;
        } else {
            return a.getNodoDer();
        }

    }
    
    /* Metodo axuliar para buscar un elemtno con una firma*/
      private NodoArbol buscar(int elemento) {
        return buscar(raiz, elemento);
    }
    
    /* Buscar un nodo en el arbol*/
    public NodoArbol buscar(NodoArbol a, int dato) {

        /* Casos base, si el nodo es null devolvemos null , pero si el nodo
        contiene el dato que estamos buscando devolvemos el dato */
        if (a == null) {
            return a;
        }
        if (a.getDato()==dato) {
            return a;

        }

        /* Recursiva 
        La busqueda es sencilla, Creamos un nodoarbol llamado retorno y le 
        asignamos el resultado de buscar dandole el nodoizquierdo como primer
        paramtero y el dato a buscar como el segundo. Si es null hacemos un return
        de la misma funcion pero con el derecho.
        
        Por ejemplo, tenemos que buscar el 7 como elemento, en la raiz tenemos 
        el 10.
        
        Lo primero que va a hacer es saber si la raiz es null, como no lo es
        se fija si la raiz contiene el dato, como la raiz tiene el dato 10 y
        nosotros buscamos el 7, vamos a entrar en la recursiva.
        
        Noodoarbol nodo = buscar(10.izquierdo, 7) en A que valia 10 vamos a
        buscar a la izquierda y se va a reetir el proceso, imaginemos que esta
        el numero 9, eso significa que a.izquierda no es null pero tampoco el
        numero que estoy buscando asi que se repite el proceso. Imaginemos que
        el nodo que contiene el 9 tiene un nodo a la izquierda con el 7 en ese caso
        el nodo al tener el valor es retornado ya que se llego a un paso base.
        
        Ejemplo 2: Imaginemos que tenemos el mismo arbol, pero nos pasan el dato 15
        El algoritmo comienza en la raiz que tiene un 10, luego como compara que
        no es el dato lopasa ala recursiva.
        
        Como el numero no va a estar la izquierda, el algoritmo lo busca igual
        hasta que el retrno sea null, si el retorno es null enonces lo busca en la
        derecha para lo cual hace lo mismo que a la izquierda
        
        */
        NodoArbol retorno = buscar(a.getNodoIzq(), dato);
        if (retorno == null) {
            return buscar(a.getNodoDer(), dato);
        } else {
            return retorno;
        }

    }
    
    /* Conocer la cantidad de hojas de un arbol */
    public int cantHojas()
    {
        return cantHojasRaiz(raiz);
    }
    
    
    /* El metodo va a contabilizar la cantidad de hojas a partir de un nodo
    normalmente lo vamos a llamar desde la raiz
    
    Si el nodo es null devolvemos cero, si el nodo no es null pero su nodo izq
    si es null retornamos 1+ el resultado del mismo metodo para el nododerecho
    en cambio si en nodoizq no es null retornamos la recursiva del nodoizquirdo + la
    recursiva del derecho
    
    Ejemplo
    
    Ejecutamos el procedimiento en la raiz que no es null y tiene un 10, el
    metodo se fija, el nodoiz es nulo? en este caso no, y tiene un valor de 9
    entonces como no es null va a ejecutar return recursiva(nodo.izq) + la
    recursiva(nodo.der)
    
    Imagineos que el nodo que tiene valor de 9 no tiene un izquierdo pero si 
    un derecho, en esa segunda ejecucion la primera parte nos devuelve 1+ el
    resultado de la recursiva para el derecho.
    
    El derecho tiene un valor de 11, pero no tiene hijos, nos devuelve 1
    
    
    */
    public int cantHojasRaiz(NodoArbol nodo)
    {
        if (nodo==null)
        {
            return 0;
        } else if(nodo.getNodoIzq()==null)
        {
            return 1+cantHojasRaiz(nodo.getNodoDer());
        } else {
            return cantHojasRaiz(nodo.getNodoIzq()) + cantHojasRaiz(nodo.getNodoDer());
        }
        
    }
    
    /* Obtener la altura de un arbol */
    public int altura()
    {
        return altura(raiz);
    }
    
    
    /* La recursiva funciona asi >
    
    El caso base es si el nodo == null devolvemos -1
    
    IMaginemos el arbol tiene el nodo raiz con un 10, se llama la funcion, el nodo
    no es null.
    
    La primera pasada se guardan dos enteros izq y der, si ambos tienen datos
    ninguno da -1 por lo que se repite la funcion.
    
    Imaginemos que el 10 tenia dos hijos, 9 y 11, esa pasada repite la funcion
    el 9 tiene un hijo 8 y el 11 no tiene ninguno.
    
    
    
    En la segunda pasada altura de derecha va a ser -1por lo que izquirda va a 
    ser mayor por lo que devolvemos izq+1
    
    La recursiva altura(nodoizq) y derecho se ejecuta en el else hasta que
    encuentra el null.
 
    
    */
    public int altura(NodoArbol nodo)
    {
        if (nodo==null)
        {
            return -1;
        } else {
            int altIzq = altura(nodo.getNodoIzq());
            int altDer = altura(nodo.getNodoDer());
            
            if (altIzq > altDer)
            {
                return altIzq+1;
            } else {
                return altDer +1;
            }
        }
    }
    
  
    /* Metodo para eliminar un elemento
   Usamos dos metodos, uno para encontrar el elemtno a borra
    
    */
    
         public boolean borrarElementoV2(int elem)
    {
    	NodoArbol auxiliar = raiz;
    	NodoArbol padre = raiz;
    	
    	boolean esHijoIzq = true;
    	
    	while (auxiliar.getDato()!=elem)
    	{
    		padre = auxiliar;
    		if (elem < auxiliar.getDato())
    		{
    			esHijoIzq = true;
    			auxiliar=auxiliar.getNodoIzq();
    		} else {
    			esHijoIzq = false;
    			auxiliar=auxiliar.getNodoDer();
    		}
    		
    		if(auxiliar==null)
    		{
    			return false;
    		}
    	}
    	
    	/* El nodo es Hoja o unico nodo */
    	if (auxiliar.getNodoIzq()==null && auxiliar.getNodoDer()==null)
    	{
    		if(auxiliar.getDato()==raiz.getDato())
    		{
    			raiz=null;
    		} else if (esHijoIzq)
    		{
    			padre.setNodoIzq(null);
    		} else {
    			padre.setNodoDer(null);
    		}
    	} else if(auxiliar.getNodoDer()==null)
    	{
    		if(auxiliar==raiz)
    		{
    			raiz=auxiliar.getNodoIzq();
    		} else if (esHijoIzq)
    		{
    			padre.setNodoIzq(auxiliar.getNodoIzq());
    		} else 
    		{
    			padre.setNodoDer(auxiliar.getNodoIzq());
    		}
    	} else if (auxiliar.getNodoIzq()==null)
    	{
    		
    		if(auxiliar==raiz)
    		{
    			raiz=auxiliar.getNodoDer();
    		} else if (esHijoIzq)
    		{
    			padre.setNodoIzq(auxiliar.getNodoDer());
    		} else 
    		{
    			padre.setNodoDer(auxiliar.getNodoDer());
    		}
    		
    		
    		
    	} else {
    		NodoArbol reemplazo = obtenerNodoReemplazo(auxiliar);
    		if (auxiliar==raiz)
    		{
    			raiz=reemplazo;
    		} else if(esHijoIzq)
    		{
    			padre.setNodoIzq(reemplazo);
    		} else 
    		{
    			padre.setNodoDer(reemplazo);
    		}
    		
    		reemplazo.setNodoIzq(auxiliar.getNodoIzq());
    	}
    	
    	
    	
    	return true;
    }
    
    
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodo)
    {
    	NodoArbol reemplazarPadre = nodo;
    	NodoArbol reemplazo = nodo;
    	NodoArbol aux = nodo.getNodoDer();
    	
    	while(aux!=null)
    	{
    		reemplazarPadre = reemplazo;
    		reemplazo = aux;
    		aux = aux.getNodoIzq();
    	}
    	
    	if (reemplazo!=nodo.getNodoDer())
    	{
    		reemplazarPadre.setNodoIzq(reemplazo.getNodoDer());
    		reemplazo.setNodoDer(nodo.getNodoDer());
    		
    	}
    	
    	
    	
    	
    	
    	return reemplazo;
    }
    
    
}
