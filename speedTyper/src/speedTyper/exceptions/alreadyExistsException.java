package speedTyper.exceptions;

public class alreadyExistsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public alreadyExistsException() {
		super("The user already exists");
	}
}
