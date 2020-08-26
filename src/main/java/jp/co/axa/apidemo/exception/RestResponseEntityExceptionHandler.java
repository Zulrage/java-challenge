package jp.co.axa.apidemo.exception;

import java.util.ArrayList;
import java.util.List;
import jp.co.axa.apidemo.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handler for the application.
 * <br> Map unexpected exception to system error with a message
 * <br> Map expected exception to system error with the
 * {@link jp.co.axa.apidemo.exception.ErrorCode ErrorCode} message
 *
 * @author bertrand.hieronymus
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ControllerAdvice
    public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

        /**
         * Common handler for generic exceptions.
         *
         * @param ex
         * @param request
         * @return
         */
        @ExceptionHandler(Exception.class)
        public final ResponseEntity<ErrorDto> handleAllExceptions(Exception ex, WebRequest request) {
            List<String> details = new ArrayList<>();
            details.add(ex.getLocalizedMessage());
            ErrorDto error = new ErrorDto(ErrorCode.SYSTEM_ERROR.getName(), details);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        /**
         * Common exception handler for business exceptions.
         *
         * @param ex
         * @param request
         * @return
         */
        @ExceptionHandler(ApiDemoBusinessException.class)
        public final ResponseEntity<ErrorDto> handleUserNotFoundException(ApiDemoBusinessException ex,
                WebRequest request) {
            List<String> details = new ArrayList<>();
            details.add(ex.getErrorMessage());
            ErrorDto error = new ErrorDto(ex.getErrorCode().getName(), details);
            HttpStatus status = ex.getErrorCode().isAuthorizationError() ? HttpStatus.UNAUTHORIZED : HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(error, status);
        }

        /**
         * Common exception handler for system errors.
         *
         * @param ex
         * @param request
         * @return
         */
        @ExceptionHandler(ApiDemoSystemException.class)
        public final ResponseEntity<ErrorDto> handleUserNotFoundException(ApiDemoSystemException ex,
                WebRequest request) {
            List<String> details = new ArrayList<>();
            details.add(ex.getErrorMessage());
            ErrorDto error = new ErrorDto(ex.getErrorCode().getName(), details);
            HttpStatus status = ex.getErrorCode().isAuthorizationError() ? HttpStatus.UNAUTHORIZED : HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(error, status);
        }
    }
}
