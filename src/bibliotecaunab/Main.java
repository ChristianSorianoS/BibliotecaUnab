package bibliotecaunab;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Scanner myObj = new Scanner(System.in).useDelimiter("\n");
        Usuario usuario1 = new Usuario();
        Libro libro1 = new Libro();
        BDdocentes objeto1 = new BDdocentes(); //puedo mandar los datos directo desde un metodo
        BDalumnos objeto2 = new BDalumnos();
        BDlibros objeto3 = new BDlibros();

        int mainMenu = 0;
        int menuDocente = 0;
        int menuEstudiante = 0;
        int menuBiblioteca = 0;
        //int crearUsuario = 0;

        //MENU PRINCIPAL
        while (mainMenu == 0) {
            System.out.println("************* MENU PRINCIPAL *************");
            System.out.println("*********** INGRESE SU OPCION ************");
            System.out.println("******************************************");
            System.out.println("***     1.- DOCENTE            ***********");
            System.out.println("***     2.- ESTUDIANTE         ***********");
            System.out.println("***     3.- BIBLIOTECA         ***********");
            System.out.println("***     4.- SALIR              ***********");
            System.out.println("******************************************");
            mainMenu = myObj.nextInt();

            switch (mainMenu) {
                case 1: {
                    // OPCIONES MENU DOCENTE
                    while (menuDocente == 0) {
                        System.out.println("************* MENU DOCENTE *************");
                        System.out.println("*********** INGRESE SU OPCION **********");
                        System.out.println("****************************************");
                        System.out.println("***     1.- CREAR DOCENTE    ***********");
                        System.out.println("***     2.- EDITAR DOCENTE   ***********");
                        System.out.println("***     3.- VER BD USUARIOS  ***********");
                        System.out.println("***     4.- SALIR AL MAIN MENU *********");
                        System.out.println("****************************************");
                        menuDocente = myObj.nextInt();

                        switch (menuDocente) {
                            case 1: {
                                objeto1.insertarregistro(usuario1);
                                menuDocente = 0;
                                break;
                            }
                            case 2: {
                                System.out.println("Ingresa el rut del docente a buscar");
                                String rutUsuario = teclado.next();
                                objeto1.buscarregistro(rutUsuario);
                                menuDocente = 0;
                                break;
                            }
                            case 3: {
                                objeto1.mostrararchivos();
                                menuDocente = 0;
                                break;
                            }
                            case 4: {
                                System.out.println("Volver al Menu Principal");
                                mainMenu = 0;
                                break;
                            }
                            default:{
                                menuDocente = 0;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    // OPCIONES MENU ESTUDIANTE
                    while (menuEstudiante == 0) {
                        System.out.println("************ MENU ESTUDIANTE ***********");
                        System.out.println("*********** INGRESE SU OPCION **********");
                        System.out.println("****************************************");
                        System.out.println("***     1.- CREAR ESTUDIANTE  **********");
                        System.out.println("***     2.- EDITAR ESTUDIANTE **********");
                        System.out.println("***     3.- VER BD USUARIOS   **********");
                        System.out.println("***     4.- SALIR AL MAIN MENU *********");
                        System.out.println("****************************************");
                        menuEstudiante = myObj.nextInt();

                        switch (menuEstudiante) {
                            case 1: {
                                objeto2.insertarregistro(usuario1);
                                menuEstudiante = 0;
                                break;
                            }
                            case 2: {
                                System.out.println("Ingresa el rut del estudiante a buscar");
                                String rutUsuario = teclado.next();
                                objeto2.buscarregistro(rutUsuario);
                                menuEstudiante = 0;
                                break;
                            }
                            case 3: {
                                objeto2.mostrararchivos();
                                menuEstudiante = 0;
                                break;
                            }
                            case 4: {
                                System.out.println("Volver al Menu Principal");
                                mainMenu = 0;
                                break;
                            }
                            default:{
                                menuEstudiante = 0;
                                break;
                            }
                        }

                }
                    break;
                }
                case 3: {
                    // OPCIÓN BIBLIOTECA
                    while (menuBiblioteca == 0) {
                        System.out.println("************ MENU BIBLIOTECA ***********");
                        System.out.println("*********** INGRESE SU OPCION **********");
                        System.out.println("****************************************");
                        System.out.println("***     1.- CREAR LIBRO       **********");
                        System.out.println("***     2.- EDITAR LIBRO      **********");
                        System.out.println("***     3.- VER BD LIBROS     **********");
                        System.out.println("***     4.- ASIGNAR LIBRO     **********");
                        System.out.println("***     5.- VER BD ASIGNACIONES ********");
                        System.out.println("***     6.- SALIR AL MAIN MENU *********");
                        System.out.println("****************************************");
                        menuBiblioteca = myObj.nextInt();

                        switch (menuBiblioteca) {
                            case 1: {
                                objeto3.insertarregistro(libro1);
                                menuBiblioteca = 0;
                                break;
                            }
                            case 2: {
                                System.out.println("Ingresa el ISBN del libro a modificar");
                                String isbn = teclado.next();
                                objeto3.buscarregistro(isbn);
                                menuBiblioteca = 0;
                                break;
                            }
                            case 3: {
                                objeto3.mostrararchivos();
                                menuBiblioteca = 0;
                                break;
                            }
                            case 4: {
                                System.out.println("Ingresa el ISBN del libro a asignar");
                                String isbn = teclado.next();
                                objeto3.asignarlibro(isbn);
                                menuBiblioteca = 0;
                                break;
                            }
                            case 5: {
                                objeto3.mostrararchivos2();
                                menuBiblioteca = 0;
                                break;}

                            case 6: {
                                System.out.println("Volver al Menu Principal");
                                mainMenu = 0;
                                break;
                            }
                            default:{
                                menuBiblioteca = 0;
                                break;
                            }
                        }
                    }
                    break;
                }

                case 4: {
                    // OPCIÓN SALIR
                    System.out.println("PROGRAMA FINALIZADO, GRACIAS POR UTILIZAR EL PROGRAMA");
                    break;
                }
                default: {
                    System.out.println("Ingrese un numero de opcion correcto (1, 2, 3 o 4) \n");
                    mainMenu = 0;
                    break;
                }
            }
        }
    }
}
