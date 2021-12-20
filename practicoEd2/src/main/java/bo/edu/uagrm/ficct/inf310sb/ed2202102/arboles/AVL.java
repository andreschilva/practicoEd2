/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 * @param <K>
 * @param <V>
 */
public class AVL<K extends Comparable<K>, V> extends ArbolBinarioBusqueda<K, V> {

    private static final byte TOPE_DIFERENCIA = 1;

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) throws NullPointerException {
        if (valorAInsertar == null) {
            throw new NullPointerException("No es permitido claves nulas en el arbol");
        }
        this.raiz = this.insertar(this.raiz, claveAInsertar, valorAInsertar);
    }

    private NodoBinario<K, V> insertar(NodoBinario<K, V> nodoActual, K claveAInsertar, V valorAInsertar) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            NodoBinario<K, V> nuevoNodo = new NodoBinario<>(claveAInsertar, valorAInsertar);
            return nuevoNodo;
        }
        
        K claveACtual = nodoActual.getClave();
        if (claveAInsertar.compareTo(claveACtual) < 0) {
            NodoBinario<K, V> aparentementeNuevoHijoIzquierdo
                    = insertar(nodoActual.getHijoIzquierdo(), claveAInsertar, valorAInsertar);
            nodoActual.setHijoIzquierdo(aparentementeNuevoHijoIzquierdo);
            return balancear(nodoActual); //prodria ser necesario balancear 
        }

        if (claveAInsertar.compareTo(claveACtual) > 0) {
            NodoBinario<K, V> aparentementeNuevoHijoDerecho
                    = insertar(nodoActual.getHijoDerecho(), claveAInsertar, valorAInsertar);
            nodoActual.setHijoDerecho(aparentementeNuevoHijoDerecho);
            return balancear(nodoActual);  //podria ser necesario balancear          
        }

        //si llego por aca quiere decir que encontre el nodo donde esta la clave a insertar
        nodoActual.setValor(valorAInsertar);
        return nodoActual;
    }

    private NodoBinario<K, V> balancear(NodoBinario<K, V> nodoActual) {
        int alturaPorDerecha = altura(nodoActual.getHijoDerecho());
        int alturaPorIzquierda = altura(nodoActual.getHijoIzquierdo());

        int diferenciaDeAltura = alturaPorIzquierda - alturaPorDerecha;

        if (diferenciaDeAltura > TOPE_DIFERENCIA) {
            //rotacion por derecha
            NodoBinario<K, V> hijoIzquierdo = nodoActual.getHijoIzquierdo();
            alturaPorDerecha = altura(hijoIzquierdo.getHijoDerecho());
            alturaPorIzquierda = altura(hijoIzquierdo.getHijoIzquierdo());
            if (alturaPorDerecha > alturaPorIzquierda) {
                return rotacionDobleALaDerecha(nodoActual);
            }
            return rotacionSimpleALaDerecha(nodoActual);
        } else if (diferenciaDeAltura < -TOPE_DIFERENCIA  ) {
            //rotacion por izquierda
            NodoBinario<K, V> hijoDerecho = nodoActual.getHijoDerecho();
            alturaPorDerecha = altura(hijoDerecho.getHijoDerecho());
            alturaPorIzquierda = altura(hijoDerecho.getHijoIzquierdo());
            if (alturaPorIzquierda > alturaPorDerecha) {
                return rotacionDobleALaIzquierda(nodoActual);
            }
            return rotacionSimpleALaIzquierda(nodoActual);
        }

        return nodoActual;
    }

    private NodoBinario<K, V> rotacionDobleALaIzquierda(NodoBinario<K, V> nodoActual) {
        NodoBinario<K, V> primerNodoARotar = rotacionSimpleALaDerecha(nodoActual.getHijoDerecho());
        nodoActual.setHijoDerecho(primerNodoARotar);
        return rotacionSimpleALaIzquierda(nodoActual);

    }

    private NodoBinario<K, V> rotacionDobleALaDerecha(NodoBinario<K, V> nodoActual) {
        NodoBinario<K, V> primerNodoARotar = rotacionSimpleALaIzquierda(nodoActual.getHijoIzquierdo());
        nodoActual.setHijoIzquierdo(primerNodoARotar);
        return rotacionSimpleALaDerecha(nodoActual);

    }

    private NodoBinario<K, V> rotacionSimpleALaIzquierda(NodoBinario<K, V> nodoActual) {
        NodoBinario<K, V> nodoARotar = nodoActual.getHijoDerecho();
        nodoActual.setHijoDerecho(nodoARotar.getHijoIzquierdo());
        nodoARotar.setHijoIzquierdo(nodoActual);
        return nodoARotar;
    }

    private NodoBinario<K, V> rotacionSimpleALaDerecha(NodoBinario<K, V> nodoActual) {
        NodoBinario<K, V> nodoARotar = nodoActual.getHijoIzquierdo();
        nodoActual.setHijoIzquierdo(nodoARotar.getHijoDerecho());
        nodoARotar.setHijoDerecho(nodoActual);
        return nodoARotar;
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
            return balancear(nodoActual);
        }

        if (claveAEliminar.compareTo(claveActual) > 0) {
            NodoBinario<K, V> aparentementeNuevoHijoDerecho
                    = eliminar(nodoActual.getHijoDerecho(), claveAEliminar);
            nodoActual.setHijoDerecho(aparentementeNuevoHijoDerecho);
            return balancear(nodoActual);

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


    
    
    
    
}
