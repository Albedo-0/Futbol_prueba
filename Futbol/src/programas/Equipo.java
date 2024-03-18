package programas;

/**
 * contiene la informacion de cada equipo
 */
import java.util.ArrayList;

public class Equipo {
 private String nombre;
 private String division;
 private ArrayList<Jugador> jugadores;

 /**
	 * al generar un equipo sólo nos piden su nombre y dividion
	 * @param nombre
	 * @param division
	 */
 public Equipo(String nombre, String division) {
     this.nombre = nombre;
     this.division = division;
     this.jugadores = new ArrayList<>();
 }

 public String getNombre() {
     return nombre;
 }

 public String getDivision() {
     return division;
 }

 public ArrayList<Jugador> getJugadores() {
     return jugadores;
 }
 /**
	 * usado para añadir jugadores a un equipo
	 * @param jugador
	 */
 public void agregarJugador(Jugador jugador) {
     jugadores.add(jugador);
 }

 
}
