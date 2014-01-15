/**
 * 
 */
package mowitnow;

import java.io.FileNotFoundException;

import mowitnow.MowItNow;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author houbeb
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class MowItNowTest {


	@Test
	public void entryMowItNowShouldFailIfFileIsInvalid() {
		try {
			new MowItNow("invalid.txt");
			Assert.fail("Should throw a FileNotFoundException");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e.getCause() instanceof FileNotFoundException);
		}
	}

	@Test
	public void orientationIsInvalid() {
		MowItNow mowItNow = new MowItNow("test/mowitnow/mowItNowIncoherent.txt");
		Assert.assertEquals("1 2 N\n", mowItNow.run());
	}

	@Test
	public void mowItNow() {
		MowItNow mowItNow = new MowItNow("test/mowitnow/mowItNow.txt");
		Assert.assertEquals("1 3 N\n5 1 E\n", mowItNow.run());
	}

	@Test
	public void mowItNowOutside() {
		MowItNow mowItNow = new MowItNow("test/mowitnow/mowItNowOutside.txt");
		Assert.assertEquals("", mowItNow.run());
	}

	@Test
	public void mowItNowWithCollision() {
		MowItNow mowItNow = new MowItNow(
				"test/mowitnow/mowItNowWithCollision.txt");
		Assert.assertEquals("1 3 N\n1 2 N\n", mowItNow.run());
	}

	@Test
	public void mowItNowWithRejection() {
		MowItNow mowItNow = new MowItNow(
				"test/mowitnow/mowItNowWithRejection.txt");
		Assert.assertEquals("1 3 N\n1 2 N\n1 2 N\n", mowItNow.run());
	}

}
