package mowitnow;

public class RejectionException extends RuntimeException {

	/**
	 * Thrown to indicate that a {@link LawnMower} has been positioned with an illegal position. 
	 * Or the position is already taken by another LawnMower.
	 * @param coordinates
	 */
	public RejectionException(Coordinates coordinates) {
		super("Invalid position given." + coordinates.getX() + " "+ coordinates.getY() + " is already taken");
	}

}
