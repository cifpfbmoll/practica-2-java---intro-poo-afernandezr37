import java.util.ArrayList;

public class Biblioteca {
    String nBiblioteca;
    ArrayList<Libro> listaLibros;
    ArrayList<Persona> listaPersonal;

    public String getNBiblioteca() {
        return this.nBiblioteca;
    }

    public void setNBiblioteca(String nBiblioteca) {
        if (Character.isUpperCase(nBiblioteca.toCharArray()[0])) {
            this.nBiblioteca = nBiblioteca;
        }
        else {
            System.out.print("El nombre de la biblioteca debe empezar con mayúscula");
        }
    }

    public ArrayList<Libro> getListaLibros() {
        return this.listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Persona> getListaPersonal() {
        return this.listaPersonal;
    }

    public void setListaPersonal(ArrayList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public String toString() {
        return (nBiblioteca + " " + listaLibros.toString() + " " + listaPersonal.toString());
    }

    public Biblioteca copiar(){
        Biblioteca biblioteca2 = new Biblioteca();
        biblioteca2.setNBiblioteca(this.nBiblioteca);
        ArrayList<Libro> copiaListaLibros = new ArrayList<Libro>();
        for (int i = 0; i<this.listaLibros.size();i++) {
            copiaListaLibros.add(this.listaLibros.get(i));
        }
        biblioteca2.setListaLibros(copiaListaLibros);
        ArrayList<Persona> copiaListaPersonal = new ArrayList<Persona>();
        for (int i = 0; i<this.listaLibros.size();i++) {
            copiaListaPersonal.add(this.listaPersonal.get(i));
        }
        biblioteca2.setListaPersonal(copiaListaPersonal);
        return biblioteca2;
    }

    public Biblioteca() {
        listaLibros = new ArrayList<Libro>();
        listaPersonal = new ArrayList<Persona>();
    }

    public Biblioteca(String nBiblioteca, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonal) {
        if (Character.isUpperCase(nBiblioteca.toCharArray()[0])) {
            this.nBiblioteca = nBiblioteca;
            this.listaLibros = listaLibros;
            this.listaPersonal = listaPersonal;
        }
        else {
            System.out.print("El nombre de la biblioteca debe empezar con mayúscula");
        }
    }

    public void mostrarLibros(ArrayList<Libro>listaLibros) {
        for (int i=0; i<listaLibros.size();i++) {
            System.out.print(listaLibros.get(i).toString());
        }
    }

    public void mostrarLibrosDisponibles(ArrayList<Libro>listaLibros) {
        for (int i=0; i<listaLibros.size();i++) {
            if (listaLibros.get(i).getNCopiasDisp()>0) {
                System.out.print(listaLibros.get(i).toString());
            }
        }
    }
}
