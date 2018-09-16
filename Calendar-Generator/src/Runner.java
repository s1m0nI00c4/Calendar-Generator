import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
	
	public static final int TEAM_NR = 20;

	public static void main(String[] args) {
		
		int home = 0;
		int h;
		
		File teamFile = new File("teams.txt");
		Team[] teamArray = new Team[TEAM_NR];
		try(Scanner scan = new Scanner(teamFile)) {
			scan.useDelimiter(";");
			for (int i = 0; i < TEAM_NR; i++) {
				Team t = new Team(scan.next());
				teamArray[i] = t;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		/*for (Team t : teamArray) {
			System.out.println(t.getName());
		}*/
		
		Turn[] turnArray = new Turn[TEAM_NR-1];
		for (int i = 0; i < turnArray.length; i++) {
			Match[] m = new Match[TEAM_NR/2];
			h = home;
			for (int e = 0; e < m.length; e++) {
				Match ma;
				if (e == 0) {
					ma = new Match (teamArray[i], teamArray[TEAM_NR-1]);
					if (i%2 == 0)												// this clause grants interleaving
						ma.reverse();
					home++;
					h++;
				}
				else {
					int temp = (h+((m.length-e)*2-1))%(TEAM_NR-1);
					ma = new Match (teamArray[h], teamArray[temp]);
					if ((i % 2 == 0) && (e % 2 == 0))							// this clause grants interleaving
						ma.reverse();
					h++;
					h = h % (TEAM_NR-1);
				}
				m[e] = ma;
			}
			Turn t = new Turn(m);
			t.shuffle();														// this shuffles matches within the same turn
			turnArray[i] = t;
		}
		
		for (Turn t : turnArray) {
			for (Match m : t.matchArray) {
				System.out.println(m.firstTeam.toString() + " - " + m.secondTeam.toString());
			}
			System.out.println("\n---\n");
		}
		

	}

}
