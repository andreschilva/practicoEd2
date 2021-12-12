/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles;

import java.util.Stack;

/**
 *
 * @author Andres
 * @param <K>
 * @param <V>
 */
public class ArbolB<K extends Comparable<K>, V> extends ArbolMViasBusqueda<K, V> {

    private int nroMaximoDeDatos;
    private int nroMinimoDeDatos;
    private int nroMinimoDeHijos;

    public ArbolB() {
        super();
        this.nroMaximoDeDatos = 2;
        this.nroMinimoDeDatos = 1;
        this.nroMinimoDeHijos = 2;
    }

    public ArbolB(int orden) throws ExeceptionOrdenNoValido {
        super(orden);
        this.nroMaximoDeDatos = super.orden - 1;
        this.nroMinimoDeDatos = this.nroMaximoDeDatos / 2;
        this.nroMinimoDeHijos = this.nroMinimoDeDatos + 1;

    }

    @Override
    public V eliminar(K claveAEliminar) throws ExcepcionClaveNoexiste {
        if (claveAEliminar == NodoMVias.datoVacio()) {
            throw new IllegalArgumentException("Clave a buscar no puede ser nula");
        }
        
        Stack<NodoMVias<K, V>> pilaDePadres = new Stack<>();
        NodoMVias<K,V> nodoActual = this.buscarNodoDeDato(claveAEliminar,pilaDePadres);
        
        if (NodoMVias.esNodoVacio(nodoActual)) {
            throw new ExcepcionClaveNoexiste();
        }
        
        int posicionDeClaveAEliminar = super.getPosicionDondeBajar(nodoActual, claveAEliminar) - 1;
        V valorARetornar = nodoActual.getValor(posicionDeClaveAEliminar);
        
        if (nodoActual.esHoja()) {
            super.eliminarClaveYValor(nodoActual, posicionDeClaveAEliminar);
            if (nodoActual.cantidadDeClavesNoVacias() < this.nroMinimoDeDatos) {
                // si llego aca hay que ajustar 
                if (pilaDePadres.isEmpty()) {
                    if (nodoActual.cantidadDeClavesNoVacias() == 0) {
                        super.vaciar();
                    }
                }else {
                    NodoMVias<K,V> nodoPadre = pilaDePadres.peek();
                    //Posicion del nodo hijo en problema en el nodoPadre
                    int posicionNodoEnProblema = super.getPosicionDondeBajar(nodoPadre, claveAEliminar);

                    this.prestarseOFusionarse(nodoActual, pilaDePadres,posicionNodoEnProblema);
                }
                
            }
        }else {
            pilaDePadres.push(nodoActual);
            NodoMVias<K,V> nodoDelPredecesor = this.obtenerNodoDeClavePredecesora(pilaDePadres,
                    nodoActual.getHijo(posicionDeClaveAEliminar));
            int posicionDelPredecesor = nodoDelPredecesor.cantidadDeClavesNoVacias() - 1;
            K clavePredecesora = nodoDelPredecesor.getClave(posicionDelPredecesor);
            V datoDelPredecesor = nodoDelPredecesor.getValor(posicionDelPredecesor);
            super.eliminarClaveYValor(nodoDelPredecesor, posicionDelPredecesor);
                NodoMVias<K, V> padreDelNodoPredecesoor = pilaDePadres.peek();
                //Posicion del nodo hijo en problema en el nodoPadre
                int posicionNodoEnProblema = super.getPosicionDondeBajar(padreDelNodoPredecesoor, clavePredecesora);
                
                nodoActual.setClave(posicionDeClaveAEliminar, clavePredecesora);
                nodoActual.setValor(posicionDeClaveAEliminar, datoDelPredecesor);
                
                if (nodoDelPredecesor.cantidadDeClavesNoVacias() < this.nroMinimoDeDatos) {
                    this.prestarseOFusionarse(nodoDelPredecesor, pilaDePadres, posicionNodoEnProblema );
                    
                }
                
            }

        return valorARetornar;
    }
        
    
    
    private NodoMVias<K,V> obtenerNodoDeClavePredecesora(Stack<NodoMVias<K,V>> pilaDePadres, NodoMVias<K,V> nodoActual) {
        while (!nodoActual.esHoja()) {            
           pilaDePadres.push(nodoActual);
           nodoActual = nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias());
        }
        return nodoActual;
    }
    
    private void prestarseOFusionarse(NodoMVias<K,V> nodoEnProblema,Stack<NodoMVias<K,V>> pilaDePadres, int posicionNodoEnProblema ) {
      
        while ((nodoEnProblema.cantidadDeClavesNoVacias() < this.nroMinimoDeDatos) && (!pilaDePadres.isEmpty())) {            

            NodoMVias<K, V> nodoPadre = pilaDePadres.pop();

            NodoMVias<K, V> nodoHermanoSig = nodoPadre.getHijo(posicionNodoEnProblema + 1);
            NodoMVias<K, V> nodoHermanoAnt;
            if (posicionNodoEnProblema == 0) {
                nodoHermanoAnt = NodoMVias.nodoVacio();
            } else {
                nodoHermanoAnt = nodoPadre.getHijo(posicionNodoEnProblema - 1);
            }

      

            //El nodoEnProblema se presta del hermano Siguiente,  si este es mayor al minimo de datos 
            if (!NodoMVias.esNodoVacio(nodoHermanoSig) && nodoHermanoSig.cantidadDeClavesNoVacias() > this.nroMinimoDeDatos) {
                this.prestarseDelHermanoSig(nodoEnProblema, nodoPadre, nodoHermanoSig, posicionNodoEnProblema);    
            } 
            //El nodoEnProblema se presta del hermano Anterior, si este es mayor al minimo de datos
            else if (!NodoMVias.esNodoVacio(nodoHermanoAnt) && nodoHermanoAnt.cantidadDeClavesNoVacias() > this.nroMinimoDeDatos) {
                this.prestarseDelHermanoAnt(nodoEnProblema, nodoPadre, nodoHermanoAnt, posicionNodoEnProblema);
            }
            else if(!NodoMVias.esNodoVacio(nodoHermanoSig)) {
                K claveDelNodoPadre = nodoPadre.getClave(posicionNodoEnProblema);
                V valorDelNodoPadre = nodoPadre.getValor(posicionNodoEnProblema);
                nodoPadre.setHijo(posicionNodoEnProblema + 1, NodoMVias.nodoVacio());
                super.eliminarClaveYValor(nodoPadre, posicionNodoEnProblema);
                this.InsertarClaveYValorEnNodo(nodoEnProblema, claveDelNodoPadre, valorDelNodoPadre);

                if (!pilaDePadres.isEmpty()) {
                    NodoMVias<K, V> nodoAbuelo = pilaDePadres.peek();
                    posicionNodoEnProblema = super.getPosicionDondeBajar(nodoAbuelo,claveDelNodoPadre);   
                }
                for (int i = 0; i < nodoHermanoSig.cantidadDeClavesNoVacias(); i++) {
                    K claveHermanoSig = nodoHermanoSig.getClave(i);
                    V valorHermanoSig = nodoHermanoSig.getValor(i);
                    NodoMVias<K, V> hijosDelHermanoSig = nodoHermanoSig.getHijo(i);
                    nodoEnProblema.setHijo(nodoEnProblema.cantidadDeHijosNovacios(), hijosDelHermanoSig);
                    this.InsertarClaveYValorEnNodo(nodoEnProblema, claveHermanoSig, valorHermanoSig);
                }
                NodoMVias<K, V> hijosDelHermanoSig = nodoHermanoSig.getHijo(nodoHermanoSig.cantidadDeClavesNoVacias());
                nodoEnProblema.setHijo(nodoEnProblema.cantidadDeHijosNovacios(), hijosDelHermanoSig);
                
                if (super.raiz.cantidadDeClavesNoVacias() == 0) {
                    super.raiz = nodoEnProblema;
                }                
            }else {
                K claveDelNodoPadre = nodoPadre.getClave(posicionNodoEnProblema - 1);
                V valorDelNodoPadre = nodoPadre.getValor(posicionNodoEnProblema - 1);
                nodoPadre.setHijo(posicionNodoEnProblema, NodoMVias.nodoVacio());
                super.eliminarClaveYValor(nodoPadre, posicionNodoEnProblema - 1);
                this.InsertarClaveYValorEnNodo(nodoHermanoAnt, claveDelNodoPadre, valorDelNodoPadre);

                if (!pilaDePadres.isEmpty()) {
                    NodoMVias<K, V> nodoAbuelo = pilaDePadres.peek();
                    posicionNodoEnProblema = super.getPosicionDondeBajar(nodoAbuelo,claveDelNodoPadre); 
                }
                
                for (int i = 0; i < nodoEnProblema.cantidadDeClavesNoVacias(); i++) {
                    K claveNodoEnProblema = nodoEnProblema.getClave(i);
                    V valorNodoEnProblema = nodoEnProblema.getValor(i);
                    NodoMVias<K, V> hijosDelNodoEnProblema = nodoEnProblema.getHijo(i);
                    nodoHermanoAnt.setHijo(nodoHermanoAnt.cantidadDeHijosNovacios(), hijosDelNodoEnProblema);
                    this.InsertarClaveYValorEnNodo(nodoHermanoAnt, claveNodoEnProblema, valorNodoEnProblema);
                }
                NodoMVias<K, V> hijosDelNodoEnProblema = nodoEnProblema.getHijo(nodoEnProblema.cantidadDeClavesNoVacias());
                nodoHermanoAnt.setHijo(nodoHermanoAnt.cantidadDeHijosNovacios(), hijosDelNodoEnProblema);  
                if (super.raiz.cantidadDeClavesNoVacias() == 0) {
                    super.raiz = nodoHermanoAnt;
                }
                
            }
            
            nodoEnProblema = nodoPadre;

        }
    }
    
    private void prestarseDelHermanoSig(NodoMVias<K,V> nodoEnProblema, NodoMVias<K,V> nodoPadre , NodoMVias<K,V> nodoHermanoSig, int posicionNodoEnProblema) {
        K claveHermanoSig = nodoHermanoSig.getClave(0);
        V valorHermanoSig = nodoHermanoSig.getValor(0);
        K claveDelNodoPadre = nodoPadre.getClave(posicionNodoEnProblema);
        V valorDelNodoPadre = nodoPadre.getValor(posicionNodoEnProblema);

        super.InsertarClaveYValorEnNodo(nodoEnProblema, claveDelNodoPadre, valorDelNodoPadre);
        super.eliminarClaveYValor(nodoPadre, posicionNodoEnProblema);
        super.InsertarClaveYValorEnNodo(nodoPadre, claveHermanoSig, valorHermanoSig);
        super.eliminarClaveYValor(nodoHermanoSig, 0);
    }
    
    private void prestarseDelHermanoAnt(NodoMVias<K,V> nodoEnProblema, NodoMVias<K,V> nodoPadre , NodoMVias<K,V> nodoHermanoAnt, int posicionNodoEnProblema) {
        K claveHermanoAnt = nodoHermanoAnt.getClave(nodoHermanoAnt.cantidadDeClavesNoVacias() - 1);
        V valorHermanoAnt = nodoHermanoAnt.getValor(nodoHermanoAnt.cantidadDeClavesNoVacias() - 1);
        K claveDelNodoPadre = nodoPadre.getClave(posicionNodoEnProblema - 1);
        V valorDelNodoPadre = nodoPadre.getValor(posicionNodoEnProblema - 1);

        super.InsertarClaveYValorEnNodo(nodoEnProblema, claveDelNodoPadre, valorDelNodoPadre);
        super.eliminarClaveYValor(nodoPadre, posicionNodoEnProblema - 1);
        super.InsertarClaveYValorEnNodo(nodoPadre, claveHermanoAnt, valorHermanoAnt);
        super.eliminarClaveYValor(nodoHermanoAnt, nodoHermanoAnt.cantidadDeClavesNoVacias() - 1);

    }    

    private NodoMVias<K,V> buscarNodoDeDato(K claveAEliminar, Stack<NodoMVias<K,V>> pilaDePadres) {
        NodoMVias<K, V> nodoActual = this.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {
            boolean huboCambioDeNodo = false;
            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias() && !huboCambioDeNodo; i++) {
                K claveActual = nodoActual.getClave(i);
                if (claveAEliminar.compareTo(claveActual) == 0) {
                    return nodoActual;
                }

                if (claveAEliminar.compareTo(claveActual) < 0) {
                    pilaDePadres.push(nodoActual);
                    nodoActual = nodoActual.getHijo(i);
                    huboCambioDeNodo = true;
                }

            }
            if (!huboCambioDeNodo) {
                pilaDePadres.push(nodoActual);
                nodoActual = nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias());
            }
        }
        return NodoMVias.nodoVacio();
    } 
    
    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) throws NullPointerException {
        if (claveAInsertar == NodoMVias.datoVacio()) {
            throw new NullPointerException("No se permite insertar claves nulos");
        }
        if (valorAInsertar == NodoMVias.datoVacio()) {
            throw new NullPointerException("No se permite insertar valores nulos");
        }
        if (this.esArbolVacio()) {
            this.raiz = new NodoMVias<>(super.orden + 1, claveAInsertar, valorAInsertar);
            return;
        }

        Stack<NodoMVias<K, V>> pilaDePadres = new Stack<>();
        NodoMVias<K, V> nodoActual = super.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {
            int posicionDeClave = this.getPosicionDeClave(nodoActual, claveAInsertar);
            if (posicionDeClave != POSICION_NO_VALIDA) {
                nodoActual.setValor(posicionDeClave, valorAInsertar);
                return;
            }

            //no hay la clave en el nodo
            if (nodoActual.esHoja()) {
                super.InsertarClaveYValorEnNodo(nodoActual, claveAInsertar, valorAInsertar);
                if (nodoActual.cantidadDeClavesNoVacias() > this.nroMaximoDeDatos) {
                    this.dividir(nodoActual, pilaDePadres);
                }
                return;
            }

            //no es hoja el nodo actual 
            int posicionPorDondeBajar = super.getPosicionDondeBajar(nodoActual, claveAInsertar);
            pilaDePadres.push(nodoActual);
            nodoActual = nodoActual.getHijo(posicionPorDondeBajar);

        }

    }

    private void dividir(NodoMVias<K, V> nodoActual, Stack<NodoMVias<K, V>> pilaDepadres) {
        //si es par 
        int posicionDelMedio = 0;
        if (orden % 2 == 0) {
            posicionDelMedio = (super.orden / 2) - 1;
            //si es impar 
        } else {
            posicionDelMedio = (super.orden / 2);
        }

        //El ciclo continua mientras el nodo actual este en problemas 
        while (nodoActual.estanClavesLlenas()) {
            K claveASubir = nodoActual.getClave(posicionDelMedio);
            V valorASubir = nodoActual.getValor(posicionDelMedio);
            NodoMVias<K, V> hijoPosSig = new NodoMVias<>(super.orden + 1); 
            
            //dividiendo los valores del nodo actual, e insertando en el nuevo nodo de la posicion siguiente            
            int j = 0;
            for (int i = posicionDelMedio + 1; i < super.orden; i++) {
                hijoPosSig.setClave(j, nodoActual.getClave(i));
                hijoPosSig.setValor(j, nodoActual.getValor(i));
                hijoPosSig.setHijo(j, nodoActual.getHijo(i));
                j++;
                //borrando clave valor e hijos del nodoActual desde la posicion del medio 
                nodoActual.setClave(i - 1, (K) NodoMVias.datoVacio());
                nodoActual.setValor(i - 1, (V) NodoMVias.datoVacio());
                nodoActual.setHijo(i, NodoMVias.nodoVacio());
            }
            nodoActual.setClave(this.nroMaximoDeDatos, (K) NodoMVias.datoVacio());
            nodoActual.setValor(this.nroMaximoDeDatos, (V) NodoMVias.datoVacio());
            hijoPosSig.setHijo((hijoPosSig.cantidadDeClavesNoVacias()), nodoActual.getHijo(super.orden));
            nodoActual.setHijo(super.orden, NodoMVias.nodoVacio());

            //si la pila es vacia, quiere decir q estamos en la raiz y no hay padres
            if (pilaDepadres.isEmpty()) {
                //nueva raiz
                super.raiz = new NodoMVias<>(super.orden + 1, claveASubir, valorASubir);
                super.raiz.setHijo(0, nodoActual);
                super.raiz.setHijo(1, hijoPosSig);
            } //caso contrario, si hay padre
            else {
                NodoMVias<K, V> nodoPadre = pilaDepadres.pop();
                
                //insertamos clave y valor a subir en en el nodo padre
                this.InsertarClaveYValorEnNodo(nodoPadre,claveASubir, valorASubir);
                int posicionHijoSig = super.getPosicionDondeBajar(nodoPadre, claveASubir);
                nodoPadre.setHijo(posicionHijoSig, hijoPosSig);
               
                //cambiando el nodo actual al nodo padre
                nodoActual = nodoPadre;
            }          
        }

    }

    protected void InsertarClaveYValorEnNodo(NodoMVias<K, V> nodoActual, K claveAInsertar, V valorAInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            V valorActual = nodoActual.getValor(i);
            NodoMVias<K, V> hijoActual = nodoActual.getHijo(i + 1);
            if (claveAInsertar.compareTo(claveActual) < 0) {
               //recorriendo clave, valor e hijo una posicion
                for (int j = i; j < (nodoActual.cantidadDeClavesNoVacias()) && (!nodoActual.estanClavesLlenas()); j++) {
                    K claveSig = nodoActual.getClave(j + 1);
                    V valorSig = nodoActual.getValor(j + 1);
                    NodoMVias<K, V> hijoSig = nodoActual.getHijo(j + 2);
                    nodoActual.setClave(j + 1, claveActual);
                    nodoActual.setValor(j + 1, valorActual);
                    nodoActual.setHijo(j + 2, hijoActual);
                    claveActual = claveSig;
                    valorActual = valorSig;
                    hijoActual = hijoSig;
                }
                nodoActual.setClave(i, claveAInsertar);
                nodoActual.setValor(i, valorAInsertar);
                return;
            }
        }
        int posicion = nodoActual.cantidadDeClavesNoVacias();
        nodoActual.setClave(posicion, claveAInsertar);
        nodoActual.setValor(posicion, valorAInsertar);
    }
    

}
