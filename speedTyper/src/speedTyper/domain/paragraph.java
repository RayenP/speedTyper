package speedTyper.domain;

public class paragraph {
	private int paragraphID;
	private String paragraphText;
	private int difficulty;
	private int highestTime;
	
	public paragraph(int paragraphID, String paragraphText, int difficulty, int highestTime){
		this.paragraphID = paragraphID;
		this.paragraphText = paragraphText;
		this.difficulty = difficulty;
		this.highestTime = highestTime;
	}
	
	public int getParagraphID() {
		return paragraphID;
	}
	public void setParagraphID(int paragraphID) {
		this.paragraphID = paragraphID;
	}
	public String getParagraphText() {
		return paragraphText;
	}
	public void setParagraphText(String paragraphText) {
		this.paragraphText = paragraphText;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getHighestTime() {
		return highestTime;
	}
	public void setHighestTime(int highestTime) {
		this.highestTime = highestTime;
	}
}
