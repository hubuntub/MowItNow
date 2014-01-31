/**
 * 
 */
package mowitnow;

import java.util.List;

/**
 * @author houbeb
 * 
 */
public class LawnMower {

	private OrientedCoordinates coordinates;
	private Coordinates coordinatesGrid;

	public LawnMower(OrientedCoordinates coordinates,
			Coordinates coordinatesGrid) {
		this.coordinates = coordinates;
		this.coordinatesGrid = coordinatesGrid;
	}

	/**
	 * executes the commands given as directions to the lanmawer
	 * 
	 * @param commands
	 *            the sequence of characters A, G, D
	 * @param takenPositions
	 *            the coordinates already taken in the grid
	 */
	public void run(String commands, List<Coordinates> takenPositions) {
		for (char caractere : commands.toCharArray()) {
			if (caractere != 'A') {
				changeOrientation(caractere);
			} else {
				move(takenPositions);
			}
		}
	}

	/**
	 * changes the orientation given the last orientation
	 * 
	 * @param sens
	 */
	protected void changeOrientation(char sens) {
		Orientation orientation = coordinates.getOrientation();
		switch (sens) {
		case 'G':
			coordinates.setOrientation(orientation.getPrevious());
			break;
		case 'D':
			coordinates.setOrientation(orientation.getNext());
			break;
		}
	}

	/**
	 * moves to another position given the orientation that is already set
	 * 
	 * @param takenPositions
	 */
	protected void move(List<Coordinates> takenPositions) {
		Coordinates c = getEventualCoordinates();
		if (c.isInferiorTo(coordinatesGrid) && !takenPositions.contains(c)) {
			this.coordinates = new OrientedCoordinates(c, getOrientation());
		}
	}

	/**
	 * @return the coordinates
	 */
	public OrientedCoordinates getCoordinates() {
		return coordinates;
	}

	protected Coordinates getEventualCoordinates() {
		Coordinates newCoordinates = new Coordinates(coordinates.getX()
				+ getOrientation().getFollowingX(), coordinates.getY()
				+ getOrientation().getFollowingY());
		return newCoordinates;
		
	}

	public Orientation getOrientation() {
		return coordinates.getOrientation();
	}

	@Override
	public String toString() {
		return coordinates.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinates == null) ? 0 : coordinates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LawnMower))
			return false;
		LawnMower other = (LawnMower) obj;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		return true;
	}

}
