package speedTyper.domain;

import java.util.Date;

public class scores {
	private int paragraphID;
	private String userName;
	private Date dateCompleted;
	private int completionTime;
	private int difficulty;
	
	public scores(int paragraphID, String userName, Date dateCompleted, int completionTime, int difficulty){
		this.paragraphID = paragraphID;
		this.userName = userName;
		this.dateCompleted = dateCompleted;
		this.completionTime = completionTime;
		this.difficulty = difficulty;
	}
	
	
	public int getParagraphID() {
		return paragraphID;
	}
	public void setParagraphID(int paragraphID) {
		this.paragraphID = paragraphID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	public int getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(int completionTime) {
		this.completionTime = completionTime;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	
}
