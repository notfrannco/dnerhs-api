package py.gov.mspbs.exception;

public class ApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9100739731917379926L;
	
	public ApiException(String msg) {
		super(msg);
	}

	public ApiException(Throwable e) {
		super(e);
	}
	
	public ApiException(String msg, Throwable e) {
        super(msg, e);
    }
}
