package customerregistration.model.repository.exception;

public class InsertionException extends Exception {
	private static final long serialVersionUID = 1L;

	public InsertionException(String msg) {
		super(msg);
	}

	public InsertionException(Exception e) {
		super(e);
	}

}
