/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.test;

import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.AVL;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ArbolB;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ArbolBinarioBusqueda;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ArbolMViasBusqueda;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ExcepcionClaveNoexiste;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ExeceptionOrdenNoValido;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.IArbolBusqueda;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class practico  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExcepcionClaveNoexiste, ExeceptionOrdenNoValido {
        int opcion;
        boolean salir = false;
        Scanner in = new Scanner(System.in); 
        
        while (! salir) {            
            System.out.println("--------------Menu Principal--------------------");
            System.out.println("1 Resultados de todos los metodos del Practico");
            System.out.println("2 Menu Arbol Binario");
            System.out.println("3 Menu Arbol AVL");
            System.out.println("4 Menu Arbol Mvias");
            System.out.println("5 Menu Arbol B");
            System.out.println("6 Salir");
            try {
                //System.out.println("Elija una opcion: ");
                opcion = in.nextInt();

                switch(opcion) {
                    case 1:
                            resultados();
                            break;
                    case 2: 
                            menuArbolBin();
                            break;
                    case 3:
                            menuArbolAvl();
                            break;
                    case 4:
                            menuArbolMvias();
                            break;
                    case 5:
                            menuArbolB();
                            break;
                    case 6: salir = true;
                            break;

                    default: System.out.println("Opcion invalida Digite nuevamente");           
                }
            }catch(InputMismatchException e) {
                System.out.println("Debe introducir un numero");
                in.next();
            }
            System.out.println("");
        }
        System.out.println("Fin del menu"); 
        
        
   }
    
    public static void resultados() throws ExeceptionOrdenNoValido, ExcepcionClaveNoexiste {
        IArbolBusqueda<Integer,String>  arbolBinario1 = new ArbolBinarioBusqueda<>();
        List<Integer> listaClaveInOrden = new LinkedList<>();
        List<String> listaValoresInOrden = new LinkedList<>();
        List<Integer> listaClavesPostOrden = new LinkedList<>();
        List<String> listaValoresPostOrden = new LinkedList<>();
        List<Integer> listaClavePreOrden = new LinkedList<>();
        List<String> listaValoresPreOrden = new LinkedList<>();
        
        IArbolBusqueda<Integer,String>  arbolAvl = new AVL<>();
        IArbolBusqueda<Integer,String>  arbolMvias1 = new ArbolMViasBusqueda<>(4);
        IArbolBusqueda<Integer,String>  arbolB = new ArbolB<>(4);
        
        System.out.println("para las pruebas se inserto las siguientes claves y valores para todos los arboles: \n"
                + "60, andres silva \n"
                + "40, Pepe serrate \n"
                + "100, Juan Morales \n"
                + "20, Juana flores \n"
                + "50, Armando Paredes \n"
                + "45, Joaquin Chumacero \n"
                + "22, Roberto paniagua \n"
                + "21, Esteban Arce \n"
                + "23, Diego Rojas \n"
                + "140, Belen Flores \n"
                + "120, Brenda Tordoya \n"
                + "125, Jose Marco Roca \n \n"
                +"y orden 4 para el arbolMvias y  arbolB \n");
        
        arbolBinario1.insertar(60, "andres silva");
        arbolBinario1.insertar(40, "Pepe serrate");
        arbolBinario1.insertar(100, "Juan Morales");
        arbolBinario1.insertar(20, "Juana flores");
        arbolBinario1.insertar(50, "Armando Paredes");
        arbolBinario1.insertar(45, "Joaquin Chumacero");
        arbolBinario1.insertar(22, "Roberto paniagua");
        arbolBinario1.insertar(21, "Esteban Arce");
        arbolBinario1.insertar(23, "Diego Rojas");
        arbolBinario1.insertar(140, "Belen Flores");
        arbolBinario1.insertar(120, "Brenda Tordoya");
        arbolBinario1.insertar(125, "Jose Marco Roca");
        
        arbolAvl.insertar(60, "andres silva");
        arbolAvl.insertar(40, "Pepe serrate");
        arbolAvl.insertar(100, "Juan Morales");
        arbolAvl.insertar(20, "Juana flores");
        arbolAvl.insertar(50, "Armando Paredes");
        arbolAvl.insertar(45, "Joaquin Chumacero");
        arbolAvl.insertar(22, "Roberto paniagua");
        arbolAvl.insertar(21, "Esteban Arce");
        arbolAvl.insertar(23, "Diego Rojas");
        arbolAvl.insertar(140, "Belen Flores");
        arbolAvl.insertar(120, "Brenda Tordoya");
        arbolAvl.insertar(125, "Jose Marco Roca");
        
        arbolMvias1.insertar(60, "andres silva");
        arbolMvias1.insertar(40, "Pepe serrate");
        arbolMvias1.insertar(100, "Juan Morales");
        arbolMvias1.insertar(20, "Juana flores");
        arbolMvias1.insertar(50, "Armando Paredes");
        arbolMvias1.insertar(45, "Joaquin Chumacero");
        arbolMvias1.insertar(22, "Roberto paniagua");
        arbolMvias1.insertar(21, "Esteban Arce");
        arbolMvias1.insertar(23, "Diego Rojas");
        arbolMvias1.insertar(140, "Belen Flores");
        arbolMvias1.insertar(120, "Brenda Tordoya");
        arbolMvias1.insertar(125, "Jose Marco Roca");
        
        arbolB.insertar(60, "andres silva");
        arbolB.insertar(40, "Pepe serrate");
        arbolB.insertar(100, "Juan Morales");
        arbolB.insertar(20, "Juana flores");
        arbolB.insertar(50, "Armando Paredes");
        arbolB.insertar(45, "Joaquin Chumacero");
        arbolB.insertar(22, "Roberto paniagua");
        arbolB.insertar(21, "Esteban Arce");
        arbolB.insertar(23, "Diego Rojas");
        arbolB.insertar(140, "Belen Flores");
        arbolB.insertar(120, "Brenda Tordoya");
        arbolB.insertar(125, "Jose Marco Roca");
        
        System.out.println("Ejercicio 1.- insertar en el arbol AVL");
        System.out.println("recorrido por niveles arbolAvl: " + arbolAvl.recorridoPorNiveles());
        ((AVL)arbolAvl).mostrarArbol();
        System.out.println("Ejercicio 2.- Eliminar del arbolAvl: 'Eliminar el 40' valor eliminado: " 
                + arbolAvl.eliminar(40));
        System.out.println("recorrido por niveles del arbolAvl despues de eliminar el 40 : " 
                + arbolAvl.recorridoPorNiveles());
        ((AVL)arbolAvl).mostrarArbol();
        System.out.println("");
        
        System.out.println("Ejercicio 3.- insertar en el arbolB");
        System.out.println("recorrido por niveles arbloB: " + arbolB.recorridoPorNiveles());
        System.out.println("Ejercicio 4.- Eliminar del arbolB: 'Eliminar el 40' valor eliminado: "
                + arbolB.eliminar(40));
        System.out.println("recorrido por niveles del arbolB despues de eliminar el 40 : " 
                + arbolB.recorridoPorNiveles());
        System.out.println("");
        
        System.out.println("Ejercicio 5.- insertar en el arbolMvias");
        System.out.println("recorrido por niveles arbloMvias: " + arbolMvias1.recorridoPorNiveles());
        System.out.println("Ejercicio 6.- Eliminar del arbloMvias: 'Eliminar el 40' valor eliminado: " 
                + arbolMvias1.eliminar(40));
        System.out.println("recorrido por niveles del arbloMvias despues de eliminar el 40 : " 
                + arbolMvias1.recorridoPorNiveles());
        System.out.println("");
        
        System.out.println("Ejercicio 7.- Cantidad de nodos con ambos Hijos no vacios del arbolBinarioBusqueda: " 
                + ((ArbolBinarioBusqueda)arbolBinario1).cantidadNodosConDosHijosNoVacios());   
        System.out.println("Ejercicio 8.- Cantidad de nodos con un Hijo no vacio del arbolBinarioBusqueda:      " 
                + ((ArbolBinarioBusqueda)arbolBinario1).cantidadNodosConUnHijo());
        System.out.println("Ejercicio 9.- Cantidad de nodos vacios del arbolBinarioBusqueda:                    " 
                + ((ArbolBinarioBusqueda)arbolBinario1).cantidadNodosVaciosDelArbol() );
        System.out.println("");
        
        listaClaveInOrden = arbolBinario1.recorridoInOrden();
        listaValoresInOrden= ((ArbolBinarioBusqueda)arbolBinario1).recorridoInOrdenParaValores();
        listaClavePreOrden = arbolBinario1.recorridoPreOrden();
        listaValoresPreOrden = ((ArbolBinarioBusqueda)arbolBinario1).recorridoPreOrdenParaValores();
        
        arbolBinario1 = new ArbolBinarioBusqueda<>(listaClaveInOrden,listaValoresInOrden,
                listaClavePreOrden, listaValoresPreOrden,true);
        System.out.println("Ejercicio 10 Reconstruccion Con preOrden" );
        ((ArbolBinarioBusqueda)arbolBinario1).mostrarArbol();
        System.out.println("");
       
        listaClavesPostOrden = arbolBinario1.recorridoPostOrden();
        listaValoresPostOrden= ((ArbolBinarioBusqueda)arbolBinario1).recorridoPostOrdenParaValores();
        
        arbolBinario1 = new ArbolBinarioBusqueda<>(listaClaveInOrden,listaValoresInOrden,
                listaClavesPostOrden, listaValoresPostOrden,false);
        System.out.println("Ejercicio 10 Reconstruccion Con postOrden" );
        ((ArbolBinarioBusqueda)arbolBinario1).mostrarArbol();
        System.out.println("");
        
        System.out.println("Ejercicio 12 ¿hay Nodos Completos en el Nivel N? N =1" );
        int n = 1;
        if (((ArbolMViasBusqueda)arbolMvias1).hayNodosCompletosNivelN(n)) {
            System.out.println("Si Hay Nodos Completos en el nivel " + n );
        }else {
            System.out.println("No hay Nodos Completos en el nivel " + n);
        }
        System.out.println("");
        
        System.out.println("para el arbol2 a comparar si es similar se insertaron las sig claves y valores: \n"
                + "80, andres silva \n"
                + "60, Pepe serrate \n"
                + "45, Juan Morales \n"
                + "65, Juana flores \n"
                + "63, Armando Paredes \n"
                + "49, Joaquin Chumacero \n"
                + "47, Roberto \n"
                + "51, juan \n"
                + "95, Ana \n"
                + "120, Marcos \n"
                + "110, Leoncio \n"
                + "115, Lucas \n \n"
                );
        
        System.out.println("Ejercicio 14 ¿Son Arboles Similares? con Arboles Mvias, orden = 4");
        
        IArbolBusqueda<Integer,String> arbolMvias2 = new ArbolMViasBusqueda<>(4);
        arbolMvias2.insertar(80, "andres silva");
        arbolMvias2.insertar(60, "Pepe serrate");
        arbolMvias2.insertar(45, "Juan Morales");
        arbolMvias2.insertar(65, "Juana flores");
        arbolMvias2.insertar(63, "Armando Paredes");
        arbolMvias2.insertar(49, "Joaquin Chumacero");
        arbolMvias2.insertar(47, "Roberto ");
        arbolMvias2.insertar(51, "juan ");
        arbolMvias2.insertar(95, "Ana ");
        arbolMvias2.insertar(120, "Marcos ");
        arbolMvias2.insertar(110, "Leoncio ");
        arbolMvias2.insertar(115, "Lucas ");
        if (((ArbolMViasBusqueda)arbolMvias1).sonArbolesSimilares((ArbolMViasBusqueda) arbolMvias2)) {
            System.out.println("si,son Arboles similares");
        }
        else {
            System.out.println("no son Arboles similares");
        } 
        System.out.println("");
        
        System.out.println("Ejercicio 15 ¿Son Arboles Similares? con Arboles Binarios");
        IArbolBusqueda<Integer,String> arbol2 = new ArbolBinarioBusqueda<>();
        arbol2.insertar(80, "andres silva");
        arbol2.insertar(60, "Pepe serrate");
        arbol2.insertar(45, "Juan Morales");
        arbol2.insertar(65, "Juana flores");
        arbol2.insertar(63, "Armando Paredes");
        arbol2.insertar(49, "Joaquin Chumacero");
        arbol2.insertar(47, "Roberto ");
        arbol2.insertar(51, "juan ");
        arbol2.insertar(95, "Ana ");
        arbol2.insertar(120, "Marcos ");
        arbol2.insertar(110, "Leoncio ");
        arbol2.insertar(115, "Lucas ");
        
        if (((ArbolBinarioBusqueda)arbolBinario1).sonArbolesSimilares((ArbolBinarioBusqueda) arbol2)) {
            System.out.println("si son Arboles similares");
        }
        else {
            System.out.println("no son Arboles similares");
        }         
    }
    
    public static void menuArbolBin() throws ExcepcionClaveNoexiste {
        int opcion;
        boolean salir = false;
        Scanner in = new Scanner(System.in); 
        IArbolBusqueda<Integer,String>  arbolBinario1 = null;
        while (!salir) {            
            System.out.println("--------------Menu ArbolBinarioBusqueda--------------------");
            System.out.println("1 Crear Arbol Binario");
            System.out.println("2 Insertar en Arbol Binario");
            System.out.println("3 Eliminar en Arbol Binario");
            System.out.println("4 insertar valores predeterminados Arbol Binario");
            System.out.println("5 Recorrido porNiveles");
            System.out.println("6 Recorrido preOrden");
            System.out.println("7 Recorrido inOrden");
            System.out.println("8 Recorrido postOrden");
            System.out.println("9 Ejercicio 7 Cantidad de nodods con ambos Hijos no vacios ");
            System.out.println("10 Ejercicio 8 Cantidad de nodos con un Hijo no vacio");
            System.out.println("11 Ejercicio 9 Cantidad de Nodos vacios del Arbol");
            System.out.println("12 Ejercicio 10 Reconstruccion preOrden, postOrden");
            System.out.println("13 Ejercicio 15 ¿Son arboles similares?");
            System.out.println("14 Mostrar Arbol");
            System.out.println("15 salir");
            
            
            
            try {
                System.out.println("Elija una opcion: ");
                opcion = in.nextInt();
                
                switch(opcion) {
                    case 1: arbolBinario1 = new ArbolBinarioBusqueda<>(); 
                            break;
                    case 2: 
                            System.out.println("clave(Int): ");
                            Integer clave = in.nextInt();
                            System.out.println("valor(Str): ");
                            String valor = in.next();
                            arbolBinario1.insertar(clave, valor);
                            break;
                    case 3: 
                            System.out.println("claveAEliminar");
                            Integer claveAEliminar = in.nextInt();
                            System.out.println("valor Eliminado: " + arbolBinario1.eliminar(claveAEliminar));
                            break;
                    case 4: 
                            arbolBinario1.insertar(60, "andres silva");
                            arbolBinario1.insertar(40, "Pepe serrate");
                            arbolBinario1.insertar(100, "Juan Morales");
                            arbolBinario1.insertar(20, "Juana flores");
                            arbolBinario1.insertar(50, "Armando Paredes");
                            arbolBinario1.insertar(45, "Joaquin Chumacero");
                            arbolBinario1.insertar(22, "Roberto paniagua");
                            arbolBinario1.insertar(21, "Esteban Arce");
                            arbolBinario1.insertar(23, "Diego Rojas");
                            arbolBinario1.insertar(140, "Belen Flores");
                            arbolBinario1.insertar(120, "Brenda Tordoya");
                            arbolBinario1.insertar(125, "Jose Marco Roca");
                            break;
                    case 5: 
                            System.out.println("recorrido porNivelse: " + arbolBinario1.recorridoPorNiveles());
                            break;
                    case 6:
                            System.out.println("recorrido preOrden: " + arbolBinario1.recorridoPreOrden());
                            break;
                    case 7:
                            System.out.println("recorrido InOrden: " + arbolBinario1.recorridoInOrden());
                            break;
                    case 8:
                            System.out.println("recorrido postOrden: " + arbolBinario1.recorridoPostOrden());
                            break;  
                    case 9:
                            System.out.println("cantidad nodos con dos hijos no vacios: " + 
                                    ((ArbolBinarioBusqueda)arbolBinario1).cantidadNodosConDosHijosNoVacios());
                            break; 
                    case 10:
                            System.out.println("cantidad nodos con un hijo no vacio: " + 
                                    ((ArbolBinarioBusqueda)arbolBinario1).cantidadNodosConUnHijo());
                            break;
                    case 11:
                            System.out.println("cantidad de nodos vacios del arbol " + 
                                    ((ArbolBinarioBusqueda)arbolBinario1).cantidadNodosVaciosDelArbol());
                            break;
                    case 12:
                            List<Integer> listaClaveInOrden = new LinkedList<>();
                            List<String> listaValoresInOrden = new LinkedList<>();
                            List<Integer> listaClavesPostOrden = new LinkedList<>();
                            List<String> listaValoresPostOrden = new LinkedList<>();
                            List<Integer> listaClavePreOrden = new LinkedList<>();
                            List<String> listaValoresPreOrden = new LinkedList<>();                           
                            
                            listaClaveInOrden = arbolBinario1.recorridoInOrden();
                            listaValoresInOrden= ((ArbolBinarioBusqueda)arbolBinario1).recorridoInOrdenParaValores();
                            listaClavePreOrden = arbolBinario1.recorridoPreOrden();
                            listaValoresPreOrden = ((ArbolBinarioBusqueda)arbolBinario1).recorridoPreOrdenParaValores();
                            listaClavesPostOrden = arbolBinario1.recorridoPostOrden();
                            listaValoresPostOrden= ((ArbolBinarioBusqueda)arbolBinario1).recorridoPostOrdenParaValores();

                            System.out.println("reconstruccion con preOrden:");
                            arbolBinario1 = new ArbolBinarioBusqueda<>(listaClaveInOrden,listaValoresInOrden,
                                    listaClavePreOrden, listaValoresPreOrden,true);
                            ((ArbolBinarioBusqueda)arbolBinario1).mostrarArbol();
                            System.out.println("");


                            System.out.println("reconstruccion con postOrden");
                            arbolBinario1 = new ArbolBinarioBusqueda<>(listaClaveInOrden,listaValoresInOrden,
                                    listaClavesPostOrden, listaValoresPostOrden,false);
                            ((ArbolBinarioBusqueda)arbolBinario1).mostrarArbol();
                            System.out.println("");                        
                            
                            break;
                    case 13:
                            IArbolBusqueda<Integer,String> arbolBinario2 = new ArbolBinarioBusqueda<>();
                            subMenuArbol2(arbolBinario2);
                            if (((ArbolBinarioBusqueda)arbolBinario1).sonArbolesSimilares((ArbolBinarioBusqueda) arbolBinario2)) {
                                System.out.println("si,son Arboles similares");
                            }
                            else {
                                System.out.println("no son Arboles similares");
                            }
                            break;                            
                             
                    case 14: 
                            ((ArbolBinarioBusqueda)arbolBinario1).mostrarArbol();
                            break;                            
                            
                    case 15: salir = true;
                            break;

                    default: System.out.println("Opcion invalida Digite nuevamente");           
                }
            }catch(InputMismatchException e) {
                System.out.println("Debe introducir un numero");
                in.next();
            }
            System.out.println("");
        }
        System.out.println("Fin del menu");        
    }
    
    public static void menuArbolAvl() throws ExcepcionClaveNoexiste {
        int opcion;
        boolean salir = false;
        Scanner in = new Scanner(System.in); 
        IArbolBusqueda  arbolAvl = null;
        while (!salir) {            
            System.out.println("--------------Menu ArbolAvl--------------------");
            System.out.println("1 Crear Arbol AVL");
            System.out.println("2 Insertar en Arbol AVL");
            System.out.println("3 Eliminar en Arbol AVL");
            System.out.println("4 insertar valores predeterminados Arbol AVL");
            System.out.println("5 Recorrido porNiveles");
            System.out.println("6 Recorrido preOrden");
            System.out.println("7 Recorrido inOrden");
            System.out.println("8 Recorrido postOrden");
            System.out.println("9 salir");
            
            
            
            try {
                System.out.println("Elija una opcion: ");
                opcion = in.nextInt();
                
                switch(opcion) {
                    case 1: arbolAvl = new AVL<>(); 
                            break;
                    case 2: 
                            System.out.println("clave(Int): ");
                            Integer clave = in.nextInt();
                            System.out.println("valor(Str): ");
                            String valor = in.next();
                            arbolAvl.insertar(clave, valor);
                            break;
                    case 3: 
                            System.out.println("claveAEliminar");
                            Integer claveAEliminar = in.nextInt();
                            System.out.println("valor Eliminado: " + arbolAvl.eliminar(claveAEliminar));
                            break;
                    case 4: 
                            arbolAvl.insertar(60, "andres silva");
                            arbolAvl.insertar(40, "Pepe serrate");
                            arbolAvl.insertar(100, "Juan Morales");
                            arbolAvl.insertar(20, "Juana flores");
                            arbolAvl.insertar(50, "Armando Paredes");
                            arbolAvl.insertar(45, "Joaquin Chumacero");
                            arbolAvl.insertar(22, "Roberto pan");
                            arbolAvl.insertar(21, "Roberto pan");
                            arbolAvl.insertar(23, "Roberto pan");
                            arbolAvl.insertar(140, "Roberto pan");
                            arbolAvl.insertar(120, "Roberto pan");
                            arbolAvl.insertar(125, "Roberto pan");
                            break;
                    case 5: 
                            System.out.println("recorrido porNivelse: " + arbolAvl.recorridoPorNiveles());
                            break;
                    case 6:
                            System.out.println("recorrido preOrden: " + arbolAvl.recorridoPreOrden());
                            break;
                    case 7:
                            System.out.println("recorrido InOrden: " + arbolAvl.recorridoInOrden());
                            break;
                    case 8:
                            System.out.println("recorrido postOrden: " + arbolAvl.recorridoPostOrden());
                            break;                            
                            
                    case 9: salir = true;
                            break;

                    default: System.out.println("Opcion invalida Digite nuevamente");           
                }
            }catch(InputMismatchException e) {
                System.out.println("Debe introducir un numero");
                in.next();
            }
            System.out.println("");
        }
        System.out.println("Fin del menu");         
    }
    
    public static void subMenuArbol2(IArbolBusqueda<Integer,String> arbol2) throws ExcepcionClaveNoexiste {
        
        int opcion2;
        Scanner in = new Scanner(System.in);
        boolean salir2 = false;
        System.out.println("");
        while (!salir2) {      
            System.out.println(" -------------menu arbol2----------------");
            System.out.println("1 insertar en el arbol2");
            System.out.println("2 insertar valores predeterminados");
            System.out.println("3 Eliminar en Arbol2");
            System.out.println("4 Recorrido porNiveles");            
            System.out.println("5. salir y motrar los resultados");
            try {
                System.out.println("Elija una opcion: ");
                opcion2 = in.nextInt();

                switch(opcion2) {
                    case 1: 
                            System.out.println("clave(Int): ");
                            Integer clave1 = in.nextInt();
                            System.out.println("valor(Str): ");
                            String valor1 = in.next();
                            arbol2.insertar(clave1, valor1);                                            
                            break;     
                    case 2: 
                            arbol2.insertar(80, "andres silva");
                            arbol2.insertar(60, "Pepe serrate");
                            arbol2.insertar(45, "Juan Morales");
                            arbol2.insertar(65, "Juana flores");
                            arbol2.insertar(63, "Armando Paredes");
                            arbol2.insertar(49, "Joaquin Chumacero");
                            arbol2.insertar(47, "Roberto ");
                            arbol2.insertar(51, "juan ");
                            arbol2.insertar(95, "Ana ");
                            arbol2.insertar(120, "Marcos ");
                            arbol2.insertar(110, "Leoncio ");
                            arbol2.insertar(115, "Lucas ");
                            break; 
                    case 3:
                            System.out.println("claveAEliminar");
                            Integer claveAEliminar1 = in.nextInt();
                            System.out.println("valor Eliminado: " + arbol2.eliminar(claveAEliminar1));
                            break;  
                    case 4: 
                            System.out.println("recorrido porNivelse: " + arbol2.recorridoPorNiveles());
                            break;                            
                    case 5: 
                            salir2 = true;
                            break;      

                    default: System.out.println("Opcion invalida Digite nuevamente");
                }                                
            }catch(InputMismatchException e) {
                System.out.println("Debe introducir un numero");
                in.next();
            }
            System.out.println("");
        }        
    }
    
    public static void menuArbolMvias() throws ExcepcionClaveNoexiste, ExeceptionOrdenNoValido {
        int opcion;
        boolean salir = false;
        Scanner in = new Scanner(System.in); 
        IArbolBusqueda  arbolMvias1 = null;
        while (!salir) {            
            System.out.println("--------------Menu ArbolMvias--------------------");
            System.out.println("1 Crear Arbol Mvias");
            System.out.println("2 Insertar en Arbol Mvias");
            System.out.println("3 Eliminar en Arbol Mvias");
            System.out.println("4 insertar valores predeterminados Arbol Mvias");
            System.out.println("5 Recorrido porNiveles");
            System.out.println("6 Recorrido preOrden");
            System.out.println("7 Recorrido inOrden");
            System.out.println("8 Recorrido postOrden");
            System.out.println("9 Ejercicio 12¿hay Nodos Completos en el Nivel N?");
            System.out.println("10 Ejercicio 14 ¿Son Arboles Similares?");
            System.out.println("11 salir");
            
            
            
            try {
                System.out.println("Elija una opcion: ");
                opcion = in.nextInt();
                
                switch(opcion) {
                    case 1: 
                            System.out.println("Digite el Orden Del Arbol: ");
                            int orden = in.nextInt();
                            arbolMvias1 = new ArbolMViasBusqueda<>(orden); 
                            break;
                    case 2: 
                            System.out.println("clave(Int): ");
                            Integer clave = in.nextInt();
                            System.out.println("valor(Str): ");
                            String valor = in.next();
                            arbolMvias1.insertar(clave, valor);
                            break;
                    case 3: 
                            System.out.println("claveAEliminar");
                            Integer claveAEliminar = in.nextInt();
                            System.out.println("valor Eliminado: " + arbolMvias1.eliminar(claveAEliminar));
                            break;
                    case 4: 
                            arbolMvias1.insertar(60, "andres silva");
                            arbolMvias1.insertar(40, "Pepe serrate");
                            arbolMvias1.insertar(100, "Juan Morales");
                            arbolMvias1.insertar(20, "Juana flores");
                            arbolMvias1.insertar(50, "Armando Paredes");
                            arbolMvias1.insertar(45, "Joaquin Chumacero");
                            arbolMvias1.insertar(22, "Roberto paniagua");
                            arbolMvias1.insertar(21, "Esteban Arce");
                            arbolMvias1.insertar(23, "Diego Rojas");
                            arbolMvias1.insertar(140, "Belen Flores");
                            arbolMvias1.insertar(120, "Brenda Tordoya");
                            arbolMvias1.insertar(125, "Jose Marco Roca");
                            break;
                    case 5: 
                            System.out.println("recorrido porNivelse: " + arbolMvias1.recorridoPorNiveles());
                            break;
                    case 6:
                            System.out.println("recorrido preOrden: " + arbolMvias1.recorridoPreOrden());
                            break;
                    case 7:
                            System.out.println("recorrido InOrden: " + arbolMvias1.recorridoInOrden());
                            break;
                    case 8:
                            System.out.println("recorrido postOrden: " + arbolMvias1.recorridoPostOrden());
                            break;      
                    case 9:
                            System.out.println("dijite el Nivel: ");
                            int nivel = in.nextInt();
                            if (((ArbolMViasBusqueda)arbolMvias1).hayNodosCompletosNivelN(nivel)) {
                                System.out.println("Si Hay Nodos Completos en el nivel " + nivel);
                            }else {
                                System.out.println("No hay Nodos Completos en el nivel " + nivel);
                            }
                            break;                             
                    case 10:
                            System.out.println("Digite el Orden Del Arbol2 a comparar: ");
                            int orden1 = in.nextInt();
                            IArbolBusqueda<Integer,String> arbolMvias2 = new ArbolMViasBusqueda<>(orden1);
                            subMenuArbol2(arbolMvias2);
                            if (((ArbolMViasBusqueda)arbolMvias1).sonArbolesSimilares((ArbolMViasBusqueda) arbolMvias2)) {
                                System.out.println("si,son Arboles similares");
                            }
                            else {
                                System.out.println("no son Arboles similares");
                            }                            
                            break;
                            
                    case 11: salir = true;
                            break;

                    default: System.out.println("Opcion invalida Digite nuevamente");           
                }
            }catch(InputMismatchException e) {
                System.out.println("Debe introducir un numero");
                in.next();
            }
            System.out.println("");
        }
        System.out.println("Fin del menu");         
    } 

    public static void menuArbolB() throws ExcepcionClaveNoexiste {
        int opcion;
        boolean salir = false;
        Scanner in = new Scanner(System.in); 
        IArbolBusqueda  arbolB1 = null;
        while (!salir) {            
            System.out.println("--------------Menu arbolB--------------------");
            System.out.println("1 Crear arbolB");
            System.out.println("2 Insertar en arbolB");
            System.out.println("3 Eliminar en arbolB");
            System.out.println("4 insertar valores predeterminados ArbolB ");
            System.out.println("5 Recorrido porNiveles");
            System.out.println("6 Recorrido preOrden");
            System.out.println("7 Recorrido inOrden");
            System.out.println("8 Recorrido postOrden");
            System.out.println("9 salir");
            
            
            
            try {
                System.out.println("Elija una opcion: ");
                opcion = in.nextInt();
                
                switch(opcion) {
                    case 1: arbolB1 = new ArbolMViasBusqueda<>(); 
                            break;
                    case 2: 
                            System.out.println("clave(Int): ");
                            Integer clave = in.nextInt();
                            System.out.println("valor(Str): ");
                            String valor = in.next();
                            arbolB1.insertar(clave, valor);
                            break;
                    case 3: 
                            System.out.println("claveAEliminar");
                            Integer claveAEliminar = in.nextInt();
                            System.out.println("valor Eliminado: " + arbolB1.eliminar(claveAEliminar));
                            break;
                    case 4: 
                            arbolB1.insertar(60, "andres silva");
                            arbolB1.insertar(40, "Pepe serrate");
                            arbolB1.insertar(100, "Juan Morales");
                            arbolB1.insertar(20, "Juana flores");
                            arbolB1.insertar(50, "Armando Paredes");
                            arbolB1.insertar(45, "Joaquin Chumacero");
                            arbolB1.insertar(22, "Roberto paniagua");
                            arbolB1.insertar(21, "Esteban Arce");
                            arbolB1.insertar(23, "Diego Rojas");
                            arbolB1.insertar(140, "Belen Flores");
                            arbolB1.insertar(120, "Brenda Tordoya");
                            arbolB1.insertar(125, "Jose Marco Roca");
                            break;
                    case 5: 
                            System.out.println("recorrido porNivelse: " + arbolB1.recorridoPorNiveles());
                            break;
                    case 6:
                            System.out.println("recorrido preOrden: " + arbolB1.recorridoPreOrden());
                            break;
                    case 7:
                            System.out.println("recorrido InOrden: " + arbolB1.recorridoInOrden());
                            break;
                    case 8:
                            System.out.println("recorrido postOrden: " + arbolB1.recorridoPostOrden());
                            break;                            
                            
                    case 9: salir = true;
                            break;

                    default: System.out.println("Opcion invalida Digite nuevamente");           
                }
            }catch(InputMismatchException e) {
                System.out.println("Debe introducir un numero");
                in.next();
            }
            System.out.println("");
        }
        System.out.println("Fin del menu");         
    }     
    
}
