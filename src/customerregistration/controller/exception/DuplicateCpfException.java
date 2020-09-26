package customerregistration.controller.exception;

public class DuplicateCpfException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DuplicateCpfException(String msg) {
		super(msg);
	}
	
	public DuplicateCpfException(Exception e) {
		super(e);
	}
	

}
