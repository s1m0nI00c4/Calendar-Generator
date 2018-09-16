
public class Match {
	
	public Team firstTeam;
	public Team secondTeam;
	private boolean homeAndAway;
	
	public Match (Team firstTeam, Team secondTeam) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.homeAndAway = true;
	}
	
	public Match(Team firstTeam, Team secondTeam, boolean homeAndAway) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.homeAndAway = homeAndAway;
	}
	
	public void reverse() {
		Team temp = firstTeam;
		firstTeam = secondTeam;
		secondTeam = temp;
	}
	
	public String toString() {
		String result = firstTeam + " - " + secondTeam;
		return result;
	}
	
	// test methods
	
	/*public static void main(String[] args) {
		Match m = new Match(new Team("Inter"), new Team("Juventus"));
		System.out.println(m);
		m.reverse();
		System.out.println(m);
	}*/

}
