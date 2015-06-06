package speedTyper.dao;

import speedTyper.domain.paragraph;

public class paragraphDAO {
	
	//get paragraph
	public paragraph retrieveParagraph(int difficulty) {
		paragraph  para = new paragraph(1, "This is a new paragraph", 1, 20);
		
		return para;
	}
	//add paragraph
	public void insertParagraph(paragraph newParagraph) {
		System.out.println("New paragraph has been added!!");
	}
	
}
