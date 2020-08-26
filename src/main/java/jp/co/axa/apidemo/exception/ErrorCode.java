package jp.co.axa.apidemo.exception;

import java.util.Arrays;

/**
 * Error code class.
 * <br> Could be transferred in a separate common project
 *
 * @author bertrand.hieronymus
 */
public enum ErrorCode {
    /**
     * Unexpected error happened.
     */
    SYSTEM_ERROR("S0001"),
    /**
     * No data could be retrieved from DB.
     */
    UNAUTHORIZED_ACTION("A0001"),
    /**
     * F
     * No data could be retrieved from DB.
     */
    NO_DATA("B0002");

    private final String name;

    public final static String AUTHORIZATION_PREFIX = "A";

    ErrorCode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Get the error code from the string code (S0001, ...)
     *
     * @param name
     * @return the error code object.
     */
    public static ErrorCode getErrorCode(String name) {
        return Arrays.asList(ErrorCode.values()).stream().filter(error -> error.getName().equals(name)).findFirst()
                .orElse(null);
    }

    public boolean isAuthorizationError() {
        return name.startsWith(AUTHORIZATION_PREFIX);
    }

    /**
     * Get the string code from the error.
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
