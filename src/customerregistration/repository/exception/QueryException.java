package customerregistration.repository.exception;

public class QueryException extends Exception {
	private static final long serialVersionUID = 1L;

	public QueryException(String msg) {
		super(msg);
	}

	public QueryException(Exception e) {
		super(e);
	}

}
