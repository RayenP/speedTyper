package speedTyper.bo;

import speedTyper.dao.paragraphDAO;
import speedTyper.domain.paragraph;
import speedTyper.exceptions.paragraphTooLongException;

public class paragraphBO {
	paragraph newParagraph;
	paragraphDAO pd;
	
	public paragraphBO(){
		pd = new paragraphDAO();
	}
	
	//get paragraph
	public paragraph getParagraph(int difficulty){
		return pd.retrieveParagraph(difficulty);
	}
	
	//add paragraph
	public void addNewParagraph(String paragraphText) throws paragraphTooLongException{
		int difficulty = 0;
		String[] words = paragraphText.split(" ");
		
		if(words.length < 10){
			difficulty = 1;
		}
		else if(words.length < 20){
			difficulty = 2;
		}
		else if(words.length < 30){
			difficulty = 3;
		}
		else{
			throw new paragraphTooLongException();
		}
		
		newParagraph = new paragraph(0, paragraphText, difficulty, 0);
		pd.insertParagraph(newParagraph);
	}
}
