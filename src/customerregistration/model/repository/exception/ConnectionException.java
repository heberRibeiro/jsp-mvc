package customerregistration.model.repository.exception;

public class ConnectionException extends Exception {
	private static final long serialVersionUID = 1L;

	public ConnectionException(String msg) {
		super(msg);
	}

	public ConnectionException(Exception e) {
		super(e);
	}

}
