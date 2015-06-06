package speedTyper.bo;

import speedTyper.domain.user;
import speedTyper.dao.userDAO;
import speedTyper.exceptions.alreadyExistsException;

public class userBO {
	userDAO ud;
	
	public userBO(){
		this.ud = new userDAO();
	}
	
	//check if user exists
	public boolean userExists(String name){
		user[] userList = ud.getUsers();
		boolean result = false;
		for(int i = 0; i < userList.length; i++){
			if(userList[i].getName().equals(name)){
				result = true;
			}
		}
		return result;
	}
	
	//add new user
	public void addUser(String name) throws alreadyExistsException{
		if(userExists(name)){
			throw new alreadyExistsException();
		}
		else {
			user currentUser = new user(name);
			ud.insertUser(currentUser);
		}
	}
}
