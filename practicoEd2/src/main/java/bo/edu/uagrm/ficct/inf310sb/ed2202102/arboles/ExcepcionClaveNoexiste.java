/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles;

/**
 *
 * @author Andres
 */
public class ExcepcionClaveNoexiste extends Exception {
    /**
     * Creates a new instance of <code>ExcepcionClaveNoexiste</code> without
     * detail message.
     */
    public ExcepcionClaveNoexiste() {
        super("clave no existe en el arbol");
    }

    /**
     * Constructs an instance of <code>ExcepcionClaveNoexiste</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionClaveNoexiste(String msg) {
        super(msg);
    }    
}
