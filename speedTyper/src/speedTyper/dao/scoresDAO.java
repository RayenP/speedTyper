package speedTyper.dao;

import java.util.Date;

import speedTyper.domain.scores;

public class scoresDAO {
	//get scores array
	public scores[] retrieveScores(){
		scores[] scoresArray = new scores[5];
		
		Date d1 = new Date();
		scoresArray[0] = new scores(1,"Rayen", d1, 50, 1);
		scoresArray[1] = new scores(1,"Kayla", d1, 34, 1);
		scoresArray[2] = new scores(1,"Test", d1, 67, 1);
		scoresArray[3] = new scores(2,"Rayen", d1, 11, 2);
		scoresArray[4] = new scores(2,"Kayla", d1, 3, 2);
		
		return scoresArray;
	}
	
	//add new score
	public void insertScore(scores newScore){
		System.out.println("Score added correctly");
	}
}
