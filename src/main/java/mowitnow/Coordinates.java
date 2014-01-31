/**
 * 
 */
package mowitnow;

/**
 * @author BEN OTHMENE HOUBEB
 * 
 */
public class Coordinates {
	protected int x;
	protected int y;

	public Coordinates(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public Coordinates() {

	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Coordinates))
			return false;
		Coordinates other = (Coordinates) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	/**
	 * Checks whether the current coordinates are not beyond the grid defined by (0, 0) and CoordinatesGrid
	 * @param coordinatesGrid
	 * @return
	 */
	public boolean isInferiorTo(Coordinates coordinatesGrid) {

		return (x >= 0 && y >= 0)
				&& (x <= coordinatesGrid.getX() && y <= coordinatesGrid.getY());
	}

}
