package py.gov.mspbs.exception;

public class ServiceException extends ApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2569964958543129165L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Throwable e) {
		super(e);
	}
	
	public ServiceException(String msg, Throwable e) {
        super(msg, e);
    }

}
