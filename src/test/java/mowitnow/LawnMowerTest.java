package mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class LawnMowerTest {
	@Test
	public void runWithNoValidCommands() {
		Coordinates coordinates = new Coordinates(2, 3);
		Coordinates coordinatesGrid = new Coordinates(5, 5);
		LawnMower lawnMower = new LawnMower(new OrientedCoordinates(
				coordinates, Orientation.N), coordinatesGrid);
		lawnMower.run("FFZQQ", new ArrayList<Coordinates>());
		assertEquals(coordinates, lawnMower.getCoordinates());
	}
	@Test
	public void changeOrientationWithValidChar() {
		Coordinates coordinates = new Coordinates(2, 3);
		Coordinates coordinatesGrid = new Coordinates(5, 5);
		LawnMower lawnMower = new LawnMower(new OrientedCoordinates(
				coordinates, Orientation.N), coordinatesGrid);
		lawnMower.changeOrientation('G');
		assertEquals(Orientation.W, lawnMower.getOrientation());
		lawnMower.changeOrientation('D');
		assertEquals(Orientation.N, lawnMower.getOrientation());
	}
	@Test
	public void changeOrientationWithIgonoringInvalidChar() {
		Coordinates coordinates = new Coordinates(2, 3);
		Coordinates coordinatesGrid = new Coordinates(5, 5);
		LawnMower lawnMower = new LawnMower(new OrientedCoordinates(
				coordinates, Orientation.N), coordinatesGrid);
		lawnMower.changeOrientation('Z');
		assertEquals(Orientation.N, lawnMower.getOrientation());
	}

	@Test
	public void toStringLawnMower() {
		Coordinates coordinates = new Coordinates(2, 3);
		Coordinates coordinatesGrid = new Coordinates(5, 5);
		LawnMower lawnMower = new LawnMower(new OrientedCoordinates(
				coordinates, Orientation.N), coordinatesGrid);
		assertEquals("2 3 N", lawnMower.toString());
		assertNotEquals("2 3 S", lawnMower.toString());
	}
	@Test
	public void getEventualCoordinates() {
		Coordinates coordinates = new Coordinates(2, 3);
		Coordinates coordinatesGrid = new Coordinates(5, 5);
		LawnMower lawnMower = new LawnMower(new OrientedCoordinates(
				coordinates, Orientation.N), coordinatesGrid);
		assertEquals(new Coordinates(2, 4), lawnMower.getEventualCoordinates());
	}
	@Test
	public void moveLawnMower() {
		Coordinates coordinates = new Coordinates(2, 3);
		OrientedCoordinates orientedCoordinates = new OrientedCoordinates(
				coordinates, Orientation.N);
		OrientedCoordinates orientedCoordinatesExpected = new OrientedCoordinates(
				new Coordinates(2, 4), Orientation.N);
		Coordinates coordinatesGrid = new Coordinates(5, 5);
		LawnMower lawnMower = new LawnMower(orientedCoordinates, coordinatesGrid);
		lawnMower.move(new ArrayList<Coordinates>());
		assertEquals(orientedCoordinatesExpected, lawnMower.getCoordinates());
	}
	@Test
	public void changeOrientationAndMove() {
		OrientedCoordinates orientedCoordinatesExpected = new OrientedCoordinates(
				new Coordinates(3, 3), Orientation.E);
		Coordinates coordinates = new Coordinates(2, 3);
		Coordinates coordinatesGrid = new Coordinates(5, 5);
		LawnMower lawnMower = new LawnMower(new OrientedCoordinates(
				coordinates, Orientation.N), coordinatesGrid);
		String commands = "DA";
		lawnMower.run(commands, new ArrayList<Coordinates>());
		assertEquals(orientedCoordinatesExpected, lawnMower.getCoordinates());
	}
	@Test
	public void equalsLawnMower(){
		Coordinates coordinatesGrid = new Coordinates();
		Coordinates coordinates = new Coordinates();
		OrientedCoordinates orientedCoordinates = new OrientedCoordinates(coordinates, Orientation.N);
		LawnMower lawnMower = new LawnMower(orientedCoordinates, coordinatesGrid);
		assertNotEquals(null, lawnMower);
		assertNotEquals(new Object(), lawnMower);
	}
	@Test
	public void lawnMowerWithCoordinates(){
		Coordinates coordinatesGrid = new Coordinates();
		Coordinates coordinates = new Coordinates();
		OrientedCoordinates orientedCoordinates = new OrientedCoordinates(coordinates, Orientation.S);
		OrientedCoordinates otherOrientedCoordinates = new OrientedCoordinates(coordinates, Orientation.N);
		LawnMower lawnMower = new LawnMower(orientedCoordinates, coordinatesGrid);
		LawnMower otherLawnMower = new LawnMower(otherOrientedCoordinates, coordinatesGrid);
		assertEquals(lawnMower, otherLawnMower);
	}
	@Test
	public void equalsLawnMowerWithNullCoordinates(){
		Coordinates coordinatesGrid = new Coordinates();
		
		LawnMower lawnMower = new LawnMower(null, coordinatesGrid);
		LawnMower otherLawnMower = new LawnMower(null, coordinatesGrid);
		assertEquals(lawnMower, otherLawnMower);
	}
	
	
	@Test
	public void hashCodeLawnMower() {
		Coordinates coordinatesGrid = new Coordinates(10, 10);
		Coordinates coordinates = new Coordinates(5, 5);
		OrientedCoordinates orientedCoordinates = new OrientedCoordinates(coordinates, Orientation.S);
		LawnMower lawnMower = new LawnMower(orientedCoordinates, coordinatesGrid);
		int expectedHashCode = (31 * 1) + orientedCoordinates.hashCode();
		
		assertEquals(expectedHashCode, lawnMower.hashCode());
	}
}
