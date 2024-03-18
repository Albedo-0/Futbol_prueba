package programas;

//Main.java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
 private static ArrayList<Equipo> equipos = new ArrayList<>();
 private static Scanner scanner = new Scanner(System.in);

 public static void main(String[] args) {
     while (true) {
         mostrarMenu();
         int opcion = scanner.nextInt();
         scanner.nextLine(); // Consumir el salto de línea

         switch (opcion) {
             case 1:
                 darAltaEquipo();
                 System.out.println("Equipo creado correctamente");
                 break;
             case 2:
                 darAltaJugador();
                 System.out.println("jugador creado");
                 break;
             case 3:
                 mostrarJugadoresPorEquipo();
                 break;
             case 4:
                 marcarMejorJugador();
                 break;
             case 5:
                 agregarKilometrosRecorridos();
                 break;
             case 6:
                 listarJugadoresFederados();
                 break;
             case 0:
                 System.out.println("Saliendo del programa...");
                 return;
             default:
                 System.out.println("Opción no válida, por favor seleccione otra.");
                 break;
         }
     }
 }

 private static void mostrarMenu() {
     System.out.println("Menú:");
     System.out.println("1. Dar de alta equipo");
     System.out.println("2. Dar de alta jugador");
     System.out.println("3. Mostrar jugadores por equipo");
     System.out.println("4. Marcar mejor jugador");
     System.out.println("5. Añadir km recorridos al jugador");
     System.out.println("6. Listar jugadores federados");
     System.out.println("0. Salir");
     System.out.println("Seleccione una opción:");
 }

 private static void darAltaEquipo() {
     System.out.println("Ingrese el nombre del equipo:");
     String nombre = scanner.nextLine();
     System.out.println("Ingrese la división del equipo (1, 2 o 3):");
     String division = scanner.nextLine();
     equipos.add(new Equipo(nombre, division));
     System.out.println("Equipo creado exitosamente.");
 }

 private static void darAltaJugador() {
     System.out.println("Ingrese el nombre del equipo al que pertenece el jugador:");
     String nombreEquipo = scanner.nextLine();
     Equipo equipo = buscarEquipo(nombreEquipo);
     if (equipo == null) {
         System.out.println("El equipo no existe.");
         return;
     }
     System.out.println("Ingrese el nombre del jugador:");
     String nombre = scanner.nextLine();
     System.out.println("Ingrese el apellido del jugador:");
     String apellido = scanner.nextLine();
     System.out.println("Ingrese el dorsal del jugador:");
     int dorsal = scanner.nextInt();
     scanner.nextLine(); // Consumir el salto de línea
     equipo.agregarJugador(new Jugador(nombre, apellido, dorsal));
     System.out.println("Jugador agregado exitosamente.");
 }

 private static void mostrarJugadoresPorEquipo() {
     System.out.println("Equipos disponibles:");
     for (Equipo equipo : equipos) {
         System.out.println("- " + equipo.getNombre());
     }
     System.out.println("Ingrese el nombre del equipo:");
     String nombreEquipo = scanner.nextLine();
     Equipo equipo = buscarEquipo(nombreEquipo);
     if (equipo == null) {
         System.out.println("El equipo no existe.");
         return;
     }
     System.out.println("Jugadores del equipo " + equipo.getNombre() + ":");
     for (Jugador jugador : equipo.getJugadores()) {
         System.out.println("- " + jugador.getNombre() + " " + jugador.getApellido());
     }
 }


 private static void marcarMejorJugador() {
	    System.out.println("Equipos disponibles:");
	    listarEquipos();
	    System.out.print("Elija un equipo: ");
	    String nombreEquipo = scanner.nextLine();

	    Equipo equipo = buscarEquipo(nombreEquipo);
	    if (equipo != null) {
	        System.out.println("Jugadores del equipo " + nombreEquipo + ":");
	        for (Jugador jugador : equipo.getJugadores()) {
	            System.out.println(jugador.getNombre() + " " + jugador.getApellido() + " - Dorsal: " + jugador.getDorsal());
	        }

	        System.out.print("Ingrese el dorsal del jugador que fue mejor del partido: ");
	        int dorsalMejorJugador = scanner.nextInt();
	        scanner.nextLine(); // Consumir el salto de línea

	        for (Jugador jugador : equipo.getJugadores()) {
	            if (jugador.getDorsal() == dorsalMejorJugador) {
	                jugador.setVecesMejorJugador(jugador.getVecesMejorJugador() + 1);
	                System.out.println("Jugador marcado como mejor del partido.");
	                return;
	            }
	        }
	        System.out.println("No se encontró ningún jugador con el dorsal especificado.");
	    } else {
	        System.out.println("Equipo no encontrado.");
	    }
	}

	private static void agregarKilometrosRecorridos() {
	    System.out.println("Equipos disponibles:");
	    listarEquipos();
	    System.out.print("Elija un equipo: ");
	    String nombreEquipo = scanner.nextLine();

	    Equipo equipo = buscarEquipo(nombreEquipo);
	    if (equipo != null) {
	        System.out.println("Jugadores del equipo " + nombreEquipo + ":");
	        for (Jugador jugador : equipo.getJugadores()) {
	            System.out.println(jugador.getNombre() + " " + jugador.getApellido() + " - Dorsal: " + jugador.getDorsal());
	        }

	        System.out.print("Ingrese el dorsal del jugador al que desea agregar los kilómetros recorridos: ");
	        int dorsalJugador = scanner.nextInt();
	        scanner.nextLine(); // Consumir el salto de línea

	        System.out.print("Ingrese el número de kilómetros recorridos por el jugador en el último partido: ");
	        double kmRecorridos = scanner.nextDouble();
	        scanner.nextLine(); // Consumir el salto de línea

	        for (Jugador jugador : equipo.getJugadores()) {
	            if (jugador.getDorsal() == dorsalJugador) {
	                jugador.agregarKilometrosRecorridos(kmRecorridos);
	                System.out.println("Kilómetros recorridos agregados correctamente.");
	                return;
	            }
	        }
	        System.out.println("No se encontró ningún jugador con el dorsal especificado.");
	    } else {
	        System.out.println("Equipo no encontrado.");
	    }
	}


	private static void listarJugadoresFederados() {
	    // Implementar lógica para listar jugadores federados
	    System.out.println("Listado de jugadores federados:");
	    System.out.println("Equipo | Nombre Apellido | Media km/partido | Veces mejor jugador");
	    for (Equipo equipo : equipos) {
	        for (Jugador jugador : equipo.getJugadores()) {
	            System.out.printf("%s     | %s %s           | %.2f             | %d\n", equipo.getNombre(), jugador.getNombre(), jugador.getApellido(),
	                    jugador.calcularMediaKmPorPartido(), jugador.getVecesMejorJugador());
	        }
	    }
	}

 
 
	private static void listarEquipos() {
	    System.out.println("Equipos disponibles:");
	    for (Equipo equipo : equipos) {
	        System.out.println("- " + equipo.getNombre());
	    }
	}


 private static Equipo buscarEquipo(String nombreEquipo) {
     for (Equipo equipo : equipos) {
         if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
             return equipo;
         }
     }
     return null;
 }
}

