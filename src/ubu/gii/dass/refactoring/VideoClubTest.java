package ubu.gii.dass.refactoring;
import junit.framework.*;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones
 * gen�ricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1

 * 
 */
public class VideoClubTest extends TestCase {
	protected Movie m0, m11, m12, m2;
	protected Customer c1;

	protected void setUp() {
		m11 = new Movie("Sky Captain", 1);
		m12 = new Movie("Alejandro Magno", 1);
		m0 = new Movie("Accion Mutante", 0);
		m2 = new Movie("Hermano Oso", 2);

		c1 = new Customer("Manuel");
	}


	public static Test suite() {

		return new TestSuite(VideoClubTest.class);
	}

	public void testAlquiler() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);

		String salida = c1.statement();

		String salidaEsperada = new String("Rental Record for Manuel\n"
				+ "\tSky Captain\t15.0\n" + "\tAccion Mutante\t2.0\n"
				+ "\tHermano Oso\t12.0\n" + "Amount owed is 29.0\n"
				+ "You earned 4 frequent renter points");

		assertTrue("Calcula mal el alquiler", salidaEsperada.equals(salida));

	}
	
	public void testAlquilerHTML() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);

		String salida = c1.HTMLstatement();

		String salidaEsperada = new String("<h1>Rental Record for Manuel</h1>\n"
				+ "<h2>Sky Captain 15.0</h2>\n" + "<h2>Accion Mutante 2.0</h2>\n"
				+ "<h2>Hermano Oso 12.0</h2>\n" + "<p>Amount owed is 29.0</p>\n"
				+ "<p>You earned 4 frequent renter points</p>");

		assertTrue("Calcula mal el alquiler", salidaEsperada.equals(salida));

	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}