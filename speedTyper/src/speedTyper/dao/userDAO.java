package speedTyper.dao;

import speedTyper.domain.user;

public class userDAO {
	
	//check if name exists
	public user[] getUsers(){
		user[] users = {new user("Rayen"), new user("Kayla"), new user("Test")};

		return users;
	}
	//add name
	public void insertUser(user currentUser){
		System.out.println("User " + currentUser.getName() + " added correctly");
	}
	
}
