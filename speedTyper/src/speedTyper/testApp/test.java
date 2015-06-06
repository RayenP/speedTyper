package speedTyper.testApp;

import java.io.*;

import speedTyper.domain.*;
import speedTyper.bo.*;
import speedTyper.exceptions.*;

public class test{
	static user currentUser;
	static paragraph currentParagraph;
	static scores userScore;
	static userBO uBO;
	static scoresBO sBO;
	static paragraphBO pBO;
	
  	public static void main(String[] args) {
  		uBO = new userBO();
  		sBO = new scoresBO();
  		pBO = new paragraphBO();
  		
		printOUT("********************************");
		printOUT("Welcome to the speed typing game");
		printOUT("********************************");
		startApp();
	}
	
	private static void printOUT(String message){

		System.out.println(message);
	}
	
	private static String readIN(){
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    return bufferRead.readLine();
		}
		catch(IOException e)
		{
			return "Error:" + e.toString();
		}
	}
	
	private static int readNumber(int max){
		String number = readIN();
		int num = 0;
		
		boolean valid = false;
		while (!valid) {
		    try {
		    	num = Integer.parseInt(number);
		        if (num > 0 && num <= max) {
		        	valid = true;
		        }
		        else
		        {
			        printOUT("Are you sure that " + num + " was one of the options?");
					printOUT("Please enter the correct number.");
		        	number = readIN();
		        }
		    } catch (NumberFormatException e) {
		        printOUT("Your sure thats a number?");
	        	number = readIN();
		    }
		}
		
		return num;
	}
		
	private static void startApp(){
		printOUT("Are you an existing player?");
		printOUT("1 = Yes");
		printOUT("2 = No");
		
		int ans = readNumber(2);
		
		printOUT("Please enter your name:");
		String name = readIN();
		
		switch(ans){
			case 1: checkExistingUser(name);
					break;
			case 2: addUser(name);
					break;
		}
		printOUT("");
		printOUT("");
		printOUT("Hello!! " + currentUser.getName());
		printOUT("");
		gameMenu();
	}
	
	private static void checkExistingUser(String name){
		if(!uBO.userExists(name)){
			printOUT("The name you provided does not exist, please try again");
			startApp();
		}
		else {
			currentUser = new user(name);
		}
	}
	
	private static void addUser(String name){
		try{
			uBO.addUser(name);
			currentUser = new user(name);
		}catch(alreadyExistsException e){
			printOUT(e.getMessage());
			startApp();
		}
	}

	private static void gameMenu(){
		printOUT("What would you like to do?");
		printOUT("1 = Start Game");
		printOUT("2 = View high scores");
		printOUT("3 = Add new paragraph");
		printOUT("4 = Change player");
		printOUT("5 = Exit");
		
		int ans = readNumber(5);
		
		switch(ans){
			case 1: playGame();
					break;
			case 2: viewScores();
					break;
			case 3: addParagraph();
					break;
			case 4: startApp();;
					break;
			case 5: printOUT("Ok well bye then, hope to see you soon");
					break;
		}
	}

	private static void playGame(){
		printOUT("Game Starting...");
		printOUT("");
		
		printOUT("What difficulty would you like to play?");
		printOUT("1 = Easy");
		printOUT("2 = Standard");
		printOUT("3 = Hard");
		int ans = readNumber(3);
		
		printOUT("Getting new paragraph");
		currentParagraph = pBO.getParagraph(ans);
		printOUT("The paragraph is:");
		printOUT(currentParagraph.getParagraphText());
		
		printOUT("");
		printOUT("Playing game...");
		printOUT("");
		
		printOUT("The game is now completed...");
		sBO.addScore(currentParagraph.getParagraphID(), currentUser.getName(), 30, currentParagraph.getDifficulty());
		printOUT("");
		printOUT("Would you like to play again?");
		printOUT("1 = Yes");
		printOUT("2 = No");		
		
		ans = readNumber(2);
		
		switch(ans){
			case 1: playGame();
					break;
			case 2: gameMenu();
					break;
		}
	}

	private static void viewScores(){
		sBO = new scoresBO();
		scores[] allScores = sBO.getAllScores();
		printOUT("*************************************");
		printOUT("Rank     Name     Time     Difficulty");
		for(int i = 0; i < allScores.length; i++){
			printOUT(i + "     " + allScores[i].getUserName() + "     " +  allScores[i].getCompletionTime() + "     " +  allScores[i].getDifficulty());
		}
		printOUT("*************************************");
	}

	private static void addParagraph(){
		printOUT("Please enter the paragraph you would like to add:");
		String newParagraph = readIN();
		printOUT("Adding paragragh..");
		printOUT("");
		try {
			pBO.addNewParagraph(newParagraph);
			printOUT("");
			gameMenu();
		}
		catch(paragraphTooLongException e){
			printOUT(e.getMessage());
			addParagraph();
		}
	}
}
