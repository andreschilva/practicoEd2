/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles;

import java.util.List;

/**
 *
 * @author Andres
 * @param <K>
 * @param <V>
 */

public interface IArbolBusqueda<K extends Comparable<K>,V> {
    public void insertar(K claveAInsertar, V valorAInsertar) throws NullPointerException;
    public V eliminar(K claveAEliminar) throws ExcepcionClaveNoexiste;
    V buscar(K claveABuscar);
    boolean contiene(K claveABuscar);
    int size();
    int altura();
    void vaciar();
    boolean esArbolVacio();
    List<K> recorridoPorNiveles();
    List<K> recorridoPreOrden();
    List<K> recorridoInOrden();
    List<K> recorridoPostOrden();
}    
