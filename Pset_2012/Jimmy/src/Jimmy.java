import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jimmy{
	
	public static void main(String[] args) throws FileNotFoundException{
		// avg num season pt / game with allows
		
		//input 1 - seasons to consider
		//2 - teams
		//stats
		
		Scanner input = new Scanner(new File("dummy.txt"));
		
		int seasons = Integer.parseInt(input.nextLine());
		
		int numTeams = Integer.parseInt(input.nextLine());
		ArrayList<int[]> teams = new ArrayList();
		
		for(int i = 0; i < numTeams; i++){
			String offense = input.next();
			String defense = input.next();
			int[] team = {Integer.parseInt(offense),Integer.parseInt(defense),i+1};
			teams.add(team);
			System.out.println(offense);
			System.out.println(defense);
		}
		
		for(int j = 0; j < seasons;j++){
			ArrayList<int[]> season_teams = (ArrayList<int[]>) teams.clone();
			int[][] margins = new int[(int)Math.log(numTeams)][];
			while(season_teams.size() != 1){
				for(int i = season_teams.size() - 1; i >= 1; i-=2){
					
					int margin = loser(season_teams.get(i),season_teams.get(i - 1));
					if(margin < 0)
						season_teams.remove(i);
					else
						season_teams.remove(i-1);
				}
			}
			
			System.out.println(season_teams.get(0)[2]);
		}	
		
		
		input.close();
	}
	
	public static int loser(int[] t1, int[] t2){
		int t1_score = (t1[0] + t2[1]) /2;
		int t2_score = (t2[0] + t1[1]) /2;
		return t1_score-t2_score;
	}
	
	 
}