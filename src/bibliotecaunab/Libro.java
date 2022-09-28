package bibliotecaunab;

import java.util.Locale;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;


    public String getIsbn() {
        return isbn;
    }

    //VALIDACIÓN ISBN

    public void setIsbn(String isbn) {
        if(isbn.length() == 13)
            this.isbn = isbn.toUpperCase();
        else{System.out.println("ISBN debe tener 13 caracteres");}

    }

    public String getTitulo() {return titulo;

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.toUpperCase();
    }

    public String getAutor() {return autor;

    }

    public void setAutor(String autor) {
        this.autor = autor.toUpperCase();
    }
}
