package jp.co.axa.apidemo.exception;

/**
 * Business exception (business logic problem) representation.
 * <br> Could be transferred in a separate common project
 *
 * @author bertrand.hieronymus
 */
public class ApiDemoBusinessException extends Exception {

    private static final long serialVersionUID = -7705719607758904039L;

    private ErrorCode errorCode;

    private String errorMessage;

    public ApiDemoBusinessException() {
        this(ErrorCode.SYSTEM_ERROR, null, null);
    }

    public ApiDemoBusinessException(ErrorCode errorCode) {
        this(errorCode, null, null);
    }

    public ApiDemoBusinessException(Throwable ex) {
        this(ErrorCode.SYSTEM_ERROR, null, ex);
    }

    public ApiDemoBusinessException(ErrorCode errorCode, Throwable ex) {
        this(errorCode, null, ex);
    }

    public ApiDemoBusinessException(ErrorCode errorCode, String message) {
        this(errorCode, message, null);
    }

    public ApiDemoBusinessException(ErrorCode errorCode, String errorMessage, Throwable ex) {
        super(errorMessage != null ? errorMessage : (errorCode != null ? errorCode.toString() : null), ex);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
