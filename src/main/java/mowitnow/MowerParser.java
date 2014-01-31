package mowitnow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MowerParser {
	private Scanner scanner;

	public MowerParser(String filename) {
		try {
			scanner = new Scanner(new FileReader(filename));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File cannot be found.", e);
		}
	}

	/**
	 * 
	 * @return
	 */
	public Map<LawnMower, String> getMowers() {
		Map<LawnMower, String> listMowers = new LinkedHashMap<>();
		Coordinates coordinatesGrid = getCoordinates(scanner.nextLine());

		while (scanner.hasNextLine()) {
			
			OrientedCoordinates coordinates = getOrientedCoordinates(scanner
					.nextLine());
			if (checkCoordinate(coordinates, coordinatesGrid)) {
				LawnMower lawnMower = new LawnMower(coordinates,
						coordinatesGrid);
				if (scanner.hasNext()) {
					String commands = scanner.nextLine();
					listMowers.put(lawnMower, commands);
				}
			}
		}
		return listMowers;

	}

	protected OrientedCoordinates getOrientedCoordinates(String nextLine) {
		OrientedCoordinates orientedCoordinates = null;
		Coordinates coordinates = getCoordinates(nextLine);
		try {
			Orientation orientation = getOrientationByIndex(nextLine, 2);
			orientedCoordinates = new OrientedCoordinates(coordinates,
					orientation);

		} catch (IllegalArgumentException e) {
			return null;
		}
		return orientedCoordinates;
	}

	protected Coordinates getCoordinates(String firstLine) {
		Coordinates coordinates = new Coordinates();
		try {
			coordinates.setX(getIntegerByIndex(firstLine, 0));
			coordinates.setY(getIntegerByIndex(firstLine, 1));

		} catch (IllegalArgumentException e) {
			return null;
		}
		return coordinates;
	}

	private boolean checkCoordinate(Coordinates coordinates,
			Coordinates coordinatesGrid) {
		if (coordinates != null && coordinatesGrid != null) {
		
			return coordinates.isInferiorTo(coordinatesGrid);
			
		}
		return false;
	}

	

	protected Orientation getOrientationByIndex(String str, int i) {
		String[] splits = str.split(" ");
		if (splits.length > i) {
			return Orientation.valueOf(splits[i]);
		}
		throw new IllegalArgumentException("Invalid orientation given.");
	}

	protected int getIntegerByIndex(String str, int i) {
		try {
			String[] splits = str.split(" ");
			if (splits.length > i) {
				int ret = Integer.valueOf(splits[i]);
				if (ret > 0) {
					return ret;
				}
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid coordinates given.", e);
		}
		throw new IllegalArgumentException("Invalid coordinates given.");
	}
}
