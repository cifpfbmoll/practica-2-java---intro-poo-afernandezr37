import java.util.ArrayList;

public class Libro {
    int isbn;
    String titulo;
    String editorial;
    int nCopias;
    int nCopiasDisp;
    static int contadorLibros = 0;


    public String toString() {
        return("ISBN: " + String.valueOf(getIsbn()) + "\nTítulo: " + titulo + "\nEditorial: " + editorial + "\nCopias: " + String.valueOf(getNCopias()) + "\nCopias disponibles: " +
        String.valueOf(nCopiasDisp));
    }

    public int getIsbn() {
        return this.isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNCopias() {
        return this.nCopias;
    }

    public int getContadorLibros() {
        return contadorLibros;
    }

    public void setNCopias(int nCopias) {
        if (nCopias> 0) {
            this.nCopias = nCopias;
        }
        else {
            System.out.println("Error, debes añadir al menos una copia");
        }
    }

    public int getNCopiasDisp() {
        return this.nCopiasDisp;
    }

    public void setNCopiasDisp(int nCopiasDisp) {
        this.nCopiasDisp = nCopiasDisp;
    }

    public Libro(int isbn, String titulo, String editorial, int nCopias, int nCopiasDisp) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.nCopias = nCopias;
        this.nCopiasDisp = nCopiasDisp;
        contadorLibros++;
    }

    public Libro() {
    }

    public static void anadirLibro(Libro libro, ArrayList<Libro> listaLibros ) {
        listaLibros.add(libro);
        contadorLibros++;
    }

    public static void eliminarLibro(int isbn, ArrayList<Libro> listaLibros) {
        Boolean libroEncontrado = false;
        for (int i = 0; (i<(listaLibros.size()) && ! libroEncontrado);i++) {
            if (listaLibros.get(i).getIsbn() == isbn) {
                libroEncontrado = true;
                if (listaLibros.get(i).getNCopias() == listaLibros.get(i).getNCopiasDisp()) {
                    listaLibros.remove(i);
                    contadorLibros--;
                }
                else {
                    System.out.println("Error, no puedes eliminar un libro con copias reservadas");
                }
            }
        }
        if (!libroEncontrado) {
            System.out.println("No hay ningún libro con el ISBN " + String.valueOf(isbn));
        }
        
    }

    public static int buscarIsbn(int isbn, ArrayList<Libro> listaLibros) {
        for (int i = 0; i<listaLibros.size();i++) {
            if (listaLibros.get(i).getIsbn() == isbn) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarTitulo(String titulo, ArrayList<Libro> listaLibros) {
        for (int i = 0; i<listaLibros.size();i++) {
            if (listaLibros.get(i).getTitulo().equals(titulo)) {
                return i;
            }
        }
        return -1;
    }
}