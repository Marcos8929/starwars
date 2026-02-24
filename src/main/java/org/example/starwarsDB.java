import org.example.Personaje;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StarWarsDatabase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Personaje> personajes = null;

        // Cargar personajes desde el archivo JSON
        try {
            personajes = database.cargarPersonajes("/mnt/data/star-wars (1).json");  // Ruta al archivo JSON
        } catch (IOException e) {
            System.out.println("Error al cargar los personajes desde el archivo.");
            return;
        }

        int opcion;
        do {
            // Mostrar el menú
            System.out.println("===== STAR WARS DATABASE =====");
            System.out.println("1. Mostrar todos los personajes");
            System.out.println("2. Mostrar personaje por índice");
            System.out.println("3. Buscar personaje por nombre");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Leer la opción del usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            // Realizar acción según la opción seleccionada
            switch (opcion) {
                case 1:
                    mostrarPersonajes(personajes);
                    break;
                case 2:
                    mostrarPersonajePorIndice(personajes, scanner);
                    break;
                case 3:
                    buscarPersonajePorNombre(personajes, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Función para mostrar todos los personajes
    public static void mostrarPersonajes(List<Personaje> personajes) {
        System.out.println("===== Todos los personajes =====");
        for (Personaje personaje : personajes) {
            System.out.println(personaje);
        }
    }

    // Función para mostrar un personaje por índice
    public static void mostrarPersonajePorIndice(List<Personaje> personajes, Scanner scanner) {
        System.out.print("Ingrese el índice del personaje: ");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < personajes.size()) {
            System.out.println(personajes.get(indice));
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Función para buscar personaje por nombre
    public static void buscarPersonajePorNombre(List<Personaje> personajes, Scanner scanner) {
        System.out.print("Ingrese el nombre del personaje a buscar: ");
        String nombreBusqueda = scanner.nextLine().toLowerCase();
        boolean encontrado = false;

        for (Personaje personaje : personajes) {
            if (personaje.getNombre().toLowerCase().contains(nombreBusqueda)) {
                System.out.println(personaje);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron personajes con ese nombre.");
        }
    }
}
