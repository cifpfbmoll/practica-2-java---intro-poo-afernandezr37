import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int menu = 1;
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNBiblioteca("CIFP Francesc Borja Moll");
        while (menu == 1 || menu == 2) {
            menu = 0;
            System.out.println("Menú de biblioteca.");
            System.out.println("Introduce 1 para el menú de reservas");
            System.out.println("Introduce 2 para el menú de personal");
            System.out.println("Introduce cualquier otra cosa para acabar el programa");
            try {
                menu = teclado.nextInt();
                teclado.nextLine();
            }
            catch (Exception e) {
            }
            switch (menu) {
                case 1:
                menuReservas(biblioteca, teclado);
                break;
                case 2:
                menuPersonal(biblioteca, teclado);
            }
        }
        teclado.close();
    }

    public static void menuReservas(Biblioteca biblioteca, Scanner teclado){
        int menu = 1;
        while (menu != 0) {
            System.out.println("Menú de reservas.");
            System.out.println("1: Añadir libro.");
            System.out.println("2: Eliminar libro.");
            System.out.println("3: Buscar libro por ISBN");
            System.out.println("4: Buscar libro por título");
            System.out.println("0: Volver al menú anterior");
            try {
                menu = teclado.nextInt();
            }
            catch (Exception e) {
            }
            teclado.nextLine();
            switch (menu) {
                case 1:
                try {
                    int auxIsbn;
                    String auxTitulo;
                    String auxEditorial;
                    int auxNCopias;
                    int auxNCopiasDisponibles;
                    System.out.println("Introduce el ISBN (un número, sin guiones (un int))");
                    auxIsbn = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Introduce el título");
                    auxTitulo = teclado.nextLine();
                    System.out.println("Introduce la editorial");
                    auxEditorial = teclado.nextLine();
                    System.out.println("Introduce el número de copias");
                    auxNCopias = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Introduce el número de copias disponibles");
                    auxNCopiasDisponibles = teclado.nextInt();
                    teclado.nextLine();
                    Libro auxLibro = new Libro(auxIsbn, auxTitulo, auxEditorial, auxNCopias, auxNCopiasDisponibles);
                    Libro.anadirLibro(auxLibro, biblioteca.getListaLibros());
                }
                catch (Exception e) {
                    System.out.println("Has introducido un valor no soportado");
                }
                break;
                case 2:
                try {
                    int auxIsbn;
                    System.out.println("Introduce el ISBN del libro que quieres eliminar");
                    auxIsbn = teclado.nextInt();
                    teclado.nextLine();
                    Libro.eliminarLibro(auxIsbn, biblioteca.getListaLibros());
                }
                catch (Exception e) {
                }
                break;
                case 3:
                try {
                    int auxIsbn;
                    int auxBuscar;
                    System.out.println("Introduce el ISBN del libro que quieres buscar");
                    auxIsbn = teclado.nextInt();
                    teclado.nextLine();
                    auxBuscar =Libro.buscarIsbn(auxIsbn, biblioteca.getListaLibros());
                    if (auxBuscar != -1) {
                        System.out.println(biblioteca.getListaLibros().get(auxBuscar).toString());
                        System.out.println("\nPulsa enter para volver al menú principal");
                        teclado.nextLine();
                    }
                    else {
                        System.out.println("No tenemos ningún libro con el ISBN introducido");
                    }
                }
                catch (Exception e) {
                }
                break;
                case 4:
                try {
                    String auxTitulo;
                    int auxBuscar;
                    System.out.println("Introduce el Título del libro que quieres buscar");
                    auxTitulo = teclado.nextLine();
                    auxBuscar =Libro.buscarTitulo(auxTitulo, biblioteca.getListaLibros());
                    if (auxBuscar != -1) {
                        System.out.println(biblioteca.getListaLibros().get(auxBuscar).toString());
                        System.out.println("\nPulsa enter para volver al menú principal");
                        teclado.nextLine();
                    }
                    else {
                        System.out.println("No tenemos ningún libro con el título introducido");
                    }
                }
                catch (Exception e) {
                }
                break;
                }
        }
    }

    public static void menuPersonal(Biblioteca biblioteca, Scanner teclado) {
        int menu = 1;
        while (menu != 0) {
            System.out.println("Menú de personal.");
            System.out.println("1: Añadir persona.");
            System.out.println("2: Eliminar persona.");
            System.out.println("3: Buscar persona por NIF");
            System.out.println("4: Buscar persona por Nombre");
            System.out.println("5: Buscar persona por Nombre y apellidos");
            System.out.println("0: Volver al menú anterior");
            try {
                menu = teclado.nextInt();
            }
            catch (Exception e) {
            }
            teclado.nextLine();
            switch (menu) {
                case 1:
                try {
                    String auxNombre;
                    String auxApellido1;
                    String auxApellido2;
                    String auxNif;
                    String auxContraseña;
                    System.out.println("Introduce el Nombre");
                    auxNombre = teclado.nextLine();
                    System.out.println("Introduce el primer apellido");
                    auxApellido1 = teclado.nextLine();
                    System.out.println("Introduce la segundo apellido");
                    auxApellido2 = teclado.nextLine();
                    System.out.println("Introduce el NIF");
                    auxNif = teclado.nextLine();
                    System.out.println("Introduce la contraseña de la persona que estamos añadiendo");
                    auxContraseña = teclado.nextLine();
                    Persona auxPersona = new Persona(auxNombre, auxApellido1, auxApellido2, auxNif, auxContraseña);
                    Persona.anadirPersona(auxPersona, biblioteca.getListaPersonal());
                }
                catch (Exception e) {
                    System.out.println("Error, has introducido un valor no soportado");
                }
                break;
                case 2:
                try {
                    String auxNif;
                    System.out.println("Introduce el NIF de la persona que quieres eliminar");
                    auxNif = teclado.nextLine();
                    Persona.eliminarPersona(auxNif, biblioteca.getListaPersonal());
                }
                catch (Exception e) {
                }
                break;
                case 3:
                try {
                    String auxNif;
                    int auxBuscar;
                    System.out.println("Introduce el NIF de la persona que quieres buscar");
                    auxNif = teclado.nextLine();
                    auxBuscar = Persona.buscarPersonaNif(auxNif, biblioteca.getListaPersonal());
                    if (auxBuscar != -1) {
                        System.out.println(biblioteca.getListaPersonal().get(auxBuscar).toString());
                        System.out.println("\nPulsa enter para volver al menú principal");
                        teclado.nextLine();
                    }
                    else {
                        System.out.println("No tenemos ninguna persona con el NIF introducido registrada");
                    }
                }
                catch (Exception e) {
                }
                break;
                case 4:
                try {
                    String auxNombre;
                    int auxBuscar;
                    System.out.println("Introduce el nombre de la persona que quieres buscar");
                    auxNombre = teclado.nextLine();
                    auxBuscar = Persona.buscarPersonaNombre(auxNombre, biblioteca.getListaPersonal());
                    if (auxBuscar != -1) {
                        System.out.println(biblioteca.getListaPersonal().get(auxBuscar).toString());
                        System.out.println("\nPulsa enter para volver al menú principal");
                        teclado.nextLine();
                    }
                    else {
                        System.out.println("No tenemos ninguna persona con el nombre introducido registrada");
                    }
                }
                catch (Exception e) {
                }
                break;
                case 5:
                try {
                    String auxNombre;
                    String auxApellido1;
                    String auxApellido2;
                    int auxBuscar;
                    System.out.println("Introduce el nombre de la persona que quieres buscar");
                    auxNombre = teclado.nextLine();
                    System.out.println("Introduce el primer apellido de la persona que quieres buscar");
                    auxApellido1 = teclado.nextLine();
                    System.out.println("Introduce el segundo apellido de la persona que quieres buscar");
                    auxApellido2 = teclado.nextLine();
                    auxBuscar = Persona.buscarPersonaNombreApellidos(auxNombre, auxApellido1, auxApellido2, biblioteca.getListaPersonal());
                    if (auxBuscar != -1) {
                        System.out.println(biblioteca.getListaPersonal().get(auxBuscar).toString());
                        System.out.println("\nPulsa enter para volver al menú principal");
                        teclado.nextLine();
                    }
                    else {
                        System.out.println("No tenemos ninguna persona con el nombre y apellidos introducidos registrada");
                    }
                }
                catch (Exception e) {
                }
                break;
                }
        }
    }
}

