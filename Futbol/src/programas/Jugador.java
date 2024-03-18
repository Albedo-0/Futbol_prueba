package programas;
/**
 * contiene los datos de cada jugador
 */
public class Jugador {
 private String nombre;
 private String apellido;
 private int dorsal;
 private int vecesMejorJugador;
 private double kmRecorridos;
 private int partidosJugados;

 /**
	 * al generarse un jugador, solo pedira su nombre,apellido y dorsal
	 * @param nombre
	 * @param apellido
	 * @param dorsal
	 */
 public Jugador(String nombre, String apellido, int dorsal) {
     this.nombre = nombre;
     this.apellido = apellido;
     this.dorsal = dorsal;
     this.vecesMejorJugador = 0;
     this.kmRecorridos = 0;
     this.partidosJugados = 0;
 }

 public String getNombre() {
     return nombre;
 }

 public String getApellido() {
     return apellido;
 }

 public int getDorsal() {
     return dorsal;
 }

 public int getVecesMejorJugador() {
     return vecesMejorJugador;
 }

 public void setVecesMejorJugador(int vecesMejorJugador) {
     this.vecesMejorJugador = vecesMejorJugador;
 }

 public double getKmRecorridos() {
     return kmRecorridos;
 }


	/**
	 * cada vez que añadamos km, significará que ha participado en un partido
	 * @param km
	 */
 public void agregarKilometrosRecorridos(double km) {
     kmRecorridos += km;
     partidosJugados++;
 }

 /**
	 * usamos la variable media que no colocamos en el contructor
	 * para calcular la media
	 * @return
	 */
 public double calcularMediaKmPorPartido() {
     if (partidosJugados == 0) return 0;
     return kmRecorridos / partidosJugados;
 }
}
