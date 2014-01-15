package mowitnow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class MowItNow {
protected static final String FAILURE = "Bad usage of the program.Usage : java MowItNow <input-file>";
	
	private MowerParser mowerParser;

	public MowItNow(String filename) {
		this.mowerParser = new MowerParser(filename);
	}

	public static void main(String[] args) {
		if (args.length == 1) {
			String filename = args[0];
			MowItNow mowItNow = new MowItNow(filename);
			System.out.println(mowItNow.run());
		} else {
			System.err.println(FAILURE);
		}
	}

	public String run() {
		StringBuffer sb = new StringBuffer();
		Map<LawnMower, String> resultParsing = mowerParser.getMowers();
		List<Coordinates> takenPositions = new ArrayList<>();
		for(Entry<LawnMower, String> entry : resultParsing.entrySet()){
			LawnMower lawnMower = entry.getKey();
			try {
				checkTakenPosition(takenPositions, lawnMower.getCoordinates());
				String commands = entry.getValue();
				lawnMower.run(commands, takenPositions );
				takenPositions.add(lawnMower.getCoordinates());
			} catch (RejectionException e){
				
			}
			
			sb.append(lawnMower + "\n");
		}
		
		return sb.toString();
	}
	protected void checkTakenPosition(List<Coordinates> takenPositions,
			Coordinates coordinates) {
		if (takenPositions.contains(coordinates)) {
			throw new RejectionException(coordinates);
		}
	}	
	

}
