package bibliotecaunab;

import java.util.Locale;

public class Usuario {

    private String nomUsuario;
    private String rutUsuario;
    private String generoUsuario;


    public String getNomUsuario() {
        return nomUsuario = nomUsuario.toUpperCase();
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario.toUpperCase();
    }

    public String getRutUsuario() { return rutUsuario;}

    //VALIDACIÓN RUT

        public void setRutUsuario(String rutUsuario) {
        if(rutUsuario.length() > 8 && rutUsuario.length() < 11
                && (rutUsuario.charAt(rutUsuario.length() -1) == 'k' || rutUsuario.charAt(rutUsuario.length() -1) > 0) ) {
            this.rutUsuario = rutUsuario;}
        else{System.out.println("Rut debe ser sin puntos ni guion");}
        }

    public String getGeneroUsuario() {
        return generoUsuario;
    }

    public void setGeneroUsuario(String generoUsuario) {
        this.generoUsuario = generoUsuario.toUpperCase();
    }
}
