package mowitnow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class OrientedCoordinatesTest {

	@Test(expected = NullPointerException.class)
	public void orientedCorrdinatesWithNullCoordinates() {
		new OrientedCoordinates(null, Orientation.E);
	}
	
	@Test
	public void orientedCoordinatesWithGivenXYAndOrientation() {
		int x = 5;
		int y = 6;
		OrientedCoordinates orientedCoordinates = new OrientedCoordinates(x, y, Orientation.N);
		assertEquals(x, orientedCoordinates.getX());
		assertEquals(y, orientedCoordinates.getY());
		assertEquals(Orientation.N, orientedCoordinates.getOrientation());
	}
	
	@Test
	public void orientedCoordinatesWithGivenCoordinatesAndOrientation() {
		Coordinates coordinates = new Coordinates();
		OrientedCoordinates orientedCoordinates = new OrientedCoordinates(coordinates, Orientation.N);
		assertEquals(coordinates.getX(), orientedCoordinates.getX());
		assertEquals(coordinates.getY(), orientedCoordinates.getY());
		assertEquals(Orientation.N, orientedCoordinates.getOrientation());
	}
}
