package py.gov.mspbs.exception;

public class ControllerException extends ApiException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6972906116726267727L;

	public ControllerException(String msg) {
		super(msg);
	}

	public ControllerException(Throwable e) {
		super(e);
	}
	
	public ControllerException(String msg, Throwable e) {
        super(msg, e);
    }

}
