/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andres
 * @param <K>
 * @param <V>
 */
public class NodoMVias<K,V> {
    private List<K> listaDeClaves;
    private List<V> listaDeValores;
    private List<NodoMVias<K,V>> listaDeHijos;
    
    public NodoMVias(int orden) {
        listaDeClaves = new LinkedList<>();
        listaDeValores = new LinkedList<>();
        listaDeHijos = new LinkedList<>();
        for (int i = 0; i < orden-1; i++) {
            listaDeClaves.add(null);
            listaDeValores.add(null);
            listaDeHijos.add(null);
        }
        listaDeHijos.add(null);
    }
    
    public NodoMVias(int orden, K primerClave, V primerValor) {
        this(orden);
        this.listaDeClaves.set(0, primerClave);
        this.listaDeValores.set(0, primerValor);
        
    }
    
    public static NodoMVias nodoVacio() {
        return null;
    }
    
    public static boolean esNodoVacio(NodoMVias elNodo) {
        return elNodo == NodoMVias.nodoVacio();
    }

    
    public static Object datoVacio() {
        return null;
    }

    public K getClave(int posicion) {
        return this.listaDeClaves.get(posicion);
    }

    public V getValor(int posicion) {
        return this.listaDeValores.get(posicion);
    }

    public NodoMVias<K,V> getHijo(int posicion) {
        return this.listaDeHijos.get(posicion);
    }     

    public void setClave(int posicion, K clave) {
        this.listaDeClaves.set(posicion, clave);
    }

    public void setValor(int posicion, V valor) {
        this.listaDeValores.set(posicion, valor);
    }

    public void setHijo(int posicion, NodoMVias<K,V> nodoHijo) {
        this.listaDeHijos.set(posicion, nodoHijo);
    }
    
    public boolean esClaveVacia(int posicion) {
        return this.listaDeClaves.get(posicion) == NodoMVias.datoVacio();
    }
    
    
    public boolean esHijoVacio(int posicion) {
        //return this.listaDeHijos.get(posicion) == NodoMVias.nodoVacio();
        return NodoMVias.esNodoVacio(this.listaDeHijos.get(posicion));
    }
    
    public boolean esHoja() {
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (!this.esHijoVacio(i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean estanClavesLlenas() {
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (this.esClaveVacia(i)) {
                return false;
            }
        }
        return true; 
    }
    
    public int cantidadDeHijosNovacios() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (!this.esHijoVacio(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }
    
     public int cantidadDeClavesNoVacias() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (!this.esClaveVacia(i)) {
                cantidad++;
            }
        }
        return cantidad; 
    } 
    
    public int cantidadDeHijosVacios() {
        return this.listaDeHijos.size() - this.cantidadDeHijosNovacios();
    }
    
}
