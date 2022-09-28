package bibliotecaunab;
import java.io.*;
import java.util.*;

public class BDlibros {

    File basedatos = new File("DatosLibro.txt");

    public BDlibros()//objeto para enviar los datos a esta clase
    {
    }

    public void existearchivo()//metodo para hacer la base de datos
    {
        try {
            if (basedatos.exists())//saber si existe el archivo de texto
            {
                System.out.println("la base de datos ya existe");
            } else {
                basedatos.createNewFile();
                System.out.println("base de datos creada");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void asignardatos(String isbn, String titulo, String autor) {
        try {
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(basedatos,
                    true)));
            Fescribe.write(isbn + " | " + titulo + " | " + autor + "\n"); //guarda en la base de datos los archivos                            //utf8 es un tipo de formato
            Fescribe.write("\n");//para el salto de linea
            System.out.println("El libro ha sido insertado en la base de datos");
            Fescribe.close();//cerrar archivo y que los datos queden escritos en .txt

            FileReader fr = new FileReader("DatosLibro.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena;
            while ((cadena = br.readLine()) != null)//cuando la siguiente linea leida no encuentra nada termina
            {
                System.out.println("" + cadena);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void mostrararchivos()

    //MUESTRA LA BASE DE DATOS
    {
        try {
            FileReader fr = new FileReader("DatosLibro.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena;
            while ((cadena = br.readLine()) != null) //cuando la siguiente linea leida no encuentra nada termina
            {
                System.out.println("" + cadena);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // CREAR LIBRO

    public void insertarregistro(Libro libro1) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");

        while (libro1.getIsbn() == null || libro1.getIsbn().isEmpty()) {
            System.out.println("Ingrese el ISBN (codigo universal del libro)");
            String isbn = teclado.next();
            libro1.setIsbn(isbn);
        }

        System.out.println("Ingrese titulo del libro");
        String titulo = teclado.next();
        boolean isCondicionSet = false;

        System.out.println("Ingrese autor del libro");
        String autor = teclado.next();
        System.out.println("");
        asignardatos(libro1.getIsbn(), titulo, autor);

    }

    // MODIFICAR LIBRO
    public void buscarregistro(String id3)
    // Busca el registro por cadena de caracteres, lo borra, y vuelve a insertar uno modificado
    {
        String libro = id3;
        try {
            Scanner teclado = new Scanner(System.in).useDelimiter("\n");
            BufferedReader leer = new BufferedReader(new FileReader("DatosLibro.txt"));
            StringBuffer inputBuffer = new StringBuffer();
            String linea = "";
            boolean encontrado = false;

            while ((linea = leer.readLine()) != null) {
                if (linea.indexOf(libro) != -1) {
                    System.out.println("SE ENCONTRO EL REGISTRO: " + linea);
                    encontrado = true;
                    Libro libro1 = new Libro();
                    //modificando libro
                    while (libro1.getIsbn() == null || libro1.getIsbn().isEmpty()) {
                        System.out.println("INGRESE LOS DATOS PARA MODIFICAR EL REGISTRO:\n");
                        System.out.println("Ingrese el nuevo ISBN");

                        String isbn = teclado.next();
                        libro1.setIsbn(isbn);
                    }

                    System.out.println("Ingrese el titulo del libro");
                    String titulo = teclado.next();
                    boolean isCondicionSet = false;

                    System.out.println("Ingrese el autor del libro");
                    String autor = teclado.next();

                    System.out.println("");
                    inputBuffer.append(libro1.getIsbn() + " | " + titulo + " | " + autor);
                    inputBuffer.append("\n");

                    System.out.println(libro1.getIsbn() + " | " + titulo + " | " + autor);
                } else {
                    inputBuffer.append(linea);
                    inputBuffer.append('\n');
                }
            }
            leer.close();
            if (encontrado) {
                FileOutputStream fileOut = new FileOutputStream("DatosLibro.txt");
                fileOut.write(inputBuffer.toString().getBytes());
                fileOut.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void asignarlibro(String id3) {
        String libro = id3;
        try {
            Scanner teclado = new Scanner(System.in).useDelimiter("\n");
            BufferedReader leer = new BufferedReader(new FileReader("DatosLibro.txt"));
            BufferedReader leerUsuarios = new BufferedReader(new FileReader("DatosUsuarios.txt"));
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("DatosAsignacion.txt", true)));//no se para que sirve
            String linea = "";
            String linea2 = "";
            String libroAsignado = "";
            String usuarioAsignado = "";
            boolean encontrado = false;
            boolean usuarioEncontrado = false;

            while ((linea = leer.readLine()) != null) {
                if (linea.indexOf(libro) != -1) {
                    System.out.println("Se encontro el libro: " + linea);
                    libroAsignado = linea;
                    encontrado = true;
                    String rut = "";
                    System.out.println("Ingrese el rut del usuario");
                    while(rut.isEmpty()) {
                        String rutTemp = teclado.next();
                        if (rutTemp.length() > 8 && rutTemp.length() < 11
                                && (rutTemp.charAt(rutTemp.length() - 1) == 'k' || rutTemp.charAt(rutTemp.length() - 1) > 0)) {
                            rut = rutTemp;
                        }
                        else{
                            System.out.println("El rut no se encuentra ingresado, por favor ingresar al usuario");
                        }
                    }
                    while ((linea2 = leerUsuarios.readLine()) != null) {
                        if (linea2.indexOf(rut) != -1) {
                            System.out.println("Usuario encontrado: " + linea2);
                            usuarioAsignado = linea2;
                            usuarioEncontrado = true;
                        }
                    }
                    leerUsuarios.close();
                    if(!usuarioEncontrado){
                        System.out.println("Usuario no existe");
                    }
                }
            }
            leer.close();
            if (encontrado && usuarioEncontrado) {
                Fescribe.write(libroAsignado + " | " + usuarioAsignado); //guarda en la base de datos los archivos                            //utf8 es un tipo de formato
                Fescribe.write("\n");//para el salto de linea
                System.out.println("El libro ha sido asignado al usuario");
                Fescribe.close();//cerrar archivo y que los datos queden escritos en .txt
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void mostrararchivos2()

    //MUESTRA LA BASE DE DATOS DE LAS ASIGNACIONES DE LIBRO
    {
        try {
            FileReader fr = new FileReader("DatosAsignacion.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena;
            while ((cadena = br.readLine()) != null) //cuando la siguiente linea leida no encuentra nada termina
            {
                System.out.println("" + cadena);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
