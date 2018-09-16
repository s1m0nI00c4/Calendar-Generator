import java.util.Random;

public class Turn {
	
	public Match[] matchArray;
	
	public Turn() {
		
	}
	
	public Turn(Match[] matchArr) {
		if (matchArr.length == Runner.TEAM_NR/2) {
			this.matchArray = matchArr;
		}
	}
	
	public void shuffle() {
		Random RANDOM = new Random();
		for (int i = matchArray.length - 1; i > 0 ; i--) {
			int e = RANDOM.nextInt(i+1);
			Match temp = matchArray[e];
			matchArray[e] = matchArray[i];
			matchArray[i] = temp;
		}
		
	}

}

