package mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class CoordinatesTest {

	
	
	@Test
	public void coordinatesWithNullIsZeroZero(){
		Coordinates coordinates = new Coordinates();
		assertEquals(0, coordinates.getX());
		assertEquals(0, coordinates.getY());
	}
	@Test
	public void coordinatesWithValues(){
		Coordinates coordinates = new Coordinates(5, 9);
		assertEquals(5, coordinates.getX());
		assertEquals(9, coordinates.getY());
	}
	@Test
	public void equalsCoordinatesWithNull(){
		Coordinates coordinates = new Coordinates();
		assertNotEquals(null, coordinates);
		assertNotEquals(new Object(), coordinates);
		assertEquals(coordinates, coordinates);
	}
	@Test
	public void equalsCoordinatesWithTheSameValues(){
		Coordinates coordinates1 = new Coordinates(5, 9);
		Coordinates coordinates2 = new Coordinates(5, 9);
		assertEquals(coordinates1, coordinates2);
	}
	@Test
	public void notEqualsCoordinatesWithDifferentValues(){
		Coordinates coordinates1 = new Coordinates(5, 9);
		Coordinates coordinates2 = new Coordinates(9, 5);
		assertNotEquals(coordinates1, coordinates2);
		coordinates1 = new Coordinates(5, 9);
		coordinates2 = new Coordinates(5, 5);
		assertNotEquals(coordinates1, coordinates2);
	}
	
	@Test
	public void hashCodeCoordinates() {
		int expectedHashCode = 31 * ((31 * 1) + 5) + 5;
		Coordinates coordinates = new Coordinates(5, 5);
		assertEquals(expectedHashCode, coordinates.hashCode());
	}
	
	@Test
	public void isInferiorTo() {
		Coordinates coordinates1 = new Coordinates(5, 5);
		Coordinates coordinates2 = new Coordinates(2, 4);
		assertTrue(coordinates2.isInferiorTo(coordinates1));
		assertFalse(coordinates1.isInferiorTo(coordinates2));
		assertTrue(coordinates1.isInferiorTo(coordinates1));
	}
	@Test
	public void isNotInferiorTo() {
		Coordinates coordinates1 = new Coordinates();
		Coordinates coordinates2 = new Coordinates();
		assertTrue(coordinates2.isInferiorTo(coordinates1));
	}
}
