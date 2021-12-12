/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.ui;

import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.AVL;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ArbolBinarioBusqueda;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ArbolBinarioBusquedaEnteroCadena;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ExcepcionClaveNoexiste;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.IArbolBusqueda;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class TestArbol {
    public static void main(String argumentos[]) throws ExcepcionClaveNoexiste {
        IArbolBusqueda <Integer, String> arbolPrueba = new ArbolBinarioBusqueda<>();
        IArbolBusqueda <Integer, String> arbolPrueba2 = new ArbolBinarioBusqueda<>();
        IArbolBusqueda <Integer, Integer> arbolPrueba3 = new ArbolBinarioBusqueda<>();
        List<Integer> listaClaveInOrden = new LinkedList<>();
        List<Integer> listaValoresInOrden = new LinkedList<>();
        List<Integer> listaClavePostOrden = new LinkedList<>();
        List<Integer> listaValoresPostOrden = new LinkedList<>();
       // IArbolBusqueda <Integer, Integer> arbolPrueba2;
        IArbolBusqueda<Integer, Integer> arbolAvl = new AVL<>();
        IArbolBusqueda arbolEnteroCadena = new ArbolBinarioBusquedaEnteroCadena();
        
        arbolEnteroCadena.insertar(1,"hola");
        
        System.out.println("" + arbolEnteroCadena.recorridoInOrden());
        
        arbolAvl.insertar(50,50);
        arbolAvl.insertar(66,66);
        arbolAvl.insertar(51,51);
        arbolAvl.insertar(35,35);
        arbolAvl.insertar(36,36);
        arbolAvl.insertar(70,70);
        arbolAvl.insertar(80,80);
        arbolAvl.insertar(90,90);
        
        //System.out.println(arbolAvl.toString());
        System.out.println("in orden AVL: " + arbolAvl.recorridoInOrden());
        System.out.println("post orden AVL: " + arbolAvl.recorridoPostOrden());
        arbolAvl.eliminar(51);
        System.out.println("in orden AVL: " + arbolAvl.recorridoInOrden());
        System.out.println("post orden AVL: " + arbolAvl.recorridoPostOrden());
        
        arbolPrueba3.insertar(50,50);
        /* arbolPrueba3.insertar(66,66);
        arbolPrueba3.insertar(51,51);*/
        arbolPrueba3.insertar(35,35);
       arbolPrueba3.insertar(36,36);
       /* arbolPrueba3.insertar(70,70);
        arbolPrueba3.insertar(80,80);
        arbolPrueba3.insertar(34,34);
        arbolPrueba3.insertar(33,33);
        arbolPrueba3.insertar(37,37);*/
        
        
        
        System.out.println("cantidad nodos con un hijo vacio: " + ((ArbolBinarioBusqueda)arbolPrueba3).cantidadNodosConUnHijo());
        if (((ArbolBinarioBusqueda)arbolPrueba3).VerificarNodosConUnHijo2()) {
            System.out.println("verdadero");
        } else {
            System.out.println("falso");
        }
        //System.out.println(arbolAvl.toString());
        System.out.println("\n" + "in orden AVL: " + arbolPrueba3.recorridoInOrden());
        System.out.println("post orden AVL: " + arbolPrueba3.recorridoPostOrden());
        arbolPrueba3.eliminar(51);
        System.out.println("in orden AVL: " + arbolPrueba3.recorridoInOrden());
        System.out.println("post orden AVL: " + arbolPrueba3.recorridoPostOrden());        
        

       
        
        arbolPrueba.insertar(60, "andres silva");
        arbolPrueba.insertar(40, "Pepe serrate");
        arbolPrueba.insertar(100, "Juan Morales");
        arbolPrueba.insertar(20, "Juana flores");
        arbolPrueba.insertar(50, "Armando Paredes");
        arbolPrueba.insertar(45, "Joaquin Chumacero");
        arbolPrueba.insertar(22, "Roberto pan");
        arbolPrueba.insertar(21, "Roberto pan");
        arbolPrueba.insertar(23, "Roberto pan");
        arbolPrueba.insertar(140, "Roberto pan");
        arbolPrueba.insertar(120, "Roberto pan");
        arbolPrueba.insertar(125, "Roberto pan");
       
        arbolPrueba2.insertar(60, "andres silva");
        arbolPrueba2.insertar(40, "Pepe serrate");
        arbolPrueba2.insertar(100, "Juan Morales");
        arbolPrueba2.insertar(20, "Juana flores");
        arbolPrueba2.insertar(50, "Armando Paredes");
        arbolPrueba2.insertar(22, "Joaquin Chumacero");
        arbolPrueba2.insertar(125, "Roberto pan");
        arbolPrueba2.insertar(200, "Roberto pan");
        arbolPrueba2.insertar(300, "Roberto pan");
        arbolPrueba2.insertar(600, "Roberto pan");
        arbolPrueba2.insertar(110, "Roberto pan");
        arbolPrueba2.insertar(115, "Roberto pan");     
        //arbolPrueba2.insertar(66, "Roberto pan");     
        
        
        System.out.println("por niveles arbolPrueba2 " + arbolPrueba2.recorridoPorNiveles() );
        
        System.out.println("por niveles: " + arbolPrueba.recorridoPorNiveles());
       
        if (((ArbolBinarioBusqueda)arbolPrueba).sonArbolesSimilares((ArbolBinarioBusqueda) arbolPrueba2)) {
            System.out.println("son Arboles similares");
        }
        else {
            System.out.println("no son Arboles similares");
        }
        
        System.out.println("inOrden: " + arbolPrueba.recorridoInOrden());
        System.out.println("inOrden: " + ((ArbolBinarioBusqueda)arbolPrueba).recorridoInOrdenIterativo());
        System.out.println("post Orden: " + arbolPrueba.recorridoPostOrden());
        System.out.println("PreOrden: " + arbolPrueba.recorridoPreOrden());
        
        
        System.out.println("cantidad de nodos vacios del arbol " + ((ArbolBinarioBusqueda)arbolPrueba).cantidadNodosVaciosDelArbol());
        System.out.println("cantidad nodos con dos hijos no vacios: " + ((ArbolBinarioBusqueda)arbolPrueba).cantidadNodosConDosHijosNoVacios());
        System.out.println(" size : " + ((ArbolBinarioBusqueda)arbolPrueba).sizeRec());
        System.out.println(" altura : " + arbolPrueba.altura());
        System.out.println(" altura : " + ((ArbolBinarioBusqueda)arbolPrueba).alturaIt());
        System.out.println(" eliminar : " + arbolPrueba.eliminar(80));
        System.out.println("inOrden: " + arbolPrueba.recorridoInOrden());
        
        listaClaveInOrden = arbolPrueba.recorridoInOrden();
        listaValoresInOrden= arbolPrueba.recorridoInOrden();
        listaClavePostOrden = arbolPrueba.recorridoPreOrden();
        listaValoresPostOrden = arbolPrueba.recorridoPreOrden();
        
        /*arbolPrueba2 = new ArbolBinarioBusqueda<>(listaClaveInOrden,listaValoresInOrden,listaClavePostOrden, listaValoresPostOrden,true);
        System.out.println(listaClaveInOrden);
        System.out.println("inorden reconstruccion :" + arbolPrueba2.recorridoInOrden());        
        System.out.println("Postorden reconstruccion :" + arbolPrueba2.recorridoPostOrden());        
        System.out.println("PreOrden reconstruccion: " + arbolPrueba2.recorridoPreOrden());*/
    }
}
