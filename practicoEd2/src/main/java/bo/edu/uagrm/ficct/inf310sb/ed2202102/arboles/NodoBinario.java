/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles;

/**
 *
 * @author Andres
 * @param <K>
 * @param <V>
 */
public class NodoBinario<K,V> {
    private K clave;
    private V valor;
    private NodoBinario<K,V> hijoIzquierdo;
    private NodoBinario<K,V> hijoDerecho;

    public NodoBinario() {
    }

    public NodoBinario(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    public NodoBinario<K, V> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoBinario<K, V> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public void setHijoIzquierdo(NodoBinario<K, V> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(NodoBinario<K, V> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
    public static NodoBinario nodoVacio() {
        return null;
    }
    
    public static boolean esNodoVacio(NodoBinario elNodo) {
        return elNodo == NodoBinario.nodoVacio();
    }
    
    public boolean esVacioHijoIzquierdo() {
        return NodoBinario.esNodoVacio(this.hijoIzquierdo);
    }
    
    public boolean esVacioHijoDerecho() {
        return NodoBinario.esNodoVacio(this.hijoDerecho);
    }
    
    public boolean esHoja() {
        return this.esVacioHijoDerecho() && 
                this.esVacioHijoIzquierdo();
    }


    
    
}
