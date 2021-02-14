import java.util.ArrayList;

public class Persona {
    String nombre;
    String apellido1;
    String apellido2;
    String nif;
    String contraseña;

    public String toString() {
        return(this.nombre + " " + this.apellido1 + " " + this.apellido2 + "\nNIF: " + nif);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        if (contraseña.length()>=8) {
            this.contraseña = contraseña;
        }
        else {
            System.out.println("Las contraseñas tienen que ser mínimo de 8 caracteres");
        }
    }

    public Persona(){

    }

    public Persona(String nombre, String apellido1, String apellido2, String nif, String contraseña) {
        if (contraseña.length()>=8) {
            this.nombre = nombre;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
            this.nif = nif;
            this.contraseña = contraseña;
        }
        else {
            System.out.println("Las contraseñas tienen que ser mínimo de 8 caracteres");
        }
    }

    public static void anadirPersona(Persona persona, ArrayList<Persona> listaPersonas) {
        listaPersonas.add(persona);
    }
    
    public static int buscarPersonaNif(String nif, ArrayList<Persona> listaPersonas) {
        for (int i = 0;i<listaPersonas.size();i++) {
            if (listaPersonas.get(i).getNif().equals(nif) )
                return i;
        }
        return -1;
    }

    public static int buscarPersonaNombre(String nombre, ArrayList<Persona> listaPersonas) {
        for (int i = 0;i<listaPersonas.size();i++) {
            if (listaPersonas.get(i).getNombre().equals(nombre) )
                return i;
        }
        return -1;
    }

    public static int buscarPersonaNombreApellidos(String nombre, String apellido1, String apellido2, ArrayList<Persona> listaPersonas) {
        for (int i = 0;i<listaPersonas.size();i++) {
            if (listaPersonas.get(i).getNombre().equals(nombre))
                if (listaPersonas.get(i).getApellido1().equals(apellido1)) {
                    if(listaPersonas.get(i).getApellido2().equals(apellido2)) {
                        return i;
                    }
                }
                
        }
        return -1;
    }

    public static  void eliminarPersona(String nif, ArrayList<Persona> listaPersonas) {
        for (int i = 0; i<(listaPersonas.size());i++) {
            boolean personaBorrada = false;
            if (listaPersonas.get(i).getNif().equals(nif)) {
                    listaPersonas.remove(i);
                    personaBorrada = true;
            }
            if (!personaBorrada) {
                System.out.println("No se ha encontrado una persona con ese NIF");
            }
        }
        
    }

    public Persona copiar() {
        Persona persona2 = new Persona();
        persona2.setNombre(this.getNombre());
        persona2.setApellido1(this.getApellido1());
        persona2.setApellido2(this.getApellido2());
        persona2.setNif(this.getNif());
        persona2.setContraseña(this.getContraseña());
        return persona2;
    }

}