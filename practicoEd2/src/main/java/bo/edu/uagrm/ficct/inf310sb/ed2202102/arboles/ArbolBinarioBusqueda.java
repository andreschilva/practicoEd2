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
public class ArbolBinarioBusqueda<K extends Comparable<K>, V> implements IArbolBusqueda<K,V> {

    protected NodoBinario<K, V> raiz;

    public ArbolBinarioBusqueda() {
        
    }

    public ArbolBinarioBusqueda(List<K> claveInOrden, List<V> valoresInorden,
            List<K> claveNoInOrden, List<V> valoresNoInOrden, boolean esConPreOrden) {
        if (claveInOrden.isEmpty() || valoresInorden.isEmpty() 
                || claveNoInOrden.isEmpty() || valoresNoInOrden.isEmpty()) {
            throw new  RuntimeException("Error, una de las listas esta vacia");
        }
        
        if (claveInOrden.size() != claveNoInOrden.size() ||
                valoresInorden.size() != valoresNoInOrden.size()) {
            throw new RuntimeException("Error los recorridos de las listas son de diferente tamaño");
        }
        
        if (esConPreOrden) {
            this.raiz = this.reconstruccionConInOrden(claveInOrden, valoresInorden, claveNoInOrden, valoresNoInOrden);
        }
        else {
            this.raiz = this.reconstruccionConPostOrden(claveInOrden, valoresInorden,
                    claveNoInOrden, valoresNoInOrden);
        }
    }
    
    private NodoBinario<K, V> reconstruccionConInOrden(List<K> claveInOrden, List<V> valoresInorden,
        List<K> clavePreOrden, List<V> valoresPreOrden) {
        if (claveInOrden.isEmpty()) {
            return null;
        }
        
        K clave = clavePreOrden.get(0); // clave de la primera posicion de la lista pre Orden 
        V valor = valoresPreOrden.get(0);
        NodoBinario<K,V> nodoRaiz = new NodoBinario<>(clave,valor);
        int posicionRaiz = posicionDeclave(claveInOrden,clave); //posicion de la raiz en la lista inOrden 
        
        //hijo izquierdo 
        List<K> subListIzqClaveInOrden = claveInOrden.subList(0, posicionRaiz );
        List<V> subListIzqValoresInOrden = valoresInorden.subList(0, posicionRaiz);
        List<K> subListIzqClavePreOrden = clavePreOrden.subList(1, posicionRaiz +1 );
        List<V> subListIzqValoresPreOrden = valoresPreOrden.subList(1, posicionRaiz + 1);
        
        NodoBinario<K,V> hijoIzquierdo = this.reconstruccionConInOrden(subListIzqClaveInOrden,
                subListIzqValoresInOrden, subListIzqClavePreOrden, subListIzqValoresPreOrden);
        
        
        //hijo Derecho 
        List<K> subListDerClaveInOrden = claveInOrden.subList(posicionRaiz + 1,claveInOrden.size());
        List<V> subListDerValoresInOrden = valoresInorden.subList(posicionRaiz + 1, claveInOrden.size());
        List<K> subListDerClavePreOrden = clavePreOrden.subList(posicionRaiz + 1 , claveInOrden.size());
        List<V> subListDerValoresPreOrden = valoresPreOrden.subList(posicionRaiz +1 , claveInOrden.size());
        NodoBinario<K,V> hijoDerecho = this.reconstruccionConInOrden(subListDerClaveInOrden, subListDerValoresInOrden, 
                subListDerClavePreOrden, subListDerValoresPreOrden);
        
        nodoRaiz.setHijoIzquierdo(hijoIzquierdo);
        nodoRaiz.setHijoDerecho(hijoDerecho);
        return nodoRaiz;
        
    }    
    private int posicionDeclave(List<K> listaDeClaves,K clave ) {
        for (int i = 0; i < listaDeClaves.size(); i++) {
            K claveActual = listaDeClaves.get(i);
            if (claveActual.compareTo(clave) == 0) {
                return i;
            }
        }
        return -1;
    }
 
    private NodoBinario<K, V> reconstruccionConPostOrden(List<K> claveInOrden, List<V> valoresInorden,
        List<K> clavePostOrden, List<V> valoresPostOrden) {
        if (claveInOrden.isEmpty()) {
            return null;
        }
        
        K clave = clavePostOrden.get(clavePostOrden.size()-1); // clave de la ultima posicion de la lista post orden 
        V valor = valoresPostOrden.get(valoresPostOrden.size()-1);
        NodoBinario<K,V> nodoRaiz = new NodoBinario<>(clave,valor);
        int posicionRaiz = posicionDeclave(claveInOrden,clave); //posicion de la raiz en in orden 
        
        //hijo izquierdo 
        List<K> subListIzqClaveInOrden = claveInOrden.subList(0, posicionRaiz );
        List<V> subListIzqValoresInOrden = valoresInorden.subList(0, posicionRaiz);
        List<K> subListIzqClavePostOrden = clavePostOrden.subList(0, posicionRaiz );
        List<V> subListIzqValoresPostOrden = valoresPostOrden.subList(0, posicionRaiz );
        
        NodoBinario<K,V> hijoIzquierdo = this.reconstruccionConPostOrden(subListIzqClaveInOrden,
                subListIzqValoresInOrden, subListIzqClavePostOrden, subListIzqValoresPostOrden);
        
        
        //hijo Derecho 
        List<K> subListDerClaveInOrden = claveInOrden.subList(posicionRaiz + 1,claveInOrden.size());
        List<V> subListDerValoresInOrden = valoresInorden.subList(posicionRaiz + 1, claveInOrden.size());
        List<K> subListDerClavePostOrden = clavePostOrden.subList(posicionRaiz , claveInOrden.size()-1);
        List<V> subListDerValoresPostOrden = valoresPostOrden.subList(posicionRaiz , claveInOrden.size()-1);
        NodoBinario<K,V> hijoDerecho = this.reconstruccionConPostOrden(subListDerClaveInOrden, subListDerValoresInOrden, 
                subListDerClavePostOrden, subListDerValoresPostOrden);
        
        nodoRaiz.setHijoIzquierdo(hijoIzquierdo);
        nodoRaiz.setHijoDerecho(hijoDerecho);
        return nodoRaiz;
        
    }
    
    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) throws NullPointerException {

        if (claveAInsertar == null) {
            throw new NullPointerException("No se permite insertar claves nulas");
        }
        if (valorAInsertar == null) {
            throw new NullPointerException("No se permite insertar valores nulas");
        }
        if (this.esArbolVacio()) {
            this.raiz = new NodoBinario<>(claveAInsertar, valorAInsertar);
            return;
        }

        NodoBinario<K, V> nodoAnterior = NodoBinario.nodoVacio();
        NodoBinario<K, V> nodoActual = this.raiz;
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            K claveActual = nodoActual.getClave();
            nodoAnterior = nodoActual;
            if (claveAInsertar.compareTo(claveActual) < 0) {
                nodoActual = nodoActual.getHijoIzquierdo();
            } else if (claveAInsertar.compareTo(claveActual) > 0) {
                nodoActual = nodoActual.getHijoDerecho();
            } else {
                nodoActual.setValor(valorAInsertar);
                return;
            }
        }
        K claveAnterior = nodoAnterior.getClave();
        NodoBinario<K, V> nuevoNodo = new NodoBinario<>(claveAInsertar, valorAInsertar);
        if (claveAInsertar.compareTo(claveAnterior) < 0) {
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        } else {
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }

    }

    @Override
    public V eliminar(K claveAEliminar) throws ExcepcionClaveNoexiste {
        V valorAEliminar = this.buscar(claveAEliminar);
        if (valorAEliminar == null) {
            return null;
        }
        this.raiz = eliminar(this.raiz, claveAEliminar);
        return valorAEliminar;
    }

    private NodoBinario<K, V> eliminar(NodoBinario<K, V> nodoActual, K claveAEliminar) {
        K claveActual = nodoActual.getClave();
        if (claveAEliminar.compareTo(claveActual) < 0) {
            NodoBinario<K, V> aparentementeNuevoHijoIzquierdo
                    = eliminar(nodoActual.getHijoIzquierdo(), claveAEliminar);
            nodoActual.setHijoIzquierdo(aparentementeNuevoHijoIzquierdo);
            return nodoActual;
        }

        if (claveAEliminar.compareTo(claveActual) > 0) {
            NodoBinario<K, V> aparentementeNuevoHijoDerecho
                    = eliminar(nodoActual.getHijoDerecho(), claveAEliminar);
            nodoActual.setHijoDerecho(aparentementeNuevoHijoDerecho);
            return nodoActual;

        }
        //lo encontre
        //caso1
        if (nodoActual.esHoja()) {
            return NodoBinario.nodoVacio();
        }

        //caso 2
        if (!nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()) {
            return nodoActual.getHijoIzquierdo();
        }

        if (nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()) {
            return nodoActual.getHijoDerecho();
        }

        //caso 3 
        NodoBinario<K, V> nodoDelSucesor = this.nodoSucesor(nodoActual.getHijoDerecho());

        NodoBinario<K, V> aparentemeneNuevoHijoDerecho = this.eliminar(
                nodoActual.getHijoDerecho(), nodoDelSucesor.getClave());

        nodoActual.setHijoDerecho(aparentemeneNuevoHijoDerecho);
        nodoActual.setClave(nodoDelSucesor.getClave());
        nodoActual.setValor(nodoDelSucesor.getValor());

        return nodoActual;

    }

    protected NodoBinario<K, V> nodoSucesor(NodoBinario<K, V> nodoActual) {
        NodoBinario<K, V> nodoAnterior = NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getHijoIzquierdo();
        }
        return nodoAnterior;
    }

    @Override
    public V buscar(K claveABuscar) {
        if (claveABuscar == null) {
            return null;
        }

        NodoBinario<K, V> nodoActual = this.raiz;
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            K claveActual = nodoActual.getClave();
            if (claveABuscar.compareTo(claveActual) > 0) {
                nodoActual = nodoActual.getHijoDerecho();
            } else if (claveABuscar.compareTo(claveActual) < 0) {
                nodoActual = nodoActual.getHijoIzquierdo();
            } else {
                return nodoActual.getValor();
            }
        }
        return null;
    }

    @Override
    public boolean contiene(K claveABuscar) {
        return this.buscar(claveABuscar) != null;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int sizeRec() {
        return sizeRec(this.raiz);
    }

    private int sizeRec(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        int sizeIzquierdo = sizeRec(nodoActual.getHijoIzquierdo());
        int sizeDerecho = sizeRec(nodoActual.getHijoDerecho());
        return sizeIzquierdo + sizeDerecho + 1;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }

    protected int altura(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        int alturaPorIzquierda = altura(nodoActual.getHijoIzquierdo());
        int alturaPorDerecha = altura(nodoActual.getHijoDerecho());
        return alturaPorIzquierda > alturaPorDerecha
                ? alturaPorIzquierda + 1
                : alturaPorDerecha + 1;
    }

    public int alturaIt() {
        int alturaArbol = 0;
        if (this.esArbolVacio()) {
            return alturaArbol;
        }
        Queue<NodoBinario<K, V>> coladeNodos = new LinkedList<>();
        coladeNodos.offer(this.raiz);
        while (!coladeNodos.isEmpty()) {
            int nroNodosDelNivel = coladeNodos.size();
            int cont = 0;
            while (cont < nroNodosDelNivel) {
                NodoBinario<K, V> nodoActual = coladeNodos.poll();
                cont++;
                if (!nodoActual.esVacioHijoIzquierdo()) {
                    coladeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if (!nodoActual.esVacioHijoDerecho()) {
                    coladeNodos.offer(nodoActual.getHijoDerecho());
                }
            }
            alturaArbol++;
        }
        return alturaArbol;
    }

    @Override
    public void vaciar() {
        this.raiz = NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new ArrayList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Queue<NodoBinario<K, V>> coladeNodos = new LinkedList<>();
        coladeNodos.offer(this.raiz);
        while (!coladeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = coladeNodos.poll();
            recorrido.add(nodoActual.getClave());
            if (!nodoActual.esVacioHijoIzquierdo()) {
                coladeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if (!nodoActual.esVacioHijoDerecho()) {
                coladeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoPreOrden() {
        List<K> recorrido = new ArrayList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }

        Stack<NodoBinario<K, V>> piladeNodos = new Stack<>();
        piladeNodos.push(this.raiz);
        while (!piladeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = piladeNodos.pop();
            recorrido.add(nodoActual.getClave());
            if (!nodoActual.esVacioHijoDerecho()) {
                piladeNodos.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()) {
                piladeNodos.push(nodoActual.getHijoIzquierdo());
            }
        }
        return recorrido;
    }
    
    public List<V> recorridoPreOrdenParaValores() {
        List<V> recorrido = new ArrayList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }

        Stack<NodoBinario<K, V>> piladeNodos = new Stack<>();
        piladeNodos.push(this.raiz);
        while (!piladeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = piladeNodos.pop();
            recorrido.add(nodoActual.getValor());
            if (!nodoActual.esVacioHijoDerecho()) {
                piladeNodos.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()) {
                piladeNodos.push(nodoActual.getHijoIzquierdo());
            }
        }
        return recorrido;
    }    

    @Override
    public List<K> recorridoInOrden() {
        List<K> recorrido = new ArrayList<>();
        this.recorridoInOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoInOrden(NodoBinario<K, V> nodoActual, List<K> recorrido) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        recorridoInOrden(nodoActual.getHijoIzquierdo(), recorrido);
        recorrido.add(nodoActual.getClave());
        recorridoInOrden(nodoActual.getHijoDerecho(), recorrido);

    }
    
    public List<V> recorridoInOrdenParaValores() {
        List<V> recorrido = new ArrayList<>();
        this.recorridoInOrdenParaValores(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoInOrdenParaValores(NodoBinario<K, V> nodoActual, List<V> recorrido) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        recorridoInOrdenParaValores(nodoActual.getHijoIzquierdo(), recorrido);
        recorrido.add(nodoActual.getValor());
        recorridoInOrdenParaValores(nodoActual.getHijoDerecho(), recorrido);

    }
    
    public List<K> recorridoInOrdenIterativo() {
        List<K> recorrido = new ArrayList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }

        Stack<NodoBinario<K, V>> piladeNodos = new Stack<>();
        NodoBinario<K, V> nodoActual = this.raiz;
        piladeNodos.push(nodoActual);
        while (!piladeNodos.isEmpty()) {
            
            while(!nodoActual.esVacioHijoIzquierdo()) {
                nodoActual = nodoActual.getHijoIzquierdo();
                piladeNodos.push(nodoActual);
            }
            NodoBinario<K, V>nodoAux = piladeNodos.pop();
            recorrido.add(nodoAux.getClave());
            if (!nodoAux.esVacioHijoDerecho()) {
                piladeNodos.push(nodoAux.getHijoDerecho());
                nodoActual = nodoAux.getHijoDerecho();
            }

        }
        return recorrido;        
    }

    @Override
    public List<K> recorridoPostOrden() {
        List<K> recorrido = new ArrayList<>();
            this.recorridoPostOrden(this.raiz, recorrido);
        return recorrido;
    
    }
    
    private void recorridoPostOrden(NodoBinario<K, V> nodoActual, List<K> recorrido) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        recorridoPostOrden(nodoActual.getHijoIzquierdo(), recorrido);
        recorridoPostOrden(nodoActual.getHijoDerecho(), recorrido);
        recorrido.add(nodoActual.getClave());

    }    
    
    public List<V> recorridoPostOrdenParaValores() {
        List<V> recorrido = new ArrayList<>();
            this.recorridoPostOrdenParaValores(this.raiz, recorrido);
        return recorrido;
    
    }
    
    private void recorridoPostOrdenParaValores(NodoBinario<K, V> nodoActual, List<V> recorrido) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        recorridoPostOrdenParaValores(nodoActual.getHijoIzquierdo(), recorrido);
        recorridoPostOrdenParaValores(nodoActual.getHijoDerecho(), recorrido);
        recorrido.add(nodoActual.getValor());

    }    
    
    public int cantidadNodosConUnHijo() {
        return cantidadNodosConUnHijoNoVacio(this.raiz
        );
    }
    
    private int cantidadNodosConUnHijoNoVacio(NodoBinario<K,V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        int cantHijoIzquierdo = cantidadNodosConUnHijoNoVacio(nodoActual.getHijoIzquierdo());
        int cantHijoDerecho = cantidadNodosConUnHijoNoVacio(nodoActual.getHijoDerecho());
        int cant = cantHijoIzquierdo + cantHijoDerecho;
        if (!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo() || 
                nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo()) {
            return   cant + 1;
        }
        return cant;
    }
    
    public int cantidadNodosConDosHijosNoVacios() {
        int contador = 0;
        if (this.esArbolVacio()) {
            return contador;
        }

        Stack<NodoBinario<K, V>> piladeNodos = new Stack<>();
        NodoBinario<K, V> nodoActual = this.raiz;
        piladeNodos.push(nodoActual);
        while (!piladeNodos.isEmpty()) {
            
            while(!nodoActual.esVacioHijoIzquierdo()) {
                nodoActual = nodoActual.getHijoIzquierdo();
                piladeNodos.push(nodoActual);
            }
            NodoBinario<K, V>nodoAux = piladeNodos.pop();
            if (!nodoAux.esVacioHijoDerecho() && !nodoAux.esVacioHijoIzquierdo()) {
                contador++;
            }
            
            if (!nodoAux.esVacioHijoDerecho()) {
                piladeNodos.push(nodoAux.getHijoDerecho());
                nodoActual = nodoAux.getHijoDerecho();
            }

        }    
        return contador;
    }
    
    public int cantidadNodosVaciosDelArbol() {
         int contador = 0;
        if (this.esArbolVacio()) {
            return contador;
        }

        Stack<NodoBinario<K, V>> piladeNodos = new Stack<>();
        NodoBinario<K, V> nodoActual = this.raiz;
        piladeNodos.push(nodoActual);
        while (!piladeNodos.isEmpty()) {
            
            while(!nodoActual.esVacioHijoIzquierdo()) {
                nodoActual = nodoActual.getHijoIzquierdo();
                piladeNodos.push(nodoActual);
            }
            NodoBinario<K, V>nodoAux = piladeNodos.pop();
            if (nodoAux.esVacioHijoDerecho()) {
                contador++;
            }
            if(nodoAux.esVacioHijoIzquierdo()) {
                contador++;
            }
            
            if (!nodoAux.esVacioHijoDerecho()) {
                piladeNodos.push(nodoAux.getHijoDerecho());
                nodoActual = nodoAux.getHijoDerecho();
            }

        }    
        return contador;       
    }
    
    public boolean VerificarNodosConUnHijo() {
        return VerificarNodosConUnHijo(this.raiz);
    }
    
    private boolean VerificarNodosConUnHijo(NodoBinario<K,V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return false;
        } 
        if(nodoActual.esHoja()) {
            return true;
        }
        boolean verifIzq = VerificarNodosConUnHijo(nodoActual.getHijoIzquierdo());
        boolean verifDer = VerificarNodosConUnHijo(nodoActual.getHijoDerecho());
        boolean resul = verifIzq || verifDer;
        if (!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo() || 
                nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo()) {
            resul = resul && true;
            
        } else {
            resul = false;
        }
        return resul;
    }   
    
    
    public boolean VerificarNodosConUnHijo2() {
        return VerificarNodosConUnHijo2(this.raiz);
    }
    
    private boolean VerificarNodosConUnHijo2(NodoBinario<K,V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return true;
        } 
        if(nodoActual.esHoja()) {
            return true;
        }
        
        if (!VerificarNodosConUnHijo2(nodoActual.getHijoIzquierdo())){
            return false;
        }
        
        if (!VerificarNodosConUnHijo2(nodoActual.getHijoDerecho())) {
            return false;
        }
        if ((!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo()) || 
                (nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo())) {
            return true;
        }    
        return false;
    }  
    
    private NodoBinario<K, V> nodoPredecesorInOrden(NodoBinario<K, V> nodoActual) {
        nodoActual = nodoActual.getHijoIzquierdo();
        NodoBinario<K, V> nodoAnterior = NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getHijoDerecho();
        }
        return nodoAnterior;
    }
    
    public boolean sonArbolesSimilares(ArbolBinarioBusqueda<K,V> arbol2) {
        
        //si son de diferente tamaño no son similares
        if (this.sizeRec() != arbol2.sizeRec()) {
            return false;
        }
        
        if (this.esArbolVacio() || arbol2.esArbolVacio()) {
            return false;
        }
        
        Stack<NodoBinario<K, V>> piladeNodosThisArbol = new Stack<>();
        piladeNodosThisArbol.push(this.raiz);
        Stack<NodoBinario<K, V>> piladeNodosArbol2 = new Stack<>();
        piladeNodosArbol2.push(arbol2.raiz);
        
        while (!piladeNodosThisArbol.isEmpty()) {
            NodoBinario<K, V> nodoActualThisArbol = piladeNodosThisArbol.pop();
            NodoBinario<K, V> nodoActualArbol2 = piladeNodosArbol2.pop();
            
            /* si el hijo izquierdo del nodo de este arbol es diferente del hijo 
            izquierdo del nodo del arbol2  o viceversa retorna falso*/
            if ((nodoActualThisArbol.esVacioHijoIzquierdo() && !nodoActualArbol2.esVacioHijoIzquierdo()) 
                    || (!nodoActualThisArbol.esVacioHijoIzquierdo() && nodoActualArbol2.esVacioHijoIzquierdo())) {
                return false;
            }
            /* si el hijo derecho del nodo de este arbol es diferente del hijo 
            derecho del nodo del arbol2  o viceversa retorna falso*/            
            if ((nodoActualThisArbol.esVacioHijoDerecho() && !nodoActualArbol2.esVacioHijoDerecho())
                    || (!nodoActualThisArbol.esVacioHijoDerecho() && nodoActualArbol2.esVacioHijoDerecho()) ) {
                return false; 
            }
            
            
            if (!nodoActualThisArbol.esVacioHijoDerecho()) {
                piladeNodosThisArbol.push(nodoActualThisArbol.getHijoDerecho());
                piladeNodosArbol2.push(nodoActualArbol2.getHijoDerecho());
            }

            if (!nodoActualThisArbol.esVacioHijoIzquierdo()) {
                piladeNodosThisArbol.push(nodoActualThisArbol.getHijoIzquierdo());
                piladeNodosArbol2.push(nodoActualArbol2.getHijoIzquierdo());
            }
           
        }
        return true;
    }    
    
    public void mostrarArbol() {
        if (!this.esArbolVacio()) {
            int cont = 0;
            this.mostrarArbol(this.raiz,cont);
        }
    }
    
    private void mostrarArbol(NodoBinario<K,V> nodoActual,int cont) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        else{
            mostrarArbol(nodoActual.getHijoDerecho(), cont + 1);
            for (int i = 0; i < cont; i++) {
                System.out.print("   ");
            }
            System.out.println(nodoActual.getClave());
            mostrarArbol(nodoActual.getHijoIzquierdo(), cont + 1);
        }
               
    }
    
/*public void niveles(){
        niveles("");
    }
    
    public void niveles(String nombreVar){
        if (nombreVar != null && nombreVar.length()>0)
            nombreVar = " del Arbol "+nombreVar;
        else
            nombreVar = "";
                    
        System.out.print("Niveles"+nombreVar+": ");
        
        if (this.raiz == null)
            System.out.println("(Arbol vacío)");
        else
            niveles(this.raiz);
    }

    private void niveles(NodoBinario<K,V> T){   //Pre: T no es null.
        LinkedList <NodoBinario<K,V>> colaNodos   = new LinkedList<>();
        LinkedList<Integer> colaNivel = new LinkedList<>();
        
        int nivelActual = 0;
        String coma="";
        
        colaNodos.addLast(T);
        colaNivel.addLast(1);
        
        do{
            NodoBinario<K,V> p = colaNodos.pop();       //Sacar un nodo p de la cola
            int nivelP = colaNivel.pop();   //Sacar el nivel donde se encuentra p.
            
            if (nivelP != nivelActual){ //Se está cambiando de nivel
                System.out.println();
                System.out.print("  Nivel "+nivelP+": ");
                nivelActual = nivelP;
                coma = "";
            }
            
            System.out.print(coma + p.getClave());
            coma = ", ";
            
            addHijos(colaNodos, colaNivel, p, nivelP);   
        }while (colaNodos.size() > 0);
        
        System.out.println();
    }
    
    private void addHijos(LinkedList <NodoBinario<K,V>> colaNodos, LinkedList<Integer> colaNivel,  NodoBinario<K,V> p, int nivelP){
       NodoBinario<K,V> hijo = null;
        for (int i=1; i<=2; i++){  //Insertar a la cola de nodos los hijos no-nulos de p
            if (i == 1) {
                hijo = p.getHijoIzquierdo();
            }
            if (i == 2) {
                hijo = p.getHijoDerecho();
            }
            
            if (hijo != null){
                colaNodos.addLast(hijo);
                colaNivel.addLast(nivelP+1);
            }
        }
    }*/

    
    //Desarrollar un metodo que retorne verdadero si los nodos que no son hojas antes del nivel n en el arbol solo tienen un hijo, falso en caso contrario 


}
