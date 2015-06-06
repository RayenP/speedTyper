package speedTyper.bo;

import java.util.Date;

import speedTyper.domain.scores;
import speedTyper.dao.scoresDAO;

public class scoresBO {
	scoresDAO sd;
	
	public scoresBO(){
		this.sd = new scoresDAO();
	}
	
	//get array of all scores
	public scores[] getAllScores(){
		return sd.retrieveScores();
	}
	
	
	//add new score
	public void addScore(int paragraghID, String user, int CompletionTime, int difficulty){
		scores newScore = new scores(paragraghID, user, new Date(),CompletionTime, difficulty);
		
		sd.insertScore(newScore);
	}
}
