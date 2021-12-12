/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.clases;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class Cliente {
    String nombre;
    String apellido;
    String direccion;
    int telefono;
    List<Paquete> ListaDePaquetes;


    public Cliente() {
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = 0;
        this.ListaDePaquetes = new LinkedList<>();
    }
    public Cliente(String nombre, String apellido, String direccion, int telefono, Paquete paquete) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ListaDePaquetes = new LinkedList<>();
        ListaDePaquetes.add(paquete);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Paquete getPaquete(int posicion) {
        return ListaDePaquetes.get(posicion);
    }

    public void setPaquete(Paquete paquete) {
        this.ListaDePaquetes.add(paquete);
    }
    
            
}
