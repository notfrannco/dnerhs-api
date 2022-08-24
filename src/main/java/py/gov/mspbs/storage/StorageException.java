package py.gov.mspbs.storage;

public class StorageException extends RuntimeException {

    private static final long serialVersionUID = 7554980319555191251L;

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
