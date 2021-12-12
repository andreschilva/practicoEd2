/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Andres
 * @param <K>
 * @param <V>
 */
public class ArbolMViasBusqueda<K extends Comparable<K>, V> implements IArbolBusqueda<K, V> {

    protected NodoMVias<K, V> raiz;
    protected int orden;
    protected static final int POSICION_NO_VALIDA = -1;
    protected static final int ORDEN_MINIMO = 3;

    public ArbolMViasBusqueda() {
        this.orden = ORDEN_MINIMO;
    }

    public ArbolMViasBusqueda(int ordenDelArbol) throws ExeceptionOrdenNoValido {
        if (ordenDelArbol < ArbolMViasBusqueda.ORDEN_MINIMO) {
            throw new ExeceptionOrdenNoValido();
        }
        this.orden = ordenDelArbol;

    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) throws NullPointerException {
        int posicionBajada;
        if (claveAInsertar == NodoMVias.datoVacio()) {
            throw new NullPointerException("No se permite insertar claves nulos");
        }
        if (valorAInsertar == NodoMVias.datoVacio()) {
            throw new NullPointerException("No se permite insertar valores nulos");
        }
        if (this.esArbolVacio()) {
            this.raiz = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
            return;
        }

        NodoMVias<K, V> nodoActual = this.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {
            int posicionDeClave = this.getPosicionDeClave(nodoActual, claveAInsertar);
            if (posicionDeClave != POSICION_NO_VALIDA) {
                nodoActual.setValor(posicionDeClave, valorAInsertar);
                return;
            }

            if (nodoActual.esHoja()) {
                if (nodoActual.estanClavesLlenas()) {
                    posicionBajada = this.getPosicionDondeBajar(nodoActual, claveAInsertar);
                    NodoMVias<K, V> nuevoHijo = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
                    nodoActual.setHijo(posicionBajada, nuevoHijo);

                } else {
                    this.InsertarClaveYValorEnNodo(nodoActual, claveAInsertar, valorAInsertar);

                }
                return;
            }

             posicionBajada = this.getPosicionDondeBajar(nodoActual, claveAInsertar);
            if (nodoActual.esHijoVacio(posicionBajada)) {
                NodoMVias<K, V> nuevoHijo = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
                nodoActual.setHijo(posicionBajada, nuevoHijo);
                return;
            }
            nodoActual = nodoActual.getHijo(posicionBajada);
        }

    }

    protected int getPosicionDeClave(NodoMVias<K, V> nodoActual, K claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveABuscar.compareTo(claveActual) == 0) {
                return i;
            }
        }
        return ArbolMViasBusqueda.POSICION_NO_VALIDA;
    }

    protected int getPosicionDondeBajar(NodoMVias<K, V> nodoActual, K claveAInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveAInsertar.compareTo(claveActual) < 0) {
                return i;
            }

        }
        return nodoActual.cantidadDeClavesNoVacias();

    }

    protected void InsertarClaveYValorEnNodo(NodoMVias<K, V> nodoActual, K claveAInsertar, V valorAInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            V valorActual = nodoActual.getValor(i);
            if (claveAInsertar.compareTo(claveActual) < 0) {
                for (int j = i; j < (nodoActual.cantidadDeClavesNoVacias()) && (!nodoActual.estanClavesLlenas()); j++) {
                    K claveSig = nodoActual.getClave(j + 1);
                    V valorSig = nodoActual.getValor(j + 1);
                    nodoActual.setClave(j + 1, claveActual);
                    nodoActual.setValor(j + 1, valorActual);
                    claveActual = claveSig;
                    valorActual = valorSig;
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

    @Override
    public V eliminar(K claveAEliminar) throws ExcepcionClaveNoexiste {
        V valorAEliminar = this.buscar(claveAEliminar);
        if (valorAEliminar == NodoMVias.datoVacio()) {
            return null;
        }
        this.raiz = eliminar(this.raiz, claveAEliminar);
        return valorAEliminar;
    }

    private NodoMVias<K, V> eliminar(NodoMVias<K, V> nodoActual, K claveAEliminar) {

        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveAEliminar.compareTo(claveActual) == 0) { //lo encontro 

                //1er caso 
                if (nodoActual.esHoja()) {
                    this.eliminarClaveYValor(nodoActual, i);
                    if (nodoActual.cantidadDeClavesNoVacias() == 0) {
                        return NodoMVias.nodoVacio();
                    }
                    return nodoActual;
                }

                //2do y 3er caso 
                K claveDeReemplazo;
                if (existenHijosMasAdelante(nodoActual, i)) {
                    claveDeReemplazo = this.buscarClaveSucesoraInOrden(nodoActual, claveAEliminar);
                } else {
                    claveDeReemplazo = this.buscarClavePredecesoraInOrden(nodoActual, claveAEliminar);
                }

                V valorAsociadoAClaveDeReemplazo = this.buscar(claveDeReemplazo);
                nodoActual = eliminar(nodoActual, claveDeReemplazo);
                nodoActual.setClave(i, claveDeReemplazo);
                nodoActual.setValor(i, valorAsociadoAClaveDeReemplazo);
                return nodoActual;

            }

            if (claveAEliminar.compareTo(claveActual) < 0) {
                NodoMVias<K, V> nodoHijo = eliminar(nodoActual.getHijo(i), claveAEliminar);
                nodoActual.setHijo(i, nodoHijo);
                return nodoActual;
            }
        }

        NodoMVias<K, V> nodoHijo = eliminar(nodoActual.getHijo(this.orden - 1), claveAEliminar);
        nodoActual.setHijo(this.orden - 1, nodoHijo);
        return nodoActual;
    }

    private K buscarClavePredecesoraInOrden(NodoMVias<K, V> nodoActual, K claveAbuscarPredecesor) {
        List<K> recorridoInOrden = new ArrayList();
        this.recorridoInOrden(nodoActual, recorridoInOrden);
        for (int i = 0; i < recorridoInOrden.size(); i++) {
            K claveActual = recorridoInOrden.get(i);
            if (claveAbuscarPredecesor.compareTo(claveActual) == 0) {
                return recorridoInOrden.get(i - 1);
            }
        }
        return (K) NodoMVias.datoVacio();
    }

    private K buscarClaveSucesoraInOrden(NodoMVias<K, V> nodoActual, K claveAbuscarSuSucesor) {
        List<K> recorridoInOrden = new ArrayList();
        this.recorridoInOrden(nodoActual, recorridoInOrden);
        for (int i = 0; i < recorridoInOrden.size(); i++) {
            K claveActual = recorridoInOrden.get(i);
            if (claveAbuscarSuSucesor.compareTo(claveActual) == 0) {
                return recorridoInOrden.get(i + 1);
            }
        }
        return (K) NodoMVias.datoVacio();
    }

    private boolean existenHijosMasAdelante(NodoMVias<K, V> nodoActual, int posicion) {
        for (int i = posicion + 1; i < this.orden; i++) {
            if (!nodoActual.esHijoVacio(i)) {
                return true;
            }
        }

        return false;

    }

    protected void eliminarClaveYValor(NodoMVias<K, V> nodoActual, int posicion) {
        nodoActual.setClave(posicion, (K) NodoMVias.datoVacio());
        for (int i = posicion; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            K claveSig = nodoActual.getClave(i + 1);
            V valorSig = nodoActual.getValor(i + 1);
            NodoMVias<K,V> hijoActual = nodoActual.getHijo(i + 1);
            NodoMVias<K,V> hijoSig = nodoActual.getHijo(i + 2);

            if (claveActual == NodoMVias.datoVacio()) {
                nodoActual.setClave(i, claveSig);
                nodoActual.setClave(i + 1, (K) NodoMVias.datoVacio());
                nodoActual.setValor(i, valorSig);
                nodoActual.setValor(i + 1, (V) NodoMVias.datoVacio());
            }
            
            if (hijoActual == NodoMVias.nodoVacio()) {
                nodoActual.setHijo(i + 1, hijoSig);
                nodoActual.setHijo(i + 2, NodoMVias.nodoVacio());
            }
        }
    }

    @Override
    public V buscar(K claveABuscar) {
        if (claveABuscar == NodoMVias.datoVacio()) {
            return (V) NodoMVias.datoVacio();
        }
        NodoMVias<K, V> nodoActual = this.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {
            boolean huboCambioDeNodo = false;
            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias() && !huboCambioDeNodo; i++) {
                K claveActual = nodoActual.getClave(i);
                if (claveABuscar.compareTo(claveActual) == 0) {
                    return nodoActual.getValor(i);
                }

                if (claveABuscar.compareTo(claveActual) < 0) {
                    nodoActual = nodoActual.getHijo(i);
                    huboCambioDeNodo = true;
                }

            }
            if (!huboCambioDeNodo) {
                nodoActual = nodoActual.getHijo(this.orden - 1);
            }
        }
        return (V) NodoMVias.datoVacio();
    }

    @Override
    public boolean contiene(K claveABuscar) {
        return this.buscar(claveABuscar) != NodoMVias.datoVacio();
    }

    @Override
    public int size() {
        return size(this.raiz);
    }

    private int size(NodoMVias<K, V> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }

        int sizeAcumulado = 0;
        for (int i = 0; i < this.orden; i++) {
            int sizeDeHijo = size(nodoActual.getHijo(i));
            sizeAcumulado += sizeDeHijo;
        }
        return sizeAcumulado + 1;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }

    private int altura(NodoMVias<K, V> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }
        int alturaMayor = 0;
        for (int i = 0; i < this.orden; i++) {
            int alturaDeHijo = altura(nodoActual.getHijo(i));
            if (alturaDeHijo > alturaMayor) {
                alturaMayor = alturaDeHijo;
            }
        }
        return alturaMayor + 1;
    }

    @Override
    public void vaciar() {
        this.raiz = NodoMVias.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoMVias.esNodoVacio(this.raiz);
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new ArrayList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Queue<NodoMVias<K, V>> coladeNodos = new LinkedList<>();
        coladeNodos.offer(this.raiz);
        while (!coladeNodos.isEmpty()) {
            NodoMVias<K, V> nodoActual = coladeNodos.poll();
            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
                recorrido.add(nodoActual.getClave(i));
                if (!nodoActual.esHijoVacio(i)) {
                    coladeNodos.offer(nodoActual.getHijo(i));
                }
            }
            if (!nodoActual.esHijoVacio(nodoActual.cantidadDeClavesNoVacias())) {
                coladeNodos.offer(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()));
            }

        }
        return recorrido;
    }

    @Override
    public List<K> recorridoPreOrden() {
        List<K> recorrido = new ArrayList<>();
        this.recorridoPreOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoPreOrden(NodoMVias<K, V> nodoActual, List<K> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }

        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            recorrido.add(nodoActual.getClave(i));
            recorridoPreOrden(nodoActual.getHijo(i), recorrido);

        }
        recorridoPreOrden(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()), recorrido);

    }

    @Override
    public List<K> recorridoInOrden() {
        List<K> recorrido = new ArrayList<>();
        this.recorridoInOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoInOrden(NodoMVias<K, V> nodoActual, List<K> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            recorridoInOrden(nodoActual.getHijo(i), recorrido);
            recorrido.add(nodoActual.getClave(i));

        }
        recorridoInOrden(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()), recorrido);

    }

    @Override
    public List<K> recorridoPostOrden() {
        List<K> recorrido = new ArrayList<>();
        this.recorridoPostOrden(this.raiz, recorrido);
        return recorrido;

    }

    private void recorridoPostOrden(NodoMVias<K, V> nodoActual, List<K> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }
        recorridoPostOrden(nodoActual.getHijo(0), recorrido);
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            recorridoPostOrden(nodoActual.getHijo(i + 1), recorrido);
            recorrido.add(nodoActual.getClave(i));

        }

    }

    public int cantidadDeClavesVacias() {
        return cantidadDeClavesVacias(this.raiz);
    }

    private int cantidadDeClavesVacias(NodoMVias<K, V> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }

        int clavesVaciasAcumuladas = (this.orden - 1) - nodoActual.cantidadDeClavesNoVacias();
        for (int i = 0; i < this.orden; i++) {
            int clavesVaciasDelHijo = cantidadDeClavesVacias(nodoActual.getHijo(i));
            clavesVaciasAcumuladas += clavesVaciasDelHijo;
        }
        return clavesVaciasAcumuladas;
    }

    public int cantidadDeClavesNoVacias() {
        return cantidadDeClavesNoVacias(this.raiz);
    }

    private int cantidadDeClavesNoVacias(NodoMVias<K, V> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }

        int clavesNoVaciasAcumuladas = nodoActual.cantidadDeClavesNoVacias();
        for (int i = 0; i < this.orden; i++) {
            int clavesNoVaciasDelHijo = cantidadDeClavesNoVacias(nodoActual.getHijo(i));
            clavesNoVaciasAcumuladas += clavesNoVaciasDelHijo;
        }
        return clavesNoVaciasAcumuladas;
    }

    public int cantidadDeHijosVacios() {
        return cantidadDeHijosVacios(this.raiz);
    }

    private int cantidadDeHijosVacios(NodoMVias<K, V> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }

        int HijosVaciosAcumulados = nodoActual.cantidadDeHijosVacios();

        for (int i = 0; i < this.orden; i++) {
            int HijosVaciosDelHijoEnTurno = cantidadDeHijosVacios(nodoActual.getHijo(i));
            HijosVaciosAcumulados += HijosVaciosDelHijoEnTurno;
        }

        return HijosVaciosAcumulados;
    }

    public int cantidadDeHijosVaciosNivelN(int nivel) {
        return cantidadDeHijosVaciosNivelN(this.raiz, nivel,0);
    }

    private int cantidadDeHijosVaciosNivelN(NodoMVias<K, V> nodoActual, int nivel, int nivelActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }
        
        int HijosVaciosAcumulados = 0;
        if (nivelActual == nivel) {
            HijosVaciosAcumulados = nodoActual.cantidadDeHijosVacios();
            return HijosVaciosAcumulados;
        }
        
        for (int i = 0; i < this.orden; i++) {
            int HijosVaciosDelHijoEnTurno = cantidadDeHijosVaciosNivelN(nodoActual.getHijo(i), nivel, nivelActual + 1);
            HijosVaciosAcumulados += HijosVaciosDelHijoEnTurno;
        }
        return HijosVaciosAcumulados;
        
    }
    
    public int cantidadDeHijosVaciosAntesDelNivelN(int nivel) {
        return cantidadDeHijosVaciosAntesDelNivelN(this.raiz, nivel,0);
    }

    private int cantidadDeHijosVaciosAntesDelNivelN(NodoMVias<K, V> nodoActual, int nivel, int nivelActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }
        
        int HijosVaciosAcumulados = 0;
        if (nivelActual < nivel) {
            HijosVaciosAcumulados = nodoActual.cantidadDeHijosVacios();
            
        }else{
            return 0;
        }
        
        
        for (int i = 0; i < this.orden; i++) {
            int HijosVaciosDelHijoEnTurno = cantidadDeHijosVaciosAntesDelNivelN(nodoActual.getHijo(i), nivel, nivelActual + 1);
            HijosVaciosAcumulados += HijosVaciosDelHijoEnTurno;
        }
        return HijosVaciosAcumulados;
        
    } 
    
    
    public int cantidadDeHijosVaciosAPatirDelNivelN(int nivel) {
        return cantidadDeHijosVaciosAPatirDelNivelN(this.raiz, nivel,0);
    }

    private int cantidadDeHijosVaciosAPatirDelNivelN(NodoMVias<K, V> nodoActual, int nivel, int nivelActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }
        
        int HijosVaciosAcumulados = 0;
        if (nivelActual >= nivel) {
            HijosVaciosAcumulados = nodoActual.cantidadDeHijosVacios();
        }else{
            return 0;
        } 
            
        
        for (int i = 0; i < this.orden; i++) {
            int HijosVaciosDelHijoEnTurno = cantidadDeHijosVaciosAPatirDelNivelN(nodoActual.getHijo(i), nivel, nivelActual + 1);
            HijosVaciosAcumulados += HijosVaciosDelHijoEnTurno;
        }
        return HijosVaciosAcumulados;
        
    }
    
    public boolean hayNodosCompletosNivelN(int nivel) {
        if (nivel > this.altura() - 1) {
            return false;
        }
        return hayNodosCompletosNivelN(this.raiz, nivel,0);
    }

    private boolean hayNodosCompletosNivelN(NodoMVias<K, V> nodoActual, int nivel, int nivelActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return true;
        }
        
        int clavesNoVaciasDelNodoActual = 0;
        if (nivelActual == nivel) {
            clavesNoVaciasDelNodoActual = nodoActual.cantidadDeClavesNoVacias();
            if (clavesNoVaciasDelNodoActual < this.orden - 1) {
            return false;
            }
            return true;
        }
        for (int i = 0; i < this.orden; i++) {
            boolean esNodoCompleto = hayNodosCompletosNivelN(nodoActual.getHijo(i), nivel, nivelActual + 1);
            if (!esNodoCompleto) {
                return false;
            }
        }
        return true;
        
    }  
    
    public boolean sonArbolesSimilares(ArbolMViasBusqueda<K,V> arbol2) {
        if (this.size() != arbol2.size()) {
            return false;
        }
        if (this.esArbolVacio() || arbol2.esArbolVacio()) {
            return false;
        }
        
        return this.sonArbolesSimilares(this.raiz, arbol2.raiz);
        
    }

    private boolean sonArbolesSimilares(NodoMVias<K, V> nodoActualThisArbol, NodoMVias<K,V> nodoActualArbol2) {

        if (NodoMVias.esNodoVacio(nodoActualThisArbol)) {
            return true;
        }
        
        for (int i = 0; i < nodoActualThisArbol.cantidadDeClavesNoVacias(); i++) {
            if ((nodoActualThisArbol.esHijoVacio(i)&& !nodoActualArbol2.esHijoVacio(i)) 
                    || (!nodoActualThisArbol.esHijoVacio(i)&& nodoActualArbol2.esHijoVacio(i))) {
                return false;
            }
            /* si el hijo de la ultima psocion del nodo de este arbol es diferente del hijo 
            de la ultima psocion del nodo del arbol2  o viceversa retorna falso*/
            if ((nodoActualThisArbol.esHijoVacio(nodoActualThisArbol.cantidadDeClavesNoVacias())&& 
                    !nodoActualArbol2.esHijoVacio(nodoActualArbol2.cantidadDeClavesNoVacias())) 
                    || (!nodoActualThisArbol.esHijoVacio(nodoActualThisArbol.cantidadDeClavesNoVacias())&&
                        nodoActualArbol2.esHijoVacio(nodoActualArbol2.cantidadDeClavesNoVacias()))) {
                return false;
            }            

            boolean tienenHijosIguales = sonArbolesSimilares(nodoActualThisArbol.getHijo(i), nodoActualArbol2.getHijo(i));
            if (!tienenHijosIguales) {
                return false;
            }
        }
        boolean tienenHijosIgualesUltimaPosicion = sonArbolesSimilares(nodoActualThisArbol.getHijo(nodoActualThisArbol.cantidadDeClavesNoVacias()),
                nodoActualArbol2.getHijo(nodoActualArbol2.cantidadDeClavesNoVacias()));
        if (!tienenHijosIgualesUltimaPosicion) {
            return false;
        }
        return true;
        
    }    

    
    
        
}
