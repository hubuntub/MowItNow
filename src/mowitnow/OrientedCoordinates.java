package mowitnow;

public class OrientedCoordinates extends Coordinates {
	private Orientation orientation = Orientation.N;

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public OrientedCoordinates(int x, int y, Orientation orientation) {
		super(x, y);
		this.setOrientation(orientation);
	}
	public OrientedCoordinates(Coordinates coordinates, Orientation orientation) {
		super(coordinates.getX(), coordinates.getY());
		this.setOrientation(orientation);
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return x + " " + y + " " + orientation;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((orientation == null) ? 0 : orientation.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	

}
