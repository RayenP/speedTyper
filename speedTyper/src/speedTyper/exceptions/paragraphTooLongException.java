package speedTyper.exceptions;

public class paragraphTooLongException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public paragraphTooLongException() {
		super("The paragraph you enter was too long");
	}
}
