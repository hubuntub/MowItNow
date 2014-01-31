package mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class MowerParserTest {
	@Test
	public void testMowerParserShouldFailIfFileIsInvalid() {
		try {
			new MowerParser("invalid.txt");
			Assert.fail("Should throw a FileNotFoundException");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e.getCause() instanceof FileNotFoundException);
		}
	}
	
	@Test
	public void testMowerParserShouldWorkIfFileExists() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		assertNotNull(mowerParser);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getIntegerByIndexWithEmptyString() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		mowerParser.getIntegerByIndex("", 1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void getIntegerByIndexWithInvalidIndex() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		mowerParser.getIntegerByIndex("A", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getIntegerByIndexWithNonIntegerValues() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		mowerParser.getIntegerByIndex("A B 2", 1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void getIntegerByIndexWith() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		mowerParser.getIntegerByIndex("1  2", 1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void getIntegerByIndexWithNegativeValues() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		mowerParser.getIntegerByIndex("1 -2", 1);
	}
	
	@Test
	public void getIntegerByIndexWithValidInteger() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		int actual1 = mowerParser.getIntegerByIndex("1 2", 0);
		int actual2 = mowerParser.getIntegerByIndex("1 2", 1);
		assertEquals(1, actual1);
		assertEquals(2, actual2);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void getOrientationByIndexWithNotAllowedCharacter() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		mowerParser.getOrientationByIndex("1 2 A", 2);
	}
	@Test
	public void getOrientationByIndexWithValidCharacter() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		Orientation actual = mowerParser.getOrientationByIndex("1 2 N", 2);
		assertEquals(Orientation.N, actual);
	}


	@Test
	public void getCoordinatesIsNull() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		Coordinates coordinates = mowerParser.getCoordinates("1252");
		assertNull(coordinates);
	}
	@Test
	public void getCoordinatesIsNotNull() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		Coordinates coordinates = mowerParser.getCoordinates("1 2");
		assertNotNull(coordinates);
		assertEquals(1, coordinates.getX());
		assertEquals(2, coordinates.getY());
	}
	@Test
	public void getOrientedCoordinatesIsNull() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		OrientedCoordinates coordinates = mowerParser.getOrientedCoordinates("1 2");
		assertNull(coordinates);
	}
	@Test
	public void getOrientedCoordinatesIsNotNull() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowIncoherent.txt");
		OrientedCoordinates coordinates = mowerParser.getOrientedCoordinates("1 2 N");
		assertNotNull(coordinates);
		assertEquals(1, coordinates.getX());
		assertEquals(2, coordinates.getY());
		assertEquals(Orientation.N, coordinates.getOrientation());
	}
	@Test
	public void getMowersIsEmpty() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNowEmpty.txt");
		Map<LawnMower, String> mowers = mowerParser.getMowers();
		assertNotNull(mowers);
		assertTrue(mowers.keySet().isEmpty());
	}
	@Test
	public void getMowersIsNotEmpty() {
		MowerParser mowerParser = new MowerParser("src/test/resources/mowItNow.txt");
		
		Coordinates coordinatesGrid = new Coordinates(5, 5);
		OrientedCoordinates coordinates1 = new OrientedCoordinates(new Coordinates(1, 2), Orientation.N);
		String commands1 = "GAGAGAGAA";
		LawnMower lawnMower1 = new LawnMower(coordinates1, coordinatesGrid);
		Map<LawnMower, String> mowers = mowerParser.getMowers();
		assertEquals(2, mowers.size());
		assertTrue(mowers.containsKey(lawnMower1));
		assertEquals(commands1, mowers.get(lawnMower1));
	}
	
}
