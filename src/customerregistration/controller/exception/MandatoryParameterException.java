package customerregistration.controller.exception;

public class MandatoryParameterException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MandatoryParameterException(String msg) {
		super(msg);
	}
	
	public MandatoryParameterException(Exception e) {
		super(e);
	}

}
