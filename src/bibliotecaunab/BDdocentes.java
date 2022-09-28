package bibliotecaunab;

import java.io.*;
import java.util.*;

public class BDdocentes
{
        File basedatos = new File ("DatosUsuarios.txt");
        public BDdocentes ()//objeto para enviar los datos a esta clase
        {
        }

        public void existearchivo()//metodo para hacer la base de datos
        {
            try
            {
                if (basedatos.exists())//saber si existe el archivo de texto
                {
                    System.out.println("la base de datos ya existe");
                }
                else
                {
                    basedatos.createNewFile();
                    System.out.println("base de datos creada");
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        public void asignardatos(String rutUsuario,String nomUsuario, String generoUsuario, String profesion, String gradoAcademico )
        {
            try
            {
                BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(basedatos,true)));//no se para que sirve
                Fescribe.write(rutUsuario +" | "+nomUsuario+ " | "+generoUsuario+" | "+profesion+" | "
                        +gradoAcademico+" | Docente"); //guarda en la base de datos los archivos                            //utf8 es un tipo de formato
                Fescribe.write("\n");//para el salto de linea
                System.out.println("El usuario ha sido insertado en la base de datos");
                Fescribe.close();//cerrar archivo y que los datos queden escritos en .txt

                FileReader fr=new FileReader("DatosUsuarios.txt");
                BufferedReader br=new BufferedReader(fr);
                String cadena;
                while((cadena=br.readLine())!=null)//cuando la siguiente linea leida no encuentra nada termina
                {
                    System.out.println(""+cadena);
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }

       public void mostrararchivos()
        {
            try
            {
                FileReader fr=new FileReader("DatosUsuarios.txt");
                BufferedReader br=new BufferedReader(fr);
                String cadena;
                while((cadena=br.readLine())!=null) //cuando la siguiente linea leida no encuentra nada termina
                    {System.out.println(""+cadena);
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }

    // CREAR DOCENTE

    public void insertarregistro(Usuario usuario1){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");

        while (usuario1.getRutUsuario() == null || usuario1.getRutUsuario().isEmpty()) {
            System.out.println("Ingrese su rut");

            //String rutUsuario = myObj.next();
            String rutUsuario = teclado.next();
            usuario1.setRutUsuario(rutUsuario);
        }

        System.out.println("Ingrese su nombre completo");
        String nomUsuario = teclado.next();
        boolean isCondicionSet = false;

        while (!isCondicionSet) {
            System.out.println("Ingrese genero (M = Masculino, F = Femenino)");
            String condicion = teclado.next();
            if (condicion.toUpperCase().equals("M") || condicion.toUpperCase().equals("F")) {
                usuario1.setGeneroUsuario(condicion);
                isCondicionSet = true;
            } else {
                System.out.println("El genero debe ser M = Masculino o F = Femenino");
            }
        }
        System.out.println("Ingrese su profesion");
        String profesion = teclado.next();

        System.out.println("Ingrese su grado academico");
        String gradoacademico = teclado.next();

        System.out.println("");
        asignardatos(usuario1.getRutUsuario(), nomUsuario, usuario1.getGeneroUsuario(),
                profesion, gradoacademico);

    }
        // MODIFICAR DOCENTE
        public void buscarregistro(String id2)
        // Busca el registro por cadena de caracteres, lo borra, y vuelve a insertar uno modificado

        {
            String usuario=id2;
            try
            {
                Scanner teclado = new Scanner(System.in).useDelimiter("\n");
                BufferedReader leer=new BufferedReader(new FileReader ("DatosUsuarios.txt"));
                StringBuffer inputBuffer = new StringBuffer();
                String linea="";
                boolean encontrado = false;

                while((linea=leer.readLine())!=null)
                {
                    if (linea.indexOf(usuario)!=-1)
                    {
                        System.out.println("SE ENCONTRO EL REGISTRO: "+linea);
                        encontrado = true;
                        Usuario usuario1 = new Usuario();
                        //modificando usuario
                        while (usuario1.getRutUsuario() == null || usuario1.getRutUsuario().isEmpty()) {
                            System.out.println("INGRESE LOS DATOS PARA MODIFICAR EL REGISTRO:\n");
                            System.out.println("Ingrese el rut");

                            String rutUsuario = teclado.next();
                            usuario1.setRutUsuario(rutUsuario);
                        }//

                        System.out.println("Ingrese el nombre completo");
                        String nomUsuario = teclado.next();
                        boolean isCondicionSet = false;

                        while (!isCondicionSet) {
                            System.out.println("Ingrese genero (M = Masculino, F = Femenino)");
                            String condicion = teclado.next();
                            if (condicion.toUpperCase().equals("M") || condicion.toUpperCase().equals("F")) {
                                usuario1.setGeneroUsuario(condicion);
                                isCondicionSet = true;
                            } else {
                                System.out.println("El genero debe ser M = Masculino o F = Femenino");
                            }
                        }
                        System.out.println("Ingrese la profesion");
                        String profesion = teclado.next();

                        System.out.println("Ingrese el grado academico");
                        String gradoacademico = teclado.next();

                        System.out.println("");
                        inputBuffer.append(usuario1.getRutUsuario() +" | "+nomUsuario+ " | "+usuario1.getGeneroUsuario()+
                                " | "+profesion+" | "+gradoacademico);
                        inputBuffer.append("\n");

                        System.out.println(usuario1.getRutUsuario() +" | "+nomUsuario+ " | "+usuario1.getGeneroUsuario()+
                                " | "+profesion+" | "+gradoacademico);}

                    else{
                        inputBuffer.append(linea);
                        inputBuffer.append('\n');
                    }
                }
                leer.close();
                if(encontrado) {
                    FileOutputStream fileOut = new FileOutputStream("DatosUsuarios.txt");
                    fileOut.write(inputBuffer.toString().getBytes());
                    fileOut.close();
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }

}
