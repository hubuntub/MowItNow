package mowitnow;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class OrientationTest {

	@Test
	public void nextOrientation() {
		Orientation orientationNorth = Orientation.N;
		assertEquals(Orientation.E, orientationNorth.getNext());

		assertEquals(Orientation.S, orientationNorth.getNext().getNext());

		assertEquals(Orientation.W, orientationNorth.getNext().getNext()
				.getNext());

		assertEquals(Orientation.N, orientationNorth.getNext().getNext()
				.getNext().getNext());
	}

	@Test
	public void previousOrientation() {
		Orientation orientationNorth = Orientation.N;
		assertEquals(Orientation.W, orientationNorth.getPrevious());

		assertEquals(Orientation.S, orientationNorth.getPrevious()
				.getPrevious());

		assertEquals(Orientation.E, orientationNorth.getPrevious()
				.getPrevious().getPrevious());

		assertEquals(Orientation.N, orientationNorth.getPrevious()
				.getPrevious().getPrevious().getPrevious());
	}
	@Test
	public void followingXOrientation() {
		assertEquals(0, Orientation.N.getFollowingX());

		assertEquals(-1, Orientation.W.getFollowingX());

		assertEquals(0, Orientation.S.getFollowingX());

		assertEquals(1, Orientation.E.getFollowingX());
	}

	@Test
	public void followingYOrientation() {
		assertEquals(0, Orientation.W.getFollowingY());

		assertEquals(-1, Orientation.S.getFollowingY());

		assertEquals(0, Orientation.E.getFollowingY());

		assertEquals(1, Orientation.N.getFollowingY());
	}
}
